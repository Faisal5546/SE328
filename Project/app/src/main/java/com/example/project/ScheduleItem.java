package com.example.project;

public class ScheduleItem {
    private String location;
    private String courseCode;
    private String facultyName;
    private String startingTime;
    private String examType;
    private String examDate;
    private String endingTime;

    public ScheduleItem(String location, String courseCode, String facultyName, String startingTime,
                        String examType, String examDate, String endingTime) {
        this.location = location;
        this.courseCode = courseCode;
        this.facultyName = facultyName;
        this.startingTime = startingTime;
        this.examType = examType;
        this.examDate = examDate;
        this.endingTime = endingTime;
    }

    // Getter methods
    public String getLocation() {
        return location;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public String getExamType() {
        return examType;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getEndingTime() {
        return endingTime;
    }
}
