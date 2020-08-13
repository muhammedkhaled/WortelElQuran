package com.example.ertaqiwratel.home.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments ;
    private String[] names;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] fragments, String[] names) {
        super(fm, behavior);
        this.fragments = fragments;
        this.names = names;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }


}
