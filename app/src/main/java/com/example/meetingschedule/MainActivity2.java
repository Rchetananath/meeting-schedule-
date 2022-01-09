package com.example.meetingschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    EditText t1,t2,t3,t4,t5;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
    }
    public  void  startdbapp(View view)
    {
        new DbManager(this);
        startActivity(new Intent(this,InsertData.class));
    }
    public void addRecord(View view)
    {
        DbManager db= new DbManager(this);
        String res =db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t3.getText().toString(),t5.getText().toString());
        Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }
}