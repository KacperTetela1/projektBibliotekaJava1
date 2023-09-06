package gui;

import javax.swing.*;
import java.awt.*;

public class AddingBookPage {
    JFrame frame = new JFrame("Book Details");
    ImageIcon icon = new ImageIcon("book.png");

    AddingBookPage() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setBounds(0, 0, 500, 80);
        frame.add(panel1);

        JLabel label1 = new JLabel("Please enter title");
        label1.setVisible(true);
        panel1.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(250, 30));
        panel1.add(textField1);

        //- second panel

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setBounds(0, 80, 500, 80);
        frame.add(panel2);

        JLabel label2 = new JLabel("Please enter author");
        label2.setVisible(true);
        panel2.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250, 30));
        panel2.add(textField2);

        //- third panel

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.setBounds(0, 160, 500, 80);
        frame.add(panel3);

        JLabel label3 = new JLabel("Please enter publicationYear");
        label3.setVisible(true);
        panel3.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(250, 30));
        panel3.add(textField3);

        //- fourth panel

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.setBounds(0, 240, 500, 80);
        frame.add(panel4);

        JLabel label4 = new JLabel("Please enter number of pages");
        label4.setVisible(true);
        panel4.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setPreferredSize(new Dimension(250, 30));
        panel4.add(textField4);

        //- fifth panel

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        panel5.setBounds(0,320,500,80);
        frame.add(panel5);

        JLabel label5 = new JLabel("Select language of book");
        label5.setVisible(true);
        panel5.add(label5);

        //- sixth panel

/*        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout());
        panel6.setBounds(0,400,500,80);
        frame.add(panel6);

        JButton button1 = new JButton("Polish");
        JButton button2 = new JButton("English");
        JButton button3 = new JButton("German");

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        panel6.add(button1);
        panel6.add(button2);
        panel6.add(button3);*/


    }

}
