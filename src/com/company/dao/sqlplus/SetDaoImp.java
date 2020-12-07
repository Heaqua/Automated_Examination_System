package com.company.dao.sqlplus;

import com.company.dao.SetDao;
import com.company.domain.Set;
import com.company.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetDaoImp implements SetDao {

    public Set findById(String testNo){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Set result = null;

        try {
            conn = TestApplication.conn;
            String sql = "select test#,";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, testNo );
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Set();

                result.setC_ID(rs.getString(""));
                result.setSem(rs.getInt(""));
                result.setTea_ID(rs.getString(""));
                result.setTestNo(rs.getString(""));
                result.setTea_ID(rs.getString(""));

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
