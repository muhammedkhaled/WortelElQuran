package com.example.ertaqiwratel.home.pojo;

public class StudentOfDayModel {
    private String studentName, studentTime;

    public StudentOfDayModel() {
    }

    public String getStudentName() {
        return studentName;
    }

    public StudentOfDayModel(String studentName, String studentTime) {
        this.studentName = studentName;
        this.studentTime = studentTime;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentTime() {
        return studentTime;
    }

    public void setStudentTime(String studentTime) {
        this.studentTime = studentTime;
    }
}
