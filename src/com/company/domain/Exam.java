package com.company.domain;

import java.security.Timestamp;

public class Exam {
    private String testNo;
    private Timestamp start;
    private int duration;

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
