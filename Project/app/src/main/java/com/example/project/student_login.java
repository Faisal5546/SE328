package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class student_login extends AppCompatActivity {

    private EditText userEditText;
    private EditText passEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

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

                // Update login button's foreground drawable based on the condition
                if (hasText) {
                    // Set foreground drawable for active state
                    loginButton.setForeground(getResources().getDrawable(R.drawable.button___active));
                } else {
                    // Set foreground drawable for inactive state
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
                DatabaseHelper myDB = new DatabaseHelper(student_login.this, "University.db", null, 1);
                String username = userEditText.getText().toString();
                String password = passEditText.getText().toString();
                Cursor cur = myDB.ViewUser(username);
                if (cur.getCount() == 0) {
                    Toast.makeText(student_login.this, "Account not found. Please create an account.", Toast.LENGTH_LONG).show();
                } else {
                    cur.moveToNext();
                    String dbType = cur.getString(1);
                    String dbPass = cur.getString(2);
                    if (Objects.equals(dbPass, password) && Objects.equals(dbType, "Faculty")) {
                        Toast.makeText(student_login.this, "Please Log in Through Faculty Log in Page", Toast.LENGTH_LONG).show();
                    }
                    else if (Objects.equals(dbPass, password) && Objects.equals(dbType, "Student")) {
                        startActivity(new Intent(student_login.this, MainActivity2.class));
                    } else {
                        Toast.makeText(student_login.this, "Incorrect Password. Please try again.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
