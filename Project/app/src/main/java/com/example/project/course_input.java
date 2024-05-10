package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class course_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_input);

        Button menuBtn = (Button) findViewById(R.id.menuBtn);

        Button backImage = findViewById(R.id.back);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous activity
                finish();
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(course_input.this, v);

                // Inflate the menu from menu resource file
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Check the IDs of menu items, switch didn't work for some reason :(
                        if (item.getItemId() == R.id.homeMenuItem) {
                            startActivity(new Intent(course_input.this, MainActivity.class));
                            return true;
                        } else if (item.getItemId() == R.id.myScheduleMenuItem) {
                            startActivity(new Intent(course_input.this, faculty_schedule.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addTestMenuItem) {
                            startActivity(new Intent(course_input.this, exam_input.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addCourseMenuItem) {
                            startActivity(new Intent(course_input.this, course_input.class));
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