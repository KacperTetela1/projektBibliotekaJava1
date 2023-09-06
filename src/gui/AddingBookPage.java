package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddingBookPage {
    JFrame frame = new JFrame("Book Details");
    ImageIcon icon = new ImageIcon("book.png");
    JPanel leftPanelContainer = new JPanel();
    JPanel rightPanelContainer = new JPanel();
    JPanel midlePanel = new JPanel();
    JPanel downPanel = new JPanel();

    AddingBookPage() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        leftPanelContainer.setLayout(new GridLayout(4, 1));
        rightPanelContainer.setLayout(new GridLayout(4, 1, 0, 22));
        midlePanel.setLayout(new FlowLayout());
        downPanel.setLayout(new FlowLayout());

        leftPanelContainer.setBounds(0, 0, 200, 200);
        rightPanelContainer.setBounds(200, 0, 200, 200);
        midlePanel.setBounds(0, 200, 400, 40);
        downPanel.setBounds(0, 250, 400, 50);

        leftPanelContainer.setBorder(new EmptyBorder(0, 50, 0, 10));
        rightPanelContainer.setBorder(new EmptyBorder(10, 0, 10, 50));
        midlePanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        frame.add(leftPanelContainer);
        frame.add(rightPanelContainer);
        frame.add(midlePanel);
        frame.add(downPanel);

        //LeftPanel

        JLabel label1 = new JLabel("Title");
        leftPanelContainer.add(label1);

        JLabel label2 = new JLabel("Author");
        leftPanelContainer.add(label2);

        JLabel label3 = new JLabel("Publication Year");
        leftPanelContainer.add(label3);

        JLabel label4 = new JLabel("Pages Amount");
        leftPanelContainer.add(label4);

        //RightPanel

        JTextField textField1 = new JTextField();
        rightPanelContainer.add(textField1);

        JTextField textField2 = new JTextField();
        rightPanelContainer.add(textField2);

        JTextField textField3 = new JTextField();
        rightPanelContainer.add(textField3);

        JTextField textField4 = new JTextField();
        rightPanelContainer.add(textField4);

        //MidlePanel

        JLabel languageLabel = new JLabel("Select book language");
        languageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        midlePanel.add(languageLabel);

        //DownPanel

        JButton button1 = new JButton("Polish");
        JButton button2 = new JButton("English");
        JButton button3 = new JButton("German");

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        downPanel.add(button1);
        downPanel.add(button2);
        downPanel.add(button3);

        //BottomPanel

        //southLabel.setText("Select type of cover");


    }

}
