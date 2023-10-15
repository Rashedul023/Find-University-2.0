package com.example.find_university;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class log extends AppCompatActivity {

    EditText emailLog;
    EditText passLog;
    private String elog;
    private String plog;

    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();

        passLog = findViewById(R.id.passlog);
        emailLog = findViewById(R.id.emaillog);


        Button Dont = findViewById(R.id.dont);
        Button Log = findViewById(R.id.login);

        Dont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(log.this, signup.class);
                startActivity(intent);
            }
        });

        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elog = emailLog.getText().toString();
                plog = passLog.getText().toString();

                if(elog.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input email", Toast.LENGTH_SHORT).show();
                }

                else if(plog.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input password", Toast.LENGTH_SHORT).show();
                }

                else{

                mAuth.signInWithEmailAndPassword(elog, plog)
                        .addOnCompleteListener(log.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    if (elog.equals("rashedul16801@gmail.com")){
                                        Intent intent = new Intent(log.this, Admin.class);
                                        startActivity(intent);
                                    }
                                    else{
                                    Intent intent = new Intent(log.this, MainActivity.class);
                                    startActivity(intent);
                                    }
                                }

                                else {
                                    emailLog.setText("");
                                    passLog.setText("");
                                    Toast.makeText(getApplicationContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });}

            }
        });

    }
}