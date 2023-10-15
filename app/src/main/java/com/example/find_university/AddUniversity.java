package com.example.find_university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUniversity extends AppCompatActivity {

    Button submit2;
    EditText aVarsity,aurl,aid,astudent,acgpa,afee,aielts,aarea,acountry,acsem,acsed,aphm,aphd,aecd,aecm,aard,aarm,aihd,aihm,ambd,ambm,afid,
    afim,aagd,aagm,ated,atem,arank;

    private String bVarsity,burl,bid,bcountry,bcsem,bcsed,bphd,bphm,becd,becm,bard,barm,bihd,bihm,bmbd,bmbm,bfid,bfim,bagd,bagm,bted,btem;
    private String bmed="n";
    private String bmem="y";
    private Long bstudent,bfee,barea,brank;
    private Double bcgpa, bielts;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_university);
        getWindow().setStatusBarColor(ContextCompat.getColor(AddUniversity.this,R.color.black));

        submit2=findViewById(R.id.submit2);

        aVarsity = findViewById(R.id.aVarsityname);
        aid =findViewById(R.id.aid);
                astudent=findViewById(R.id.astudent);
        acgpa=findViewById(R.id.acgpa);
                afee=findViewById(R.id.afee);
        aielts=findViewById(R.id.aielts);
                aarea=findViewById(R.id.aarea);
        acountry=findViewById(R.id.acountry);
                acsem=findViewById(R.id.acsem);
        acsed=findViewById(R.id.acsed);
                aphm=findViewById(R.id.aphm);
        aphd=findViewById(R.id.aphd);
                aecd=findViewById(R.id.aecd);
        aecm=findViewById(R.id.aecm);
                aard=findViewById(R.id.aard);
        aarm=findViewById(R.id.aarm);
                aihd=findViewById(R.id.aihd);
        aihm=findViewById(R.id.aihm);
                ambd=findViewById(R.id.ambd);
        ambm=findViewById(R.id.ambm);
                afid=findViewById(R.id.afid);
                afim=findViewById(R.id.afim);
        aagd=findViewById(R.id.aagd);
                aagm=findViewById(R.id.aagm);
        ated=findViewById(R.id.ated);
                atem=findViewById(R.id.atem);
        aurl=findViewById(R.id.aurl);
        arank = findViewById(R.id.rank);



        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bstudent = Long.valueOf(astudent.getText().toString());
                bfee =  Long.valueOf(afee.getText().toString());
                barea =  Long.valueOf(aarea.getText().toString());
                brank = Long.valueOf(arank.getText().toString());

                bcgpa = Double.valueOf(acgpa.getText().toString());
                bielts = Double.valueOf(aielts.getText().toString());

                bVarsity=aVarsity.getText().toString();
                        burl=aurl.getText().toString();
                bid=aid.getText().toString();
                        bcountry=acountry.getText().toString();
                bcsem=acsem.getText().toString();
                        bcsed=acsed.getText().toString();
                bphd=aphd.getText().toString();
                        bphm=aphm.getText().toString();
                becd=aecd.getText().toString();
                        becm=aecm.getText().toString();
                bard=aard.getText().toString();
                        barm=aarm.getText().toString();
                bihd=aihd.getText().toString();
                        bihm=aihm.getText().toString();
                bmbd=ambd.getText().toString();
                        bmbm=ambm.getText().toString();
                bfid=afid.getText().toString();
                        bfim=afim.getText().toString();
                bagd=aagd.getText().toString();
                        bagm=aagm.getText().toString();
                bted=ated.getText().toString();
                        btem=atem.getText().toString();
                burl=aurl.getText().toString();

                MainModel obj = new MainModel(bVarsity,barea,bcgpa,bcountry,bfee,bstudent,bielts,burl,brank,bcsem,bcsed,bihd,bihm
                ,becd,becm,bmbd,bmbm,bphd,bphm,bard,barm,bfid,bfim,bagd,bagm,bted,btem,bmed,bmem);

                database=FirebaseDatabase.getInstance();
                mDatabase = database.getReference("varsity");
                mDatabase.child(bid).setValue(obj);

                Toast.makeText(AddUniversity.this, "Submitted", Toast.LENGTH_SHORT).show();

            }
        });
    }
}