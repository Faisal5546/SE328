package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View; // Import View from android.view package
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class faculty_login extends AppCompatActivity {

    EditText userEditText;
    EditText passEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        userEditText = findViewById(R.id.user);
        passEditText = findViewById(R.id.pass);
        loginButton = findViewById(R.id.login);


        ImageView backImage = findViewById(R.id.back);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous activity
                finish();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Check if both user and pass EditText fields have text
                String userText = userEditText.getText().toString();
                String passText = passEditText.getText().toString();
                boolean hasText = !userText.isEmpty() && !passText.isEmpty();

                if (hasText) {
                    // set foreground drawable for active state
                    loginButton.setForeground(getResources().getDrawable(R.drawable.button___active));
                } else {
                    // set foreground drawable for inactive state
                    loginButton.setForeground(getResources().getDrawable(R.drawable.button___inactive));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        userEditText.addTextChangedListener(textWatcher);
        passEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDB = new DatabaseHelper(faculty_login.this, "University.db", null, 1);
                String username = userEditText.getText().toString();
                String password = passEditText.getText().toString();
                Cursor cur = myDB.ViewUser(username);
//                if (cur.getCount() == 0) {
//                    Toast.makeText(faculty_login.this, "Account not found. Please create an account.", Toast.LENGTH_LONG).show();
//                } else {
//                    cur.moveToNext();
//                    String dbType = cur.getString(1);
//                    String dbPass = cur.getString(2);
//                    if (Objects.equals(dbPass, password) && Objects.equals(dbType, "Student")) {
//                        Toast.makeText(faculty_login.this, "Please Log in Through Student Log in Page", Toast.LENGTH_LONG).show();
//                    }
//                    else if (Objects.equals(dbPass, password) && Objects.equals(dbType, "Faculty")) {
                        startActivity(new Intent(faculty_login.this, MainActivity.class));
//                    } else {
//                        Toast.makeText(faculty_login.this, "Incorrect Password. Please try again.", Toast.LENGTH_LONG).show();
//                    }
//                }
            }
        });

    }
}
