package com.company.ui;



import com.company.ui.LoginPage;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class OriginalLoginPage extends JFrame{
    JLabel label;
    public OriginalLoginPage(){
        super("Online Examination System");

        //settings and fonts
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Times New Roman",Font.BOLD,40);
        Font font2 = new Font("Times New Roman",Font.PLAIN,30);

        //create a new label
        label=new JLabel("Login as");
        label.setFont(font1);
        label.setBounds(270,100,300,100);

        //create 2 new buttons
        JButton teacherButton=new JButton("Teacher");
        teacherButton.setBounds(200,200,300,100);
        teacherButton.setFont(font2);
        JButton studentButton=new JButton("Student");
        studentButton.setBounds(200,400,300,100);
        studentButton.setFont(font2);

        //set the frame layout
        setLayout(null);
        Container contentPane=this.getContentPane();
        contentPane.add(label);
        contentPane.add(teacherButton);
        contentPane.add(studentButton);

        //set the background picture
        ImageIcon image=new ImageIcon("src\\com\\company\\view\\Images\\background1.jpg");
        JLabel lbBg = new JLabel(image);
        lbBg.setBounds(0, 0, 700, 600);
        contentPane.add(lbBg);


        setSize(700,600);
        setLocationRelativeTo(null);
        setVisible(true);

        setIconImage(getDefaultToolkit().getImage("src/com/company/view/Images/logo1.png"));

        //Event
        studentButton.addActionListener(e -> {
            setVisible(false);
            new LoginPage();
        });

        teacherButton.addActionListener(e -> {
            setVisible(false);
            new LoginPage();
        });
    }
}




