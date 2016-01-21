package evg.testt.model;

import java.util.Set;

/**
 * Created by alex on 21.01.16.
 */

public class Translator extends BaseModel {

    private String languageIn;
    private String languageOut;
    private String textIn;
    private String textOut;
    Set<Language> languages;

    public Set<Language> getLanguages() {return languages;}

    public void setLanguages(Set<Language> languages) {this.languages = languages;}

    public String getLanguageIn() { return languageIn; }

    public void setLanguageIn(String languageIn) { this.languageIn = languageIn; }

    public String getLanguageOut() { return languageOut; }

    public void setLanguageOut(String languageOut) { this.languageOut = languageOut; }

    public String getTextIn() { return textIn; }

    public void setTextIn(String textIn) { this.textIn = textIn; }

    public String getTextOut() { return textOut; }

    public void setTextOut(String textOut) { this.textOut = textOut; }

}
