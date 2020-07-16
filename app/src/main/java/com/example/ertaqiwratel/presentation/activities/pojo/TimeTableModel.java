package com.example.ertaqiwratel.presentation.activities.pojo;

public class TimeTableModel {

    private String day;
    private String regularDate;
    private String higriDate;
    private boolean isCheck;
    private String rateNewSave;
    private String rateNearPast;
    private String rateFarPast;
    private String rateMetn;
    private boolean isExpandable;

    public TimeTableModel(String day, String regularDate, String higriDate,
                          String rateNewSave, String rateNearPast, String rateFarPast, String rateMetn) {
        this.day = day;
        this.regularDate = regularDate;
        this.higriDate = higriDate;
        this.isCheck = true;
        this.rateNewSave = rateNewSave;
        this.rateNearPast = rateNearPast;
        this.rateFarPast = rateFarPast;
        this.rateMetn = rateMetn;
        this.isExpandable = false;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRegularDate() {
        return regularDate;
    }

    public void setRegularDate(String regularDate) {
        this.regularDate = regularDate;
    }

    public String getHigriDate() {
        return higriDate;
    }

    public void setHigriDate(String higriDate) {
        this.higriDate = higriDate;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getRateNewSave() {
        return rateNewSave;
    }

    public void setRateNewSave(String rateNewSave) {
        this.rateNewSave = rateNewSave;
    }

    public String getRateNearPast() {
        return rateNearPast;
    }

    public void setRateNearPast(String rateNearPast) {
        this.rateNearPast = rateNearPast;
    }

    public String getRateFarPast() {
        return rateFarPast;
    }

    public void setRateFarPast(String rateFarPast) {
        this.rateFarPast = rateFarPast;
    }

    public String getRateMetn() {
        return rateMetn;
    }

    public void setRateMetn(String rateMetn) {
        this.rateMetn = rateMetn;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
