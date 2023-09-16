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
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton deleteButton = new JButton("Delete");
    private JButton showAvailableArticlesButton = new JButton("Available articles");
    private JButton showNotAvailableArticlesButton = new JButton("Not available Articles");
    private JButton borrowBookButton = new JButton("Borrow Book");
    private JButton returnBookButton = new JButton("Return book");

    LaunchPage() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);

        navigationBar.setLayout(new FlowLayout());

        navigationBar.setBounds(0,0,140,500);

        navigationBar.setBorder(new EmptyBorder(10,0,10,0));

        frame.add(navigationBar);

        //AddBookButton

        addBookButton.setFocusable(false);
        addBookButton.addActionListener(e -> createBook());
        navigationBar.add(addBookButton);

        //AddEBookButton

        addEBookButton.setFocusable(false);
        addEBookButton.addActionListener(e -> createEBook());
        navigationBar.add(addEBookButton);

        //AddAudioBookButton

        addAudioBookButton.setFocusable(false);
        addAudioBookButton.addActionListener(e -> createAudioBook());
        navigationBar.add(addAudioBookButton);

        //AddDeleteButton

        deleteButton.setFocusable(false);
        deleteButton.addActionListener(e -> createDelete());
        navigationBar.add(deleteButton);

        //AddShowAvailableArticlesButton

        showAvailableArticlesButton.setFocusable(false);
        showAvailableArticlesButton.addActionListener(e -> createShowAvailableArticles());
        navigationBar.add(showAvailableArticlesButton);

        //AddShowNotAvailableArticlesButton

        showNotAvailableArticlesButton.setFocusable(false);
        showNotAvailableArticlesButton.addActionListener(e -> createShowNotAvailableArticles());
        navigationBar.add(showNotAvailableArticlesButton);

        //AddBorrowBookButton

        borrowBookButton.setFocusable(false);
        borrowBookButton.addActionListener(e -> createBorrowBook());
        navigationBar.add(borrowBookButton);

        //AddReturnBookButton

        returnBookButton.setFocusable(false);
        returnBookButton.addActionListener(e -> createReturnBook());
        navigationBar.add(returnBookButton);



    }

    private static void createBook() {
        var addBookPage = new AddBookPage();
    }

    private static void createEBook() {
        var addEBookPage = new AddEBookPage();
    }

    private static void createAudioBook() {
        var addAudioBookPage = new AddAudioBookPage();
    }

    private static void createDelete() {
        var addDelete = new Delete();
    }

    private static void createShowAvailableArticles() {
        var createShowAvailableArticles = new ShowAvailableArticles();
    }

    private static void createShowNotAvailableArticles() {
        var createShowNotAvailableArticles = new ShowNotAvailableArticles();
    }

    private static void createBorrowBook() {
        var createBorrowBook = new BorrowBook();
    }

    private static void createReturnBook() {
        var createReturnBook = new ReturnBook();
    }

}