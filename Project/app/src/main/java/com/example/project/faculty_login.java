package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View; // Import View from android.view package
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
                startActivity(new Intent(faculty_login.this, MainActivity.class));
            }
        });

    }
}
