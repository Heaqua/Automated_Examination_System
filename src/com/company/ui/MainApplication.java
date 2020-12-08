package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.SetDao;
import com.company.dao.sqlplus.*;
import com.company.domain.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        forTestingPurpose();
        app=new OriginalLoginPage();
        try {
            TestApplication.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void forTestingPurpose() {
//        TakeDaoImp takeDaoImp = new TakeDaoImp();
//
//        Take take = takeDaoImp.findByKey("201A123401", "S180102");
//        System.out.println(take.getComment());
//        System.out.println(take.getTest_result().doubleValue());

        StudentDaoImp studentDaoImp = new StudentDaoImp();
        Student s = new Student("Goofy", "S180102", "123456");
        StudentReport report = studentDaoImp.getStudentReport(s);

    }

}
