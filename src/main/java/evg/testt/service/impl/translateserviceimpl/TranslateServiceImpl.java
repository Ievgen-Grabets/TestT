package evg.testt.service.impl.translateserviceimpl;

import evg.testt.exception.TranslateServiceException;
import evg.testt.service.translateservice.Language;
import evg.testt.service.translateservice.TranslateResult;
import evg.testt.service.translateservice.TranslateService;
import org.apache.http.HttpEntity;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class TranslateServiceImpl implements TranslateService {

    private static final TranslateLanguage LANG_ENGLISH_EN = new TranslateLanguage("en","english","english");
    private static final TranslateLanguage LANG_RUSSIAN_RU = new TranslateLanguage("ru","русский","russian");

    private static final Set<Language> availableLanguages = new HashSet<>();

    private static final JSONParser parser = new JSONParser();

    static {
        availableLanguages.add(LANG_ENGLISH_EN);
        availableLanguages.add(LANG_RUSSIAN_RU);
    }

    private static final String FMT_PREPARED_TRANSLATE_SERVICE_URL_MAIN
            = "http://api.lingualeo.com/translate.php?q=%s&source=%s&target=%s&port=1001";

    private static final String FMT_PREPARED_TRANSLATE_SERVICE_URL_ADDITION
            = "http://api.lingualeo.com/gettranslates?word=%s";

    private final CacheConfig cacheConfig = CacheConfig.custom()
            .setMaxCacheEntries(1000)
            .setMaxObjectSize(8192)
            .build();
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30000)
            .setSocketTimeout(30000)
            .build();
    private final CloseableHttpClient cachingClient = CachingHttpClients.custom()
            .setCacheConfig(cacheConfig)
            .setDefaultRequestConfig(requestConfig)
            .build();
    private final HttpCacheContext context = HttpCacheContext.create();

    private class TranslateParams {
        private final String textToTranslate;
        private final String sourceLang;
        private final String targetLang;

        public TranslateParams(String textToTranslate, String sourceLang, String targetLang) {
            this.textToTranslate = textToTranslate;
            this.sourceLang = sourceLang;
            this.targetLang = targetLang;
        }

        public String getTextToTranslate() {
            return textToTranslate;
        }

        public String getSourceLang() {
            return sourceLang;
        }

        public String getTargetLang() {
            return targetLang;
        }
    }


    @Override
    public Set<Language> getAvailableLanguages() {
        return Collections.unmodifiableSet(availableLanguages);
    }

    private String executeRequest(String url) throws IOException {
        HttpGet httpget = new HttpGet(url);

        try (CloseableHttpResponse response = cachingClient.execute(httpget, context)) {
            HttpEntity entity;
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    return EntityUtils.toString(entity);
                }
            }
        }
        return "";
    }

    private TranslateResultImpl executeAndProcessResponseForMainURL(TranslateParams translateParams)
            throws TranslateServiceException {
        String url = String.format(FMT_PREPARED_TRANSLATE_SERVICE_URL_MAIN,
                translateParams.getTextToTranslate(),
                translateParams.getSourceLang(),
                translateParams.getTargetLang());
        try {
            return parseMainTranslateResultFromJson(executeRequest(url));
        } catch (IOException e) {
            e.printStackTrace();
            throw new TranslateServiceException(e);
        }
    }

    @Override
    public TranslateResult translate(String textToTranslate, String sourceLang, String targetLang) {
        TranslateParams translateParams = new TranslateParams(textToTranslate,sourceLang,targetLang);
        TranslateResultImpl translateResult = executeAndProcessResponseForMainURL(translateParams);

        if(sourceLang.equals(LANG_ENGLISH_EN.getShortName()) && targetLang.equals(LANG_RUSSIAN_RU.getShortName())) {
            TranslateResultImpl additionTranslateResult = executeAndProceseResponseForAddURL(translateParams);
            updateTranslateResult(translateResult,additionTranslateResult);
        }

        return translateResult;
    }

    private void updateTranslateResult(TranslateResultImpl translateResult, TranslateResultImpl additionTranslateResult) {
        translateResult.setSoundURL(additionTranslateResult.soundURL());
        translateResult.setTranscription(additionTranslateResult.transcription());
        translateResult.addAlternativeTranslations(additionTranslateResult.translation());
        translateResult.setAlternativeTranslations(additionTranslateResult.alternativeTranslations());
    }

    @Override
    public TranslateResult translate(String textToTranslate, Language sourceLang, Language targetLang) {
        return translate(textToTranslate, sourceLang.getShortName(), targetLang.getShortName());
    }

    private TranslateResultImpl executeAndProceseResponseForAddURL(TranslateParams translateParams) {
        String url = String.format(FMT_PREPARED_TRANSLATE_SERVICE_URL_ADDITION,
                translateParams.getTextToTranslate());
        try {
            return parseAdditionTranslateResultFromJson(executeRequest(url));
        } catch (IOException e) {
            e.printStackTrace();
            throw new TranslateServiceException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private TranslateResultImpl parseAdditionTranslateResultFromJson(String json) {
        try {
            Map<String,Object> resultMap = (Map<String,Object>) parser.parse(json);

            List<Map<String,Object>> translation = (List<Map<String,Object>>) resultMap.get("translate");

            if(translation == null) {
                throw new TranslateServiceException("Can't translate!");
            }

            List<String> allListTranslations = new ArrayList<>();

            for(Map<String,Object> translateValue : translation) {
                String value = (String) translateValue.get("value");
                if(value != null) {
                    allListTranslations.add(value);
                }
            }

            if(allListTranslations.isEmpty()) {
                throw new TranslateServiceException("Can't translate!");
            }

            TranslateResultImpl translateResult = new TranslateResultImpl();
            translateResult.setTranslation(allListTranslations.get(0));

            for(int i = 1; i < allListTranslations.size(); i++) {
                translateResult.addAlternativeTranslations(allListTranslations.get(i));
            }

            String tmpString = (String) resultMap.get("transcription");
            if(tmpString != null) {
                translateResult.setTranscription(tmpString);
            }

            tmpString = (String) resultMap.get("sound_url");
            if(tmpString != null) {
                translateResult.setSoundURL(tmpString);
            }

            return translateResult;

        } catch (ParseException e) {
            e.printStackTrace();
            throw new TranslateServiceException("ParseException");
        }
    }

    @SuppressWarnings("unchecked")
    private TranslateResultImpl parseMainTranslateResultFromJson(String json) throws TranslateServiceException {
        try {
            Map<String,String> resultMap = (Map<String,String>) parser.parse(json);

            String translation = resultMap.get("translation");

            if(translation == null) {
                throw new TranslateServiceException("Can't translate!");
            }

            TranslateResultImpl translateResult = new TranslateResultImpl();
            translateResult.setTranslation(translation);

            return translateResult;

        } catch (ParseException e) {
            e.printStackTrace();
            throw new TranslateServiceException("ParseException");
        }
    }
}
