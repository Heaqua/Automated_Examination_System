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
        return test_result;
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
