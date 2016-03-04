package com.media.realimagemedia.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.media.realimagemedia.fragments.DemoFragment;
import com.media.realimagemedia.fragments.FeaturedFragment;
import com.media.realimagemedia.fragments.HotFragment;
import com.media.realimagemedia.fragments.MonthFragment;
import com.media.realimagemedia.fragments.UnansweredFragment;
import com.media.realimagemedia.fragments.WeekFragment;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackOverflowPagerAdapter extends FragmentPagerAdapter {

    public StackOverflowPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FeaturedFragment featuredFragment = new FeaturedFragment();
                return featuredFragment;
            case 1:
                HotFragment hotFragment = new HotFragment();
                return hotFragment;
            case 2:
                WeekFragment weekFragment = new WeekFragment();
                return weekFragment;
            case 3:
                MonthFragment monthFragment = new MonthFragment();
                return monthFragment;
            case 4:
                UnansweredFragment unansweredFragment = new UnansweredFragment();
                return unansweredFragment;
            default:
                Fragment fragment = new DemoFragment();
                return fragment;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FEATURED";
            case 1:
                return "HOT";
            case 2:
                return "WEEK";
            case 3:
                return "MONTH";
            case 4:
                return "UNANSWER";
        }
        return null;
    }
}
