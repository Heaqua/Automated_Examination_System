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
    public static short num=0;
    public static int start=0;


    public static void main(String[] args){
        forTestingPurpose();
        app=new OriginalLoginPage();
    }

    public static void forTestingPurpose() {
        try {
            TestApplication.testApplication();
            ExamDaoImp examDaoImp = new ExamDaoImp();
            examDaoImp.deleteExam("201Z100199");
            examDaoImp.create("201Z100199", "2020/12/31:14:00:00", 180);
            SetDaoImp setDaoImp = new SetDaoImp();
            setDaoImp.create("201Z100199", 2020, 1, "T890023", "C01");
            Exam exam = examDaoImp.findById("201Z100199");
            System.out.println(exam.getStart());
            System.out.println(exam.getSub_id());
//            setDaoImp.deleteSete("201Z100199");
//            SetDao setDao = new SetDaoImp();
//            setDao.create("201Z100199",2018,1,"T090909","C09");
//            examDaoImp.deleteExam("201Z100199");
            TestApplication.conn.close();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}
