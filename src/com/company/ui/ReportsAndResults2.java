package com.company.ui;

import com.company.dao.StudentDao;
import com.company.dao.SubjectDao;
import com.company.dao.TakeDao;
import com.company.dao.sqlplus.Current;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.dao.sqlplus.SubjectDaoImp;
import com.company.dao.sqlplus.TakeDaoImp;
import com.company.domain.Exam;
import com.company.domain.Student;
import com.company.domain.Subject;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class ReportsAndResults2 extends JFrame {
    public static void main(String[] args) {
        new ReportsAndResults2();
    }

    StudentDao studentDao=new StudentDaoImp();
    Subject[] allSubjects=studentDao.allSubjects((Student) MainApplication.user);
    Exam[] allExams=studentDao.allExams((Student) MainApplication.user);

    String subjectId;
    String result;
    String report;


    public ReportsAndResults2() {
        //
        super("Reports and Results");
        for(int i=0;i<allExams.length;i++){
            TakeDao takeDao=new TakeDaoImp();
            result= takeDao.findByKey(allExams[i].getTestNo(),MainApplication.user.getId()).getTest_result().toString();

            SubjectDao subjectDao=new SubjectDaoImp();
            //needs to review
            //TODO
//            subjectId=subjectDao.findByStuId(Current.getCurrentYear(),Current.getCurrentSem(),MainApplication.user.getId(),allExams[i].getTestNo()).getSub_id();


            //TODO:report=;
        }





        JPanel panel = new JPanel();
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/ui/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman", Font.PLAIN, 30);
        Font font1 = new Font("Times New Roman", Font.ITALIC, 30);
        Font font2 = new Font("Times New Roman", Font.PLAIN, 28);

        //set a title
        JLabel title = new JLabel(subjectId);
        if(subjectId == null) {
            title = new JLabel("ABCT1234");
        }
        title.setBounds(290,50,400,50);
        title.setFont(font);
        panel.add(title);

        //set labels for result and report
        JLabel result1 = new JLabel("Result: ");
        result1.setBounds(100,130,200,50);
        result1.setFont(font);
        panel.add(result1);
        JLabel report1 = new JLabel("Report: ");
        report1.setBounds(100,230,200,50);
        report1.setFont(font);
        panel.add(report1);
        JLabel result2 = new JLabel(result);
        result2.setBounds(300,130,300,50);
        result2.setFont(font1);
        panel.add(result2);
        JLabel report2 = new JLabel(report);
        report2.setBounds(210,210,400,100);
        report2.setFont(font1);
        panel.add(report2);
        SetText(report2,report);
        JScrollPane jsp=new JScrollPane(report2);
        jsp.setBounds(210,210,400,250);
        panel.add(jsp);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,480,150,40);
        back.setFont(font);
        panel.add(back);

        this.setVisible(true);
        //click "back"
        back.addActionListener(e -> {
            setVisible(false);
            new ReportsAndResults();
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

