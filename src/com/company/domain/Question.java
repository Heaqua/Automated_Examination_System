package com.company.domain;

public class Question {
    private int quesNo;
    private String com;
    private String type;
    private int score;
    private String content;
    private String answer;

    public Question(){

    }

    public Question(int quesNo, String com, String type, int score, String content, String answer) {
        this.quesNo = quesNo;
        this.com = com;
        this.type = type;
        this.score = score;
        this.content = content;
        this.answer = answer;
    }

    public void setQuesNo(short quesNo) {
        this.quesNo = quesNo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCom() {
        return com;
    }

    public int getQuesNo() {
        return quesNo;
    }
}
