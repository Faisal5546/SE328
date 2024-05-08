package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // home activity

        Button addTest = (Button) findViewById(R.id.addTest);
        Button schedule = (Button) findViewById(R.id.mySchedule);

        addTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, exam_input.class));
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, faculty_schedule.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.homeMenuItem) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        } else if (id == R.id.myScheduleMenuItem) {
            startActivity(new Intent(MainActivity.this, faculty_schedule.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openOptionsMenu(View view) {
        openOptionsMenu();
    }
}
