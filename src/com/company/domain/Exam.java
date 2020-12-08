package com.company.domain;

import java.sql.Timestamp;

public class Exam {
    private String testNo;
    private Timestamp start;
    private int duration;

    //
    private short year;
    private int sem;
    private String tea_id;
    private String c_id;
    private String sub_id;

    public Exam(){

    }

    public Exam(String testNo, Timestamp start, int duration,
                short year, int sem, String tea_id, String c_id, String sub_id){
        this.testNo = testNo;
        this.start = start;
        this.duration = duration;
        this.year = year;
        this.sem = sem;
        this.tea_id = tea_id;
        this.c_id = c_id;
        this.sub_id = sub_id;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTestNo() {
        return testNo;
    }

    public Timestamp getStart() {
        return start;
    }

    public int getDuration() {
        return duration;
    }
}
