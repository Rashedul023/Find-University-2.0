package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Combine extends AppCompatActivity {

    RecyclerView recyclerView;
    FilteredAdapter filteredAdapter;
    EditText country, ieltsScore, cgpa, tuitionFee;
    Button buttonApplyFilters;
    private CheckBox c1,c2,c3,c4;
    MainAdapter mainAdapter;

    private String cf,cgf,ief,fef ;
    private double ieltsFilter = 9;
    private double cgpaFilter=4 ;
    private double tuitionFeeFilter=500000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(Combine.this, R.color.mainColor2));

        c1 = findViewById(R.id.checkBox7);
        c2 = findViewById(R.id.checkBox8);
        c3 = findViewById(R.id.checkBox9);
        c4 = findViewById(R.id.checkBox10);

        country = findViewById(R.id.countryFilter);
        ieltsScore = findViewById(R.id.ieltsFilter);
        cgpa = findViewById(R.id.cgpaFilter);
        tuitionFee = findViewById(R.id.tuitionFeeFilter);
        buttonApplyFilters = findViewById(R.id.buttonApplyFilters);

        recyclerView = findViewById(R.id.rvl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonApplyFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyFilters();
            }
        });
    }

    private void applyFilters() {

        cf = country.getText().toString();
        ief = ieltsScore.getText().toString();
        cgf = cgpa.getText().toString();
        fef = tuitionFee.getText().toString();

        if(ief.isEmpty()){}
        else{ieltsFilter = Double.parseDouble(ieltsScore.getText().toString());}

        if(cgf.isEmpty()){}
        else { cgpaFilter = Double.parseDouble(cgpa.getText().toString());}

        if(fef.isEmpty()){}
        else
        { tuitionFeeFilter = Double.parseDouble(tuitionFee.getText().toString());}



        if(cf.isEmpty()){cf ="Ban";}


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("varsity");

        Query query = reference.orderByChild("varsity");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<MainModel> filteredUniversities = new ArrayList<>();


                if(c1.isChecked() && c2.isChecked() && c3.isChecked() && c4.isChecked()){

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MainModel university = snapshot.getValue(MainModel.class);

                    if (university != null
                            && university.getCountry().equals(cf)
                            && university.getIelts() <= ieltsFilter
                            && university.getCgpa() <= cgpaFilter
                            && university.getFee() <= tuitionFeeFilter) {
                        filteredUniversities.add(university);
                    }
                }

                // Create a new adapter for the filtered list and set it to the RecyclerView
                filteredAdapter = new FilteredAdapter(filteredUniversities);
                recyclerView.setAdapter(filteredAdapter);}



                //Start

             else   if(c1.isChecked() && c2.isChecked() && c3.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)
                                && university.getIelts() <= ieltsFilter
                                && university.getCgpa() <= cgpaFilter
                               ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if(c1.isChecked() && c2.isChecked() && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)
                                && university.getIelts() <= ieltsFilter

                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if(c1.isChecked()  && c3.isChecked() && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)

                                && university.getCgpa() <= cgpaFilter
                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if( c2.isChecked() && c3.isChecked() && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getIelts() <= ieltsFilter
                                && university.getCgpa() <= cgpaFilter
                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if(c1.isChecked() && c2.isChecked() ){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)
                                && university.getIelts() <= ieltsFilter
                              ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if(c1.isChecked() &&  c3.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)

                                && university.getCgpa() <= cgpaFilter
                               ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if(c1.isChecked()  && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)

                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if(c2.isChecked() && c3.isChecked() ){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getIelts() <= ieltsFilter
                                && university.getCgpa() <= cgpaFilter
                                ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if( c2.isChecked()  && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getIelts() <= ieltsFilter

                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}




                //Start

                else   if( c3.isChecked() && c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getCgpa() <= cgpaFilter
                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if(c1.isChecked() ){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null
                                && university.getCountry().equals(cf)
                             ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}



                //Start

                else   if( c2.isChecked() ){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getIelts() <= ieltsFilter
                               ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if( c3.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null


                                && university.getCgpa() <= cgpaFilter
                               ) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}


                //Start

                else   if( c4.isChecked()){

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainModel university = snapshot.getValue(MainModel.class);

                        if (university != null

                                && university.getFee() <= tuitionFeeFilter) {
                            filteredUniversities.add(university);
                        }
                    }

                    // Create a new adapter for the filtered list and set it to the RecyclerView
                    filteredAdapter = new FilteredAdapter(filteredUniversities);
                    recyclerView.setAdapter(filteredAdapter);}





             else{
                    Toast.makeText(Combine.this, "Select please", Toast.LENGTH_SHORT).show();
                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("varsity")
                                        .orderByChild("name").startAt(str).endAt(str+"\uf8ff")
                                ,MainModel.class)
                        .build();
        mainAdapter = new MainAdapter(options);
        mainAdapter.startListening();
        recyclerView.setAdapter(mainAdapter);
    }
}
