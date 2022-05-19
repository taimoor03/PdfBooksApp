package com.example.pdfbooks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private static final String FILE_EMAIL = "Rememberme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView signupbtn = findViewById(R.id.signup_btn);

        signupbtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        EditText emailinput = findViewById(R.id.email_input);
        EditText passwordinput = findViewById(R.id.Password_input);
        Button signbtn = findViewById(R.id.signin_btn);
        CheckBox rememberbox = findViewById(R.id.remember_me);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();



        SharedPreferences sharedPreferences = getSharedPreferences(FILE_EMAIL, MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();

        String saveEmail = sharedPreferences.getString("svemail", "");
        String savePassword = sharedPreferences.getString("svpassword", "");
        rememberbox.setChecked(sharedPreferences.contains("checked") && sharedPreferences.getBoolean("checked", false));
        emailinput.setText(saveEmail);
        passwordinput.setText(savePassword);


        signbtn.setOnClickListener(v -> {
                    String email = emailinput.getText().toString().trim();
                    String password = passwordinput.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        emailinput.setError("Email is Required.");
                        emailinput.requestFocus();
                        return;
                    }

                    if (rememberbox.isChecked()) {
                        editor.putBoolean("checked", true);
                        editor.apply();
                        StoreDataUsingSharedPref(email, password);

                    } else {
                        getSharedPreferences(FILE_EMAIL, MODE_PRIVATE).edit().clear().apply();
                    }
                    if (TextUtils.isEmpty(password)) {
                        passwordinput.setError("Password is Required.");
                        passwordinput.requestFocus();
                        return;
                    }

                    if (password.length() < 6) {
                        passwordinput.setError("Password Must be >= 6 Characters");
                        passwordinput.requestFocus();

                    }

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Error ! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    });


                }

        );


    }

    private void StoreDataUsingSharedPref(String email, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_EMAIL, MODE_PRIVATE).edit();
        editor.putString("svemail", email);
        editor.putString("svpassword", password);
        editor.apply();



    }
}






