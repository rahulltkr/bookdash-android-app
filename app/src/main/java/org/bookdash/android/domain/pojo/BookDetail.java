package org.bookdash.android.domain.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parse.ParseFile;

import org.bookdash.android.BookDashApplication;

import java.io.File;

/**
 * @author Rebecca Franks
 * @since 2015/07/16 2:10 PM
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BookDetail implements Parcelable {

    private String book_title;
    private String book_cover_page_url;
    private String aboutBook;
    private String book_enabled;
    private String book_language;
    private String key;
    private boolean isDownloading = false;
    private String webUrl;

    public BookDetail() {
    }

    public BookDetail(String title, String bookCoverUrl, String key, Language languageId) {
        book_title = title;
        book_cover_page_url = bookCoverUrl;
        this.key = key;

    }

    protected BookDetail(Parcel in) {
        book_title = in.readString();
        book_cover_page_url = in.readString();
        aboutBook = in.readString();
        book_enabled = in.readString();
        book_language = in.readString();
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

    public String getBook_title() {
        return book_title;
    }

    public String getBook_cover_page_url() {
        return book_cover_page_url;
    }

    public ParseFile getBookFile() {
        return null;//getParseFile(BOOK_DOWNLOAD_FILE_COL);
    }

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
        bookDetailParcelable.setBookTitle(getBook_title());
        bookDetailParcelable.setBookImageUrl(getBook_cover_page_url());
        bookDetailParcelable.setBookDetailObjectId(getKey());
        bookDetailParcelable.setWebUrl(getWebUrl());
        return bookDetailParcelable;
    }*/

    public String getWebUrl() {
        return webUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(book_title);
        dest.writeString(book_cover_page_url);
        dest.writeString(aboutBook);
        dest.writeString(book_enabled);
        dest.writeString(book_language);
        dest.writeString(key);
        dest.writeByte((byte) (isDownloading ? 1 : 0));
        dest.writeString(webUrl);
    }

}