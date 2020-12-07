package com.company.dao;

import com.company.domain.Exam;
import com.company.domain.Question;

import java.sql.Timestamp;

public interface ExamDao {

    public Exam findById(String exam);
    public void create(String testNo, Timestamp start, int duration);
    public Question[] allQuestions(Exam exam);

}
