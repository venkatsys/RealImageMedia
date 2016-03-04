package com.media.realimagemedia.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Venkat on 03-02-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * Database Name
     */
    public static String DATABASENAME = "realmedia.db";
    public static int DATABASEVERSION = 1;
    
    /**
     * Table Definition for Question Interest
     */
    public static final String DONE_QUESTION_SECTION_INTEREST = "stackoverflow_interest";
    public static final String COLUMN_QUESTIONPRIMARYID = "_id";
    public static final String COLUMN_QUESTIONID = "question_id";
    public static final String COLUMN_QUESTIONTAGNAME = "question_tag";
    public static final String COLUMN_QUESTIONTITLE = "question_title";
    public static final String COLUMN_QUESTIONTIME = "question_time";
    public static final String COLUMN_QUESTIONAUTHORNAME = "question_authorname";
    public static final String COLUMN_QUESTIONANSWERCOUNT = "question_answercount";
    public static final String COLUMN_QUESTIONVIEWCOUNT = "question_viewcount";
    public static final String COLUMN_QUESTIONSCORE = "question_score";
    
    /**
     * Table Definition
     */
    public static final String DONE_QUESTION_SECTION_FEATURED = "stackoverflow_featured";
    public static final String DONE_QUESTION_SECTION_HOT = "stackoverflow_hot";
    public static final String DONE_QUESTION_SECTION_WEEK = "stackoverflow_week";
    public static final String DONE_QUESTION_SECTION_MONTH = "stackoverflow_month";
    
    
    /**
     * Create Table for Questions Definition and Declaration
     */
    private static final String TABLE_CREATE_QUESTION_SECTION = "CREATE TABLE "
            + DONE_QUESTION_SECTION_INTEREST + "(" + COLUMN_QUESTIONPRIMARYID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTIONID
            + " TEXT NULL, " + COLUMN_QUESTIONTITLE + " TEXT NULL, "
            + COLUMN_QUESTIONTIME + " TEXT NULL, " + COLUMN_QUESTIONAUTHORNAME
            + " TEXT NULL, " + COLUMN_QUESTIONANSWERCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONVIEWCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONTAGNAME + " TEXT NULL, "
            + COLUMN_QUESTIONSCORE + " TEXT NULL" + ")";
    
    
    /**
     * Create Table for Questions Definition and Declaration
     */
    private static final String TABLE_CREATE_QUESTION_FEATURED = "CREATE TABLE "
            + DONE_QUESTION_SECTION_FEATURED + "(" + COLUMN_QUESTIONPRIMARYID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTIONID
            + " TEXT NULL, " + COLUMN_QUESTIONTITLE + " TEXT NULL, "
            + COLUMN_QUESTIONTIME + " TEXT NULL, " + COLUMN_QUESTIONAUTHORNAME
            + " TEXT NULL, " + COLUMN_QUESTIONANSWERCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONVIEWCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONTAGNAME + " TEXT NULL, "
            + COLUMN_QUESTIONSCORE + ")";
    
    /**
     * Create Table for Questions Definition and Declaration
     */
    private static final String TABLE_CREATE_QUESTION_HOT = "CREATE TABLE "
            + DONE_QUESTION_SECTION_HOT + "(" + COLUMN_QUESTIONPRIMARYID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTIONID
            + " TEXT NULL, " + COLUMN_QUESTIONTITLE + " TEXT NULL, "
            + COLUMN_QUESTIONTIME + " TEXT NULL, " + COLUMN_QUESTIONAUTHORNAME
            + " TEXT NULL, " + COLUMN_QUESTIONANSWERCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONVIEWCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONTAGNAME + " TEXT NULL, "
            + COLUMN_QUESTIONSCORE + ")";
    
    
    /**
     * Create Table for Questions Definition and Declaration
     */
    private static final String TABLE_CREATE_QUESTION_WEEK = "CREATE TABLE "
            + DONE_QUESTION_SECTION_WEEK + "(" + COLUMN_QUESTIONPRIMARYID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTIONID
            + " TEXT NULL, " + COLUMN_QUESTIONTITLE + " TEXT NULL, "
            + COLUMN_QUESTIONTIME + " TEXT NULL, " + COLUMN_QUESTIONAUTHORNAME
            + " TEXT NULL, " + COLUMN_QUESTIONANSWERCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONVIEWCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONTAGNAME + " TEXT NULL, "
            + COLUMN_QUESTIONSCORE + ")";
    
    
    /**
     * Create Table for Questions Definition and Declaration
     */
    private static final String TABLE_CREATE_QUESTION_MONTH = "CREATE TABLE "
            + DONE_QUESTION_SECTION_MONTH + "(" + COLUMN_QUESTIONPRIMARYID
            + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_QUESTIONID
            + " TEXT NULL, " + COLUMN_QUESTIONTITLE + " TEXT NULL, "
            + COLUMN_QUESTIONTIME + " TEXT NULL, " + COLUMN_QUESTIONAUTHORNAME
            + " TEXT NULL, " + COLUMN_QUESTIONANSWERCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONVIEWCOUNT + " TEXT NULL, "
            + COLUMN_QUESTIONTAGNAME + " TEXT NULL, "
            + COLUMN_QUESTIONSCORE + ")";
    
    
    public DatabaseHelper(Context context){
        super(context , DATABASENAME , null , DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("ddddddddddd","ddddddddddddddd");
        db.execSQL(TABLE_CREATE_QUESTION_SECTION);
        db.execSQL(TABLE_CREATE_QUESTION_FEATURED);
        db.execSQL(TABLE_CREATE_QUESTION_HOT);
        db.execSQL(TABLE_CREATE_QUESTION_WEEK);
        db.execSQL(TABLE_CREATE_QUESTION_MONTH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("ddddddddddd", "ddddddddddddddd");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CREATE_QUESTION_SECTION);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CREATE_QUESTION_FEATURED);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CREATE_QUESTION_HOT);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CREATE_QUESTION_WEEK);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CREATE_QUESTION_MONTH);
        onCreate(db);
    }
}