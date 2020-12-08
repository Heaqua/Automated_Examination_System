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
    }

    public static void forTestingPurpose() {
        try {
            TestApplication.testApplication();
            Exam e = new Exam();
            e.setTestNo("201C241101");
            ExamDaoImp examDaoImp = new ExamDaoImp();
            Question[] ques = examDaoImp.allQuestions(e);
            for(Question q: ques){
                System.out.print(q.getQuesNo());
                System.out.print(q.getCom());
                System.out.print(q.getType());
                System.out.print(q.getScore());
                System.out.print(q.getContent());
                System.out.print(q.getAnswer());
                System.out.println();
            }
            TestApplication.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/*
try {
        TestApplication.testApplication();
        Question q = new QuestionDaoImp().findByID((short) 1, "201C241101");
        System.out.println(q.getContent());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

 */