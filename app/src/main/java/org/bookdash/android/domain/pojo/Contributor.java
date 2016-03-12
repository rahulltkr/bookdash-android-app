package org.bookdash.android.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Contributor  {


    private String name;
    private String role;
    private String avatarUrl;

    public Contributor() {
    }

    public Contributor(String name, String role) {
        this.name = name;
        this.role = role;

    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
