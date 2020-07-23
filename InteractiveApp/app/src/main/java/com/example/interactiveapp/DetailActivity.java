package com.example.interactiveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    TextView results;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        results = findViewById(R.id.result);
        logout=findViewById(R.id.logout);

        SharedPreferences pref = getSharedPreferences("RegData", Context.MODE_PRIVATE);
        String username =pref.getString("username","");
        String role =pref.getString("role","");
        results.setText("WELCOME " +username+ " :"+role);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("RegData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.clear();
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Data Cleared Successfully",Toast.LENGTH_SHORT).show();

            }
        });


    }
}