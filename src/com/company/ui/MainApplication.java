package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.SetDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.SetDaoImp;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.domain.*;
import com.company.dao.sqlplus.TestApplication;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication {

    public static People user;
    public static OriginalLoginPage app;
    public static short num=1;
    public static int start=0;


    public static void main(String[] args){

        try {
            TestApplication.testApplication();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //forTestingPurpose();
        app=new OriginalLoginPage();
//        try {
//            TestApplication.conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    public static void forTestingPurpose() {
        StudentDaoImp studentDaoImp = new StudentDaoImp();
        Student s = new Student();
        s.setId("S180102");
        Exam[] exams = studentDaoImp.allExams(s);
        for(Exam exam: exams){
            System.out.println(exam.getSub_id());
        }
    }

}
