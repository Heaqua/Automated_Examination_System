package com.company.view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class StudentMainPage extends JFrame{

    public StudentMainPage(String title){
        super(title);
        JPanel panel = new JPanel();
        setBounds(500,300,700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,25);
        Font font1 = new Font("Times New Roman",Font.PLAIN,40);

        //set a label to show the personal information
        JLabel info = new JLabel("Personal information: " + "xxxxxxxxxxxxxxxxx");
        info.setBounds(1,1,500,30);
        info.setFont(font);
        panel.add(info);

        //set a label to notice logout
        JLabel logout = new JLabel("Logout");
        logout.setBounds(560,1,200,30);
        logout.setFont(font);
        panel.add(logout);

        //set three buttons to show the functions
        JButton viewExam = new JButton("View exam timetable");
        viewExam.setBounds(140,140,400,60);
        viewExam.setFont(font1);
        panel.add(viewExam);
        JButton take = new JButton("Take exam");
        take.setBounds(140,240,400,60);
        take.setFont(font1);
        panel.add(take);
        JButton result = new JButton("Report and results");
        result.setBounds(140,340,400,60);
        result.setFont(font1);
        panel.add(result);
        setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));
        setVisible(true);

        //Event
        //click "view exam schedule"
        viewExam.addActionListener(e -> {
            setVisible(false);
            new ExamSchedule();
        });

        //click "take an exam"
        take.addActionListener(e -> {
            setVisible(false);
            new TakeAnExam();
        });

        //click "reports and results"
        result.addActionListener(e -> {
            setVisible(false);
            new ReportsAndResults();
        });

    }


}

