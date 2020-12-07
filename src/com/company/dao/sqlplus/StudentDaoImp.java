package com.company.dao.sqlplus;

import com.company.dao.StudentDao;
import com.company.domain.Exam;
import com.company.domain.Student;

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
                result= new Student();

                result.setName(rs.getString("stu_name"));
                result.setId(rs.getString("stu_id"));
                result.setPassword(rs.getString("stu_pwd"));
                result.setC_id(rs.getString("c_id"));

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

    public Exam[]  allExams(Student student){
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        Exam[] result=null;

        try{
            conn=TestApplication.conn;
            String sql1="";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,student.getId());
            rs1=pstmt1.executeQuery();

            String sql2="";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,student.getId());
            rs2=pstmt2.executeQuery();

            int index=rs2.getInt(1);
            result=new Exam[index];
            int i=1;

            if(rs1.next()){
                i++;
                Exam exam=new Exam();

                exam.setDuration(rs1.getInt(""));
                exam.setStart(rs1.getTimestamp(""));
                exam.setTestNo(rs1.getString(""));

                result[i-1]=exam;

            }
            return result;


        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(rs1!=null){
                try{
                    rs1.close();
                }
                catch (SQLException e){

                }
            }
            if(rs2!=null){
                try{
                    rs2.close();
                }
                catch (SQLException e){

                }
            }

            if(pstmt1!=null){
                try{
                    pstmt1.close();;
                }
                catch (SQLException e){

                }
            }
            if(pstmt2!=null){
                try{
                    pstmt2.close();
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
