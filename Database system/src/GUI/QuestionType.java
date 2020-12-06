package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;

public class QuestionType {
    public static void main(String[] args) {
        place();
    }
    private static void place(){
        JFrame QType = new JFrame("Question Type");
        JPanel panel = new JPanel();

        //set frame size
        int num = 1;
        QType.setBounds(500,300,700,600);
        QType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QType.add(panel);
        panel.setLayout(null);

        //set fonts
        Font font = new Font("Times New Roman",Font.PLAIN,40);
        Font font1 = new Font("Times New Roman",Font.PLAIN,30);

        //set a label to show the Q#
        JLabel count = new JLabel("Question " + num);
        count.setBounds(1,1,200,50);
        count.setFont(font);
        panel.add(count);

        //set a notice label
        JLabel notice = new JLabel("Please choose the type of the question : ");
        notice.setBounds(80,80,600,50);
        notice.setFont(font1);
        panel.add(notice);

        //set three buttons
        JButton Mul = new JButton("Multiple choice");
        JButton Fill = new JButton("Fill in the blank");
        JButton standard = new JButton("Standard full-length test questions");
        Mul.setBounds(120,170,450,50);
        Mul.setFont(font1);
        Fill.setBounds(120,260,450,50);
        Fill.setFont(font1);
        standard.setBounds(120,350,450,50);
        standard.setFont(font1);
        panel.add(Mul);
        panel.add(Fill);
        panel.add(standard);


        QType.setVisible(true);
        QType.setIconImage(getDefaultToolkit().getImage("src\\Images\\logo1.png"));



        //Event
        Mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QType.setVisible(false);
                MultipleChoice.main();
            }
        });

        Fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        standard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
