package com.company.ui;

import javax.swing.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class TakeAnExam extends JFrame {
    public static void main(String[] args) {
        new TakeAnExam();
    }
    public TakeAnExam(){

        setIconImage(getDefaultToolkit().getImage("src/com/company/view/Images/logo1.png"));

    }
}
