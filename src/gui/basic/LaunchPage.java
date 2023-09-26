package gui.basic;

import gui.Delete;
import gui.ReturnBook;
import gui.ShowAvailableArticles;
import gui.ShowNotAvailableArticles;
import gui.write.AddAudioBookPage;
import gui.write.AddBookPage;
import gui.write.AddEBookPage;
import gui.write.BorrowBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchPage {
    private JFrame frame = new JFrame("Library Manager");
    private ImageIcon icon = new ImageIcon("book.png");
    private JPanel navigationBar = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton deleteButton = new JButton("Delete");
    private JButton showAvailableArticlesButton = new JButton("Available articles");
    private JButton showNotAvailableArticlesButton = new JButton("Not available Articles");
    private JButton borrowBookButton = new JButton("Borrow Book");
    private JButton returnBookButton = new JButton("Return book");

    public LaunchPage() {
        configureFrame();
        configureComponents();
    }

    private void configureFrame() {
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.setLocation(700,230);

        navigationBar.setLayout(new GridLayout(8, 1));

        navigationBar.setBounds(0, 0, 100, 465);

        //navigationBar.setBorder(new EmptyBorder(10,0,10,0));

        frame.add(navigationBar);
    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookPage());
        createButton(addEBookButton, e -> new AddEBookPage());
        createButton(addAudioBookButton, e -> new AddAudioBookPage());
        createButton(deleteButton, e -> new Delete());
        createButton(showAvailableArticlesButton, e -> new ShowAvailableArticles());
        createButton(showNotAvailableArticlesButton, e -> new ShowNotAvailableArticles());
        createButton(borrowBookButton, e -> new BorrowBook());
        createButton(returnBookButton, e -> new ReturnBook());
    }

    private void createButton(JButton button, ActionListener actionListener) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        navigationBar.add(button);
    }


}