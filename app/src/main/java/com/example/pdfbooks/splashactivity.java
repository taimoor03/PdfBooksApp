package com.example.pdfbooks;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class splashactivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
        Objects.requireNonNull(getSupportActionBar()).hide();
        new Handler().postDelayed(() -> {
            Intent intent=new Intent(splashactivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        },6000);
    }
}