package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LaunchPage {
    private JFrame frame = new JFrame("Library Manager");
    private ImageIcon icon = new ImageIcon("book.png");
    private JPanel navigationBar = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");

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

        //AddBookButton

        addBookButton.setFocusable(false);
        addBookButton.addActionListener(e -> createBook());
        navigationBar.add(addBookButton);

        //AddEBookButton

        addEBookButton.setFocusable(false);
        addEBookButton.addActionListener(e -> createEBook());
        navigationBar.add(addEBookButton);



    }

    public static void createBook() {
        var addBookPage = new AddBookPage();
    }

    public static void createEBook() {
        var addBookPage = new AddEBookPage();
    }

}