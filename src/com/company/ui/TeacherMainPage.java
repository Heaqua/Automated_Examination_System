package com.company.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class TeacherMainPage extends JFrame {
    public static void main(String[] args){
        new TeacherMainPage();
    }
    public TeacherMainPage(){
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
        //TODO
        JLabel info = new JLabel("Personal information: " + "xxxxxxxxxxxxxxxxx");
        info.setBounds(1,1,500,30);
        info.setFont(font);
        panel.add(info);

        //set a label to notice logout
        JLabel logout = new JLabel("Logout");
        logout.setBounds(560,1,150,30);
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

        ImageIcon image = new ImageIcon("src\\com\\company\\ui\\Images\\logout.jpg");
        JLabel logOut=new JLabel(image);
        logOut.setBounds(635,1,30,30);
        panel.add(logOut);


        setVisible(true);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));

        //Event
        //click the button "Set an exam"
        setAnExam.addActionListener(e -> {
            setVisible(false);
            new SetAnExam();
        });

        //Click the button "mark papers"
        markPapers.addActionListener(e -> {
            setVisible(false);
            new MarkPapers("ab=?","1",2);
        });

        //click the button "View Examination results"
        result.addActionListener(e -> {
            setVisible(false);
            new ViewExaminationResults();
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
