package com.company.ui;

import com.company.dao.StudentDao;
import com.company.dao.TeacherDao;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.dao.sqlplus.TeacherDaoImp;
import com.company.domain.Student;
import com.company.domain.Teacher;

import javax.swing.*;
import java.awt.*;

import static com.company.ui.MainApplication.app;
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
            if(app.ifAStudent[0]==0) {
                TeacherDao teacherDao = new TeacherDaoImp();
                Teacher teacher = teacherDao.findById(user_text.getText());

                String passwordText = new String(pw.getPassword());

                if (teacher.getPassword().equals(passwordText) && teacher != null) {
                    setVisible(false);
                    MainApplication.user = teacher;
                    MainApplication.mainPage=new TeacherMainPage();
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Error: Login failed (name/password refused)", "Login failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                StudentDao studentDao=new StudentDaoImp();
                Student student=studentDao.findById(user_text.getText());

                String passwordText=new String(pw.getPassword());

                if(student.getPassword().equals(passwordText)&&student!=null){
                    setVisible(false);
                    MainApplication.user=student;
                    MainApplication.mainPage=new StudentMainPage();

                }else {
                    JOptionPane.showInternalMessageDialog(null, "Error: Login failed (name/password refused)", "Login failed", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });

    }

}
