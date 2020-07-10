package com.example.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.support.v4.content.ContextCompat.startActivity;

public class MainActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get EditText references
        nameEditText = findViewById(R.id.input_name);
        lastNameEditText = findViewById(R.id.input_lastName);
        emailEditText = findViewById(R.id.input_email);
        phoneNumberEditText = findViewById(R.id.input_phoneNumber);

        Button button = findViewById(R.id.button_create_contact);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();

                //Get values from EditText and create a new Contact
                Integer phoneNumberInt = parsePhoneNumber(phoneNumber);
                if (phoneNumberInt != null) {
                    createNewContact(name, lastName, email, phoneNumberInt);
                }
            }
        });
    }

    private void createNewContact(String name, String lastName, String email, Integer phoneNumber) {
        Contact contact = new Contact(name, lastName, email, phoneNumber);
        Log.d(TAG, "New contact created: " + contact.toString());
        clearEditText();

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);
        intent.putExtra("email", email);
        intent.putExtra("phoneNumber", phoneNumber);
        startActivity(intent);
    }

    private void clearEditText() {
        nameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
    }

    public static Integer parsePhoneNumber(String phoneNumber) {
        try {
            return Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
