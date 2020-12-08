package com.company.dao.sqlplus;

import com.company.dao.ClassDao;
import com.company.domain.Class1;
import com.company.domain.Student;
import com.company.domain.Teacher;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Class1DaoImp implements ClassDao {
    static OracleConnection conn = TestApplication.conn;
    @Override
    public Class1 findById(String cId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Class1 result = null;

        try {
            String sql = "select c_id, instructor_id  from class where c_id= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Class1();

               result.setC_id(rs.getString(1));
               result.setInstructor_id(rs.getString(2));

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

    public Student[] allStudents(Class1 class1){
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        Student[] result=null;

        try{
            conn=TestApplication.conn;
            String sql1="select stu_id, stu_name, c_id, stu_pwd from student,class where student.c_id=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,class1.getC_id());
            rs1=pstmt1.executeQuery();

            String sql2="select sum(stu_id) from student,class  where student.c_id =?";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,class1.getC_id());
            rs2=pstmt2.executeQuery();

            int index=rs2.getInt(1);
            result=new Student[index];
            int i=1;

            if(rs1.next()){
                i++;
                Student student=new Student(rs1.getString("stu_name"),
                        rs1.getString("stu_id"),
                        rs1.getString("stu_pwd")
                        );
                student.setC_id(rs1.getString("c_id"));

                result[i-1]=student;

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
        }
        return null;




    }
}
