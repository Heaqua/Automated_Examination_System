package com.company.dao;

import com.company.domain.Question;

public interface QuestionDao {
    public Question findByID(String id);
    public void create(int questionNo,String testNo,String compulsory,String content,String answer);

}
