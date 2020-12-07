package com.company.domain;

public class Answer {
    private int quesNo;
    private String stu_ID;
    private String stu_ans;
    private int score;

    public  void setQuesNo(int quesNo) {
        this.quesNo = quesNo;
    }

    public void setStu_ID(String stu_ID) {
        this.stu_ID = stu_ID;
    }

    public void setStu_ans(String stu_ans) {
        this.stu_ans = stu_ans;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuesNo() {
        return quesNo;
    }

    public String getStu_ID() {
        return stu_ID;
    }

    public String getStu_ans() {
        return stu_ans;
    }

    public int getScore() {
        return score;
    }
}
