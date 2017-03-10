package com.su.odb.serialporttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 2016/7/29.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    private Fragment[] fragments;

    public MyPagerAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.length;
    }
}
