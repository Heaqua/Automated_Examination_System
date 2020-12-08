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
//        takeDaoImp.delete("0201Z100199", "S180102");
        try {
            Statement stmt = TestApplication.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C_ID FROM STUDENT WHERE STU_ID = 'S180102'");
            rs.next();
            System.out.println(rs.getString(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        StudentDaoImp studentDaoImp = new StudentDaoImp();
        Student s = new Student();
        s.setId("S180102");
        studentDaoImp.allExams(s);
    }

}
