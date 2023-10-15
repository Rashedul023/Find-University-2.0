package com.example.find_university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class According extends AppCompatActivity {

    private String sub = "";
    Button phd5;
    Button master5;
    RecyclerView recyclerView5;
    MainAdapter mainAdapter5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_according);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(According.this,R.color.mainColor2));

        phd5 = findViewById(R.id.buttonPhd);
        master5 = findViewById(R.id.buttonMaster);

        recyclerView5 = findViewById(R.id.rvl5);
        recyclerView5.setLayoutManager(new LinearLayoutManager(this));




        // Get the currently logged-in user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

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
                            sub = user.getMajor();


                            Toast.makeText(According.this, sub, Toast.LENGTH_SHORT).show();
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

        phd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("CSE".equals(sub) || "cse".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("csed").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

               else if ("Mechanical Engineering".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("med").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Microbiology".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mbd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Fisheries".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("fid").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Agriculture".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("agd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else     if ("Textile Engineering".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ted").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Pharmacy".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("phd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Economics".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ecd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }


                else    if ("Architecture".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ard").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }


                else    if ("Islamic Study".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ihd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }


                else     if ("".equals(sub)) {
                    Toast.makeText(According.this, "Please wait", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(According.this, "Sorry this subject is not available", Toast.LENGTH_SHORT).show();
                }


            }
        });



        master5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("CSE".equals(sub) || "cse".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("csem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else if ("Mechanical Engineering".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Microbiology".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mbm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Fisheries".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("fim").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else   if ("Agriculture".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("agm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else  if ("Textile Engineering".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("tem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else  if ("Pharmacy".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("phm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else  if ("Economics".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ecm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }


                else  if ("Architecture".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("arm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }


                else  if ("Islamic Study".equals(sub)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ihm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter5 = new MainAdapter(options);
                    recyclerView5.setAdapter(mainAdapter5);
                    mainAdapter5.startListening();
                }

                else  if ("".equals(sub)) {
                    Toast.makeText(According.this, "Please wait", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(According.this, "Sorry this subject is not available", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mainAdapter5 != null) {
            mainAdapter5.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mainAdapter5 != null) {
            mainAdapter5.stopListening();
        }
    }
}