package com.gduric.mojabiblioteka;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class BookDetailsActivity extends AppCompatActivity {
    private TextView txtBookName,txtAuthor, txtPages, txtDesc;
    private Button btnAddToWantToRead, btnAddToAlreadyRead,btnAddToCurrentlyReading,btnAddToFav;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        initViews();

        //TODO: get the data from the recycler view
        Book book = new Book(2, "Things Fall Apart", "Chinua Achebe", 209, "https://images-na.ssl-images-amazon.com/images/I/514QQ3BgxIL._SX323_BO1,204,203,200_.jpg","https://images-na.ssl-images-amazon.com/images/I/514QQ3BgxIL._SX323_BO1,204,203,200_.jpg", "A novel of great power that turns the world upside down. The Nigerian novelist Achebe reached back to the early days of his people's encounter with colonialism, the 1890's, though the white man and his religion make an impression upon the story only in its later stages. Instead of being treated as onlookers to the arrival of the colonial power, either passive or menacing, here the Africans are center stage, capable all the while of nobility but also cruelty, wisdom and bewilderment. Okonkwo is an ambitious man within the Umuofia clan of the Igbo tribe. Determined to be a lord, he observes its rules, even the harshest of them, though that observance will eventually drive away his own son. Achebe guides us through the intricacies of Igbo culture, its profound sense of justice, its sometimes murderous rules, its noble and harmful machismo. By the time the British colonial administrator arrives towards the end of the book to dismiss the natives as savages, we know how profoundly mistaken that word is.");
        setData(book);
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