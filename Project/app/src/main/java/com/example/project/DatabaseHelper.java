package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Time;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "University.db";
    public static final String COURSES = "Courses";
    public static final String COURSES_ID = "ID";
    public static final String COURSES_DAY = "Day";
    public static final String COURSES_MONTH = "Month";
    public static final String COURSES_TIME = "Time";
    public static final String COURSES_DEPARTMENT = "Department";
    public static final String COURSES_LEVEL = "Level";
    public static final String COURSES_TYPE = "Type";
    public static final String COURSES_LOCATION = "Location";

    public static final String USERS = "Users";
    public static final String USERS_NAME = "Username";
    public static final String USERS_PASSWORD = "Password";
    public static final String USERS_TYPE = "Type";
    public static final String USERS_ID = "ID";

    public static final String REGISTRATIONS = "Students";
    public static final String NAME = "Name";
    public static final String COURSE = "Course";
    public static final String DEPARTMENT = "Department";

    private ArrayList<Cursor> conflicts;


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + COURSES + "(" +
                        COURSES_ID + " TEXT PRIMARY KEY," +
                        COURSES_DAY + " TEXT NOT NULL," +
                        COURSES_MONTH + " TEXT NOT NULL," +
                        COURSES_TIME + " TEXT NOT NULL," +
                        COURSES_LEVEL + " TEXT NOT NULL," +
                        COURSES_TYPE + " TEXT NOT NULL," +
                        COURSES_LOCATION + " TEXT NOT NULL," +
                        COURSES_DEPARTMENT + " TEXT NOT NULL" + ");"
        );


        sqLiteDatabase.execSQL(
                "CREATE TABLE " + USERS + "(" +
                        USERS_NAME + " TEXT NOT NULL," +
                        USERS_TYPE + " TEXT NOT NULL," +
                        USERS_ID + " TEXT PRIMARY KEY," +
                        USERS_PASSWORD + " TEXT NOT NULL" + ");"
        );
        ContentValues values = new ContentValues();
        values.put(USERS_NAME, "Faisal");
        values.put(USERS_TYPE, "Student");
        values.put(USERS_PASSWORD, "12345");
        values.put(USERS_ID, "1");
        sqLiteDatabase.insert(USERS, null, values);
        values = new ContentValues();
        values.put(USERS_NAME, "Saif");
        values.put(USERS_TYPE, "Student");
        values.put(USERS_PASSWORD, "112233");
        values.put(USERS_ID, "2");
        sqLiteDatabase.insert(USERS, null, values);
        values = new ContentValues();
        values.put(USERS_NAME, "Hoda");
        values.put(USERS_TYPE, "Faculty");
        values.put(USERS_PASSWORD, "12345");
        values.put(USERS_ID, "3");
        sqLiteDatabase.insert(USERS, null, values);
        values.put(USERS_NAME, "Ahmed");
        values.put(USERS_TYPE, "Faculty");
        values.put(USERS_PASSWORD, "112233");
        values.put(USERS_ID, "4");
        sqLiteDatabase.insert(USERS, null, values);

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + REGISTRATIONS + "(" +
                        NAME + " TEXT NOT NULL," +
                        COURSE + " TEXT NOT NULL," +
                        DEPARTMENT + " TEXT NOT NULL" + ");"
        );
        values = new ContentValues();
        values.put(NAME, "Saif");
        values.put(COURSE, "SE330");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Saif");
        values.put(COURSE, "SE310");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Saif");
        values.put(COURSE, "SE328");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Faisal");
        values.put(COURSE, "SE225");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Faisal");
        values.put(COURSE, "SE212");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Faisal");
        values.put(COURSE, "EE210");
        values.put(DEPARTMENT, "EE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Hoda");
        values.put(COURSE, "SE328");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values = new ContentValues();
        values.put(NAME, "Hoda");
        values.put(COURSE, "SE324");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values.put(NAME, "Ahmed");
        values.put(COURSE, "SE330");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
        values.put(NAME, "Ahmed");
        values.put(COURSE, "SE310");
        values.put(DEPARTMENT, "SE");
        sqLiteDatabase.insert(REGISTRATIONS, null, values);
    }
    public void AddCourse(String ID, String examDay, String examMonth, String examTime, String department, String level, String type, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COURSES_DEPARTMENT, department);
        values.put(COURSES_ID, ID);
        values.put(COURSES_DAY, examDay);
        values.put(COURSES_MONTH, examMonth);
        values.put(COURSES_TIME, examTime);
        values.put(COURSES_LEVEL, level);
        values.put(COURSES_TYPE, type);
        values.put(COURSES_LOCATION, location);
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
    public void RegisterUser(String name, String courseID, String department) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(COURSE, courseID);
        values.put(DEPARTMENT, department);
        db.insert(REGISTRATIONS, null, values);
    }
    public Cursor ViewCourses(String Date, String Time) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + COURSES + " WHERE Date = ? AND Time = ?", new String[] {Date, Time});
    }
    public Cursor ViewExams(String CourseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + COURSES + " WHERE ID = ?", new String[] {CourseID});
    }
    public Cursor ViewUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + USERS + " WHERE Username = ?", new String[] {username});
    }
    public Cursor ViewUser(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + USERS + " WHERE ID = ?", new String[] {String.valueOf(ID)});
    }

    public Cursor ViewRegisteredCourses(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + REGISTRATIONS + " WHERE Name = ?", new String[] {name});
    }
    public Boolean isRegistered(String name, String courseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + REGISTRATIONS + " WHERE Name = ? AND Course = ?", new String[] {name, courseID});
        return cursor.getCount() > 0;
    }
    public Boolean isConflict(String courseDepartment, String examDay, String examMonth, String examTime, String examLocation, String courseLevel) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Query that checks for exam conflicts of the same room
        Cursor reservedRoom = db.rawQuery("SELECT * FROM " + COURSES + " WHERE Day = ? AND Month = ? AND Time = ? AND Location = ?",
                new String[] {examDay, examMonth, examTime, examLocation});

        // Query that checks for exam conflicts of the same department (e.g. freshman COE course can't be scheduled at the same time as another freshman COE course)
        Cursor sameDepartment = db.rawQuery("SELECT * FROM " + COURSES + " WHERE Day = ? AND Month = ? AND Time = ? AND Department = ? AND Level = ?",
                new String[] {examDay, examMonth, examTime, courseDepartment, courseLevel});

        if (reservedRoom.getCount() > 0 || sameDepartment.getCount() > 0 ) {
            addConflicts(reservedRoom, sameDepartment);
            return true;
        }
        return false;
    }
    public Cursor addConflicts(Cursor roomConflict, Cursor departmentConflict) {
        SQLiteDatabase db = this.getWritableDatabase();
        while (roomConflict.moveToNext()) {
            roomConflict.getString(0);
        }
        return db.rawQuery("SELECT * FROM " + COURSES + " WHERE Day = ? AND Month = ?", new String[] {"", ""});
    }

    public ArrayList<Cursor> getConflicts() {
        return conflicts;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
