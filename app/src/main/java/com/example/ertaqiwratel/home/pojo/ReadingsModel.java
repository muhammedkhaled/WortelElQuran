package com.example.ertaqiwratel.home.pojo;

public class ReadingsModel {
    private String Parent, child_1 , child_2;

    public ReadingsModel() {
    }

    public ReadingsModel(String parent, String child_1, String child_2) {
        Parent = parent;
        this.child_1 = child_1;
        this.child_2 = child_2;
    }

    public String getParent() {
        return Parent;
    }

    public void setParent(String parent) {
        Parent = parent;
    }

    public String getChild_1() {
        return child_1;
    }

    public void setChild_1(String child_1) {
        this.child_1 = child_1;
    }

    public String getChild_2() {
        return child_2;
    }

    public void setChild_2(String child_2) {
        this.child_2 = child_2;
    }
}
