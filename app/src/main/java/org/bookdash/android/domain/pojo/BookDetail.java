package org.bookdash.android.domain.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.bookdash.android.BookDashApplication;

import java.io.File;

/**
 * @author Rebecca Franks
 * @since 2015/07/16 2:10 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDetail implements Parcelable {

    private String bookTitle;
    private String bookCoverPageUrl;
    private String aboutBook;
    private String bookEnabled;
    private String bookLanguage;


    private String key;
    private boolean isDownloading = false;
    private String webUrl;

    public BookDetail() {
    }

    public BookDetail(String title, String bookCoverUrl, String key, Language languageId) {
        bookTitle = title;
        bookCoverPageUrl = bookCoverUrl;
        this.key = key;

    }

    protected BookDetail(Parcel in) {
        bookTitle = in.readString();
        bookCoverPageUrl = in.readString();
        aboutBook = in.readString();
        bookEnabled = in.readString();
        bookLanguage = in.readString();
        key = in.readString();
        isDownloading = in.readByte() != 0;
        webUrl = in.readString();
    }

    public static final Creator<BookDetail> CREATOR = new Creator<BookDetail>() {
        @Override
        public BookDetail createFromParcel(Parcel in) {
            return new BookDetail(in);
        }

        @Override
        public BookDetail[] newArray(int size) {
            return new BookDetail[size];
        }
    };

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookCoverPageUrl() {
        return bookCoverPageUrl;
    }

 /*   public ParseFile getBookFile() {
        return null;//getParseFile(BOOK_DOWNLOAD_FILE_COL);
    }*/

    /* public Language getLanguage() {
         return (Language) get(BOOK_LANGUAGE_COL);
     }

     public Book getBook() {
         return (Book) get(BOOK_ID_COL);
     }
 */
    public String getAboutBook() {
        return aboutBook;
    }


    public String getFolderLocation(String filesDir) {
        return getFolderLocation(new File(filesDir, key + File.separator));
    }

    private String getFolderLocation(File file) {
        if (file.isDirectory() && (file.canRead())) {
            File[] files = file.listFiles();
            return files[0].getAbsoluteFile().toString();
        }
        return null;
    }

    public boolean isDownloadedAlready() {
        String targetLocation = BookDashApplication.FILES_DIR + File.separator + key;
        File f = new File("", targetLocation);
        return f.exists();
    }

    public String getKey() {
        return key;
    }

    public boolean isDownloading() {
        return isDownloading;
    }

    public void setIsDownloading(boolean isDownloading) {
        this.isDownloading = isDownloading;
    }

    /*public BookDetailParcelable toBookParcelable() {
        BookDetailParcelable bookDetailParcelable = new BookDetailParcelable();
        bookDetailParcelable.setBookTitle(getBookTitle());
        bookDetailParcelable.setBookImageUrl(getBookCoverPageUrl());
        bookDetailParcelable.setBookDetailObjectId(getKey());
        bookDetailParcelable.setWebUrl(getWebUrl());
        return bookDetailParcelable;
    }*/

    public String getWebUrl() {
        return webUrl;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookTitle);
        dest.writeString(bookCoverPageUrl);
        dest.writeString(aboutBook);
        dest.writeString(bookEnabled);
        dest.writeString(bookLanguage);
        dest.writeString(key);
        dest.writeByte((byte) (isDownloading ? 1 : 0));
        dest.writeString(webUrl);
    }

}