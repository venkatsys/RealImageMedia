package com.media.realimagemedia.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Created by Venkat on 03-02-2016.
 */
public class RealImageContentProvider extends ContentProvider {

    /**
     * Database Helper Instance Class
     */
	//https://javafromjson.dashingrocket.com
	//https://javafromjson.dashingrocket.com/
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase dbDatabase;
    private SQLiteQueryBuilder queryBuilder = null;
    /**
     * DATABASE AUTHORITY
     */
    public static final String AUTHORITY = "com.realmedia";

    /**
     * TO BUILD BASE URI
     */
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    /**
     * To add URL CODE to identify the path
     */
    public static final int QUESTION_SECTION_INTEREST = 100;
    public static final int QUESTION_SECTION_INTEREST_FEED = 101;
    public static final int QUESTION_SECTION_INTEREST_DELETE = 102;

    public static final int QUESTION_SECTION_FEATURED_INSERT = 103;
    public static final int QUESTION_SECTION_FEATURED_FEED = 104;
    public static final int QUESTION_SECTION_FEATURED_DELETE = 105;

    public static final int QUESTION_SECTION_HOT_INSERT = 106;
    public static final int QUESTION_SECTION_HOT_FEED = 107;
    public static final int QUESTION_SECTION_HOT_DELETE = 108;

    public static final int QUESTION_SECTION_WEEK_INSERT = 109;
    public static final int QUESTION_SECTION_WEEK_FEED = 110;
    public static final int QUESTION_SECTION_WEEK_DELETE = 111;

    public static final int QUESTION_SECTION_MONTH_INSERT = 112;
    public static final int QUESTION_SECTION_MONTH_FEED = 113;
    public static final int QUESTION_SECTION_MONTH_DELETE = 114;



    static {
        final UriMatcher matcher = uriMatcher;
        matcher.addURI(AUTHORITY, "interest/question/add", QUESTION_SECTION_INTEREST);
        matcher.addURI(AUTHORITY, "interest/question/get", QUESTION_SECTION_INTEREST_FEED);
        matcher.addURI(AUTHORITY, "interest/section/delete", QUESTION_SECTION_INTEREST_DELETE);

        matcher.addURI(AUTHORITY, "featured/question/add", QUESTION_SECTION_FEATURED_INSERT);
        matcher.addURI(AUTHORITY, "featured/question/get", QUESTION_SECTION_FEATURED_FEED);
        matcher.addURI(AUTHORITY, "featured/question/delete", QUESTION_SECTION_FEATURED_DELETE);

        matcher.addURI(AUTHORITY, "hot/question/add", QUESTION_SECTION_HOT_INSERT);
        matcher.addURI(AUTHORITY, "hot/question/get", QUESTION_SECTION_HOT_FEED);
        matcher.addURI(AUTHORITY, "hot/question/delete", QUESTION_SECTION_HOT_DELETE);

        matcher.addURI(AUTHORITY, "week/question/add", QUESTION_SECTION_WEEK_INSERT);
        matcher.addURI(AUTHORITY, "week/question/get", QUESTION_SECTION_WEEK_FEED);
        matcher.addURI(AUTHORITY, "week/question/delete", QUESTION_SECTION_WEEK_DELETE);

        matcher.addURI(AUTHORITY, "month/question/add", QUESTION_SECTION_MONTH_INSERT);
        matcher.addURI(AUTHORITY, "month/question/get", QUESTION_SECTION_MONTH_FEED);
        matcher.addURI(AUTHORITY, "month/question/delete", QUESTION_SECTION_MONTH_DELETE);
    }

    @Override
    public boolean onCreate() {
        this.dbHelper = new DatabaseHelper(getContext());
        this.dbDatabase = this.dbHelper.getWritableDatabase();
        return (this.dbHelper != null);
    }

    /**
     * To return db object
     */
    public synchronized SQLiteDatabase getDb() {

        return dbDatabase;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int uriType = uriMatcher.match(uri);


        Cursor cursor = null;
        queryBuilder = new SQLiteQueryBuilder();
        switch (uriType) {
            case QUESTION_SECTION_INTEREST_FEED:
                queryBuilder.setTables(DatabaseHelper.DONE_QUESTION_SECTION_INTEREST);
            break;
            case QUESTION_SECTION_FEATURED_FEED:
                queryBuilder.setTables(DatabaseHelper.DONE_QUESTION_SECTION_FEATURED);
            break;
            case QUESTION_SECTION_HOT_FEED:
                queryBuilder.setTables(DatabaseHelper.DONE_QUESTION_SECTION_HOT);
            break;
            case QUESTION_SECTION_WEEK_FEED:
                queryBuilder.setTables(DatabaseHelper.DONE_QUESTION_SECTION_WEEK);
            break;
            case QUESTION_SECTION_MONTH_FEED:
                queryBuilder.setTables(DatabaseHelper.DONE_QUESTION_SECTION_MONTH);
            break;
        }
        cursor = queryBuilder.query(this.getDb(), projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues cv) {
        long id = 0L;
            switch (uriMatcher.match(uri)) {
                case QUESTION_SECTION_INTEREST:
                    id = this.getDb().insert(DatabaseHelper.DONE_QUESTION_SECTION_INTEREST, null, cv);
                break;
                case QUESTION_SECTION_FEATURED_INSERT:
                    id = this.getDb().insert(DatabaseHelper.DONE_QUESTION_SECTION_FEATURED, null, cv);
                break;
                case QUESTION_SECTION_HOT_INSERT:
                    id = this.getDb().insert(DatabaseHelper.DONE_QUESTION_SECTION_HOT, null, cv);
                break;
                case QUESTION_SECTION_WEEK_INSERT:
                    id = this.getDb().insert(DatabaseHelper.DONE_QUESTION_SECTION_WEEK, null, cv);
                break;
                case QUESTION_SECTION_MONTH_INSERT:
                    id = this.getDb().insert(DatabaseHelper.DONE_QUESTION_SECTION_MONTH, null, cv);
                break;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int row = 0;
        int matched = uriMatcher.match(uri);
        try {
            switch (uriMatcher.match(uri)) {
                case QUESTION_SECTION_INTEREST_DELETE:
                    this.getDb().execSQL("delete from " + DatabaseHelper.DONE_QUESTION_SECTION_INTEREST);
                break;
                case QUESTION_SECTION_FEATURED_DELETE:
                    this.getDb().execSQL("delete from " + DatabaseHelper.DONE_QUESTION_SECTION_FEATURED);
                break;
                case QUESTION_SECTION_HOT_DELETE:
                    this.getDb().execSQL("delete from " + DatabaseHelper.DONE_QUESTION_SECTION_HOT);
                break;
                case QUESTION_SECTION_WEEK_DELETE:
                    this.getDb().execSQL("delete from " + DatabaseHelper.DONE_QUESTION_SECTION_WEEK);
                break;
                case QUESTION_SECTION_MONTH_DELETE:
                    this.getDb().execSQL("delete from " + DatabaseHelper.DONE_QUESTION_SECTION_MONTH);
                break;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
