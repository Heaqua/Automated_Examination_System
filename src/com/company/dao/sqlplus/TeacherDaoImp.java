package com.company.dao.sqlplus;

import com.company.dao.TeacherDao;
import com.company.domain.Class1;
import com.company.domain.Subject;
import com.company.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImp implements TeacherDao {
    public Teacher login(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Teacher result = null;

        try {
            conn = TestApplication.conn;
            String sql = "select tea_id,tea_name,tea_pwd from teacher where tea_id= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Teacher();

                result.setName(rs.getString("tea_name"));
                result.setId(rs.getString("tea_id"));
                result.setPassword(rs.getString("tea_pwd"));

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

    public Subject[] allSubjects(Teacher teacher) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        Subject[] result = null;

        try {
            conn = TestApplication.conn;
            String sql1 = "select sub_id,sub_name from teach where tea_id=?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, teacher.getId());
            rs1 = pstmt1.executeQuery();

            String sql2 = "select sum(sub_id) from teach where tea_id=?";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, teacher.getId());
            rs2 = pstmt2.executeQuery();

            int index = rs2.getInt(1);
            result = new Subject[index];
            int i = 1;

            if (rs1.next()) {
                i++;
                Subject subject = new Subject();

                subject.setSub_id(rs1.getString("sub_id"));
                subject.setSub_name(rs1.getString("sub_name"));

                result[i - 1] = subject;

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


    public Class1[] allClasses(Teacher teacher) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        Class1[] result = null;

        try {
            conn = TestApplication.conn;
            String sql1 = "select c_id,instructor_id from teach,class where tea_id=? and class.c_id=teach.c_id";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, teacher.getId());
            rs1 = pstmt1.executeQuery();

            String sql2 = "select sum(c_id) from teach where tea_id=?";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, teacher.getId());
            rs2 = pstmt2.executeQuery();

            int index = rs2.getInt(1);
            result = new Class1[index];
            int i = 1;

            if (rs1.next()) {
                i++;
                Class1 class1 = new Class1();

                class1.setC_id(rs1.getString("c_id"));
                class1.setInstructor_id(rs1.getString("instructor_id"));

                result[i - 1] = class1;

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
