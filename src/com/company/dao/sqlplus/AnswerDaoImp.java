package com.company.dao.sqlplus;

import com.company.dao.AnswerDao;
import com.company.domain.Answer;
import oracle.jdbc.driver.OracleConnection;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerDaoImp implements AnswerDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement queryAnswer;
    static {
        try {
            queryAnswer = conn.prepareStatement("SELECT STU_ANS, STU_SCORE FROM ANSWER WHERE TEST# = ? " +
                    "AND Q# = ? AND STU_ID =?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Answer findByKey(int questionNo, String testNo, String stu_id) {
        ResultSet rs = null;
        Answer a = null;
        try {
            queryAnswer.setString(1, testNo);
            queryAnswer.setInt(2, questionNo);
            queryAnswer.setString(3, stu_id);
            rs = queryAnswer.executeQuery();
            rs.next();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }

    @Override
    public void create(int questionNo, String testNo, String stu_id, String stu_answer, BigDecimal stu_score) {

    }

    @Override
    public void modify(String stu_answer, BigDecimal stu_score) {

    }

    @Override
    public void delete(Answer answer) {

    }
}
