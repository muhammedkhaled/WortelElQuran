package com.example.ertaqiwratel.presentation.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OnBoardingSliderPageAdapter extends FragmentPagerAdapter {

    public OnBoardingSliderPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return OnBoardingFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}