package com.company.domain;

import java.math.BigDecimal;

public class Answer {
    private short quesNo;
    private String testNo;
    private String stu_ID;
    private String stu_ans;
    private BigDecimal score;

    public Answer(){}
    public Answer(short quesNo, String testNo, String stu_ID, String stu_ans, BigDecimal score){
        this.testNo = testNo;
        this.quesNo = quesNo;
        this.stu_ID = stu_ID;
        this.stu_ans = stu_ans;
        this.score = score;
    }

    public String getTestNo(){
        return testNo;
    }
    public void setQuesNo(short quesNo) {
        this.quesNo = quesNo;
    }

    public void setStu_ID(String stu_ID) {
        this.stu_ID = stu_ID;
    }

    public void setStu_ans(String stu_ans) {
        this.stu_ans = stu_ans;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public short getQuesNo() {
        return quesNo;
    }

    public String getStu_ID() {
        return stu_ID;
    }

    public String getStu_ans() {
        return stu_ans;
    }

    public BigDecimal getScore() {
        return score;
    }
}
