package com.media.realimagemedia.stackoverflowlogin;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.media.realimagemedia.MyApplication;
import com.media.realimagemedia.utils.AppConstants;

/**
 * Created by Venkat on 03-03-2016.
 */
public class Constants {
    public static String invalidLogin= "InvalidLogin";
    private static Toast validmessage;
    private static Uri deleteUri , todoUri= null;
    private static String parseString = null;
    private static Cursor SelectedSections = null;
    /**
     * Method to show valdiation message
     * @param c
     * @param message
     */
    public static void ShowValidationMessage(Activity c , String message){
        validmessage = Toast.makeText(c, message, Toast.LENGTH_SHORT);
        validmessage.setGravity(Gravity.CENTER_VERTICAL, 0, -70);
        validmessage.show();
    }

    /**
     * Method to Empty Records in the Table
     */
    public static void EmptyTable(int stackRange){
        if(AppConstants.DONE_QUESTION_SECTION_FEATURED == stackRange)
            parseString = "content://com.realmedia/featured/question/delete";
        else if(AppConstants.DONE_QUESTION_SECTION_HOT == stackRange)
            parseString = "content://com.realmedia/hot/question/delete";
        else if(AppConstants.DONE_QUESTION_SECTION_WEEK == stackRange)
            parseString = "content://com.realmedia/week/question/delete";
        else if(AppConstants.DONE_QUESTION_SECTION_MONTH == stackRange)
            parseString = "content://com.realmedia/month/question/delete";
        else if(AppConstants.DONE_QUESTION_SECTION_INTEREST == stackRange)
            parseString = "content://com.realmedia/interest/question/delete";
        deleteUri = Uri.parse(parseString);
        MyApplication.getAppContext().getContentResolver().delete(deleteUri,null,null);
        deleteUri = null;
        parseString=null;
    }

    /**
     * Method to return the Total Number of Records
     */
    public static int TotalRecords(int stackRange){
        if(AppConstants.DONE_QUESTION_SECTION_FEATURED == stackRange)
            parseString = "content://com.realmedia/featured/question/get";
        else if(AppConstants.DONE_QUESTION_SECTION_HOT == stackRange)
            parseString = "content://com.realmedia/hot/question/get";
        else if(AppConstants.DONE_QUESTION_SECTION_WEEK == stackRange)
            parseString = "content://com.realmedia/week/question/get";
        else if(AppConstants.DONE_QUESTION_SECTION_MONTH == stackRange)
            parseString = "content://com.realmedia/month/question/get";
        else if(AppConstants.DONE_QUESTION_SECTION_INTEREST == stackRange)
            parseString = "content://com.realmedia/interest/question/get";
        todoUri = Uri.parse(parseString);
        SelectedSections = MyApplication.getAppContext().getContentResolver().query(todoUri, null,
                null, null, null);
        todoUri = null;
        parseString=null;
        Log.i("TotalCount","SelectedSections.getCount()" + SelectedSections.getCount());
        return SelectedSections.getCount();
    }
}
