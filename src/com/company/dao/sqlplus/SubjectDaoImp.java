package com.company.dao.sqlplus;

import com.company.dao.SubjectDao;
import com.company.domain.Subject;
import com.company.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDaoImp implements SubjectDao {
    @Override
    public Subject findById(String id) {
        return null;
    }

    public Subject findByTeaClaId(String teaId, String classId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Subject result = null;

        try {
            conn = TestApplication.conn;
            String sql = "select sub_id, sub_name from subject,";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teaId);
            pstmt.setString(2, classId);
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
