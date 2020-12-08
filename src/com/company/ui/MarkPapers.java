package com.company.ui;

import com.company.dao.AnswerDao;
import com.company.dao.QuestionDao;
import com.company.dao.TeacherDao;
import com.company.dao.sqlplus.AnswerDaoImp;
import com.company.dao.sqlplus.QuestionDaoImp;
import com.company.dao.sqlplus.TeacherDaoImp;
import com.company.domain.Answer;
import com.company.domain.Exam;
import com.company.domain.Question;
import com.company.domain.Teacher;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static java.awt.Toolkit.getDefaultToolkit;

public class MarkPapers extends JFrame {


    TeacherDao teacherDao=new TeacherDaoImp();
    Exam[] allExams=teacherDao.findAllExams(MainApplication.user.getId());

    AnswerDao answerDao=new AnswerDaoImp();
    Answer[] allAnswers=answerDao.findByTeaId(MainApplication.user.getId());

    int len=allAnswers.length;



    private Question answerToQuestion(Answer answer){
        QuestionDao questionDao=new QuestionDaoImp();
        return questionDao.findByID(answer.getQuesNo(),answer.getTestNo());
    }


    public MarkPapers(int i) {
        super("Mark papers");

        String Question=answerToQuestion(allAnswers[i]).getContent();
        String Answer=answerToQuestion(allAnswers[i]).getAnswer();
        int score=answerToQuestion(allAnswers[i]).getScore();


        JPanel panel = new JPanel();
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman", Font.PLAIN, 30);
        Font font1 = new Font("Times New Roman", Font.PLAIN, 25);
        Font font2 = new Font("Times New Roman", Font.ITALIC, 20);

        //set label for Question#
        JLabel num = new JLabel("Question " + MainApplication.num);
        num.setBounds(1, 1, 200, 30);
        num.setFont(font1);
        panel.add(num);

        //set two labels to display the question and answer
        JLabel ques = new JLabel(Question);
        JLabel ans = new JLabel(Answer);
        ques.setBounds(30, 50, 600, 200);
        ques.setFont(font1);
        SetText(ques,Question);
        panel.add(ques);
        JScrollPane jsp=new JScrollPane(ques);
        jsp.setBounds(30,50,620,200);
        panel.add(jsp);
        ans.setBounds(30,280,400,150);
        ans.setFont(font1);
        SetText(ans,Answer);
        panel.add(ans);
        JScrollPane jsp1=new JScrollPane(ans);
        jsp1.setBounds(30,280,420,150);
        panel.add(jsp1);

        //mark score
        JLabel score1 = new JLabel("Mark: ");
        score1.setBounds(455,255,80,50);
        score1.setFont(font1);
        panel.add(score1);

        //input mark
        JTextField score2 = new JTextField();
        score2.setBounds(525,260,70,40);
        score2.setFont(font);
        panel.add(score2);

        // full mark
        JLabel full = new JLabel("/ "+ score);
        full.setBounds(605,260,70,40);
        full.setFont(font);
        panel.add(full);

        //comment
        JLabel comment = new JLabel("Comment: ");
        comment.setBounds(40,450,100,40);
        comment.setFont(font2);
        panel.add(comment);

        //comment area
        JTextArea com = new JTextArea();
        com.setBounds(140,450,250,70);
        com.setFont(font2);
        com.setLineWrap(true);
        panel.add(com);

        JScrollPane roll=new JScrollPane(com);
        roll.setBounds(140,450,250,70);
        panel.add(roll);

        //set two buttons
        JButton save = new JButton("Save and next");
        save.setBounds(455,440,190,40);
        save.setFont(font1);
        panel.add(save);
        JButton quit = new JButton("Save and quit");
        quit.setBounds(455,490,190,40);
        quit.setFont(font1);
        panel.add(quit);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));
        this.setVisible(true);

        //Event


        //click the button "Save and next"
        save.addActionListener(e -> {
            setVisible(false);

            if(i<len){
                new MarkPapers(i+1);
                MainApplication.start++;
            }

            String scoreFromText=score2.getText();
            BigDecimal scoreBigDecimal=new BigDecimal(scoreFromText);


            AnswerDao answerDao=new AnswerDaoImp();
            answerDao.modify(allAnswers[i],scoreBigDecimal);

        });

        //Click the button "Save and quit"
        quit.addActionListener(e -> {
            setVisible(false);
            new TeacherMainPage();

            String scoreFromText=score2.getText();
            BigDecimal scoreBigDecimal=new BigDecimal(scoreFromText);
            AnswerDao answerDao=new AnswerDaoImp();
            answerDao.modify(allAnswers[i],scoreBigDecimal);

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