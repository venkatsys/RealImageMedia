package com.media.realimagemedia.utils;

import android.database.Cursor;
import android.util.Log;

import com.media.realimagemedia.contentprovider.DatabaseHelper;
import com.media.realimagemedia.model.MyStackComp;
import com.media.realimagemedia.model.StackOverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StringManipulation {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;
    /**
     * Method to Return the Database Results
     */
    public static List<StackOverflow> SelectedCursorResults(Cursor data){
        List<StackOverflow> getStackData = new ArrayList<>();
        while(data.moveToNext()){
            int questionID = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONID);
            int questionTitle = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONTITLE);
            int questionTime = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONTIME);
            int questionAuthorname = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONAUTHORNAME);
            int questionAnswerCount = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONANSWERCOUNT);
            int questionViewCount = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONVIEWCOUNT);
            int questionScore = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONSCORE);
            int questionTagName = data.getColumnIndex(DatabaseHelper.COLUMN_QUESTIONTAGNAME);
            Log.i("MINE", "TITLE is" + data.getString(questionTagName));

            StackOverflow stackData = new StackOverflow();
            stackData.setQuestionid(data.getString(questionID));
            stackData.setQuestiontagname(data.getString(questionTagName));
            stackData.setQuestiontitle(data.getString(questionTitle));
            stackData.setQuestiontime(data.getString(questionTime));
            stackData.setQuestionauthorname(data.getString(questionAuthorname));
            stackData.setQuestionanswercount(data.getString(questionAnswerCount));
            stackData.setQuestionviewcount(data.getString(questionViewCount));
            stackData.setQuestionscore(data.getString(questionScore));
            getStackData.add(stackData);
        }
        data.close();;
        Collections.sort(getStackData, new MyStackComp());
        return  getStackData;
    }

    /***
     * Method to return the second,time&minute
     * @param time
     * @return
     */
    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            time *= 1000;
        }

        long now = getCurrentTime();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return diff / DAY_MILLIS + " days ago";
        }
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    /**
     * Method to Return Tag Objects
     * @param stackOverflow
     */
    public static List<String> toGetTagObjects(String stackOverflow){
        String[] accessTokensplit = stackOverflow.split(",");
        List<String> getTagData = new ArrayList<>();
        for(int i = 0 ; i < accessTokensplit.length ; i++){
            getTagData.add(accessTokensplit[i].toString());
        }
        return getTagData;
    }
}
