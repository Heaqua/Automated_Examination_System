package com.company.dao;

import com.company.domain.Take;

import java.math.BigDecimal;

public interface TakeDao {
    public Take findByKey(String testNo, String stu_id);
    public void create(String testNo, String stu_id, BigDecimal test_result, String comments);
    public void modify(String test_result,String comments);
}
