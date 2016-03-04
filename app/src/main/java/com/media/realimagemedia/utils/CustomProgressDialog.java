package com.media.realimagemedia.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Venkat on 03-03-2016.
 */
public class CustomProgressDialog extends ProgressDialog {

    public CustomProgressDialog(Context context){
        this(context , 0);
    }
    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public void setCustomTitle(String message){
        this.setMessage(message);
    }
}
