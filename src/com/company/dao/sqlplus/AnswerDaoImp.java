package com.company.dao.sqlplus;

import com.company.dao.AnswerDao;
import com.company.domain.Answer;
import com.company.domain.Exam;
import oracle.jdbc.driver.OracleConnection;

import java.math.BigDecimal;
import java.sql.*;

public class AnswerDaoImp implements AnswerDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement queryAnswer;
    static PreparedStatement storeAnswer;
    static PreparedStatement deleteAnswer;
    static PreparedStatement updateScore;
    static {
        try {
            storeAnswer = conn.prepareStatement("INSERT INTO ANSWER VALUES (?,?,?,?,?)");
            deleteAnswer = conn.prepareStatement("DELETE FROM ANSWER WHERE TEST# = ? " +
                    "AND Q# = ? AND STU_ID = ?");
            updateScore = conn.prepareStatement("UPDATE SET STU_SCORE = ? WHERE TEST# = ? AND Q# = ? AND STU_ID = ?");
            queryAnswer = conn.prepareStatement("SELECT STU_ANS, STU_SCORE FROM ANSWER WHERE TEST# = ? " +
                    "AND Q# = ? AND STU_ID =?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Answer findByKey(short questionNo, String testNo, String stu_id) {
        ResultSet rs = null;
        Answer a = null;
        try {
            queryAnswer.setString(1, testNo);
            queryAnswer.setShort(2, questionNo);
            queryAnswer.setString(3, stu_id);
            rs = queryAnswer.executeQuery();
            rs.next();
            String stu_ans = rs.getString(1);
            BigDecimal score = rs.getBigDecimal(2);
            a = new Answer(questionNo, testNo, stu_id, stu_ans, score);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException exception){
                }
            }
        }
    return a;
    }
    @Override
    public void create(int questionNo, String testNo, String stu_id, String stu_answer, BigDecimal stu_score){
        ResultSet rs = null;
        try {
            storeAnswer.setString(1, testNo);
            storeAnswer.setInt(2, questionNo);
            storeAnswer.setString(3, stu_id);
            storeAnswer.setString(4, stu_answer);
            storeAnswer.setBigDecimal(5, stu_score);
            storeAnswer.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException exception){
                }
            }
        }
    }

    @Override
    public void create1(int questionNo, String testNo, String stu_id, String stu_answer) {
        ResultSet rs = null;
        try {
            storeAnswer.setString(1, testNo);
            storeAnswer.setInt(2, questionNo);
            storeAnswer.setString(3, stu_id);
            storeAnswer.setString(4, stu_answer);
            storeAnswer.setNull(5, Types.DOUBLE);
            storeAnswer.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException exception){
                }
            }
        }
    }

    @Override
    public void modify(Answer answer,BigDecimal stu_score) {
        try{
            Connection conn = TestApplication.conn;
            String sql = "update answer set stu_score=? where q#=? and test#=? and stu_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1,stu_score);
            pstmt.setInt(2,answer.getQuesNo());
            pstmt.setString(3,answer.getTestNo());
            pstmt.setString(4,answer.getStu_ID());
            int rows = pstmt.executeUpdate();
            System.out.printf("Successfully insert %d data item \n", rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Answer answer) {
        try {
            deleteAnswer.setString(1,answer.getTestNo());
            deleteAnswer.setInt(2, answer.getQuesNo());
            deleteAnswer.setString(3, answer.getStu_ID());
            deleteAnswer.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Answer[] findByTeaId(String teaId){
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        Answer[] result = null;

        try {
            conn = TestApplication.conn;
            //TODO
            String sql1 = "";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, teaId);
            rs1 = pstmt1.executeQuery();

            //TODO
            String sql2 = "";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, teaId);
            rs2 = pstmt2.executeQuery();

            int index=0;
            if(rs2.next()){
                index=rs2.getInt(1);
            }
            result = new Answer[index];
            int i = 0;

            if (rs1.next()) {
                i++;
                Answer answer = new Answer();

                answer.setQuesNo(rs1.getShort("Q#"));
                answer.setStu_ID(rs1.getString("stu_id"));
                answer.setTestNo(rs1.getString("test#"));
                answer.setStu_ans(rs1.getString("stu_ans"));
                answer.setScore(rs1.getBigDecimal("stu_score"));

                result[i - 1] = answer;

            }
            return result;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs1 != null) {
                try {
                    rs1.close();
                } catch (SQLException e) {

                }
            }
            if (rs2 != null) {
                try {
                    rs2.close();
                } catch (SQLException e) {

                }
            }

            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                    ;
                } catch (SQLException e) {

                }
            }
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException e) {

                }
            }


            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {

                }
            }
        }
        return null;
    }
}


