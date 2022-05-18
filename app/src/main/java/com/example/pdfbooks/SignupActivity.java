package com.example.pdfbooks;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Objects.requireNonNull(getSupportActionBar()).hide();
        EditText username = findViewById(R.id.username_view);
        EditText email_ = findViewById(R.id.email_view);
        EditText number = findViewById(R.id.number_view);
        EditText passwrd = findViewById(R.id.password_view);
        EditText confirmpassword = findViewById(R.id.confirm_password_view);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        TextView loginbtn = findViewById(R.id.login_btn_intent);
        Button signupbtn = findViewById(R.id.signup_btn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = email_.getText().toString().trim();
                String password = passwrd.getText().toString().trim();
                String confirm_password = confirmpassword.getText().toString().trim();
                final String fullName = username.getText().toString();
                final String phone = number.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    email_.setError("Email is Required.");
                    email_.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    passwrd.setError("Password is Required.");
                    passwrd.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    passwrd.setError("Password Must be >= 6 Characters");
                    passwrd.requestFocus();
                    return;
                }
                if (!password.equals(confirm_password)) {
                    confirmpassword.setError("Password is not matched");
                    confirmpassword.requestFocus();
                    //  Toast.makeText(SignupActivity.this, "Password is not matched", Toast.LENGTH_SHORT).show();
                } else {

                    // register the user in firebase

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                // send verification link

                                FirebaseUser fuser = firebaseAuth.getCurrentUser();
                                fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        //     Toast.makeText(SignupActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                    }
                                });

                                Toast.makeText(SignupActivity.this, "Registration is Successful.", Toast.LENGTH_SHORT).show();
                                String userID = firebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String, Object> user = new HashMap<>();
                                user.put("fName", fullName);
                                user.put("email", email);
                                user.put("phone", phone);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            } else {
                                Toast.makeText(SignupActivity.this, "Error ! " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }}
            });




    }
}
