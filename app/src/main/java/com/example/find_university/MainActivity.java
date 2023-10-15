package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.canvas.CanvasCompat;

public class MainActivity extends AppCompatActivity {
    Button searchButton, filterButton, subjectButton, favButton, accButton, update;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.mainColor)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.mainColor2));

        searchButton= findViewById(R.id.searchButton);

        subjectButton = findViewById(R.id.subjectButton);
        favButton = findViewById(R.id.favouriteButton);
        accButton = findViewById(R.id.accordingButton);



        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,According.class);
                startActivity(intent);
            }
        });

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FavouriteList.class);
                startActivity(intent);
            }
        });



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Combine.class);
                startActivity(intent);
            }
        });



        subjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Subject.class);
                startActivity(intent2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.profileId){
            Intent intent = new Intent(MainActivity.this,profile.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.changeId){
            Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.profileId2){
            Intent intent = new Intent(MainActivity.this,profile.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.changeId2){
            Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}