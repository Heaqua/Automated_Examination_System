package com.company.view.GUI;

import GUI.SetAnExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class TeacherMainPage {
    public static void main(String[] args) {
        place();
    }
    private static void place(){
        JFrame Teacher = new JFrame("Teacher login page");
        JPanel panel = new JPanel();
        Teacher.setBounds(500,300,700,600);
        Teacher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Teacher.add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,25);
        Font font1 = new Font("Times New Roman",Font.PLAIN,40);

        //set a label to show the personal information
        //TODO
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
        JButton setAnExam = new JButton("Set an exam");
        setAnExam.setBounds(140,140,400,60);
        setAnExam.setFont(font1);
        panel.add(setAnExam);
        JButton markPapers = new JButton("Mark papers");
        markPapers.setBounds(140,240,400,60);
        markPapers.setFont(font1);
        panel.add(markPapers);
        JButton result = new JButton("View results");
        result.setBounds(140,340,400,60);
        result.setFont(font1);
        panel.add(result);

        Teacher.setVisible(true);
        Teacher.setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));

        //Event
        //click the button "Set an exam"
        setAnExam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher.setVisible(false);
                new SetAnExam();
            }
        });

        //Click the button "mark papers"
        markPapers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher.setVisible(false);
                new MarkPapers();
            }
        });

        //click the button "View Examination results"
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher.setVisible(false);
                new ViewExaminationResults();
            }
        });

    }

}
