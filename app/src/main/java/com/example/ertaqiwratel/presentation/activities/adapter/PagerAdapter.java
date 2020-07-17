package com.example.ertaqiwratel.presentation.activities.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ertaqiwratel.presentation.activities.destinations.StudentChatRoomFragment;
import com.example.ertaqiwratel.presentation.activities.destinations.StudentScheduleFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private final int numOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StudentChatRoomFragment();
            case 1:
                return new StudentScheduleFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
