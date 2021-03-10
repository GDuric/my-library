package com.gduric.mojabiblioteka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BookRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        adapter = new BookRecyclerViewAdapter(this);
        booksRecyclerView = findViewById(R.id.recyclerView);
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Don Quixote", "Miguel de Cervantes", 863, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Miguel_de_Cervantes_%281605%29_El_ingenioso_hidalgo_Don_Quixote_de_la_Mancha.png/250px-Miguel_de_Cervantes_%281605%29_El_ingenioso_hidalgo_Don_Quixote_de_la_Mancha.png", "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. Quixano eventually appears to other people to have lost his mind from little sleep and food and because of so much reading.", "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. Quixano eventually appears to other people to have lost his mind from little sleep and food and because of so much reading. Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. Quixano eventually appears to other people to have lost his mind from little sleep and food and because of so much reading."));

        books.add(new Book(2, "Things Fall Apart", "Chinua Achebe", 209, "https://images-na.ssl-images-amazon.com/images/I/514QQ3BgxIL._SX323_BO1,204,203,200_.jpg","https://images-na.ssl-images-amazon.com/images/I/514QQ3BgxIL._SX323_BO1,204,203,200_.jpg", "A novel of great power that turns the world upside down. The Nigerian novelist Achebe reached back to the early days of his people's encounter with colonialism, the 1890's, though the white man and his religion make an impression upon the story only in its later stages. Instead of being treated as onlookers to the arrival of the colonial power, either passive or menacing, here the Africans are center stage, capable all the while of nobility but also cruelty, wisdom and bewilderment. Okonkwo is an ambitious man within the Umuofia clan of the Igbo tribe. Determined to be a lord, he observes its rules, even the harshest of them, though that observance will eventually drive away his own son. Achebe guides us through the intricacies of Igbo culture, its profound sense of justice, its sometimes murderous rules, its noble and harmful machismo. By the time the British colonial administrator arrives towards the end of the book to dismiss the natives as savages, we know how profoundly mistaken that word is."));
        books.add(new Book(3, "Nostromo", "Joseph Conrad", 480,  "https://images-na.ssl-images-amazon.com/images/I/41ZBtjr9X0L.jpg", "Edited with an introduction and notes by Martin Seymour-Smith. In his evocation of the republic of Costaguana, set amid the exotic and grandiose scenery of South America, Conrad reveals not only the lives and fates of his characters but also the physical and political composition of a whole country.", "Edited with an introduction and notes by Martin Seymour-Smith. In his evocation of the republic of Costaguana, set amid the exotic and grandiose scenery of South America, Conrad reveals not only the lives and fates of his characters but also the physical and political composition of a whole country." ));
        books.add(new Book (4, "Atonement", "Ian McEwan", 371, "https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/Atonement_%28novel%29.jpg/220px-Atonement_%28novel%29.jpg", "Atonement is a 2001 British metafiction novel written by Ian McEwan. Set in three time periods, 1935 England, Second World War England and France, and present-day England, it covers an upper-class girl's half-innocent mistake that ruins lives, her adulthood in the shadow of that mistake, and a reflection on the nature of writing.", "Ian McEwan’s symphonic novel of love and war, childhood and class, guilt and forgiveness provides all the satisfaction of a brilliant narrative and the provocation we have come to expect from this master of English prose.\n" +
                "\n" +
                "On a hot summer day in 1935, thirteen-year-old Briony Tallis witnesses a moment’s flirtation between her older sister, Cecilia, and Robbie Turner, the son of a servant and Cecilia’s childhood friend. But Briony’ s incomplete grasp of adult motives—together with her precocious literary gifts—brings about a crime that will change all their lives.\n" +
                "\n" +
                "As it follows that crime’s repercussions through the chaos and carnage of World War II and into the close of the twentieth century, Ato"  ));


        adapter.setBooks(books);
    }
}