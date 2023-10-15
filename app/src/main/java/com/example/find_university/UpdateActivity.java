package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {

    private TextInputLayout majorInputLayout, cgpaInputLayout, ieltsInputLayout;
    private EditText majorEditText, cgpaEditText, ieltsEditText;
    private Button updateButton;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(UpdateActivity.this,R.color.mainColor2));

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("users");

        majorInputLayout = findViewById(R.id.updateMajor);
        cgpaInputLayout = findViewById(R.id.updateCGPA);
        ieltsInputLayout = findViewById(R.id.updateIELTS);

        majorEditText = findViewById(R.id.majorEditText);
        cgpaEditText = findViewById(R.id.cgpaEditText);
        ieltsEditText = findViewById(R.id.ieltsEditText);

        updateButton = findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserInfo();
            }
        });
    }

    private void updateUserInfo() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String uid = currentUser.getUid();
            String major = majorEditText.getText().toString().trim();
            String cgpa = cgpaEditText.getText().toString().trim();
            String ielts = ieltsEditText.getText().toString().trim();

            // Update the user's information in the database
            mDatabase.child(uid).child("major").setValue(major);
            mDatabase.child(uid).child("cgpa").setValue(cgpa);
            mDatabase.child(uid).child("ielts").setValue(ielts);

            Toast.makeText(UpdateActivity.this, "User information updated successfully", Toast.LENGTH_SHORT).show();
        } else {
            // User not authenticated
            Toast.makeText(UpdateActivity.this, "User not authenticated", Toast.LENGTH_SHORT).show();
        }
    }
}
