package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button schedule = (Button) findViewById(R.id.mySchedule);
        Button menuBtn = (Button) findViewById(R.id.menuBtn);

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, student_schedule.class));
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a PopupMenu
                PopupMenu popupMenu = new PopupMenu(MainActivity2.this, v);

                // Inflate the menu from menu resource file
                popupMenu.getMenuInflater().inflate(R.menu.menu_main2, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Check the IDs of menu items, switch didn't work for some reason :(
                        if (item.getItemId() == R.id.homeMenuItem) {
                            startActivity(new Intent(MainActivity2.this, MainActivity2.class));
                            return true;
                        } else if (item.getItemId() == R.id.myScheduleMenuItem) {
                            startActivity(new Intent(MainActivity2.this, student_schedule.class));
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