package com.company.ui;

import com.company.dao.StudentDao;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.domain.Student;
import com.company.domain.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class ReportsAndResults extends JFrame {

    public static void main(String[] args) {
        new ReportsAndResults();
    }

    StudentDao studentDao=new StudentDaoImp();
    Subject[] allSubjects=studentDao.allSubjects((Student) MainApplication.user);

    public ReportsAndResults() {
        super("Reports and Results");
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
        Font font1 = new Font("Times New Roman", Font.ITALIC, 40);
        Font font2 = new Font("Times New Roman", Font.PLAIN, 28);

        //set a title
        JLabel title = new JLabel("Results and Reports");
        title.setBounds(220,50,400,50);
        title.setFont(font);
        panel.add(title);

        //set label for setting subjects
        JLabel subject = new JLabel("Select Subject : ");
        subject.setBounds(50,200,200,50);
        subject.setFont(font);
        panel.add(subject);

        //set a ComboBox
        String[] subjects = new String[]{"ABCT1234", "AF2111", "APSS1011", "CBS2012","COMP2011","COMP2021","COMP2411","ELC2012","HTM1203"};
        final String[] sub = new String[1];
        final JComboBox<String> comboBox = new JComboBox<String>(subjects);{
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        sub[0] = subjects[comboBox.getSelectedIndex()];
                    }
                }
            });
        }
        comboBox.setBounds(300,200,200,50);
        comboBox.setFont(font2);
        panel.add(comboBox);

        //set a button for "sure"
        JButton sure = new JButton("Sure");
        sure.setBounds(450,400,100,50);
        sure.setFont(font);
        panel.add(sure);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,400,150,50);
        back.setFont(font);
        panel.add(back);


        //click "back"
        back.addActionListener(e -> {
            setVisible(false);;
            new StudentMainPage();
        });

        //click "Sure"
        sure.addActionListener(e -> {
            setVisible(false);
            new ReportsAndResults2(sub[0],"A","You are so greatlalaedddadaaacacacaecaaelalalallalala");
        });

        this.setVisible(true);


    }
}
