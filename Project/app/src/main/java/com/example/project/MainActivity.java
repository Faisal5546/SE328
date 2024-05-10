package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // home activity

        Button addTest = (Button) findViewById(R.id.addTest);
        Button schedule = (Button) findViewById(R.id.mySchedule);
        Button addCourse = (Button) findViewById(R.id.addCourse);


        Button menuBtn = (Button) findViewById(R.id.menuBtn);

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

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, course_input.class));
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);

                // Inflate the menu from menu resource file
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Check the IDs of menu items, switch didn't work for some reason :(
                        if (item.getItemId() == R.id.homeMenuItem) {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                            return true;
                        } else if (item.getItemId() == R.id.myScheduleMenuItem) {
                            startActivity(new Intent(MainActivity.this, faculty_schedule.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addTestMenuItem) {
                            startActivity(new Intent(MainActivity.this, exam_input.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addCourseMenuItem) {
                            startActivity(new Intent(MainActivity.this, course_input.class));
                            return true;
                        }
                        return false;
                    }
                });

                // Show the PopupMenu
                popupMenu.show();
            }
        });
    }
}
