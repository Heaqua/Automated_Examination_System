package com.company.dao.sqlplus;

import com.company.dao.QuestionDao;
import com.company.domain.Question;
import oracle.jdbc.driver.OracleConnection;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDaoImp implements QuestionDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement queryQuestion;

    static {
        try {
            queryQuestion = conn.prepareStatement("SELECT COMPULSORY, TYPE, SCORE," +
                    " Q_CONTENT, ANSWER FROM QUESTION WHERE TEST# = ? AND Q# = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Question findByID(int questionNo, String testNo) {
        Question q = null;
        ResultSet rs = null;
        try {
            queryQuestion.setString(1,testNo);
            queryQuestion.setInt(2, questionNo);
            rs = queryQuestion.executeQuery();
            rs.next();
            q = new Question(questionNo, rs.getString(1), rs.getString(2),
                    rs.getInt(3), rs.getString(4), rs.getString(5));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException exception){
                }
            }
        }

        return q;
    }

    @Override
    public void create(int questionNo, String testNo, String compulsory, String type, BigDecimal score, String content, String answer) {

    }
}
