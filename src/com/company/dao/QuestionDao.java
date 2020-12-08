package com.company.dao;

import com.company.domain.Question;

import java.math.BigDecimal;

public interface QuestionDao {
    public Question findByID(short questionNo,String testNo);
    public void create(short questionNo, String testNo, String compulsory, String type, BigDecimal score, String content, String answer);
}
