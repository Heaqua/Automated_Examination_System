package com.company.dao;

import com.company.domain.Take;

import java.math.BigDecimal;

public interface TakeDao {
    public Take findByKey(String testNo, String stu_id);
    public void create(String testNo, String stu_id, BigDecimal test_result, String comments);
    public void modifyTestResult(Take take,BigDecimal testResult);
    public void modifyComments(Take take, String comments );
}
