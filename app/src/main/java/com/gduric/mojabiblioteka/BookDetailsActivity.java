package com.gduric.mojabiblioteka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

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
                }
            }
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
        btnAddToFav = findViewById(R.id.btnFavourites);
    }
}