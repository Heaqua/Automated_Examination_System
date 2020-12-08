package com.company.ui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class QuestionType extends JFrame {

    public QuestionType(){
        super("Question Type");
        JPanel panel = new JPanel();

        //set frame size
        setBounds(500,300,700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,40);
        Font font1 = new Font("Times New Roman",Font.PLAIN,30);

        //set a label to show the Q#
        JLabel count = new JLabel("Question " + MainApplication.num);
        count.setBounds(1,1,200,50);
        count.setFont(font);
        panel.add(count);

        //set a notice label
        JLabel notice = new JLabel("Please choose the type of the question : ");
        notice.setBounds(80,80,600,50);
        notice.setFont(font1);
        panel.add(notice);

        //set three buttons
        JButton Mul = new JButton("Multiple choice");
        JButton Fill = new JButton("Fill in the blank");
        JButton standard = new JButton("Standard full-length test questions");
        Mul.setBounds(120,170,450,50);
        Mul.setFont(font1);
        Fill.setBounds(120,260,450,50);
        Fill.setFont(font1);
        standard.setBounds(120,350,450,50);
        standard.setFont(font1);
        panel.add(Mul);
        panel.add(Fill);
        panel.add(standard);


        setVisible(true);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));
        setSize(700,600);
        setLocationRelativeTo(null);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,460,150,50);
        back.setFont(font);
        panel.add(back);



        //Event
        Mul.addActionListener(e -> {
           setVisible(false);
           new MultipleChoice();
        });

        Fill.addActionListener(e -> {
            setVisible(false);
            new FillBlanks();
        });

        standard.addActionListener(e -> {
            setVisible(false);
            new FullLength();
        });

        back.addActionListener(e -> {
            setVisible(false);
            new TeacherMainPage();
        });

    }

}
