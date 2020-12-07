package com.company.ui;

import com.company.domain.*;
import com.company.dao.sqlplus.*;
import com.company.dao.sqlplus.TestApplication;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication {

    public static People user;
    public static OriginalLoginPage app;
    public static int num=0;


    public static void main(String[] args){
        try {
            TestApplication.testApplication();
            Question q = new QuestionDaoImp().findByID(1, "201C241101");
            System.out.println(q.getContent());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app=new OriginalLoginPage();
    }

}
