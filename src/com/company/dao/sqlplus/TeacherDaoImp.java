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
}
