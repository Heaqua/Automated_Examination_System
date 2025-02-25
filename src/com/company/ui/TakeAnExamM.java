package com.company.ui;

import com.company.dao.AnswerDao;
import com.company.dao.ExamDao;
import com.company.dao.QuestionDao;
import com.company.dao.sqlplus.AnswerDaoImp;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.QuestionDaoImp;
import com.company.domain.Exam;
import com.company.domain.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static java.awt.Toolkit.getDefaultToolkit;

public class TakeAnExamM extends JFrame {

    int num;
    int total;
    BigDecimal score;
    String Question;
    String Com;
    String studentAnswer;



    public TakeAnExamM(Exam e, int i){
        super("Take an exam");

        //
        //
        ExamDao examDao=new ExamDaoImp();
        Question[] allQuestions=examDao.allQuestions(e);

        num=allQuestions[i].getQuesNo();
        total=allQuestions.length;
        score=allQuestions[i].getScore();
        Question=allQuestions[i].getContent();
        Com=allQuestions[i].getCom();





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

//        //a label to show the question#
        JLabel que = new JLabel("Question " + num + " / "+ total);
        que.setBounds(1,1,300,50);
        que.setFont(font);
        panel.add(que);

//        a label to show the total score of the question
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
        JLabel A2 = new JLabel(getA(ques.getText()));
        JLabel B2 = new JLabel(getB(ques.getText()));
        JLabel C2 = new JLabel(getC(ques.getText()));
        JLabel D2 = new JLabel(getD(ques.getText()));
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

        //set a button
        JButton next = new JButton("Save and next");
        next.setBounds(480,480,150,50);
        next.setFont(font);
        panel.add(next);

        //a label "compulsory" or not
        JLabel compulsory = new JLabel(Com);
        compulsory.setBounds(480,300,300,40);
        compulsory.setFont(font2);
        panel.add(compulsory);
        String content2 = ques.getText();



        this.setVisible(true);


        A1.addActionListener(e1 -> {
            studentAnswer=A1.getText();
        });

        B1.addActionListener(e1 -> {
            studentAnswer=B1.getText();
        });

        C1.addActionListener(e1 -> {
            studentAnswer=C1.getText();
        });

        D1.addActionListener(e1 -> {
            studentAnswer=D1.getText();
        });




        BigDecimal stuScore;

        if(studentAnswer.equals(allQuestions[i].getAnswer())){
            stuScore=allQuestions[i].getScore();

        }
        else {
            stuScore=new BigDecimal(0);
        }





        next.addActionListener(x -> {
            setVisible(false);
            MainApplication.start++;
            if(MainApplication.start<allQuestions.length) {
                if (allQuestions[i].getType().equals("MC")) {
                    AnswerDao answerDao=new AnswerDaoImp();
                    answerDao.create(num,e.getTestNo(),MainApplication.user.getId(),studentAnswer,stuScore);
                    new TakeAnExamM(e, MainApplication.start);
                } else {
                    AnswerDao answerDao=new AnswerDaoImp();
                    answerDao.create(num,e.getTestNo(),MainApplication.user.getId(),studentAnswer,stuScore);
                    new TakeAnExamB(e, MainApplication.start);
                }

            }
        });


    }


    public String getA(String content){
        String[] sep = content.split("/");
        String A3 = sep[1];
        return A3;
    }
    public String getB(String content){
        String[] sep = content.split("/");
        String B3 = sep[2];
        return B3;
    }
    public String getC(String content){
        String[] sep = content.split("/");
        String C3 = sep[3];
        return C3;
    }
    public String getD(String content){
        String[] sep = content.split("/");
        String D3 = sep[4];
        return D3;
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
