package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.PopupMenu;


public class exam_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_input);

        Button menuBtn = (Button) findViewById(R.id.menuBtn);

        Button backImage = findViewById(R.id.back);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous activity
                finish();
            }
        });
/*
        EditText code = findViewById(R.id.codeInput);
        Spinner level = findViewById(R.id.levelSpinner);
        Spinner department = findViewById(R.id.departmentSpinner);
        Spinner day = findViewById(R.id.daySpinner);
        Spinner month = findViewById(R.id.monthSpinner);
        Spinner time = findViewById(R.id.timeSpinner);
        Spinner type = findViewById(R.id.typeSpinner);
        Spinner location = findViewById(R.id.locationSpinner);
        Button reserve_btn = findViewById(R.id.reserveBtn);
        CheckBox confirm = findViewById(R.id.confirmChk);

        DatabaseHelper myDB = new DatabaseHelper(this, "University.db", null, 1);
        reserve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!confirm.isChecked()) {
                    Toast.makeText(exam_input.this, "Please confirm the information.", Toast.LENGTH_LONG).show();
                    return;
                }
                String course_code = code.getText().toString();
                String course_level = level.getSelectedItem().toString();
                String course_department = department.getSelectedItem().toString();
                String exam_day = day.getSelectedItem().toString();
                String exam_month = month.getSelectedItem().toString();
                String exam_time = time.getSelectedItem().toString();
                String exam_type = type.getSelectedItem().toString();
                String exam_location = location.getSelectedItem().toString();

                if (!myDB.isConflict(course_department, exam_day, exam_month, exam_time, exam_location, course_level)) {
                    try {
                        myDB.AddCourse(course_code, exam_day, exam_month, exam_time, course_department, course_level, exam_type, exam_location);
                    } catch (Exception e) {
                        Toast.makeText(exam_input.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(exam_input.this, "There is a conflict with another exam.", Toast.LENGTH_LONG).show();
                }
            }
        });

 */

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(exam_input.this, v);

                // Inflate the menu from menu resource file
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Check the IDs of menu items, switch didn't work for some reason :(
                        if (item.getItemId() == R.id.homeMenuItem) {
                            startActivity(new Intent(exam_input.this, MainActivity.class));
                            return true;
                        } else if (item.getItemId() == R.id.myScheduleMenuItem) {
                            startActivity(new Intent(exam_input.this, faculty_schedule.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addTestMenuItem) {
                            startActivity(new Intent(exam_input.this, exam_input.class));
                            return true;
                        }
                        else if (item.getItemId() == R.id.addCourseMenuItem) {
                            startActivity(new Intent(exam_input.this, course_input.class));
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