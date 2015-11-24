package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EncryptionService;
import evg.testt.wrapper.XMLEncryptedWrapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@RestController
public class DepartmentRestController {

    private CacheConfig cacheConfig = CacheConfig.custom()
            .setMaxCacheEntries(1000)
            .setMaxObjectSize(8192)
            .build();
    private RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30000)
            .setSocketTimeout(30000)
            .build();
    private CloseableHttpClient cachingClient = CachingHttpClients.custom()
            .setCacheConfig(cacheConfig)
            .setDefaultRequestConfig(requestConfig)
            .build();
    private HttpCacheContext context = HttpCacheContext.create();

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EncryptionService encryptionService;

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getDepartment(@PathVariable("id") int id) {

        Department department;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "/scripts/fakescript.js", method = RequestMethod.GET, produces = "application/x-javascript")
    public ResponseEntity<String> fakescript() {

        System.out.println("fakescript1");
        String script = "(function(){ console.log('fakescript');})();";

        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("fakescript2");

        return new ResponseEntity<>(script, HttpStatus.OK);
    }

    @RequestMapping(value = "/scripts/fakescript.js", method = RequestMethod.GET, produces = "application/javascript")
    public ResponseEntity<String> fakescript2() {

        System.out.println("fakescript1");
        String script = "(function(){ console.log('fakescript');})();";

        try {
            Thread.sleep(8000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("fakescript2");

        return new ResponseEntity<>(script, HttpStatus.OK);
    }


    @RequestMapping(value = "/vast_original", method = RequestMethod.GET, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XMLEncryptedWrapper> getOriginal() throws IOException{

        HttpGet httpget = new HttpGet("http://ads.adfox.ru/168627/getCode?yandexuid=16377534351516971839&sign=cc02b3498db1b7b1544fd35156281c84&p1=bdcfe&p2=ekza&pfc=lsbo&pfb=btpaj&plp=a&pli=a&pop=a&puid1=&placement=-EZeei-sDQVcFumh&widgetid=-EZeei-sDQVcFumh&player_sid=1682041229&platform=linux&browser=chrome&browser_ver=37.0.2062.120&platform_ver=3.0&p=2&itime=0&embedded=false&flash_prerolls=1&pc=0&pq=0&r_ver=v3.0&showVpaid=true&st=1448270913&attempt=1/1&success=0/1&referrer=http%3A%2F%2Flocalhost%3A3000%2Fwork_fine&platinum=true&allowCacheBuster=true");
        try (CloseableHttpResponse response = cachingClient.execute(httpget, context)) {
            HttpEntity entity;
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    HttpHeaders responseHeaders = new HttpHeaders();
                    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
                    responseHeaders.add("Access-Control-Allow-Origin","*");
                    String body = EntityUtils.toString(entity);
                    body = body.replace("http://banners.adfox.ru/150305/adfox/205544/801069_1.mp4", "http://localhost:8080/video_ads_streaming");
                    XMLEncryptedWrapper xmlEncryptedWrapper = new XMLEncryptedWrapper();
                    xmlEncryptedWrapper.setEncryptedXMLFile(Base64.encodeBase64String(body.getBytes()));
                    return ResponseEntity.ok().headers(responseHeaders).body(xmlEncryptedWrapper);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/video_ads_full", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getAdsVideo(HttpServletResponse response) throws IOException{

        HttpGet httpget = new HttpGet("http://banners.adfox.ru/150305/adfox/205544/801069_1.mp4");
        try(CloseableHttpResponse restResponse = cachingClient.execute(httpget, context)) {
            if (restResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity;
                entity = restResponse.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    byte[] body = EntityUtils.toByteArray(entity);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    return new ResponseEntity<>(body, headers, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf(restResponse.getStatusLine().getStatusCode()));
            }
        }
    }

    @RequestMapping(value = "/video_ads_streaming", method = RequestMethod.GET)
    public void getStreamingAdsVideo(HttpServletResponse response) throws IOException{

        HttpGet httpget = new HttpGet("http://banners.adfox.ru/150305/adfox/205544/801069_1.mp4");
        //HttpGet httpget = new HttpGet("http://cx.aos.ask.com/question/aq/700px-394px/real-life-examples-series-circuits_cb5f68412d4ca1ec.jpg");
        try(CloseableHttpResponse restResponse = cachingClient.execute(httpget, context)){
            if (restResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity;
                entity = restResponse.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    try {
                        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                        //response.setHeader("Content-Disposition", "attachment; filename="+file.getName().replace(" ", "_"));
                        InputStream iStream = entity.getContent();
                        IOUtils.copy(iStream, response.getOutputStream());
                        response.flushBuffer();
                    } catch (java.nio.file.NoSuchFileException e) {
                        response.setStatus(HttpStatus.NOT_FOUND.value());
                    } catch (Exception e) {
                        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                    }
                }
            }
        }

    }

}
