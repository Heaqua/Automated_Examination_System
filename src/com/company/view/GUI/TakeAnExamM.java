package com.company.view.GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class TakeAnExamM extends JFrame {
    public static void main(String[] args) {
        new TakeAnExamM(2,10,5,"5+65 = ?","3","5","70","1","Compulsory");
    }
    public TakeAnExamM(int num,int total,int score,String Question,String A,String B,String C,String D,String Com){
        super("Take an exam");
        JPanel panel = new JPanel();
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/view/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,30);
        Font font2 = new Font("Times New Roman",Font.PLAIN,25);

        //a label to show the question#
        JLabel que = new JLabel("Question " + num + " / "+ total);
        que.setBounds(1,1,300,50);
        que.setFont(font);
        panel.add(que);

        //a label to show the total score of the question
        JLabel score1 = new JLabel("Score : " + score);
        score1.setBounds(520,1,300,50);
        score1.setFont(font);
        panel.add(score1);

        //a label for question
        JLabel ques = new JLabel();
        ques.setBounds(30, 100, 600, 200);
        ques.setFont(font);
        SetText(ques,Question);
        panel.add(ques);
        JScrollPane jsp=new JScrollPane(ques);
        jsp.setBounds(30,100,620,200);
        panel.add(jsp);

        //4 buttons for student to choose

        JRadioButton A1 = new JRadioButton("A");
        JRadioButton B1 = new JRadioButton("B");
        JRadioButton C1 = new JRadioButton("C");
        JRadioButton D1 = new JRadioButton("D");
        ButtonGroup Group2 = new ButtonGroup();
        Group2.add(A1);
        Group2.add(B1);
        Group2.add(C1);
        Group2.add(D1);
        A1.setBounds(30,320,50,30);
        A1.setFont(font);
        B1.setBounds(30,370,50,30);
        B1.setFont(font);
        C1.setBounds(30,420,50,30);
        C1.setFont(font);
        D1.setBounds(30,470,50,30);
        D1.setFont(font);
        panel.add(A1);
        panel.add(B1);
        panel.add(C1);
        panel.add(D1);

        //four labels for answer
        JLabel A2 = new JLabel(A);
        JLabel B2 = new JLabel(B);
        JLabel C2 = new JLabel(C);
        JLabel D2 = new JLabel(D);
        A2.setBounds(100,320,100,30);
        A2.setFont(font2);
        B2.setBounds(100,370,100,30);
        B2.setFont(font2);
        C2.setBounds(100,420,100,30);
        C2.setFont(font2);
        D2.setBounds(100,470,100,30);
        D2.setFont(font2);
        panel.add(A2);
        panel.add(B2);
        panel.add(C2);
        panel.add(D2);

        //set a progressBar
        final int MIN_PROGRESS = 0;
        final int MAX_PROGRESS = 100;

        final int[] currentProgress = {MIN_PROGRESS};
        JProgressBar progressBar = new JProgressBar();{
            new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentProgress[0]++;
                    if (currentProgress[0] > MAX_PROGRESS) {
                        currentProgress[0] = MIN_PROGRESS;
                    }
                    progressBar.setValue(currentProgress[0]);
                }
            }).start();
        }
        progressBar.setBounds(30,60,600,20);
        progressBar.setMinimum(MIN_PROGRESS);
        progressBar.setMaximum(MAX_PROGRESS);
        progressBar.setValue(currentProgress[0]);
        progressBar.setStringPainted(true);
        panel.add(progressBar);

        //a button for next
        JButton next = new JButton("Next");
        next.setBounds(480,480,150,50);
        next.setFont(font);
        panel.add(next);

        //a label "compulsory" or not
        JLabel compulsory = new JLabel(Com);
        compulsory.setBounds(480,300,300,40);
        compulsory.setFont(font2);
        panel.add(compulsory);


        //click "next"
        next.addActionListener(e -> {
            setVisible(false);
            new TakeAnExamM(3,10,5,"7*8","56","98","2","3","Optional");
        });
        this.setVisible(true);



    }
    void SetText(JLabel jLabel, String longString) {
        StringBuilder text = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0,num = 0;
        while (start + num < longString.length()) {
            while (true) {
                num++;
                if (start + num > longString.length())
                    break;
                if (fontMetrics.charsWidth(chars, start, num)
                        > jLabel.getWidth()) {
                    break;
                }
            }
            text.append(chars, start, num - 1).append("<br/>");
            start = start + num - 1;
            num = 0;
        }
        text.append(chars, start, longString.length() - start);
        text.append("</html>");
        jLabel.setText(text.toString());
    }
}
