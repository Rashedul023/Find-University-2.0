package com.example.find_university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Check extends AppCompatActivity {

    EditText pass;
    Button checkPass;
    private String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        getWindow().setStatusBarColor(ContextCompat.getColor(Check.this,R.color.black));

        pass = findViewById(R.id.TextPassword);
        checkPass = findViewById(R.id.passwordEnter);

        checkPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p= pass.getText().toString();

                if(p.equals("2003023")){
                Intent intent = new Intent(Check.this,AddUniversity.class);
                startActivity(intent);}
                else {
                    Toast.makeText(Check.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}