package com.company.ui;

import com.company.domain.Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class TakeAnExamB extends JFrame {


    public TakeAnExamB(int num,int total,int score,String Question,String Com){
        super("Take an exam");
        JPanel panel = new JPanel();
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/ui/Images/logo1.png"));

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

        //get answer
        JTextArea answer = new JTextArea();
        answer.setBounds(30,350,400,130);
        answer.setFont(font);
        answer.setLineWrap(true);
        panel.add(answer);

        JScrollPane jsp1=new JScrollPane(answer);
        jsp1.setBounds(30,350,400,130);
        panel.add(jsp1);



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
//        next.addActionListener(e -> {
//            setVisible(false);
//            new TakeAnExamM(3,10,5,"7*8","56","98","2","3","Optional");
//        });
//        this.setVisible(true);
//
        next.addActionListener(e -> {
            setVisible(false);
            MainApplication.start++;
            (StudentMainPage)MainApplication.mainPage.takeAnExam

        });


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
