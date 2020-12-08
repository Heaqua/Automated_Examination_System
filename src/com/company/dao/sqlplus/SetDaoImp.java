package com.company.dao.sqlplus;

import com.company.dao.SetDao;
import com.company.domain.Set;
import com.company.domain.Teacher;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetDaoImp implements SetDao {
    static OracleConnection conn = TestApplication.conn;

    public Set findById(String testNo){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Set result = null;

        try {
            conn = TestApplication.conn;
            String sql = "select test#,year,sem,tea_id,c_id from set where test#=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, testNo );
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Set();

                result.setC_ID(rs.getString("c_id"));
                result.setSem(rs.getBoolean("sem"));
                result.setTea_ID(rs.getString("tea_id"));
                result.setTestNo(rs.getString("test#"));
                result.setYear(rs.getShort("year"));

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

    public void create(String testNo,short year,boolean sem,String teaId,String cId){
     try{
        String sql="insert into set (test#,year,sem,tea_id,c_id) values (?,?,?,?,?)" ;
        PreparedStatement pstmt=conn.prepareStatement(sql);

        pstmt.setString(1,testNo);
        pstmt.setShort(2,year);
        pstmt.setBoolean(3,sem);
        pstmt.setString(4,teaId);
        pstmt.setString(5,cId);

        int insertedRows=pstmt.executeUpdate();

        System.out.printf("Insert %d rows successfully \n",insertedRows);
    } catch (SQLException e){
        e.printStackTrace();
    }
    }

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
                result.setSem(rs.getBoolean("sem"));
                result.setTea_ID(rs.getString("tea_id"));
                result.setTestNo(rs.getString("test#"));
                result.setYear(rs.getShort("year"));

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
