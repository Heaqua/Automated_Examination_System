package com.company.ui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;


public class LoginPage extends JFrame {

    public LoginPage(){

        super("Login page");
        JPanel panel = new JPanel();
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);
        Font font1 = new Font("Times New Roman",Font.ITALIC,40);
        Font font = new Font("Times New Roman",Font.ITALIC,30);
        JLabel name = new JLabel("Automated Examination System");
        JLabel userID = new JLabel("User ID : ");
        JLabel password = new JLabel("Password : ");
        JTextField user_text = new JTextField();
        JPasswordField pw = new JPasswordField();
        name.setBounds(75,50,600,50);
        name.setFont(font1);
        userID.setBounds(50,150,200,30);
        userID.setFont(font);
        password.setBounds(50,250,300,30);
        password.setFont(font);
        user_text.setBounds(250,150,200,50);
        user_text.setFont(font);
        pw.setBounds(250,250,250,50);
        pw.setFont(font);
        panel.add(name);
        panel.add(userID);
        panel.add(password);
        panel.add(user_text);
        panel.add(pw);

        Font font2=new Font("Times New Roman",Font.BOLD,30);
        JButton loginButton=new JButton("Login");
        loginButton.setBounds(250,350,150,50);
        loginButton.setFont(font2);
        panel.add(loginButton);

        //set the background picture
        ImageIcon image=new ImageIcon("src\\com\\company\\ui\\Images\\background1.jpg");
        JLabel lbBg = new JLabel(image);
        lbBg.setBounds(0, 0, 700, 600);
        panel.add(lbBg);

        setVisible(true);
        setIconImage(getDefaultToolkit().getImage("src\\com\\company\\ui\\Images\\logo1.png"));


        //Event
        loginButton.addActionListener(e -> {


            //TODO
            //judge the user ID and password
            //If the user input a student account, then turn to student main page



            //If the user input a teacher account, then turn to teacher main page
            setVisible(false);
            new TeacherMainPage();

            //else
            //a remainder showing "Error: Login failed (name/password refused)"
            //JOptionPane.showInternalMessageDialog(null, "Error: Login failed (name/password refused)",
                    //"Login failed", JOptionPane.INFORMATION_MESSAGE);

                setVisible(false);
                new TeacherMainPage();




        });

    }

}
