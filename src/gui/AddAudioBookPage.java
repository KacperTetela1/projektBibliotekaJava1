package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddAudioBookPage {
    JFrame frame = new JFrame("Audiobook Details");
    ImageIcon icon = new ImageIcon("book.png");
    JPanel leftPanelContainer = new JPanel();
    JPanel rightPanelContainer = new JPanel();
    JPanel midlePanelUp = new JPanel();
    JPanel midlePanelLow = new JPanel();
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();
    JPanel footer = new JPanel();

    AddAudioBookPage() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);

        leftPanelContainer.setLayout(new GridLayout(4, 1));
        rightPanelContainer.setLayout(new GridLayout(4, 1, 0, 22));
        midlePanelUp.setLayout(new FlowLayout());
        midlePanelLow.setLayout(new FlowLayout());
        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());
        footer.setLayout(new FlowLayout());

        leftPanelContainer.setBounds(0, 0, 200, 200);
        rightPanelContainer.setBounds(200, 0, 200, 200);
        midlePanelUp.setBounds(0, 200, 400, 40);
        midlePanelLow.setBounds(0, 250, 400, 50);
        downPanelUp.setBounds(0,300,400,50);
        downPanelLow.setBounds(0,350,400,50);
        footer.setBounds(0,400,400,50);

        leftPanelContainer.setBorder(new EmptyBorder(0, 50, 0, 10));
        rightPanelContainer.setBorder(new EmptyBorder(10, 0, 10, 50));
        midlePanelUp.setBorder(new EmptyBorder(10, 0, 0, 0));
        midlePanelLow.setBorder(new EmptyBorder(0,0,0,0));
        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));
        footer.setBorder(new EmptyBorder(0,0,0,0));

        frame.add(leftPanelContainer);
        frame.add(rightPanelContainer);
        frame.add(midlePanelUp);
        frame.add(midlePanelLow);
        frame.add(downPanelUp);
        frame.add(downPanelLow);
        frame.add(footer);

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

        //MidlePanelUp

        JLabel languageLabel = new JLabel("Select book language");
        languageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        midlePanelUp.add(languageLabel);

        //MidlePanelLow

        JButton button1 = new JButton("Polish");
        JButton button2 = new JButton("English");
        JButton button3 = new JButton("German");

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        midlePanelLow.add(button1);
        midlePanelLow.add(button2);
        midlePanelLow.add(button3);

        //DownPanelUp

        JLabel coverLabel = new JLabel("Select type of cover");
        coverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downPanelUp.add(coverLabel);

        //DownPanelLow

        JButton button4 = new JButton("Hardcover");
        JButton button5 = new JButton("Softcover");

        button4.setFocusable(false);
        button5.setFocusable(false);

        downPanelLow.add(button4);
        downPanelLow.add(button5);

        //Footer

        JButton button6 = new JButton("Cancel");
        JButton button7 = new JButton("Create");

        button6.setFocusable(false);
        button7.setFocusable(false);

        footer.add(button6);
        footer.add(button7);


    }

}
