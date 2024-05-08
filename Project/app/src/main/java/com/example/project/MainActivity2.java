package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button schedule = (Button) findViewById(R.id.mySchedule);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, student_schedule.class));
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
            startActivity(new Intent(faculty_schedule.this, MainActivity.class));
            return true;
        } else if (id == R.id.myScheduleMenuItem) {
            startActivity(new Intent(faculty_schedule.this, faculty_schedule.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openOptionsMenu(View view) {
        openOptionsMenu();
    }
}