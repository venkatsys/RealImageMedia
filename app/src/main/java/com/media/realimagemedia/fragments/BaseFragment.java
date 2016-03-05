package com.media.realimagemedia.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.media.realimagemedia.MyApplication;
import com.media.realimagemedia.R;
import com.media.realimagemedia.stackoverflowlogin.Constants;
import com.media.realimagemedia.utils.CustomProgressDialog;

/**
 * Created by Venkat on 05-03-2016.
 */
public class BaseFragment extends Fragment {
    static ProgressDialog progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void showProgress(final Activity parent) {
        parent.runOnUiThread(new Runnable() {
            public void run() {
                progress = ProgressDialog.show(parent,"", "");
                progress.setTitle("Loading");
                progress.setCancelable(true);
            }
        });
    }

    public static void stopProgress(final Activity parent) {
        parent.runOnUiThread(new Runnable() {
            public void run() {
                if ((progress != null) && (progress.isShowing()))
                    progress.dismiss();
            }
        });
    }

    public static void toAddClass(String key , Class className){
        MyApplication.toLoad(key);
        MyApplication.put(key,className);
    }

}
