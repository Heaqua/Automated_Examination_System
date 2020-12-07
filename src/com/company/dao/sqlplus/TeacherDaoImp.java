package com.company.dao.sqlplus;

import com.company.dao.TeacherDao;
import com.company.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImp implements TeacherDao {
    public Teacher login(String userId){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Teacher result=null;

        try{
            conn=TestApplication.conn;
            String sql="select tea_id,tea_name,tea_pwd from teacher where tea_id= ?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            rs=pstmt.executeQuery();

            if(rs.next()){
                result=new Teacher();

                result.setName(rs.getString("tea_name"));
                result.setId(rs.getString("tea_id"));
                result.setPassword(rs.getString("tea_pwd"));

                return result;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException e){

                }
            }

            if(pstmt!=null){
                try{
                    pstmt.close();;
                }
                catch (SQLException e){

                }
            }

            if(conn !=null){
                try {
                    conn.close();
                }
                catch (SQLException e){

                }
            }
        }
        return null;

    }

    public String[] allSubjects(Teacher teacher){
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        String[] result=null;

        try{
            conn=TestApplication.conn;
            String sql1="select sub_id,sub_name from teach where tea_id=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,teacher.getId());
            rs1=pstmt1.executeQuery();

            String sql2="select sum(sub_id) from teach where tea_id=?";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,);


            if(rs1.next()){
                result=new Teacher();

                result.setName(rs.getString("tea_name"));
                result.setId(rs.getString("tea_id"));
                result.setPassword(rs.getString("tea_pwd"));

                return result;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException e){

                }
            }

            if(pstmt!=null){
                try{
                    pstmt.close();;
                }
                catch (SQLException e){

                }
            }

            if(conn !=null){
                try {
                    conn.close();
                }
                catch (SQLException e){

                }
            }
        }
        return null;
    }
}
