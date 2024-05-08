package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class ScheduleAdapter extends ArrayAdapter<ScheduleItem> {
    private Context mContext;
    private int mResource;

    public ScheduleAdapter(@NonNull Context context, int resource, @NonNull List<ScheduleItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        // Get the item data at the current position
        ScheduleItem item = getItem(position);

        // Find views in the layout
        TextView locationTextView = convertView.findViewById(R.id.location);
        TextView courseCodeTextView = convertView.findViewById(R.id.courseCode);
        TextView facultyNameTextView = convertView.findViewById(R.id.facultyName);
        TextView startingTimeTextView = convertView.findViewById(R.id.startingTime);
        TextView examTypeTextView = convertView.findViewById(R.id.exam_type);
        TextView examDateTextView = convertView.findViewById(R.id.exam_date);
        TextView endingTimeTextView = convertView.findViewById(R.id.endingTime);
        Button updateButton = convertView.findViewById(R.id.updateButton);

        // Set values based on item data
        locationTextView.setText(item.getLocation());
        courseCodeTextView.setText(item.getCourseCode());
        facultyNameTextView.setText(item.getFacultyName());
        startingTimeTextView.setText(item.getStartingTime());
        examTypeTextView.setText(item.getExamType());
        examDateTextView.setText(item.getExamDate());
        endingTimeTextView.setText(item.getEndingTime());

        // Set listener for the update button
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle update button click
                // You can perform any action here, such as updating the database or UI
            }
        });

        return convertView;
    }
}

