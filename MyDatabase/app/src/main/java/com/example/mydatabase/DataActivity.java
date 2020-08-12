package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    DbHandler db;
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        view=findViewById(R.id.text1);
        db = new DbHandler(this);
        String data= db.getData();
        view.setText(data);
        view.setMovementMethod(new ScrollingMovementMethod());

    }
}