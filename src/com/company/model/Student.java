package com.company.model;

import com.company.TestApplication;
import oracle.jdbc.driver.OracleConnection;
import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Student {
    private String stu_id;
    static OracleConnection conn = TestApplication.conn;
    static Statement stmt;

    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // private Exam[] exams;
    public Student(String ID){
        stu_id = ID;
    }

    public boolean login(String password) throws SQLException {
        String s = "SELECT STU_PWD FROM STUDENT WHERE STU_ID = '" + stu_id + "'";
        ResultSet rset = stmt.executeQuery(s);
        rset.next();
        if(rset.getString(1).equals(password)) return true;
        return false;
    }

    public void printSubject(){

    }

    public void printExamTable(){

    }

    public void printClass(){}

    public boolean examAvailable(Exam exam){
        // Get time and judge whether it is later than the start time
        return true;
    }

    public void answerQuestion(Question q){
        // Show the question. Prompt input.
        // Store the answer to sql
    }

    public void takeExam(Exam e){
        // Get the questions from the database
        // A for-loop to answer the question one by one
        // Implement a "back"/"save answer and next question" options after each answer
    }

    public String getTestResult(Exam e){
        return "A";
    }

    public void getAnalysisReport(){

    }



}
