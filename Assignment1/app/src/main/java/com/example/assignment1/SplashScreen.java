package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed (
            new Runnable() {
                public void run () {
                    startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                    finish();
                }
            }, 2000
        );
        Toast.makeText(this,"Welcome to my App",Toast.LENGTH_LONG).show();
    }
}