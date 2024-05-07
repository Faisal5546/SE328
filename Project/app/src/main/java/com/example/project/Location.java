package com.example.project;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Location {
    private String location;
    private ArrayList<Integer> times = new ArrayList<>(10);
    private ArrayList<Integer> dates = new ArrayList<>(372);

    public Location(String location) {
        location = this.location;
    }

    public Boolean ReserveRoom(String examDay, String examMonth, String examTime, String examDuration) {
        int date = Integer.parseInt(examDay) * Integer.parseInt(examMonth);
        int time = Integer.parseInt(examTime);
        int duration = Integer.parseInt(examDuration) / 30;
        if (dates.get(date) != 1 && times.get(time) != 1) {
            dates.set(date, 1);
            times.set(time, 1);
            return true;
        }
        return false;
    }


}
