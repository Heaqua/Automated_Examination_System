package com.company.dao.sqlplus;

import com.company.dao.SubjectDao;
import com.company.domain.Subject;
import com.company.domain.Teacher;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDaoImp implements SubjectDao {
    static OracleConnection conn = TestApplication.conn;
    public Subject findByTeaClaId(short year,boolean sem,String teaId, String classId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Subject result = null;

        try {
            String sql = "select sub_id, sub_name from subject,set,choose where tea_Id=? and set.c_id=? and set.year=? and set.sem=?  " +
                    "set.c_id=choose.c_id and set.year=choose.year"+ "and  set.sem=choose.sem";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teaId);
            pstmt.setString(2, classId);
            pstmt.setShort(3,year);
            pstmt.setBoolean(4,sem);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Subject();

                result.setSub_name(rs.getString("sub_name"));
                result.setSub_id(rs.getString("sub_id"));

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

    public Subject findById(String subId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Subject result = null;

        try {
            String sql = "select sub_id, sub_name from subject where sub_id=?,";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Subject();

                result.setSub_name(rs.getString("sub_name"));
                result.setSub_id(rs.getString("sub_id"));

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
