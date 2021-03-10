package com.gduric.mojabiblioteka;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnCurrentlyReading,  btnAlreadyRead, btnToRead,btnFavourites,
            btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnToRead = findViewById(R.id.btnToRead);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnAbout = findViewById(R.id.btnAbout);
    }
}