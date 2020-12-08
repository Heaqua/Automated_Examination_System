package com.company.ui;

import com.company.dao.ExamDao;
import com.company.dao.StudentDao;
import com.company.dao.SubjectDao;
import com.company.dao.TakeDao;
import com.company.dao.sqlplus.ExamDaoImp;
import com.company.dao.sqlplus.StudentDaoImp;
import com.company.dao.sqlplus.SubjectDaoImp;
import com.company.dao.sqlplus.TakeDaoImp;
import com.company.domain.Exam;
import com.company.domain.Student;
import com.company.domain.Subject;
import com.company.domain.Take;

import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class ViewExaminationResults2 extends JFrame {





    public ViewExaminationResults2(String class0,String subject) {

        super("View Examination Results");

        StudentDao studentDao=new StudentDaoImp();
        Student[] allStudents=studentDao.findByCId(class0);
        TakeDao takeDao=new TakeDaoImp();
        SubjectDao subjectDao=new SubjectDaoImp();
        ExamDao examDao=new ExamDaoImp();

        String[] oneString;


        int len=allStudents.length;
        Object[][] rowData0=new Object[len][2];

        for(int i=0;i<len;i++){
            oneString=new String[2];
            oneString[0]=allStudents[i].getName();
            Take take=takeDao.findByKey(examDao.findBySubIdCId(subject,class0).getTestNo(),allStudents[i].getId());
            oneString[1]=take.getTest_result().toString();
            rowData0[i]=oneString;
        }

        Object[][] row0=new Object[3][2];
        row0[0][0]="Average";
        row0[0][1]=examDao.generateAverageResult(examDao.findBySubIdCId(subject,class0).getTestNo(),class0);

        row0[1][0]="Median";
        row0[1][1]=examDao.generateMediumResult(examDao.findBySubIdCId(subject,class0).getTestNo(),class0);

        row0[2][0]="Mode";
        row0[2][1]=examDao.generateModeResult(examDao.findBySubIdCId(subject,class0).getTestNo(),class0);




        JPanel panel = new JPanel();
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        panel.setLayout(null);

        //logo
        setIconImage(getDefaultToolkit().getImage("src/com/company/ui/Images/logo1.png"));

        //set fonts
        Font font = new Font("Times New Roman", Font.PLAIN, 25);
        Font font1 = new Font("Times New Roman", Font.ITALIC, 30);
        Font font2 = new Font("Times New Roman", Font.PLAIN, 22);

        //set a title
        JLabel title = new JLabel("View Examination Results");
        title.setBounds(190, 10, 400, 50);
        title.setFont(font1);
        panel.add(title);

        //set two labels for class and subject
        JLabel classes = new JLabel(class0);
        if(class0 == null){
            classes = new JLabel("C01");
        }
        classes.setBounds(30,60,200,50);
        classes.setFont(font);
        panel.add(classes);

        JLabel sub = new JLabel(subject);
        if(subject == null){
            sub = new JLabel("ABCT1234");
        }
        sub.setBounds(200,60,200,50);
        sub.setFont(font);
        panel.add(sub);

        //set two tables
        Object[] columnNames = {"Student", "Result"};
        Object[] column = {"Name","Statistics"};

        /*
        Object[][] rowData = {
                {"Lucy", "A"},
                {"Lisa", "B"},
                {"Ada", "B+"},
                {"Bob", "A-"},
                {"Tommy", "A-"},
                {"Mandy", "A-"},
        };
        Object[][] row = {
                {"Average", "A"},
                {"Median", "B"},
                {"Mode", "B+"},
        };

         */
        Object[][] rowData=rowData0;
        Object[][] row=row0;


        JTable dataTable = new JTable(rowData, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataTable.setFont(font2);
        dataTable.setRowHeight(60);
        dataTable.getTableHeader().setFont(font);
        dataTable.getTableHeader().setReorderingAllowed(false);
        dataTable.setRowSelectionAllowed(false);
        JScrollPane roll= new JScrollPane(dataTable);
        roll.setBounds(40,100,600,200);
        roll.setFont(font2);
        panel.add(roll);

        JTable dataTable2 = new JTable(row,column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataTable2.setFont(font2);
        dataTable2.setRowHeight(60);
        dataTable2.getTableHeader().setFont(font);
        dataTable2.getTableHeader().setReorderingAllowed(false);
        dataTable2.setRowSelectionAllowed(false);
        JScrollPane roll2= new JScrollPane(dataTable2);
        roll2.setBounds(40,330,600,140);
        roll2.setFont(font2);
        panel.add(roll2);

        //set a button for back
        JButton back = new JButton("Back");
        back.setBounds(40,480,150,50);
        back.setFont(font);
        panel.add(back);


        //click "back"
        back.addActionListener(e -> {
            setVisible(false);;
            new TeacherMainPage();
        });

        this.setVisible(true);
    }
}