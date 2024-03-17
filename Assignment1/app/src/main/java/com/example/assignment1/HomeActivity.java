package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Variable declarations
        setContentView(R.layout.activity_home);
        ImageView grad_img = findViewById(R.id.graduation_img);
        ImageView baby_img = findViewById(R.id.baby_img);
        ImageView wedding_img = findViewById(R.id.wedding_img);
        ImageView birthday_img = findViewById(R.id.birthday_img);

        // Image Activities
        grad_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GraduationActivity.class));
            }
        });
        wedding_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, WeddingActivity.class));
            }
        });
        birthday_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, BirthdayActivity.class));

            }
        });
        baby_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GenderActivity.class));

            }
        });
    }
}