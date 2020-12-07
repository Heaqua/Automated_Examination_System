package com.company.domain;

import com.company.TestApplication;
import oracle.jdbc.driver.OracleConnection;
import java.math.BigDecimal;
import java.sql.*;

public class Student {
    private final String stu_id;
    static OracleConnection conn = TestApplication.conn;
    static Statement stmt;
    static PreparedStatement storeAnswer;
    static PreparedStatement mcqAnswer;
    static PreparedStatement queryQuestion;
    static PreparedStatement testNumGrade;
    static PreparedStatement testComments;

    static {
        try {
            stmt = conn.createStatement();
            storeAnswer = conn.prepareStatement("INSERT INTO ANSWER VALUES (?,?,?,?)");
            mcqAnswer = conn.prepareStatement("SELECT SCORE, ANSWER FROM " +
                    "QUESTION WHERE TEST# = ? AND Q# = ?");
            queryQuestion = conn.prepareStatement("SELECT COMPULSORY, TYPE, SCORE, Q_CONTENT " +
                    "FROM QUESTION WHERE TEST# = ? AND Q# = ?");
            testNumGrade = conn.prepareStatement("SELECT TEST_RESULT FROM TAKE " +
                    "WHERE TEST# = ? AND STU_ID = ?");
            testComments = conn.prepareStatement("SELECT COMMENTS FROM TAKE " +
                    "WHERE TEST# = ? AND STU_ID = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // private Exam[] exams;
    public Student(String ID){
        stu_id = ID;
    }

    /**
     * Return a boolean variable indicating whether its password is correct
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean login(String password) throws SQLException {
        String s = "SELECT STU_PWD FROM STUDENT WHERE STU_ID = '" + stu_id + "'";
        ResultSet rset = stmt.executeQuery(s);
        rset.next();
        if(rset.getString(1) == password) return true;
        return false;
    }


//    public ResultSet printExamTable(){
//
//
//    }

    public void printClass(){}

    public boolean examAvailable(String ExamId){
        // Get time and judge whether it is later than the start time

        return true;
    }


     /**
     * Store the answer into database
     * @param answer
     * @param testId
     * @param questionId
     * @param mcq If true, it will store the score of this question as well
     */
    public void storeAnswer(String answer, String testId, String questionId,
                            boolean mcq) throws SQLException {
        storeAnswer.setString(1, questionId);
        storeAnswer.setString(2, testId);
        storeAnswer.setString(3, stu_id);
        storeAnswer.setString(4, answer);
        if(!mcq){
            storeAnswer.setNull(5, Types.INTEGER);
            storeAnswer.executeUpdate();
        }else{
            mcqAnswer.setString(1, testId);
            mcqAnswer.setString(2, questionId);
            ResultSet rset = mcqAnswer.executeQuery();
            rset.next();
            int maxScore = rset.getInt(1);
            String stdAns = rset.getString(2);
            if(stdAns == answer) {
                // Answer correct
                storeAnswer.setInt(5, maxScore);
            }else{
                storeAnswer.setInt(5, 0);
            }
            storeAnswer.executeUpdate();
        }
    }

    /**
     *
     * @param questionId
     * @param testId
     * @return string COMPULSORY ("Y" or "N"), string TYPE, BigDecimal SCORE, string Q_CONTENT, string ANSWER
     */
    public ResultSet queryQuestion(String questionId, String testId) throws SQLException {
        queryQuestion.setString(1, testId);
        queryQuestion.setString(2, questionId);
        ResultSet rset = queryQuestion.executeQuery();
        return rset;
    }

    /**
     *
     * @param testId
     * @return A Double of the test score only.
     * If you want the letter grade or the comments,
     * use other methods
     * @throws SQLException
     */
    public Double getTestNumGrade(String testId) throws SQLException {
        testNumGrade.setString(1, testId);
        testNumGrade.setString(2, stu_id);
        ResultSet rset = testNumGrade.executeQuery();
        rset.next();
        BigDecimal dec = rset.getBigDecimal(1);
        Double doub = dec.doubleValue();
        return doub;
    }

    /**
     *
     * @param d a numeric number of score
     * @return the letter grade
     */
    public String letterGradeByNumGrade(Double d){
        if(d >= 95 && d <= 100) return "A+";
        else if(d >= 90) return "A";
        else if(d >= 85) return "A-";
        else if (d >= 80) return "B+";
        else if (d >= 75 ) return "B";
        else if (d >= 70) return "B-";
        else if (d >= 65) return "C+";
        else if (d >= 60) return "C";
        else if(d >= 55) return "C-";
        else if(d >= 50) return "D+";
        else if (d >= 45) return "D";
        else if (d >= 40) return "D-";
        else if(d < 40) return "F";
        return "Wrong input";
    }

    /**
     *
     * @param testId
     * @return the letter grade only
     * @throws SQLException
     */
    public String getLetterGrade(String testId) throws SQLException {
        return letterGradeByNumGrade(getTestNumGrade(testId));
    }

    /**
     *
     * @param testId
     * @return the comments as a string
     * @throws SQLException
     */
    public String getTestComments(String testId) throws SQLException {
        testComments.setString(1, testId);
        testComments.setString(2, stu_id);
        ResultSet rset = testComments.executeQuery();
        rset.next();
        String comment = rset.getString(1);
        return comment;
    }


    public void getAnalysisReport(){

    }





}

