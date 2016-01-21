package evg.testt.controller;

import evg.testt.model.Language;
import evg.testt.model.Translator;
import evg.testt.util.JspPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TranslatorController {

    @RequestMapping(value = "/translMain", method = RequestMethod.GET)
    public ModelAndView mainView() {
        Translator translator = new Translator();
        translator.setLanguageIn("English");
        translator.setLanguageOut("Ukranian");
        translator.setLanguages(hardSetting());
        translator.setTextIn("This is the most perfect translator in the world I ever seen !");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translator", translator);
    }

    @RequestMapping(value = "/doTransl", method = RequestMethod.POST)
    public ModelAndView doTranslate(String languageIn, String languageOut, String textIn) {
        Translator translator = new Translator();
        translator.setLanguageIn(languageIn);
        translator.setLanguageOut(languageOut);
        translator.setTextIn(textIn);
        translator.setLanguages(hardSetting());
        //something doing...
        translator.setTextOut("Якось так ми i перекладаемо...");
        return new ModelAndView(JspPath.TRANSLATOR_HOME, "translator", translator);
    }

    private Set<Language> hardSetting() {
        List<String> langs = new ArrayList<>();
        langs.add("English");
        langs.add("Ukranian");
        langs.add("Russian");
        langs.add("Frances");
        Set<Language> languages = new HashSet<>();
        for (int i = 0; i < langs.size(); i++) {
            Language language = new Language();
            language.setLanguageName(langs.get(i));
            languages.add(language);
        }
        return languages;
    }


}
