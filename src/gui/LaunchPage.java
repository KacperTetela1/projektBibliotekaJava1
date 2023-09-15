package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LaunchPage {
    private JFrame frame = new JFrame("Library Manager");
    private ImageIcon icon = new ImageIcon("book.png");
    private JPanel navigationBar = new JPanel();
    private JButton myButton = new JButton("Add book");

    LaunchPage() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);

        navigationBar.setLayout(new FlowLayout());

        navigationBar.setBounds(0,0,100,500);

        navigationBar.setBorder(new EmptyBorder(10,10,10,10));

        frame.add(navigationBar);

        myButton.setFocusable(false);
        myButton.addActionListener(e -> method1());
        navigationBar.add(myButton);

    }

    public static void method1() {

        AddingBookPage addingBookPage = new AddingBookPage();

    }

}