package com.company.dao.sqlplus;

import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImp implements StudentDao {
    public Student login(String userId){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student result=null;

        try{
            conn=TestApplication.conn;
            String sql="select stu_id,stu_name,c_id, stu_pwd from teacher where stu_id= ?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            rs=pstmt.executeQuery();

            if(rs.next()){
                result=new Student();

                result.setName(rs.getString("stu_name"));
                result.setId(rs.getString("stu_id"));
                result.setPassword(rs.getString("stu_pwd"));
                result.setClassId(rs.getString("c_id"));

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
