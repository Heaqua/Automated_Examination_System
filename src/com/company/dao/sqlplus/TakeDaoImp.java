package com.company.dao.sqlplus;

import com.company.dao.TakeDao;
import com.company.domain.Take;
import com.company.domain.Teacher;
import oracle.jdbc.driver.OracleConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TakeDaoImp implements TakeDao {
    static OracleConnection conn = TestApplication.conn;

    public Take findByKey(String testNo, String stuId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Take result = null;

        try {
            String sql = "select test#,stu_id,test_result,comments from take where test#=? and stu_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,testNo );
            pstmt.setString(2,stuId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Take();

                result.setTestNo(rs.getString("test#"));
                result.setStu_ID(rs.getString("stu_id"));
                result.setTest_result(rs.getBigDecimal("test_result"));
                result.setComment(rs.getString("comments"));

                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                    ;
                } catch (SQLException e) {

                }
            }
        }
        return null;

    }

    public void create(String testNo, String stuId , BigDecimal testResult, String comments){
        try {
            String sql = "insert into take (test#,stu_id,test_result,comments) values (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,testNo );
            pstmt.setString(2,stuId);
            pstmt.setBigDecimal(3,testResult);
            pstmt.setString(4,comments);
            int rows = pstmt.executeUpdate();
            System.out.printf("Successfully insert %d data item \n", rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyTestResult(Take take, BigDecimal testResult){
    try{
        String sql = "update take set test_result=? where test#=? and stu_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBigDecimal(1,testResult);
        pstmt.setString(2,take.getTestNo());
        pstmt.setString(3,take.getStu_ID());
        int rows = pstmt.executeUpdate();
        System.out.printf("Successfully insert %d data item \n", rows);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public void modifyComments(Take take,String comments){
        try{
            String sql = "update take set comments=? where test#=? and stu_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,comments);
            pstmt.setString(2,take.getTestNo());
            pstmt.setString(3,take.getStu_ID());
            int rows = pstmt.executeUpdate();
            System.out.printf("Successfully insert %d data item \n", rows);
        } catch (SQLException e) {
                e.printStackTrace();
        }

}



}
