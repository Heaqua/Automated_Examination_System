package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.domain.*;
import com.company.dao.sqlplus.TestApplication;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication {

    public static People user;
    public static OriginalLoginPage app;
    public static int num=0;


    public static void main(String[] args){
        forTestingPurpose();
        app=new OriginalLoginPage();
        try {
            TestApplication.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void forTestingPurpose() {
        try {
            TestApplication.testApplication();
            ExamDaoImp examDaoImp = new ExamDaoImp();
            Exam e = examDaoImp.findById("201Z100199");
            System.out.println(e.getDuration());
            TestApplication.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
