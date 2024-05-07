package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "University.db";
    public static final String COURSES = "Courses";
    public static final String COURSES_ID = "ID";
    public static final String COURSES_NAME = "Name";
    public static final String COURSES_DATE = "Date";
    public static final String COURSES_TIME = "Time";
    public static final String COURSES_DEPARTMENT = "Department";
    public static final String COURSES_LEVEL = "Level";
    public static final String COURSES_TYPE = "Type";
    public static final String COURSES_DURATION = "Duration";
    public static final String COURSES_LOCATION = "Location";

    public static final String USERS = "Users";
    public static final String USERS_NAME = "Username";
    public static final String USERS_PASSWORD = "Password";
    public static final String USERS_TYPE = "Type";

    public static final String STUDENTS = "Students";
    public static final String STUDENT_NAME = "Name";
    public static final String STUDENT_COURSE = "Course";
    public static final String STUDENT_MAJOR = "Major";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + COURSES + "(" +
                        COURSES_ID + " TEXT PRIMARY KEY," +
                        COURSES_DATE + " TEXT NOT NULL," +
                        COURSES_TIME + " TEXT NOT NULL," +
                        COURSES_LEVEL + " TEXT NOT NULL," +
                        COURSES_LEVEL + " TEXT NOT NULL," +
                        COURSES_TYPE + " TEXT NOT NULL," +
                        COURSES_DURATION + " TEXT NOT NULL," +
                        COURSES_LOCATION + " TEXT NOT NULL," +
                        COURSES_DEPARTMENT + " TEXT NOT NULL" + ");"
        );
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + USERS + "(" +
                        USERS_NAME + " TEXT PRIMARY KEY," +
                        USERS_TYPE + " TEXT NOT NULL," +
                        USERS_PASSWORD + " TEXT NOT NULL" + ");"
        );
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + STUDENTS + "(" +
                        STUDENT_NAME + " TEXT NOT NULL," +
                        STUDENT_COURSE + " TEXT NOT NULL," +
                        STUDENT_MAJOR + " TEXT NOT NULL" + ");"
        );
    }
    public void AddCourse(String ID, String ExamDate, String ExamTime, String College, String Level, String Type, String Duration, String Location) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COURSES_DEPARTMENT, College);
        values.put(COURSES_ID, ID);
        values.put(COURSES_DATE, ExamDate);
        values.put(COURSES_TIME, ExamTime);
        values.put(COURSES_LEVEL, Level);
        values.put(COURSES_TYPE, Type);
        values.put(COURSES_DURATION, Duration);
        values.put(COURSES_LOCATION, Location);
        db.insert(COURSES, null, values);
    }
    public void AddUser(String Username, String Password, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERS_NAME, Username);
        values.put(USERS_PASSWORD, Password);
        values.put(USERS_TYPE, Type);
        db.insert(USERS, null, values);
    }
    public void AddStudent(String StudentName, String CourseID, String Major) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME, StudentName);
        values.put(STUDENT_COURSE, CourseID);
        values.put(STUDENT_MAJOR, Major);
        db.insert(STUDENTS, null, values);
    }
    public Cursor ViewCourses(String Date, String Time) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + COURSES + " WHERE Date = ? AND Time = ?", new String[] {Date, Time});
    }
    public Cursor ViewExams(String CourseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + COURSES + " WHERE ID = ?", new String[] {CourseID});
    }
    public Cursor ViewUser(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + USERS + " WHERE Username = ?", new String[] {Username});
    }

    public Cursor ViewRegisteredCourses(String StudentName) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + STUDENTS + " WHERE Name = ?", new String[] {StudentName});
    }
    public Boolean isRegistered(String StudentName, String CourseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENTS + " WHERE Name = ? AND Course = ?", new String[] {StudentName, CourseID});
        return cursor.getCount() > 0;
    }
    public Boolean examConflict(String courseDepartment, String examDay, String examMonth, String examTime, String examDuration, String examLocation) {
        SQLiteDatabase db = this.getWritableDatabase();
        Location location = new Location(examLocation);
        Boolean reservable = location.ReserveRoom(examDay, examMonth, examTime, exanDuration);
        Cursor sameDateTime = db.rawQuery("SELECT * FROM " + COURSES + " WHERE Date = ? AND Time = ?", new String[] {ExamDate, CourseDepartment});
        if (sameDateTime.getCount() > 0) {
            Cursor sameLocation = db.rawQuery("SELECT * FROM " + COURSES + " WHERE Location = ?", new String[] {ExamLocation});
            Cursor sameDepartment = db.rawQuery("SELECT * FROM " + COURSES + " WHERE Department = ?", new String[] {CourseDepartment});
            return sameLocation.getCount() > 0 || sameDepartment.getCount() > 0;
        }
        return false;
    };


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
