package com.company.dao.sqlplus;

import com.company.dao.ExamDao;
import com.company.domain.Exam;
import com.company.domain.Question;
import com.company.domain.TestStats;
import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ExamDaoImp implements ExamDao {
    static OracleConnection conn = TestApplication.conn;
    static PreparedStatement questions;
    static PreparedStatement queryExamTime;
    static PreparedStatement queryExamSete;
    static PreparedStatement subByExam;
    static PreparedStatement queryTestStats;
    static PreparedStatement queryAllScore;
    static PreparedStatement deleteExam;
    static PreparedStatement examByClass;

    static {
        try {
            examByClass = conn.prepareStatement("SELECT TEST# FROM SETE WHERE C_ID = ?");
            questions = conn.prepareStatement("SELECT Q#, COMPULSORY, TYPE, SCORE, Q_CONTENT, ANSWER " +
                    "FROM QUESTION WHERE TEST# = ?");
            queryExamTime = conn.prepareStatement("SELECT START_TIME, DURATION FROM EXAM WHERE TEST# = ?");
            queryExamSete = conn.prepareStatement("SELECT YEAR, SEM, TEA_ID, C_ID FROM SETE WHERE TEST# = ?");
            queryTestStats = conn.prepareStatement("SELECT AVG(TEST_RESULT), MEDIAN(TEST_RESULT), MAX(TEST_RESULT), MIN(TEST_RESULT), STDDEV(TEST_RESULT) FROM TAKE WHERE TEST# = ?");
            queryAllScore = conn.prepareStatement("SELECT TEST_RESULT FROM TAKE WHERE TEST# = ?");
            deleteExam = conn.prepareStatement("DELETE FROM EXAM WHERE TEST# = ?");
            subByExam = conn.prepareStatement("SELECT SUB_ID FROM TEACH WHERE YEAR = ? " +
                    "AND SEM = ? AND C_ID = ? AND TEA_ID = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Exam[] findExamByClass(String c_id){
        ResultSet rs = null;
        ArrayList<Exam> exams = new ArrayList<>();
        Exam[] examsArray = null;
        try {
            examByClass.setString(1, c_id);
            rs = examByClass.executeQuery();
            while(rs.next()){
                Exam exam = findById(rs.getString(1));
                exams.add(exam);
            }
            examsArray = new Exam[exams.size()];
            examsArray = exams.toArray(examsArray);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return examsArray;
    }

    @Override
    public Exam findById(String testId) {
        ResultSet rs = null;
        Exam e = null;
        try {
            queryExamTime.setString(1, testId);
            rs = queryExamTime.executeQuery();
            rs.next();
            Timestamp start_time = rs.getTimestamp(1);
            int duration = rs.getInt(2);
            queryExamSete.setString(1, testId);
            rs = queryExamSete.executeQuery();
            rs.next();
            short year = rs.getShort(1);
            int sem = rs.getInt(2);
            String tea_id = rs.getString(3);
            String c_id = rs.getString(4);
            subByExam.setShort(1, year);
            subByExam.setInt(2, sem);
            subByExam.setString(3, c_id);
            subByExam.setString(4, tea_id);
            rs = subByExam.executeQuery();
            rs.next();
            String sub_id = rs.getString(1);
            e = new Exam(testId, start_time, duration, year, sem, tea_id, c_id, sub_id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException exception) {
                }
            }
        }
        return e;
    }


    //TODO please comment in the sql file if you run the create methods
    public void create(String testNo, String start, int duration){
        try{
            Connection conn=TestApplication.conn;
            String sql="insert into exam values (?,to_date(?,'yyyy/mm/dd:hh24:mi:ss'),?)" ;
            PreparedStatement pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,testNo);
            pstmt.setString(2,start);
            pstmt.setInt(3,duration);

            int insertedRows=pstmt.executeUpdate();

            System.out.printf("Insert %d rows successfully \n",insertedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Debugged
    public Question[] allQuestions(Exam e){
        ResultSet rs = null;
        ArrayList<Question> quesList = new ArrayList<>();
        Question[] ques = null;
        try {
            questions.setString(1, e.getTestNo());
            rs = questions.executeQuery();
            while(rs.next()){
                quesList.add(new Question(rs.getShort(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            ques = new Question[quesList.size()];
            ques = quesList.toArray(ques);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException exception){
                }
            }

        }
        return ques;
    }

    // Debugged
    @Override
    public TestStats getTestStatsById(String testId) {
        TestStats t = null;
        ResultSet rs = null;
        try {
            queryTestStats.setString(1, testId);
            rs = queryTestStats.executeQuery();
            rs.next();
            double average = rs.getBigDecimal(1).doubleValue();
            double median = rs.getBigDecimal(2).doubleValue();
            double max = rs.getBigDecimal(3).doubleValue();
            double min = rs.getBigDecimal(4).doubleValue();
            double sd = rs.getBigDecimal(5).doubleValue();
            queryAllScore.setString(1, testId);
            rs = queryAllScore.executeQuery();
            ArrayList<Double> scoresList = new ArrayList();
            while(rs.next()){
                scoresList.add(rs.getBigDecimal(1).doubleValue());
            }
            double[] scores = scoresList.stream().mapToDouble(i -> i).toArray();
            t = new TestStats(scores, average, median, max, min, sd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException exception) {
                }
            }
        }
        return t;
    }

    public void deleteExam(String testId){
        try {
            deleteExam.setString(1, testId);
            deleteExam.executeUpdate();
            System.out.println(testId + " deleted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Exam findBySubIdCId(String subId,String cId){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Exam result = null;

        try {
            String sql = "";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = new Exam();

                result.setTestNo(rs.getString("TEST#"));
                result.setStart(rs.getTimestamp("START_TIME"));
                result.setDuration(rs.getInt("DURATION"));

                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                    ;
                } catch (SQLException e) {

                }
            }
        }
        return null;

    }

}
