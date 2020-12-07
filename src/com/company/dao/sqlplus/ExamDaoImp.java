package com.company.dao.sqlplus;

import com.company.dao.ExamDao;
import com.company.domain.Exam;
import com.company.domain.Question;
import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;

public class ExamDaoImp implements ExamDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement questions;
    static PreparedStatement queryExamTime;
    static PreparedStatement queryExamSete;
    static PreparedStatement subByExam;

    static {
        try {
            questions = conn.prepareStatement("SELECT Q#, COMPULSORY, TYPE, SCORE, Q_CONTENT " +
                    "FROM QUESTION WHERE TEST# = ?");
            queryExamTime = conn.prepareStatement("SELECT START_TIME, DURATION FROM EXAM WHERE TEST# = ?");
            queryExamSete = conn.prepareStatement("SELECT YEAR, SEM, TEA_ID, C_ID FROM SETE WHERE TEST# = ?");
            subByExam = conn.prepareStatement("SELECT SUB_ID FROM TEACH WHERE YEAR = ? " +
                    "AND SEM = ? AND C_ID = ? AND TEA_ID = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public Exam findById(String testId) {
        ResultSet rs = null;
        Exam e = null;
        try {
            queryExamTime.setString(1, testId);
            rs = queryExamTime.executeQuery();
            rs.next();
            Timestamp start_time = rs.getTimestamp(1);
            int duration = rs.getInt(2);
            queryExamSete.setString(1, testId);
            rs = queryExamSete.executeQuery();
            rs.next();
            int year = rs.getInt(1);
            int sem = rs.getInt(2);
            String tea_id = rs.getString(3);
            String c_id = rs.getString(4);
            subByExam.setInt(1, year);
            subByExam.setInt(2, sem);
            subByExam.setString(3, c_id);
            subByExam.setString(4, tea_id);
            rs = subByExam.executeQuery();
            rs.next();
            String sub_id = rs.getString(1);
            e = new Exam(testId, start_time, duration, year, sem, tea_id, c_id, sub_id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException exception) {
                }
            }
        }
        return e;
    }

    public void create(String testNo, Timestamp start, int duration){
        try{
            Connection conn=TestApplication.conn;
            String sql="insert into exam (test#,start_time,duration) values (?,?,?)" ;
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,testNo);
            pstmt.setTimestamp(2,start);
            pstmt.setInt(3,duration);

            int insertedRows=pstmt.executeUpdate();

            System.out.printf("Insert %d rows successfully \n",insertedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Question[] allQuestions(Exam e){
        ResultSet rs = null;
        Question[] ques = null;
        try {
            questions.setString(1, e.getTestNo());
            rs = questions.executeQuery();
            int num = 0;
            if(rs.last()){
                num = rs.getRow();
                rs.beforeFirst();
            }
            ques = new Question[num];
            for(int i = 0; i < num; i++){
                ques[i] = new Question(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6));
            }
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
        return ques;
    }






}
