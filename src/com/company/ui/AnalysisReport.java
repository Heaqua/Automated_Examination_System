package com.company.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class AnalysisReport extends JFrame {
    public static void main(String[] args) {
        new AnalysisReport();
    }
    public AnalysisReport(){
        super("Analysis Report");
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
        Font font2 = new Font("Times New Roman",Font.PLAIN,12);

        //set a title
        JLabel title = new JLabel("Analysis Report");
        title.setBounds(200,20,400,50);
        title.setFont(font1);
        panel.add(title);

        //set a table
                Object[] columnNames = {"Subject code", "Subject name","Grade","Position in class",
                "Average","Highest","Comments"};
        Object[][] rowData = {
                {"COMP2011", "Data Structure","A","98","70","99","Excellent!"},
                {"COMP2411", "Database Systems","B+","90","73","96","Great!"},
                {"COMP2021", "Java","B+","91","69","91","You are great!"},
        };

        JTable dataTable = new JTable(rowData, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataTable.setFont(font2);
        dataTable.setRowHeight(150);
        dataTable.getTableHeader().setFont(font2);
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.setRowSelectionAllowed(false);
        JScrollPane roll= new JScrollPane(dataTable);
        roll.setBounds(6,160,670,200);
        roll.setFont(font2);
        panel.add(roll);
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        dataTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        dataTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        dataTable.getColumnModel().getColumn(5).setPreferredWidth(30);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,460,150,50);
        back.setFont(font);
        panel.add(back);


        //click "back"
        back.addActionListener(e -> {
            setVisible(false);;
            new StudentMainPage();
        });

        this.setVisible(true);

    }
}
