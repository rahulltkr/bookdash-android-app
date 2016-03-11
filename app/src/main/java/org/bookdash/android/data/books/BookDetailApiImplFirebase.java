package org.bookdash.android.data.books;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.bookdash.android.domain.pojo.Book;
import org.bookdash.android.domain.pojo.BookContributor;
import org.bookdash.android.domain.pojo.BookDetail;
import org.bookdash.android.domain.pojo.Language;
import org.bookdash.android.domain.pojo.gson.BookPages;

import java.util.ArrayList;
import java.util.List;


public class BookDetailApiImplFirebase implements BookDetailApi {

    private static final String TAG = "BookDetailApi";
    Firebase firebase;

    public BookDetailApiImplFirebase() {
        firebase = new Firebase("https://book-dash.firebaseIO.com");
    }

    @Override
    public void getBooksForLanguages(String language, final BookServiceCallback<List<BookDetail>> bookServiceCallback) {

        firebase.child("book_details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<BookDetail> bookDetails = new ArrayList<>();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    BookDetail post = postSnapshot.getValue(BookDetail.class);
                    bookDetails.add(post);
                }
                bookServiceCallback.onLoaded(bookDetails);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                bookServiceCallback.onError(error.toException());
            }
        });
    }

    @Override
    public void getBookDetail(String bookDetailId, final BookServiceCallback<BookDetail> bookServiceCallback) {
        firebase.child("book_details").startAt(bookDetailId, "objectId").endAt(bookDetailId, "objectId").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                BookDetail post = dataSnapshot.getValue(BookDetail.class);

                bookServiceCallback.onLoaded(post);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                bookServiceCallback.onError(firebaseError.toException());
            }
        });
    }

    @Override
    public void getContributorsForBook(Book bookId, BookServiceCallback<List<BookContributor>> contributorsCallback) {

    }

    @Override
    public void getLanguages(final BookServiceCallback<List<Language>> languagesCallback) {
        firebase.child("languages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Language> language = new ArrayList<>();
                for (DataSnapshot languageSnapshot : snapshot.getChildren()) {
                    Language lang = languageSnapshot.getValue(Language.class);
                    language.add(lang);
                }
                languagesCallback.onLoaded(language);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                languagesCallback.onError(error.toException());
            }
        });
    }

    @Override
    public void downloadBook(BookDetail bookDetail, BookServiceCallback<BookPages> downloadBookCallback, BookServiceProgressCallback bookServiceProgressCallback) {

    }
}
