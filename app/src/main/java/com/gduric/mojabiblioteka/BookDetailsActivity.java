package com.gduric.mojabiblioteka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookDetailsActivity extends AppCompatActivity {
    public static String BOOK_ID_KEY = "id";
    public static Integer BOOK_DEFAULT_ID = -1;

    private TextView txtBookName,txtAuthor, txtPages, txtDesc;
    private Button btnAddToWantToRead, btnAddToAlreadyRead,btnAddToCurrentlyReading,btnAddToFav;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        initViews();

        Intent intent = getIntent();
        if(null != intent){
            int bookId =intent.getIntExtra(BOOK_ID_KEY, BOOK_DEFAULT_ID);
            if(bookId != BOOK_DEFAULT_ID){
                Book selectedBook = Utils.getInstance().getBookById(bookId);
                if(null != selectedBook) {
                    setData(selectedBook);

                    handleAlreadyRead(selectedBook);
                    handleWantToRead(selectedBook);
                    handleAddToFav(selectedBook);
                    handleCurrentlyReading(selectedBook);
                }
            }
        }
    }

    private void handleAlreadyRead(final Book selectedBook) {
        ArrayList<Book> alreadyRead = Utils.getInstance().getAlreadyReadBooks();
        boolean isAlreadyRead = false;
        for (Book book:alreadyRead
             ) {
            if(book.getId() == selectedBook.getId()){
                isAlreadyRead = true;
            }
        }
        if(isAlreadyRead){
           btnAddToAlreadyRead.setEnabled(false);
        } else {
           btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick (View v){
                   if(Utils.getInstance().addToAlreadyRead(selectedBook)){
                       Toast.makeText(BookDetailsActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(BookDetailsActivity.this, AlreadyReadBooksActivity.class);
                       startActivity(intent);
                   } else {
                       Toast.makeText(BookDetailsActivity.this, "Book Not Added. Try Again.", Toast.LENGTH_SHORT).show();
                   }
               }
           });
        }
    }

    private void handleWantToRead(final Book selectedBook) {
        ArrayList<Book> wantToRead = Utils.getInstance().getWantToReadBooks();
        boolean isInTheList = false;
        for (Book book:wantToRead
        ) {
            if(book.getId() == selectedBook.getId()){
                isInTheList = true;
            }
        }
        if(isInTheList){
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    if(Utils.getInstance().addToWantToRead(selectedBook)){
                        Toast.makeText(BookDetailsActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookDetailsActivity.this, WantToReadBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookDetailsActivity.this, "Book Not Added. Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAddToFav(final Book selectedBook) {
        ArrayList<Book> favouriteBooks = Utils.getInstance().getFavouriteBooks();
        boolean isInTheList = false;
        for (Book book:favouriteBooks
        ) {
            if(book.getId() == selectedBook.getId()){
                isInTheList = true;
            }
        }
        if(isInTheList){
            btnAddToFav.setEnabled(false);
        } else {
            btnAddToFav.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    if(Utils.getInstance().addToFavouriteBooks(selectedBook)){
                        Toast.makeText(BookDetailsActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookDetailsActivity.this, FavouriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookDetailsActivity.this, "Book Not Added. Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReading(final Book selectedBook) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
        boolean isInTheList = false;
        for (Book book:currentlyReadingBooks
        ) {
            if(book.getId() == selectedBook.getId()){
                isInTheList = true;
            }
        }
        if(isInTheList){
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    if(Utils.getInstance().addToCurrentlyReadingBooks(selectedBook)){
                        Toast.makeText(BookDetailsActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookDetailsActivity.this, CurrentlyReadingBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookDetailsActivity.this, "Book Not Added. Try Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDesc.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews(){
        txtAuthor = findViewById(R.id.authorNameBox);
        txtBookName = findViewById(R.id.bookNameBox);
        txtPages = findViewById(R.id.pagesBox);
        txtDesc = findViewById(R.id.longDescBox);
        bookImage = findViewById(R.id.bookImg);
        btnAddToWantToRead = findViewById(R.id.btnWantToRead);
        btnAddToAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAddToFav = findViewById(R.id.btnAddToFav);
    }
}