package com.example.find_university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Subject extends AppCompatActivity {

    private String s = "";
    Button phd;
    Button master;
    RecyclerView recyclerView2;
    MainAdapter mainAdapter2;
    DatabaseReference likereference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(Subject.this,R.color.mainColor2));
        likereference=FirebaseDatabase.getInstance().getReference("likes");

        phd = findViewById(R.id.phdButton);
        master = findViewById(R.id.masterButton);

        recyclerView2 = findViewById(R.id.rvl2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        String[] type = new String[] {"CSE", "Pharmacy", "Economics", "Architecture", "Islamic Study", "Microbiology",
                "Fisheries", "Agriculture", "Mechanical Engineering","Textile Engineering"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                type
        );

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.filled_exposed);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s = autoCompleteTextView.getText().toString();
                Toast.makeText(Subject.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("CSE".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("csed").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Mechanical Engineering".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("med").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Microbiology".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mbd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Fisheries".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("fid").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Agriculture".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("agd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Textile Engineering".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ted").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Pharmacy".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("phd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Economics".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ecd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }


                if ("Architecture".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ard").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }


                if ("Islamic Study".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ihd").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }


                if ("".equals(s)) {
                    Toast.makeText(Subject.this, "Please input a subject", Toast.LENGTH_SHORT).show();
                }


            }
        });



        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("CSE".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("csem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Mechanical Engineering".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Microbiology".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("mbm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Fisheries".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("fim").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Agriculture".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("agm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Textile Engineering".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("tem").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Pharmacy".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("phm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("Economics".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ecm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }


                if ("Architecture".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("arm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }


                if ("Islamic Study".equals(s)) {

                    FirebaseRecyclerOptions<MainModel> options =
                            new FirebaseRecyclerOptions.Builder<MainModel>()
                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                                    .orderByChild("ihm").equalTo("y"),
                                            MainModel.class)
                                    .build();
                    mainAdapter2 = new MainAdapter(options);
                    recyclerView2.setAdapter(mainAdapter2);
                    mainAdapter2.startListening();
                }

                if ("".equals(s)) {
                    Toast.makeText(Subject.this, "Please input a subject", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mainAdapter2 != null) {
            mainAdapter2.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mainAdapter2 != null) {
            mainAdapter2.stopListening();
        }
    }
}
