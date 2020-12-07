package com.company.ui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class ViewExaminationResults2 extends JFrame {
    public static void main(String[] args) {
        new ViewExaminationResults();
    }

    public ViewExaminationResults2(String class0,String subject) {
        super("View Examination Results");
        JPanel panel = new JPanel();
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/view/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman", Font.PLAIN, 30);
        Font font1 = new Font("Times New Roman", Font.ITALIC, 40);
        Font font2 = new Font("Times New Roman", Font.PLAIN, 28);

        //set a title
        JLabel title = new JLabel("View Examination Results");
        title.setBounds(190, 30, 400, 50);
        title.setFont(font);
        panel.add(title);

        //set two labels for class and subject
        JLabel classes = new JLabel(class0);
        if(classes == null){
            classes = new JLabel("C01");
        }
        classes.setBounds(30,100,200,50);
        classes.setFont(font);
        panel.add(classes);

        this.setVisible(true);
    }
}