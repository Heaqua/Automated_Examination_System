package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.SetDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.SetDaoImp;
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
        //forTestingPurpose();
        try {
            TestApplication.testApplication();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app=new OriginalLoginPage();
//        try {
//            TestApplication.conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    public static void forTestingPurpose() {
        try {
            TestApplication.testApplication();
//            ExamDao examDao=new ExamDaoImp();
//            examDao.create(testNumber,start2,dur);
            SetDao setDao = new SetDaoImp();
            setDao.create("201Z100199",2018,1,"T090909","C09");
            TestApplication.conn.close();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}
