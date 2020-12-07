package com.company.dao.sqlplus;

import com.company.dao.QuestionDao;
import com.company.domain.Question;

import java.math.BigDecimal;

public class QuestionDaoImp implements QuestionDao {
    @Override
    public Question findByID(int questionNo, String testNo) {
        return null;
    }

    @Override
    public void create(int questionNo, String testNo, String compulsory, String type, BigDecimal score, String content, String answer) {

    }
}
