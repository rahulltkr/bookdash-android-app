package org.bookdash.android.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * @author Rebecca Franks (rebecca.franks@dstvdm.com)
 * @since 2015/07/16 7:37 PM
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Language  {

    public static final String LANGUAGE_TABLE_NAME = "Language";
    public static final String LANG_CODE_COL = "language_abbreviation";
    public static final String LANG_NAME_COL = "language_name";
    public static final String LANGUAGE_ID = "language_id";

    public Language() {
    }

    private String language_name;
    private String language_abbreviation;
    private String language_id;

    public Language(String languageName, String code, String languageId) {
        language_abbreviation =  code;
        language_name =  languageName;
        this.language_id = languageId;

    }

    public String getLanguageCode() {
        return language_abbreviation;
    }

    public String getLanguageName() {
        return language_name;
    }

    public String getLanguageId() {
        return language_id;
    }

    @Override
    public String toString() {
        return getLanguageName();
    }
}
