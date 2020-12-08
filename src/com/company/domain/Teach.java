package com.company.domain;

public class Teach {
    private int year;

    //semester 1:true semester 2:false
    private boolean sem;
    private String c_ID;
    private String tea_ID;
    private String sub_ID;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean getSem() {
        return sem;
    }

    public void setSem(boolean sem) {
        this.sem = sem;
    }

    public String getC_ID() {
        return c_ID;
    }

    public void setC_ID(String c_ID) {
        this.c_ID = c_ID;
    }

    public String getTea_ID() {
        return tea_ID;
    }

    public void setTea_ID(String tea_ID) {
        this.tea_ID = tea_ID;
    }

    public String getSub_ID() {
        return sub_ID;
    }

    public void setSub_ID(String sub_ID) {
        this.sub_ID = sub_ID;
    }
}
