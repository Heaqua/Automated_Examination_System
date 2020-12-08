package com.company.dao;

import com.company.domain.Exam;
import com.company.domain.Question;
import com.company.domain.TestStats;

import java.sql.Time;
import java.sql.Timestamp;

public interface ExamDao {


    public Exam findById(String exam);
    public void create(String testNo, String start, int duration);
    public Question[] allQuestions(Exam exam);

    public TestStats getTestStatsById(String testId);

    public Exam findBySubIdCId(String subId,String cId);

}
