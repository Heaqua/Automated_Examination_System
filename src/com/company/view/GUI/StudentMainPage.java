package com.company.view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class StudentMainPage extends JFrame{
    public static void main(String[] args) {
        new StudentMainPage("CSCC");
    }

    public StudentMainPage(String title){
        super(title);
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

        //log-out logo


        ImageIcon image = new ImageIcon("src\\com\\company\\view\\Images\\logout.jpg");
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

        logOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new OriginalLoginPage();
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

