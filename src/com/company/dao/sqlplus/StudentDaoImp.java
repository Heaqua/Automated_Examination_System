package com.company.dao.sqlplus;

import com.company.dao.StudentDao;
import com.company.domain.Exam;
import com.company.domain.Student;
import com.company.domain.Subject;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImp implements StudentDao {
    static OracleConnection conn = TestApplication.conn;
    public Student findById(String userId){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student result=null;

        try{
            conn=TestApplication.conn;
            String sql="SELECT STU_ID,STU_NAME,C_ID,STU_PWD FROM STUDENT WHERE STU_ID= ?";
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
        }
        return null;

    }

    public Exam[]  allExams(Student student){
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        Exam[] result=null;

        try{
            conn=TestApplication.conn;

            //TODO
            String sql1="SELECT TEST#,DATE,START_TIME,DURATION FROM STUDENT S,SET E,TEACH T " +
                    "WHERE S.STU_ID =? AND S.C_ID=E.C_ID AND T.YEAR =? AND T.SEM =?" +
                    "AND T.TEA_ID = E.TEA_ID AND T.YEAR = E.YEAR AND T.SEM = E.SEM AND" +
                    "T.C_ID = S.C_ID";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,student.getId());
            pstmt1.setShort(2,Current.getCurrentYear());
            pstmt1.setBoolean(3,Current.getCurrentSem());
            rs1=pstmt1.executeQuery();

            String sql2="SELECT SUM (TEST#) FROM STUDENT S,SET E,TEACH T " +
                    "WHERE S.STU_ID =? AND S.C_ID=E.C_ID AND T.YEAR =? AND T.SEM =?" +
                    "AND T.TEA_ID = E.TEA_ID AND T.YEAR = E.YEAR AND T.SEM = E.SEM AND" +
                    "T.C_ID = S.C_ID";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,student.getId());
            rs2=pstmt2.executeQuery();

            int index=0;
            if(rs2.next()){
                index=rs2.getInt(1);
            }
            result=new Exam[index];
            int i=0;

            if(rs1.next()){
                i++;
                Exam exam=new Exam();

                exam.setDuration(rs1.getInt("duration"));
                exam.setStart(rs1.getTimestamp("start_time"));
                exam.setTestNo(rs1.getString("test#"));

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
        }
        return null;
    }

    public Subject[] allSubjects(Student student){
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        Subject[] result=null;

        try{
            String sql1="select sub_id,sub_name from subject,choose,student where subject.sub_id=choose.sub_id and choose.c_id=student.c_id and student.stu_id=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,student.getId());
            rs1=pstmt1.executeQuery();

            String sql2="select sum(sub_id) from subject,choose,student where subject.sub_id=choose.sub_id and choose.c_id=student.c_id and student.stu_id=?";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,student.getId());
            rs2=pstmt2.executeQuery();


            int index=0;
            if(rs2.next()){
                index=rs2.getInt(1);
            }


            result=new Subject[index];
            int i=0;

            if(rs1.next()){
                i++;
                Subject subject=new Subject();

                subject.setSub_id(rs1.getString("sub_id"));
                subject.setSub_name(rs1.getString("sub_name"));

                result[i-1]=subject;

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
