package com.example.college_canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;

public class sregister extends AppCompatActivity {

    EditText sid,sname,mail,pno,p,cp;
    Button reg;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sregister);
        db=openOrCreateDatabase("canteen", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists std(sid varchar, sname varchar, mail varchar, phone integer, p varchar);");
        db.execSQL("create table if not exists wallet(sid varchar, balance integer);");
        sid=(EditText)findViewById(R.id.editTextTextPersonName2);
        sname=(EditText)findViewById(R.id.editTextTextPersonName3);
        mail=(EditText)findViewById(R.id.editTextTextEmailAddress);
        pno=(EditText)findViewById(R.id.editTextPhone);
        p=(EditText)findViewById(R.id.editTextTextPassword2);
        reg=(Button) findViewById(R.id.button4);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("insert into std values('"+sid.getText()+"','"+sname.getText()+"','"+mail.getText()+"','"+pno.getText()+"','"+p.getText()+"')");
                db.execSQL("insert into wallet values('"+sid.getText()+"',0)");
                Toast.makeText(getApplicationContext(),"Registration Successfully Done", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(sregister.this, login_s.class);
                startActivity(i);
                clearText();
            }
        });

    }
    public void clearText()
    {
        sid.setText("");
        sname.setText("");
        mail.setText("");
        pno.setText("");
        p.setText("");
        cp.setText("");
    }
}