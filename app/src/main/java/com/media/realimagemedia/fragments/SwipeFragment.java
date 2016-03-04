package com.media.realimagemedia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.media.realimagemedia.R;
import com.media.realimagemedia.adapter.StackOverflowPagerAdapter;

/**
 * Created by venkat on 03-03-16.
 */
public class SwipeFragment extends Fragment implements ActivityToFragmentCommunicator{
    private ViewPager mViewPager;
    private StackOverflowPagerAdapter mNewsfeedSectionsAdapter;

    public SwipeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View swipeView = inflater.inflate(R.layout.swipe_layout, container, false);
        this.mViewPager = (ViewPager) swipeView.findViewById(R.id.pager);
        this.mNewsfeedSectionsAdapter = new StackOverflowPagerAdapter(getChildFragmentManager());
        this.mViewPager.setAdapter(this.mNewsfeedSectionsAdapter);
        return swipeView;
    }

    @Override
    public void passDataToFragment(int itemValue) {
        this.mViewPager.setCurrentItem(itemValue);
    }
}
