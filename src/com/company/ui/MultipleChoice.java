package com.company.ui;

import com.company.dao.QuestionDao;
import com.company.dao.sqlplus.QuestionDaoImp;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static com.company.ui.MainApplication.num;
import static java.awt.Toolkit.getDefaultToolkit;

public class MultipleChoice extends JFrame {
    String A1,B1,C1,D1,ques,ans,compul;
    BigDecimal scores;
        public MultipleChoice(){
            super("Set Multiple Choice Question");
            JPanel panel = new JPanel();
            this.setSize(700,600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.add(panel);

            panel.setLayout(null);
            Font font = new Font("Times New Roman",Font.PLAIN,20);
            JLabel count = new JLabel("Question "+MainApplication.num);
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
            JButton next = new JButton("Save and Next");
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
            question.setLineWrap(true);
            question.setFont(font);
            panel.add(question);
            JScrollPane roll=new JScrollPane(question);
            roll.setBounds(10,90,600,100);
            panel.add(roll);
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
            this.setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));
            this.setVisible(true);



            //Event
            score2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            question.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {

                }

                @Override
                public void removeUpdate(DocumentEvent e) {

                }

                @Override
                public void changedUpdate(DocumentEvent e) {

                }
            });

            A0.addActionListener(e -> {

            });

            B0.addActionListener(e -> {

            });

            C0.addActionListener(e -> {

            });

            D0.addActionListener(e -> {

            });

            Optional.addActionListener(e -> {
                compul = "N";

            });

            Com.addActionListener(e -> {
                compul = "Y";

            });

            A.addActionListener(e -> {
                ans = "A";
            });

            B.addActionListener(e -> {
                ans = "B";
            });

            C.addActionListener(e -> {
                ans = "C";
            });

            D.addActionListener(e -> {
                ans = "D";
            });

            save.addActionListener(e -> {

            });

            next.addActionListener(e -> {

            });
            //Event
            //click the button "Save and Complete"
            save.addActionListener(e -> {
                A1 = A0.getText();
                B1 = B0.getText();
                C1 = C0.getText();
                D1 = D0.getText();
                String scoreText = score2.getText();
                scores = new BigDecimal(scoreText);
                ques = question.getText()+"|"+A1+"|"+B1+"|"+C1+"|"+D1;
                setVisible(false);
                new TeacherMainPage();
                QuestionDao questionDao = new QuestionDaoImp();
                questionDao.create(num,SetAnExam.testNumber,compul,"MC",scores,ques,ans);
            });

            //Click the button "Save and Next"
            next.addActionListener(e -> {
                A1 = A0.getText();
                B1 = B0.getText();
                C1 = C0.getText();
                D1 = D0.getText();
                String scoreText = score2.getText();
                scores = new BigDecimal(scoreText);
                ques = question.getText()+"|"+A1+"|"+B1+"|"+C1+"|"+D1;
                setVisible(false);
                new QuestionType();
                QuestionDao questionDao = new QuestionDaoImp();
                questionDao.create(num,SetAnExam.testNumber,compul,"MC",scores,ques,ans);
            });

    }
}

