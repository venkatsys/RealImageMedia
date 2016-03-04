package com.media.realimagemedia.utils;

import android.content.ContentValues;
import android.net.Uri;

import com.media.realimagemedia.MyApplication;
import com.media.realimagemedia.contentprovider.DatabaseHelper;
import com.media.realimagemedia.model.ItemElement;
import com.media.realimagemedia.model.Owner;
import com.media.realimagemedia.model.StackoverflowData;

/**
 * Created by Venkat on 03-03-2016.
 */
public class LocalUpdate implements Runnable {
    private DisplayResults callback;
    private int sectionRange = -1;
    private int tagLength = -1;
    private ContentValues insertSectionContentValues = null;
    private Uri todoUri = null;
    private StackoverflowData stackoverflowData;
    private String tagConcatenate = "";
    public LocalUpdate(DisplayResults displayResults) {
        this.callback = displayResults;
    }

    public void TogetStackoverflowResults(StackoverflowData sectionDatas, int stackRange){
        this.sectionRange = stackRange;
        this.stackoverflowData = sectionDatas;
    }
    private void BulkInsert(){
        this.insertSectionContentValues = new ContentValues();
        ItemElement[] itemElement = this.stackoverflowData.getItems();
        for(int i = 0 ; i < itemElement.length ; i++){
            Owner myOwner = itemElement[i].getOwner();
            String[] tagName = itemElement[i].getTags();
            tagLength = itemElement[i].getTags().length;
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONID,String.valueOf(itemElement[i].getQuestion_id()));
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONTITLE,itemElement[i].getTitle());
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONTIME,itemElement[i].getCreation_date());
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONAUTHORNAME,myOwner.getDisplay_name());
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONANSWERCOUNT, itemElement[i].getAnswer_count());
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONVIEWCOUNT, itemElement[i].getView_count());
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONSCORE, itemElement[i].getScore());
            for(int j = 0 ; j < tagLength ; j++){
                tagConcatenate+=tagName[j]+",";
            }
            //Log.i("sample", "venkat" + tagConcatenate.substring(0,tagConcatenate.length()-1));
            this.insertSectionContentValues.put(DatabaseHelper.COLUMN_QUESTIONTAGNAME,tagConcatenate.substring(0,tagConcatenate.length()-1));
            if(AppConstants.DONE_QUESTION_SECTION_FEATURED == this.sectionRange)
                this.todoUri = Uri.parse("content://com.realmedia/featured/question/add");
            else if(AppConstants.DONE_QUESTION_SECTION_HOT == this.sectionRange)
                this.todoUri = Uri.parse("content://com.realmedia/hot/question/add");
            else if(AppConstants.DONE_QUESTION_SECTION_WEEK == this.sectionRange)
                this.todoUri = Uri.parse("content://com.realmedia/week/question/add");
            else if(AppConstants.DONE_QUESTION_SECTION_MONTH == this.sectionRange)
                this.todoUri = Uri.parse("content://com.realmedia/month/question/add");
            else if(AppConstants.DONE_QUESTION_SECTION_INTEREST == this.sectionRange)
                this.todoUri = Uri.parse("content://com.realmedia/interest/question/add");
            MyApplication.getAppContext().getContentResolver().insert(this.todoUri, this.insertSectionContentValues);
            tagConcatenate="";
        }
        this.callback.onSuccess(true);
        this.todoUri = null;
        this.insertSectionContentValues = null;
    }
    @Override
    public void run() {
        this.BulkInsert();
    }
}
