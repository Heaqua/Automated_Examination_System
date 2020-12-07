package com.company.ui;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.math.BigDecimal;

import static java.awt.Toolkit.getDefaultToolkit;

public class FillBlanks extends JFrame {
    public static void main(String[] args) {
        new FillBlanks();
    }
    public FillBlanks(){
        super("Fill in the blank");
        JPanel panel = new JPanel();
        this.setBounds(500,300,700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(null);

        //set font
        Font font = new Font("Times New Roman",Font.PLAIN,20);

        //set Q#
        int number = 1;
        JLabel count = new JLabel("Question "+number);
        count.setBounds(1,2,100,30);
        count.setFont(font);
        panel.add(count);

        //set the question
        JLabel ques = new JLabel("Please set the question: (with a blank in it)");
        ques.setBounds(10,30,500,50);
        ques.setFont(font);
        panel.add(ques);

        //set the question area
        JTextArea question = new JTextArea();
        question.setBounds(10,90,600,200);
        question.setFont(font);
        question.setLineWrap(true);
        panel.add(question);

        JScrollPane jsp=new JScrollPane(question);
        Dimension size=question.getPreferredSize();
        jsp.setBounds(10,90,600,200);
        panel.add(jsp);

        //set the score
        JLabel score = new JLabel("Set score : ");
        score.setBounds(450,20,100,70);
        score.setFont(font);
        panel.add(score);

        //set the score area
        JTextField score2 = new JTextField();
        score2.setBounds(550,30,40,40);
        score2.setFont(font);
        panel.add(score2);

        //set a hint
        JLabel hint = new JLabel("Please set the correct answer : ");
        hint.setBounds(10,300,300,50);
        hint.setFont(font);
        panel.add(hint);

        //set the correct answer
        JTextField answer = new JTextField();
        answer.setBounds(10,350,400,100);
        answer.setFont(font);
        panel.add(answer);

        //set compulsory or optional button and a "OR" label
        JLabel OR = new JLabel("OR");
        JRadioButton Com = new JRadioButton("Compulsory");
        JRadioButton Optional = new JRadioButton("Optional");
        ButtonGroup Group = new ButtonGroup();
        Group.add(Com);
        Group.add(Optional);
        Com.setSelected(true);
        Com.setBounds(340,300,130,30);
        Com.setFont(font);
        Optional.setBounds(530,300,120,30);
        Optional.setFont(font);
        OR.setBounds(480,300,30,30);
        OR.setFont(font);
        panel.add(OR);
        panel.add(Com);
        panel.add(Optional);

        //set two buttons for deciding whether complete or not
        JButton save = new JButton("Save and Complete");
        JButton next = new JButton("Save and Next");
        save.setBounds(450,460,200,30);
        save.setFont(font);
        next.setBounds(450,500,200,30);
        next.setFont(font);
        panel.add(save);
        panel.add(next);

        setSize(700,600);
        setLocationRelativeTo(null);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));
        this.setVisible(true);

        score2.addActionListener(e -> {
            String scoreFromText=score2.getText();
        });

        question.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String questionFromText=question.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        answer.addActionListener(e -> {

        });

        Com.addActionListener(e -> {
            String comOrOp="Y";
        });

        Optional.addActionListener(e -> {
            String comOrOp="N";
        });

        save.addActionListener(e -> {
            MainApplication.num++;
            new TeacherMainPage();
        });

        next.addActionListener(e -> {
            MainApplication.num++;

        });
        //Event
        //click the button "Save and Complete"
        save.addActionListener(e -> {
            setVisible(false);
            new TeacherMainPage();
        });

        //Click the button "Save and Next"
        next.addActionListener(e -> {
            setVisible(false);
            new QuestionType();
        });


    }
}
