package com.media.realimagemedia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.media.realimagemedia.R;

/**
 * Created by venkatesan on 10/12/2015.
 */
public class DemoFragment extends Fragment{
    public DemoFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.activity_main , container , false);
        return rootView;
    }
}
