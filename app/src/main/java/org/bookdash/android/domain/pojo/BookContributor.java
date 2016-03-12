package org.bookdash.android.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class BookContributor  {

    public BookContributor() {
    }

    public BookContributor(Contributor contributor) {

    }

    public Contributor getContributor() {
        return null;
    }
}
