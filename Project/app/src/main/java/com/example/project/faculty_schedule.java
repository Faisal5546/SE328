package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.View;
public class faculty_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_schedule);
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
