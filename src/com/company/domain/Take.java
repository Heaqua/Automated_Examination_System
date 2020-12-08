package com.company.domain;

import java.math.BigDecimal;

public class Take {
    private String testNo;
    private String stu_ID;
    private BigDecimal test_result;
    private String comment;

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getStu_ID() {
        return stu_ID;
    }

    public void setStu_ID(String stu_ID) {
        this.stu_ID = stu_ID;
    }

    public BigDecimal getTest_result() {
        System.out.println("getTest_result");
        return test_result;
    }

    public String getLetterGrade(){
        System.out.println(this.test_result);
        System.out.println(this.getTestNo()+ " Have called getLetterGrade");
        return letterGradeByNumGrade(getTest_result().doubleValue());
    }

    public static String letterGradeByNumGrade(Double d){
        if(d >= 95 && d <= 100) return "A+";
        else if(d >= 90) return "A";
        else if(d >= 85) return "A-";
        else if (d >= 80) return "B+";
        else if (d >= 75 ) return "B";
        else if (d >= 70) return "B-";
        else if (d >= 65) return "C+";
        else if (d >= 60) return "C";
        else if(d >= 55) return "C-";
        else if(d >= 50) return "D+";
        else if (d >= 45) return "D";
        else if (d >= 40) return "D-";
        else if(d < 40) return "F";
        return "Wrong input";
    }

    public void setTest_result(BigDecimal test_result) {
        this.test_result = test_result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
