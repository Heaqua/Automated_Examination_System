package com.company.view.GUI;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class SetAnExam extends JFrame {
    public static void main(String[] args) {
        new SetAnExam();
    }
    public SetAnExam(){
        super("Set an Exam");
        JPanel panel = new JPanel();
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(null);
        setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,30);
        Font font1 = new Font("Times New Roman",Font.ITALIC,40);

        //set a label for information
        JLabel info = new JLabel("Examination Information");
        info.setBounds(140,10,500,50);
        info.setFont(font1);
        panel.add(info);

        //set labels for setting
        JLabel subject = new JLabel("Subject : ");
        subject.setBounds(100,100,200,50);
        subject.setFont(font);
        panel.add(subject);


        this.setVisible(true);
    }

}

