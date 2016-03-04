package com.media.realimagemedia;

import android.app.Application;
import android.content.Context;

import com.media.realimagemedia.contentprovider.RealImageContentProvider;

/**
 * Created by Venkat on 03-03-2016.
 */
public class MyApplication extends Application{
    private static Context context;
    private RealImageContentProvider dbContentProvider = null;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        dbContentProvider = new RealImageContentProvider();
    }
    public static Context getAppContext() {
        return MyApplication.context;
    }
}
