package com.media.realimagemedia;

import android.app.Application;
import android.content.Context;

import com.media.realimagemedia.contentprovider.RealImageContentProvider;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by Venkat on 03-03-2016.
 */
public class MyApplication extends Application{
    private static Context context;
    private RealImageContentProvider dbContentProvider = null;
    private static HashMap<String,WeakReference<Class>> mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        dbContentProvider = new RealImageContentProvider();
        mDatabase = new HashMap<String,WeakReference<Class>>();
    }
    public static Context getAppContext() {
        return MyApplication.context;
    }

    /**
     * To Handle Key to classname
     * @param key
     * @return
     */
    public static Boolean toLoad(String key) {
        WeakReference<Class> weakRef= mDatabase.get(key);
        if(weakRef == null) return null;
        Class result=weakRef.get();
        if (result==null) {
            mDatabase.remove(key);
        }
        return true;
    }

    /**
     * To Handle Memory Management add key and classname to weakreference
     * @param key
     * @param className
     */
    public static void put(String key, Class className) {
        mDatabase.put(key, new WeakReference<Class>(className));
    }
}
