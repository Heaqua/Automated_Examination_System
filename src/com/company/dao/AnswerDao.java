package com.company.dao;

import com.company.domain.Answer;

import java.math.BigDecimal;

public interface AnswerDao {

    public Answer findByKey(int questionNo,String testNo,String stu_id);
    public void create(int questionNo, String testNo, String stu_id, String stu_answer, BigDecimal stu_score);
    public void create1(int questionNo, String testNo, String stu_id, String stu_answer);
    public void modify(BigDecimal stu_score);
    public void delete(Answer answer);

}
