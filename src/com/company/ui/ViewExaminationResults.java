package com.company.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class ViewExaminationResults extends JFrame {

    public ViewExaminationResults(){
        super("View Examination Results");
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
        Font font1 = new Font("Times New Roman",Font.ITALIC,40);
        Font font2 = new Font("Times New Roman",Font.PLAIN,28);

        //set a title
        JLabel title = new JLabel("View Examination Results");
        title.setBounds(190,50,400,50);
        title.setFont(font);
        panel.add(title);

        //set label for setting subjects
        JLabel subject = new JLabel("Select Class : ");
        subject.setBounds(50,160,200,50);
        subject.setFont(font);
        panel.add(subject);

        //set a ComboBox
        String[] classes= new String[]{"C01", "C02", "C03"};
        final String[] class2 = new String[1];
        final JComboBox<String> comboBox = new JComboBox<String>(classes);{
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        class2[0] = classes[comboBox.getSelectedIndex()];
                    }
                }
            });
        }
        comboBox.setBounds(300,160,200,50);
        comboBox.setFont(font2);
        panel.add(comboBox);

        //set label for setting subjects
        JLabel subject2 = new JLabel("Select Subject : ");
        subject2.setBounds(50,300,200,50);
        subject2.setFont(font);
        panel.add(subject2);

        //set a ComboBox
        String[] subjects = new String[]{"ABCT1234", "AF2111", "APSS1011", "CBS2012","COMP2011","COMP2021","COMP2411","ELC2012","HTM1203"};
        final String[] sub2 = new String[1];
        final JComboBox<String> comboBox2 = new JComboBox<String>(subjects);{
            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        sub2[0] = subjects[comboBox2.getSelectedIndex()];
                    }
                }
            });
        }
        comboBox2.setBounds(300,300,200,50);
        comboBox2.setFont(font2);
        panel.add(comboBox2);

        //set a button for "sure"
        JButton sure = new JButton("Sure");
        sure.setBounds(450,460,100,50);
        sure.setFont(font);
        panel.add(sure);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,460,150,50);
        back.setFont(font);
        panel.add(back);


        //click "back"
        back.addActionListener(e -> {
            setVisible(false);;
            new TeacherMainPage();
        });

        //click "Sure"
        sure.addActionListener(e -> {
            setVisible(false);
            new ViewExaminationResults2(class2[0],sub2[0]);
        });


        this.setVisible(true);

    }
}
