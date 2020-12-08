package com.company.dao.sqlplus;

import com.company.dao.SetDao;
import com.company.domain.*;
import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetDaoImp implements SetDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement deleteSete;

    static {
        try {
            deleteSete = conn.prepareStatement("DELETE FROM SETE WHERE TEST# = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteSete(String testId){
        try {
            deleteSete.setString(1, testId);
            deleteSete.executeUpdate();
            System.out.println(testId + " deleted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Set findById(String testNo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Set result = null;

        try {
            conn = TestApplication.conn;
            String sql = "SELECT TEST#,YEAR,SEM,TEA_ID,C_ID FROM SETE WHERE TEST#=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, testNo );
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Set();

                result.setC_ID(rs.getString("c_id"));
                result.setSem(rs.getInt("sem"));
                result.setTea_ID(rs.getString("tea_id"));
                result.setTestNo(rs.getString("test#"));
                result.setYear(rs.getInt("year"));

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

    public void create(String testNo,int year,int sem,String teaId,String cId){
     try{
        String sql="INSERT INTO SETE (TEST#,YEAR,SEM,TEA_ID,C_ID) VALUES (?,?,?,?,?)" ;
        PreparedStatement pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,testNo);
        pstmt.setInt(2,year);
        pstmt.setInt(3,sem);
        pstmt.setString(4,teaId);
        pstmt.setString(5,cId);

        int insertedRows=pstmt.executeUpdate();

        System.out.printf("Insert %d rows successfully \n",insertedRows);
    } catch (SQLException e){
        e.printStackTrace();
    }
    }

    //TODO a teacher can set multiple exams how can it has a return type of Set instead of Set[]?
    public Set findByTeaId(String teaId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Set result = null;

        try {
            conn = TestApplication.conn;
            String sql = "SELECT TEST#,YEAR,SEM,TEA_ID,C_ID FROM SET WHERE TEST#=?";
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, testNo );
            rs = pstmt.executeQuery();




            if (rs.next()) {
                result = new Set();

                result.setC_ID(rs.getString("c_id"));
                result.setSem(rs.getInt("sem"));
                result.setTea_ID(rs.getString("tea_id"));
                result.setTestNo(rs.getString("test#"));
                result.setYear(rs.getInt("year"));

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
}
