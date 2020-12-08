package com.company.dao.sqlplus;

import com.company.dao.StudentDao;
import com.company.domain.*;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImp implements StudentDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement findClass;

    static {
        try {
            findClass = conn.prepareStatement("SELECT C_ID FROM STUDENT WHERE STU_ID = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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
                result= new Student(rs.getString("stu_name"), rs.getString("stu_id"), rs.getString("stu_pwd"));

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
        try {
            findClass.setString(1, student.getId());
            ResultSet rs = findClass.executeQuery();
            rs.next();
            String c_id = rs.getString(1);
            ExamDaoImp examDaoImp = new ExamDaoImp();
            return examDaoImp.findExamByClass(c_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            String sql1="select subject.sub_id,subject.sub_name from subject,choose,student where subject.sub_id=choose.sub_id and choose.c_id=student.c_id and student.stu_id=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,student.getId());
            rs1=pstmt1.executeQuery();

            String sql2="select sum(subject.sub_id) from subject,choose,student where subject.sub_id=choose.sub_id and choose.c_id=student.c_id and student.stu_id=?";
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

    public Student[] findByCId(String cId){
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        Student[] result=null;

        try{
            String sql1="SELECT STU_ID, STU_NAME, C_ID,STU_PWD FROM STUDENT WHERE C_ID=?";
            pstmt1=conn.prepareStatement(sql1);
            pstmt1.setString(1,cId);
            rs1=pstmt1.executeQuery();

            String sql2="SELECT SUM(STU_ID) FROM STUDENT WHERE C_ID=?";
            pstmt2=conn.prepareStatement(sql2);
            pstmt2.setString(1,cId);
            rs2=pstmt2.executeQuery();


            int index=0;
            if(rs2.next()){
                index=rs2.getInt(1);
            }


            result=new Student[index];
            int i=0;

            if(rs1.next()){
                i++;
                Student student=new Student(rs1.getString(2), rs1.getString(1), rs1.getString(4));
                student.setC_id(rs1.getString(3));
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

    public StudentReport getStudentReport(Student s){
        ExamDaoImp examDaoImp = new ExamDaoImp();
        SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
        TakeDaoImp takeDaoImp = new TakeDaoImp();
        TeacherDaoImp teacherDaoImp = new TeacherDaoImp();
        Exam[] exams = allExams(s);
        String[][] table = new String[exams.length][8];
        int year = exams[0].getYear();
        int sem = exams[0].getSem();
        System.out.println("Before execution: ");
        for(Exam exam: exams){
            System.out.println(exam.getTestNo());
        }
        System.out.println("End");
        for(int i = 0; i < exams.length; i++){
            table[i][0] = exams[i].getSub_id();
            // Find the sub_name
            Subject subject = subjectDaoImp.findById(exams[i].getSub_id());
            table[i][1] = subject.getSub_name();
            // Find letter grade and comments
            System.out.println("testNo " + exams[i].getTestNo());
            Take take = takeDaoImp.findByKey(exams[i].getTestNo(), s.getId());
            System.out.println("testNo after take: " + exams[i].getTestNo());
            System.out.println(s.getId());
            System.out.println(take == null);

            double numGrade = take.getTest_result().doubleValue();
            table[i][2] = take.letterGradeByNumGrade(numGrade);
            table[i][7] = take.getComment();
            // Find prof name
            Teacher teacher = teacherDaoImp.findById(exams[i].getTea_id());
            table[i][6] = teacher.getTea_name();
            // Find testStats
            TestStats testStats = examDaoImp.getTestStatsById(exams[i].getTestNo());
            double[] scores = testStats.getScores();
            // Find the progress
            int numBeyond = 0;
            for(int j = 0; j < scores.length; j ++){
                if(numGrade > scores[j]) numBeyond++;
                else break;
            }
            float progress = (float)numBeyond/(float)scores.length * 100.0F;
            String progressString = String.format("%.2f%%", progress);
            table[i][3] = progressString;
            table[i][4] = String.valueOf(testStats.getAverage());
            table[i][5] = String.valueOf(testStats.getMax());
        }
        StudentReport studentReport = new StudentReport(year, sem, s.getName(), s.getId(), s.getC_id());
        studentReport.setTable(table);
        return studentReport;
    }

}
