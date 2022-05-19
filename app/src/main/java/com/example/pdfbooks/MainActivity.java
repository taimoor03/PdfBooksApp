package com.example.pdfbooks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfbooks.adapter.ProductAdapter;
import com.example.pdfbooks.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Types,Variables And Oprators\n",
                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b"

                ));

        productList.add(
                new Product(
                        1,
                        " More types, Methods, Conditionals \n",

                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));

        productList.add(
                new Product(
                        1,
                        "Loops, Arrays ",


                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));

        productList.add(
                new Product(
                        1,
                        "Classes and Objects",
                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));
        productList.add(
                new Product(
                        1,
                        "Acess Control,Java API, Classes",
                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));
        productList.add(
                new Product(
                        1,
                        " Design, Debugging, Interfaces",
                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));
        productList.add(
                new Product(
                        1,
                        "Java 6",
                        60000,
                        R.drawable.android,
                        "java6.pdf"
                ));
        productList.add(
                new Product(
                        1,
                        "Basic Classes",
                        60000,
                        R.drawable.android,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));
        productList.add(
                new Product(
                        1,
                        "Strings",
                        60000,
                        R.drawable.fb_icon,
                        "https://firebasestorage.googleapis.com/v0/b/firepdf-4c1d6.appspot.com/o/2.intro.pdf?alt=media&token=75731b04-c1e7-42c4-b988-e50a8f7e5f6b    "
                ));


        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

}