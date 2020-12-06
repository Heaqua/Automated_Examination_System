package com.company.view.GUI;

import javax.swing.*;

import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class MarkPapers extends JFrame {
    public static void main(String[] args) {
        new MarkPapers();
    }
    public MarkPapers(){
        super("Mark papers");
        JPanel panel = new JPanel();
        this.setSize(700,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(null);
        setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,30);
        Font font1 = new Font("Times New Roman",Font.PLAIN,25);
        Font font2 = new Font("Times New Roman",Font.ITALIC,20);

        //set label for Question#
        int number = 1;
        JLabel num = new JLabel("Question " + number);
        num.setBounds(1,1,200,40);
        num.setFont(font1);
        panel.add(num);

        //set a   for display the question


        //set a  for display the answer

        //set a

        this.setVisible(true);
    }

}