package com.company.dao.sqlplus;

import com.company.dao.QuestionDao;
import com.company.domain.Question;
import oracle.jdbc.driver.OracleConnection;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.Connection;
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
        try{
            Connection conn=TestApplication.conn;
            String sql="insert into question (q#,test#,compulsory,type,score,question_content,answer) values (?,?,?,?,?,?,?)" ;
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,questionNo);
            pstmt.setString(2,testNo);
            pstmt.setString(3,compulsory);
            pstmt.setString(4,type);
            pstmt.setBigDecimal(5,score);
            pstmt.setString(6,content);
            pstmt.setString(7,answer);

            int insertedRows=pstmt.executeUpdate();

            System.out.printf("Insert %d rows successfully \n",insertedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

