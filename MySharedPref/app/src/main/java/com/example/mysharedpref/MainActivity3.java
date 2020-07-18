package com.example.mysharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edit1 =findViewById(R.id.name);
        edit2 =findViewById(R.id.regno);
        edit3 =findViewById(R.id.address);
        edit4 =findViewById(R.id.phone);
        button = findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("RegData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("NAME",edit1.getText().toString());
                editor.putString("REGNO",edit2.getText().toString());
                editor.putString("ADDRESS",edit3.getText().toString());
                editor.putString("PHONE",edit4.getText().toString());
                editor.commit();
                Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Data saved successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}