package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class forgot_username extends AppCompatActivity {

    EditText userIdEditText;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_username);

        loginButton = findViewById(R.id.login);
        userIdEditText = (EditText) findViewById(R.id.userId);

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
                // Check if user id EditText field has text
                String userID = userIdEditText.getText().toString();
                boolean hasText = !userID.isEmpty();

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

        userIdEditText.addTextChangedListener(textWatcher);
    }
}