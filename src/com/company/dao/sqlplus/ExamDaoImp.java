package com.company.dao.sqlplus;

import com.company.dao.ExamDao;
import com.company.domain.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ExamDaoImp implements ExamDao {

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






}
