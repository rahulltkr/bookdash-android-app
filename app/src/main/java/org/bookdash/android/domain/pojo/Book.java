package org.bookdash.android.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rebecca Franks (rebecca.franks@dstvdm.com)
 * @since 2015/07/17 6:39 PM
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Book  {

    public String getDateBookCreated(){
        Date date = null;
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d, yyyy");
        return simpleDateFormat.format(date);
    }

}
