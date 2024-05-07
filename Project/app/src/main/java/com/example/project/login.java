package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    Button faBtn;
    Button stBtn;
    Button forgotUsernameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button faBtn = (Button) findViewById(R.id.facultyLogin);
        Button stBtn = (Button) findViewById(R.id.studentLogin);
        forgotUsernameButton = findViewById(R.id.forgotUsername);

        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,faculty_login.class));
            }
        });

        stBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, student_login.class));
            }
        });

        forgotUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, forgot_username.class));
            }
        });
    }
}