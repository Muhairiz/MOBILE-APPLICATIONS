package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ToggleButton btntoggle;
    Spinner spinner;
    CheckBox check1,check2,check3;
    TimePicker timePicker;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btntoggle=findViewById(R.id.togglebtn);
        spinner=findViewById(R.id.spn);
        check1=findViewById(R.id.check1);
        check2=findViewById(R.id.check2);
        check3=findViewById(R.id.check3);
        timePicker=findViewById(R.id.tmpick);
        datePicker=findViewById(R.id.dpick);

        final ArrayList<String> language= new ArrayList<>();
        language.add("Java");
        language.add("Python");
        language.add("C++");
        language.add("PHP");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,language);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),"You selected"+language.get(i),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You selected Apple",Toast.LENGTH_SHORT).show();
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You selected Orange",Toast.LENGTH_SHORT).show();
            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You selected Pineapple",Toast.LENGTH_SHORT).show();
            }
        });

        btntoggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btntoggle.isChecked()){
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minutes) {
                Toast.makeText(getApplicationContext(),hourOfDay+":"+minutes,Toast.LENGTH_SHORT).show();
            }
        });

        Calendar calendar=Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date =day+"/"+month+"/"+year;
                Toast.makeText(MainActivity.this,date,Toast.LENGTH_SHORT).show();
            }
        });


    }
}