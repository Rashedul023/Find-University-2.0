package com.example.find_university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log; // Import Log
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    private TextView textViewUserName, textMajor, textCgpa, textIelts;
    private Button change;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(profile.this,R.color.mainColor2));

        // Initialize views
        textViewUserName = findViewById(R.id.textViewUserName);
        textMajor = findViewById(R.id.textmajor);
        textCgpa = findViewById(R.id.textcgpa);
        textIelts = findViewById(R.id.textielts);
        change = findViewById(R.id.buttonChange);

        // Get the currently logged-in user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        if (currentUser != null) {
            // User is logged in, retrieve and display their name
            String uid = currentUser.getUid();

            // Retrieve the user's name from Firebase Realtime Database
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users"); // Correct path

            databaseReference.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        User user = dataSnapshot.getValue(User.class);
                        if (user != null) {
                            String userName = user.getUname();
                            textViewUserName.setText("Name: " + userName);

                            String userMajor = user.getMajor();
                            String userCgpa = user.getCgpa();
                            String userIelts = user.getIelts();

                            textMajor.setText("Your Major: " + userMajor);
                            textCgpa.setText("Your CGPA: "+ userCgpa);
                            textIelts.setText("Your IELTS Score: "+userIelts);





                            // Debugging: Print the retrieved name to log
                            Log.d("FirebaseDebug", "Retrieved name: " + userName);
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle the error
                    Log.e("FirebaseError", "Error: " + databaseError.getMessage());
                }
            });
        }
    }
}
