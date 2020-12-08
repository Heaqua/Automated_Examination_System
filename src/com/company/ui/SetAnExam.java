package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.SetDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.SetDaoImp;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static java.awt.Toolkit.getDefaultToolkit;

public class SetAnExam extends JFrame {
    static String testNumber;
    public SetAnExam(){
        super("Set an Exam");
        JPanel panel = new JPanel();
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(null);
        setIconImage(getDefaultToolkit().getImage("src/com/company/ui/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,30);
        Font font1 = new Font("Times New Roman",Font.ITALIC,40);
        Font font2 = new Font("Times New Roman",Font.PLAIN,25);
        Font font3 = new Font("Times New Roman",Font.BOLD,30);
        Font font4 = new Font("Times New Roman",Font.ITALIC,20);

        //set a label for information
        JLabel info = new JLabel("Examination Information");
        info.setBounds(140,10,500,50);
        info.setFont(font1);
        panel.add(info);

        //set label for setting subjects
        JLabel subject = new JLabel("Select Subject : ");
        subject.setBounds(50,100,200,50);
        subject.setFont(font);
        panel.add(subject);

        //set a ComboBox
        String[] subjects = new String[]{"ABCT1234", "AF2111", "APSS1011", "CBS2012","COMP2011","COMP2021","COMP2411","ELC2012","HTM1203"};
        final JComboBox<String> comboBox = new JComboBox<String>(subjects);
        comboBox.setBounds(300,100,200,50);
        comboBox.setFont(font2);
        panel.add(comboBox);

        //set label for setting classes
        JLabel class0 = new JLabel("Select Class : ");
        class0.setBounds(50,180,200,50);
        class0.setFont(font);
        panel.add(class0);

        //set the class ComboBox
        String[] classes = new String[]{"C01", "C02", "C03"};
        final JComboBox<String> comboBox2 = new JComboBox<String>(classes);
        comboBox2.setBounds(300,180,200,50);
        comboBox2.setFont(font2);
        panel.add(comboBox2);

        //set the test# label
        JLabel test = new JLabel("Set the Test.No : ");
        test.setBounds(50,260,300,50);
        test.setFont(font);
        panel.add(test);

        //set the text field for test#
        JTextField testNo = new JTextField();
        testNo.setBounds(300,260,200,50);
        testNo.setFont(font2);
        panel.add(testNo);

        //set the start time label
        JLabel start = new JLabel("Set the Start time : ");
        start.setBounds(50,340,300,50);
        start.setFont(font);
        panel.add(start);

        //set the hint
        JLabel hint = new JLabel("(Format:yyyy/mm/dd:hh:mi:ss)");
        hint.setBounds(70,380,300,30);
        hint.setFont(font4);
        panel.add(hint);

        //set the text field for setting start time
        JTextField time = new JTextField();
        time.setBounds(300,340,200,50);
        time.setFont(font2);
        panel.add(time);

        //set the duration label
        JLabel duration = new JLabel("Set the Duration : ");
        duration.setBounds(50,420,300,50);
        duration.setFont(font);
        panel.add(duration);

        //set the second hint
        JLabel hint2 = new JLabel("(Format: 120)(min)");
        hint2.setBounds(70,460,300,30);
        hint2.setFont(font4);
        panel.add(hint2);

        //set the text field for setting start time
        JTextField du = new JTextField();
        du.setBounds(300,420,200,50);
        du.setFont(font2);
        panel.add(du);

        //set the start button
        JButton startBu = new JButton("Start");
        startBu.setBounds(530,470,100,50);
        startBu.setFont(font3);
        panel.add(startBu);
        this.setVisible(true);

        //Event
        //click the button "Start"
        startBu.addActionListener(e -> {
            setVisible(false);
            String sub2 = (String) comboBox.getSelectedItem();
            String cla = (String) comboBox2.getSelectedItem();
            testNumber = testNo.getText();
            String start2 = start.getText();

            int dur = Integer.parseInt(du.getText());
            new QuestionType();

            //insert values into EXAM
            ExamDao examDao=new ExamDaoImp();
            examDao.create(testNumber,start2,dur);
            SetDao setDao = new SetDaoImp();
            setDao.create(testNumber,getYear(start2),getMonth(start2),MainApplication.user.getId(),cla);
        });

    }
    public short getYear(String date){
        String[] sep = date.split("/");
        short year = Short.parseShort(sep[0]);
        return year;
    }
    public boolean getMonth(String date){
        String[] sep = date.split("/");
        int month = Integer.parseInt(sep[1]);
        if(month>8 && month <=12){
            return true;
        }
        return false;
    }



    }


