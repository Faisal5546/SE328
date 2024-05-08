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
import android.widget.Spinner;
import android.widget.Toast;

public class exam_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_input);
        EditText code = findViewById(R.id.codeInput);
        Spinner level = findViewById(R.id.levelSpinner);
        Spinner deparment = findViewById(R.id.departmentSpinner);
        Spinner day = findViewById(R.id.daySpinner);
        Spinner month = findViewById(R.id.monthSpinner);
        Spinner time = findViewById(R.id.timeSpinner);
        Spinner type = findViewById(R.id.typeSpinner);
        Spinner duration = findViewById(R.id.durationSpinner);
        Spinner location = findViewById(R.id.locationSpinner);
        Button reserve_btn = findViewById(R.id.reserveBtn);
        CheckBox confirm = findViewById(R.id.confirmChk);

        DatabaseHelper myDB = new DatabaseHelper(this, "University.db", null, 1);
        reserve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course_code = code.getText().toString();
                String course_level = level.getSelectedItem().toString();
                String course_department = deparment.getSelectedItem().toString();
                String exam_day = day.getSelectedItem().toString();
                String exam_month = month.getSelectedItem().toString();
                String exam_time = time.getSelectedItem().toString();
                String exam_type = type.getSelectedItem().toString();
                String exam_duration = duration.getSelectedItem().toString();
                String exam_location = location.getSelectedItem().toString();

                if () {

                } else {
                    StringBuilder buffer = new StringBuilder();
                    while (cur.moveToNext()) {
                        buffer.append("Course ID: ").append(cur.getString(0)).append("\n");
                        buffer.append("Course Name: ").append(cur.getString(1)).append("\n");
                        buffer.append("Exam Date: ").append(cur.getString(2)).append("\n");
                        buffer.append("Exam Time: ").append(cur.getString(3)).append("\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(FacultyDashboard.this);
                    builder.setMessage(buffer.toString());
                    builder.setTitle("Conflicting Exams:");
                    builder.show();
                }
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
            startActivity(new Intent(exam_input.this, MainActivity.class));
            return true;
        } else if (id == R.id.myScheduleMenuItem) {
            startActivity(new Intent(exam_input.this, faculty_schedule.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openOptionsMenu(View view) {
        openOptionsMenu();
    }
}