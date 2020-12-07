package com.company.ui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class ExamSchedule extends JFrame {
    public static void main(String[] args) {
        new ExamSchedule();
    }
    public ExamSchedule(){
        super("Exam Schedule");
        JPanel panel = new JPanel();
        setSize(700,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/ui/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,30);
        Font font1 = new Font("Times New Roman",Font.ITALIC,40);
        Font font2 = new Font("Times New Roman",Font.PLAIN,28);

        //set a title label
        JLabel title = new JLabel("Exam Schedule");
        title.setBounds(210,20,300,40);
        title.setFont(font1);
        panel.add(title);

        //set a table
        Object[] columnNames = {"Subject", "Date", "Start time", "Duration"};
        Object[][] rowData = {
                {"COMP2011", "Sep 16th", "13:00", "120min"},
                {"COMP2021", "Sep 17th", "14:00", "60min"},
                {"COMP2411", "Sep 18th", "15:00", "70min"},
                {"AF2111", "Sep 19th", "16:00", "100min"},
        };
        JTable dataTable = new JTable(rowData, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataTable.setFont(font2);
        dataTable.setRowHeight(85);
        dataTable.getTableHeader().setFont(font);
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.setRowSelectionAllowed(false);
        JScrollPane roll= new JScrollPane(dataTable);
        roll.setBounds(40,120,600,300);
        roll.setFont(font2);
        panel.add(roll);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,480,150,40);
        back.setFont(font);
        panel.add(back);

        this.setVisible(true);

        //click "back"
        back.addActionListener(e -> {
            setVisible(false);
            new StudentMainPage();
        });

    }
}
