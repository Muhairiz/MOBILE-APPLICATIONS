package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Activity onDestroy",Toast.LENGTH_LONG).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this,"Activity onPause",Toast.LENGTH_LONG).show();
    }

    public void onRestart(){
        super.onRestart();
        Toast.makeText(this,"Activity onRestart",Toast.LENGTH_LONG).show();
    }

    public void onResume(){
        super.onResume();
        Toast.makeText(this,"Activity onResume",Toast.LENGTH_LONG).show();
    }

    public void onStart(){
        super.onStart();
        Toast.makeText(this,"Activity onStart",Toast.LENGTH_LONG).show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this,"Activity onStop",Toast.LENGTH_LONG).show();
    }


}