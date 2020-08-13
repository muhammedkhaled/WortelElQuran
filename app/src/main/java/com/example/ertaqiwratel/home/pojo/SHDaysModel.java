package com.example.ertaqiwratel.home.pojo;

import com.example.ertaqiwratel.home.adapters.TimeChildAdapter;

public class SHDaysModel {
    private String dayName;
    private TimeChildAdapter childAdapter;

    public SHDaysModel() {
    }

    public SHDaysModel(String dayName, TimeChildAdapter childAdapter) {
        this.dayName = dayName;
        this.childAdapter = childAdapter;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public TimeChildAdapter getChildAdapter() {
        return childAdapter;
    }

    public void setChildAdapter(TimeChildAdapter childAdapter) {
        this.childAdapter = childAdapter;
    }
}

