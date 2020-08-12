package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editfname,editlname,editaddress,editemail;
    Button save,view;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editfname = findViewById(R.id.fname);
        editlname = findViewById(R.id.lname);
        editaddress = findViewById(R.id.add);
        editemail = findViewById(R.id.email);
        save = findViewById(R.id.insert);
        view=findViewById(R.id.view);

        db = new DbHandler(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=editfname.getText().toString();
                String lname=editlname.getText().toString();
                String address=editaddress.getText().toString();
                String email=editemail.getText().toString();

                if(fname.equals("") | lname.equals("") |  address.equals("") |  email.equals("")){
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_LONG).show();
                }else{
                    db.insertStudent(fname,lname,address,email);
                    editfname.setText("");
                    editlname.setText("");
                    editaddress.setText("");
                    editemail.setText("");
                    Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);
            }
        });
    }
}