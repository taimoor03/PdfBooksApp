package com.example.pdfbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfbooks.adapter.ProductAdapter;
import com.example.pdfbooks.models.Product;
import com.google.firebase.auth.FirebaseAuth;

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
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);


        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "DS with Java\n",
                        60000,
                        R.drawable.dswithjava,
                        " https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FData%20Structures%20with%20Java%20(%20PDFDrive%20).pdf?alt=media&token=a4cfa50e-93ba-4136-b7f9-b01904c24611"
                ));

        productList.add(
                new Product(
                        1,
                        " Automobile Engineering \n",

                        60000,
                        R.drawable.automobileengineering,
                        "  https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2Fautomobileengineering.pdf?alt=media&token=8cb500a6-20ec-4fd0-9585-07707cc84dd1 "
                ));

        productList.add(
                new Product(
                        1,
                        "Basics of Automobile ",
                        60000,
                        R.drawable.basicsofautomobile,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2Fautomobile-basics.pdf?alt=media&token=3ce48fce-a045-4c26-83d9-32be27ce02a8"
                ));
        productList.add(
                new Product(
                        1,
                        "Hacking Gmail",
                        60000,
                        R.drawable.hackinggmail,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FHacking_Gmail_2006.pdf?alt=media&token=3ec3b04e-cfa2-4d28-a98b-24973d79db9d"
                ));
        productList.add(
                new Product(
                        1,
                        "Hardware Hacking",
                        60000,
                        R.drawable.hardwarehacking,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2Foriginalhackingmanual.pdf?alt=media&token=2ec517db-af90-4169-91ea-00556beab210"
                ));
        productList.add(
                new Product(
                        1,
                        " IOT",
                        60000,
                        R.drawable.internetofthings,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FInternet%20of%20Things%20(%20PDFDrive%20).pdf?alt=media&token=28097cd5-7b0b-4932-b406-d63c62766ab1"
                ));
        productList.add(
                new Product(
                        1,
                        "Learn C",
                        60000,
                        R.drawable.learncprogramming,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FExpert%20C%20Programming%20(%20PDFDrive%20).pdf?alt=media&token=d78fc6e1-c850-4fb4-82fb-0fbc98d5cbf1"
                ));
        productList.add(
                new Product(
                        1,
                        "Learn Python",
                        60000,
                        R.drawable.learnpython,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2Fpython_tutorial.pdf?alt=media&token=57606b77-a4c7-4834-a307-f4c57281b2b5"
                ));
        productList.add(
                new Product(
                        1,
                        "Matlab GUI",
                        60000,
                        R.drawable.matlabgui,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FMatlabBuildGUIs.pdf?alt=media&token=99147f19-ffb5-490f-9df2-66da154555b0"
                ));
        productList.add(
                new Product(
                        1,
                        "R Programming",
                        60000,
                        R.drawable.rprogramming,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FR%20Programming%20(%20PDFDrive%20).pdf?alt=media&token=12980324-7e1d-4c18-8e53-ff7ae8fcff29"
                ));
        productList.add(
                new Product(
                        1,
                        "Social Media Mining",
                        60000,
                        R.drawable.socialmediamining,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FSocial%20Media%20Mining%20(%20PDFDrive%20).pdf?alt=media&token=b722ff06-58b0-4b8b-817e-1da0c887477f"
                ));
        productList.add(
                new Product(
                        1,
                        "Social Media Marketing",
                        60000,
                        R.drawable.socialmediamarketing,
                        "https://firebasestorage.googleapis.com/v0/b/user-authentication-4022f.appspot.com/o/Pdfbooks%2FSocial%20Media%20Marketing.pdf?alt=media&token=bf72004f-6bee-4b9c-926a-5da9e1cc2e07"
                ));
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        //creating recyclerview adapter */
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.mybutton) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        }


        return (super.onOptionsItemSelected(item));
    }
}
