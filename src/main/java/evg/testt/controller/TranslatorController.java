package evg.testt.controller;

import evg.testt.dto.TranslatorDto;
import evg.testt.service.TranslatorService;
import evg.testt.service.translateservice.TranslateService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "translate")
public class TranslatorController {

    //@Autowired
    //Language languageService;

    @Autowired
    TranslateService translateService;

    @Autowired
    TranslatorService translatorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainView() throws SQLException {
        /*
        Set<evg.testt.model.Language> languages = new HashSet<>(languageService.getAll());
        if (languages.size() == 0) {
            List<String> langs = LanguageUtil.fillLanguages();
            for (int i = 0; i < langs.size(); i++) {
                evg.testt.model.Language language = new evg.testt.model.Language();
                language.setFullName(langs.get(i));
                language.setId(i+1);
                languageService.update(language);
            }
            languages = new HashSet<>(languageService.getAll());
        }
        */
        TranslatorDto translatorDto = new TranslatorDto();
        //translatorDto.setLanguageIn(LanguageUtil.defaultLangIn("English"));
        //translatorDto.setLanguageOut(LanguageUtil.defaultLangOut("Ukranian"));
        translatorDto.setLanguages(translateService.getAvailableLanguages());
        translatorDto.setTextIn("This is the most perfect translator in the world I have ever seen!");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.GET)
    public String goMainView() {
        return "redirect:/translate";
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.POST)
    public ModelAndView doTranslate(String languageIn, String languageOut, String textIn) throws SQLException {
        TranslatorDto translatorDto = new TranslatorDto();
        //translatorDto.setLanguageIn(LanguageUtil.defaultLangIn(languageIn));
        //translatorDto.setLanguageOut(LanguageUtil.defaultLangOut(languageOut));
        translatorDto.setTextIn(textIn);
        //Set<evg.testt.model.Language> languages = new HashSet<>(languageService.getAll());
        //translatorDto.setLanguages(languages);
        //translatorDto = translatorService.translate(translatorDto);
        translatorDto.setTextOut(translateService.translate(textIn,languageIn,languageOut).translation());
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }


}
