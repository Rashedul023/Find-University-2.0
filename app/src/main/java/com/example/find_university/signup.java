package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    TextInputLayout t1, t2, t0,t3,t4,t5;
    ProgressBar bar;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;

    private String uname;
    private String major;
    private String scgpa;
    private String sielts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));

        t0 = findViewById(R.id.name);
        t1 = findViewById(R.id.email);
        t2 = findViewById(R.id.password);
        t3 = findViewById(R.id.major);
        t4 = findViewById(R.id.scgpa);
        t5 = findViewById(R.id.sielts);
        bar = findViewById(R.id.progressBar2);

        bar.setVisibility(View.INVISIBLE);

        Button Submit = findViewById(R.id.submit);
        Button Already = findViewById(R.id.already);

        Already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, log.class);
                startActivity(intent);
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View view) {
                String email = t1.getEditText().getText().toString();
                String password = t2.getEditText().getText().toString();
                major = t3.getEditText().getText().toString();
                uname = t0.getEditText().getText().toString();
                scgpa = t4.getEditText().getText().toString();
                sielts = t5.getEditText().getText().toString();

                bar.setVisibility(View.VISIBLE);

                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input email", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                }
                else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input password", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                }

                else if (scgpa.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input CGPA", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                }
                else if (sielts.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input IELTS", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                }
                else if (major.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please input Major", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                }

                else {
                    mAuth = FirebaseAuth.getInstance();

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        if (currentUser != null) {
                                            // Successfully registered, update UI and save user data
                                            bar.setVisibility(View.INVISIBLE);
                                            t0.getEditText().setText("");
                                            t1.getEditText().setText("");
                                            t2.getEditText().setText("");
                                            t3.getEditText().setText("");
                                            t4.getEditText().setText("");
                                            t5.getEditText().setText("");
                                            String uid = currentUser.getUid();

                                            // Set the user's name using setUname method
                                            User user = new User(uname, major, uid, scgpa, sielts);

                                            // Call updateUI with the user's UID and name
                                            updateUI(uid, user);

                                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(signup.this, log.class);
                                            startActivity(intent);
                                        }
                                    } else {
                                        // Registration failed
                                        Toast.makeText(getApplicationContext(), "Registration Error, Please try again.", Toast.LENGTH_SHORT).show();
                                        bar.setVisibility(View.INVISIBLE);
                                        t0.getEditText().setText("");
                                        t1.getEditText().setText("");
                                        t2.getEditText().setText("");
                                        t3.getEditText().setText("");
                                        t4.getEditText().setText("");
                                        t5.getEditText().setText("");
                                    }
                                }
                            });
                }
            }
        });
    }

    public void updateUI(String uid, User user) {
        if (mDatabase == null) {
            // Initialize Firebase Database reference
            database = FirebaseDatabase.getInstance();
            mDatabase = database.getReference("users"); // Replace "users" with the actual path you want to store user data in
        }

        if (uid != null && user != null) {
            String keyid = mDatabase.push().getKey();
            mDatabase.child(uid).setValue(user); // Adding user info to database under UID
        }
    }
}
