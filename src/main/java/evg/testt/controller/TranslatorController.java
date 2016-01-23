package evg.testt.controller;

import evg.testt.dto.TranslatorDto;
import evg.testt.model.Language;
import evg.testt.service.LanguageServise;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "translate")
public class TranslatorController {

    @Autowired
    LanguageServise languageServise;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainView() throws SQLException {
        Set<Language> languages = new HashSet<>(languageServise.getAll());
        if (languages.size() == 0) {
            fillLanguages();
            languages = new HashSet<>(languageServise.getAll());
        }
        TranslatorDto translatorDto = new TranslatorDto();
        translatorDto.setLanguageIn("English");
        translatorDto.setLanguageOut("Ukranian");
        translatorDto.setLanguages(languages);
        translatorDto.setTextIn("This is the most perfect translator in the world I ever seen !");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.GET)
    public String goMainView() {
        return "redirect:/translate";
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.POST)
    public ModelAndView doTranslate(String languageIn, String languageOut, String textIn) throws SQLException {
        TranslatorDto translatorDto = new TranslatorDto();
        translatorDto.setLanguageIn(languageIn);
        translatorDto.setLanguageOut(languageOut);
        translatorDto.setTextIn(textIn);
        Set<Language> languages = new HashSet<>(languageServise.getAll());
        translatorDto.setLanguages(languages);

        //translating here...

        translatorDto.setTextOut("Якось так ми i перекладаемо...");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translatorDto", translatorDto);
    }

    private void fillLanguages() throws SQLException {
        List<String> langs = new ArrayList<>();
        langs.add("English");
        langs.add("Ukranian");
        langs.add("Russian");
        langs.add("Frances");
        for (int i = 0; i < langs.size(); i++) {
            Language language = new Language();
            language.setLanguageName(langs.get(i));
            language.setId(i+1);
            languageServise.update(language);
        }
    }


}
