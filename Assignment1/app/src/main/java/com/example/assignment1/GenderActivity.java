package com.example.assignment1;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;


public class GenderActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] gender = {"boy", "girl"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_gender, gender));
    }
    public void onListItemClick(ListView lv, View v, int position, long id) {
        switch (position) {
            case 0:
//                startActivity(new Intent(GenderActivity.this, BoyActivity.class));
                break;
            case 1:
//                startActivity(new Intent(GenderActivity.this, GirlActivity.class));
                break;
        }
    }
}