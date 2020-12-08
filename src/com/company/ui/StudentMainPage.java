package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.QuestionDao;
import com.company.dao.StudentDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.domain.Exam;
import com.company.domain.Question;
import com.company.domain.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;

import static java.awt.Toolkit.getDefaultToolkit;

public class StudentMainPage extends JFrame{
    Exam takeAnExam;
    public StudentMainPage(){
        super("Main Page");
        JPanel panel = new JPanel();
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,25);
        Font font1 = new Font("Times New Roman",Font.PLAIN,40);

        //set a label to show the personal information
        JLabel info = new JLabel( MainApplication.user.getName()+" "+MainApplication.user.getId());
        info.setBounds(1,1,500,30);
        info.setFont(font);
        panel.add(info);

        //set a label to notice logout
        JLabel logout = new JLabel("Logout");
        logout.setBounds(560,1,200,30);
        logout.setFont(font);
        panel.add(logout);

        //set four buttons to show the functions
        JButton viewExam = new JButton("View exam timetable");
        viewExam.setBounds(140,120,400,60);
        viewExam.setFont(font1);
        panel.add(viewExam);
        JButton take = new JButton("Take exam");
        take.setBounds(140,220,400,60);
        take.setFont(font1);
        panel.add(take);
        JButton result = new JButton("Report and results");
        result.setBounds(140,320,400,60);
        result.setFont(font1);
        panel.add(result);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));
        JButton analysis = new JButton("Analysis Report");
        analysis.setBounds(140,420,400,60);
        analysis.setFont(font1);
        panel.add(analysis);

        //log-out logo


        ImageIcon image = new ImageIcon("src\\com\\company\\ui\\Images\\logout.jpg");
        JLabel logOut=new JLabel(image);
        logOut.setBounds(635,1,30,30);
        panel.add(logOut);

        setVisible(true);

        //Event
        //click "view exam schedule"
        viewExam.addActionListener(e -> {
            setVisible(false);
            new ExamSchedule();
        });
        analysis.addActionListener(e -> {
            setVisible(false);
            new AnalysisReport();
        });

        //click "take an exam"
        take.addActionListener(e -> {
            setVisible(false);
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            StudentDao studentDao = new StudentDaoImp();
            Exam[] exams = studentDao.allExams((Student) MainApplication.user);
            for (int i = 0; i < exams.length; i++) {
                if (currentTime.toString().equals(exams[i].getStart().toString())) {
                    takeAnExam=exams[i];

                    //judge the first question type
                    ExamDao examDao=new ExamDaoImp();
                    Question[] allQuestions=examDao.allQuestions(takeAnExam);
                    if(allQuestions[0].getType().equals("MC")){
                        new TakeAnExamM();
                    }
                    else {
                        new TakeAnExamB(allQuestions[0].getQuesNo(),allQuestions.length,allQuestions[0].getScore(),allQuestions[0].getContent(),allQuestions[0].getCom());
                    }

                }
            }
        });

        //click "reports and results"
        result.addActionListener(e -> {
            setVisible(false);
            new ReportsAndResults();
        });

        logOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                MainApplication.app = new OriginalLoginPage();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}

