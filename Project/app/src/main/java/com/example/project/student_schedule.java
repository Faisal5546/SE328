package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class student_schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_schedule);

        Button menuBtn = (Button) findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(student_schedule.this, v);

                // Inflate the menu from menu resource file
                popupMenu.getMenuInflater().inflate(R.menu.menu_main2, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Check the IDs of menu items, switch didn't work for some reason :(
                        if (item.getItemId() == R.id.homeMenuItem) {
                            startActivity(new Intent(student_schedule.this, MainActivity2.class));
                            return true;
                        } else if (item.getItemId() == R.id.myScheduleMenuItem) {
                            startActivity(new Intent(student_schedule.this, student_schedule.class));
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