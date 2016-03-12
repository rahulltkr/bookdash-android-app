package org.bookdash.android.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Rebecca Franks (rebecca.franks@dstvdm.com)
 * @since 2015/07/16 7:37 PM
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Language  {

    public static final String LANGUAGE_TABLE_NAME = "Language";
    public static final String LANG_CODE_COL = "languageAbbreviation";
    public static final String LANG_NAME_COL = "languageName";
    public static final String LANGUAGE_ID = "languageId";

    public Language() {
    }

    private String languageName;
    private String languageAbbreviation;
    private String languageId;

    public Language(String languageName, String code, String languageId) {
        languageAbbreviation =  code;
        this.languageName =  languageName;
        this.languageId = languageId;

    }

    public String getLanguageCode() {
        return languageAbbreviation;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getLanguageId() {
        return languageId;
    }

    @Override
    public String toString() {
        return getLanguageName();
    }
}
