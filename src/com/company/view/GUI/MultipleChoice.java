package com.company.view.GUI;

import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

import static java.awt.Toolkit.getDefaultToolkit;

public class MultipleChoice extends JFrame {

        public MultipleChoice(){
            super("Set Multiple Choice Question");
            JPanel panel = new JPanel();
            setSize(700,600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(panel);
            setVisible(true);
            int number;
            panel.setLayout(null);
            number = 1;
            Font font = new Font("Times New Roman",Font.PLAIN,20);
            JLabel count = new JLabel("Question "+number);
            JLabel hint = new JLabel("Please set the question: (multiple choice) ");
            JLabel score = new JLabel("Set score : ");
            JLabel hint2 = new JLabel("Please set four answers : ");
            JLabel OR = new JLabel("OR");
            JTextArea question = new JTextArea();
            JTextField score2 = new JTextField();
            JTextField A0 = new JTextField();
            JTextField B0 = new JTextField();
            JTextField C0 = new JTextField();
            JTextField D0 = new JTextField();
            JRadioButton A = new JRadioButton("A");
            JRadioButton B = new JRadioButton("B");
            JRadioButton C = new JRadioButton("C");
            JRadioButton D = new JRadioButton("D");
            JRadioButton Com = new JRadioButton("Compulsory");

            JRadioButton Optional = new JRadioButton("Optional");
            JButton save = new JButton("Save and Complete");
            JButton next = new JButton("Next");
            ButtonGroup Group = new ButtonGroup();
            Group.add(Com);
            Group.add(Optional);
            ButtonGroup Group2 = new ButtonGroup();
            Group2.add(A);
            Group2.add(B);
            Group2.add(C);
            Group2.add(D);
            Com.setSelected(true);
            A.setSelected(true);
            count.setBounds(1,2,100,30);
            count.setFont(font);
            hint.setBounds(10,20,400,70);
            hint.setFont(font);
            hint2.setBounds(10,190,300,70);
            hint2.setFont(font);
            score.setBounds(450,20,100,70);
            score.setFont(font);
            question.setBounds(10,90,600,100);
            question.setFont(font);
            score2.setBounds(550,30,40,40);
            score2.setFont(font);

            A0.setBounds(80,260,400,30);
            A0.setFont(font);
            B0.setBounds(80,310,400,30);
            B0.setFont(font);
            C0.setBounds(80,360,400,30);
            C0.setFont(font);
            D0.setBounds(80,410,400,30);
            D0.setFont(font);
            A.setBounds(10,260,50,30);
            A.setFont(font);
            B.setBounds(10,310,50,30);
            B.setFont(font);
            C.setBounds(10,360,50,30);
            C.setFont(font);
            D.setBounds(10,410,50,30);
            D.setFont(font);
            OR.setBounds(480,210,30,30);
            OR.setFont(font);
            Com.setBounds(340,210,130,30);
            Com.setFont(font);
            Optional.setBounds(540,210,120,30);
            Optional.setFont(font);
            save.setBounds(450,460,200,30);
            save.setFont(font);
            next.setBounds(450,500,200,30);
            next.setFont(font);
            panel.add(count);
            panel.add(hint);
            panel.add(hint2);
            panel.add(score);
            panel.add(question);
            panel.add(score2);
            panel.add(A);
            panel.add(B);
            panel.add(C);
            panel.add(D);
            panel.add(A0);
            panel.add(B0);
            panel.add(C0);
            panel.add(D0);
            panel.add(Com);
            panel.add(Optional);
            panel.add(OR);
            panel.add(save);
            panel.add(next);
            setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));

        //Event








    }
}

