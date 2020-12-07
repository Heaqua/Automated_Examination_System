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

    static {
        try {
            questions = conn.prepareStatement("SELECT Q#, COMPULSORY, TYPE, SCORE, Q_CONTENT " +
                    "FROM QUESTION WHERE TEST# = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public Exam findById(String exam) {
        return null;
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
                ques[i] = new Question(rs.getString(1), rs.getString(2), rs.getString(3),
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
