package com.example.pdfbooks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText resetinput = findViewById(R.id.resetpass_email_input);
        Button sendemail = findViewById(R.id.resetpass_button);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              resetpassword();

            }


            public void resetpassword() {
                String email=resetinput.getText().toString().trim();

                if(email.isEmpty()){
                    resetinput.setError("Email is required!");
                    resetinput.requestFocus();
                }
               // if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                 //   resetinput.setError("Please provide valid email");
                 //   resetinput.requestFocus();
               // }
                progressBar.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(ForgotPasswordActivity.this, "Check your email to reset your password", Toast.LENGTH_LONG).show();
                    finish();
                    Intent intent=new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                    startActivity(intent);
                    }
                    else{
                        Toast.makeText(ForgotPasswordActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent=new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }

                });
            }
        });


    }





}