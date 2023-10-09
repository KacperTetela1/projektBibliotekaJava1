package gui.launch;

import gui.other.Delete;
import gui.other.ReturnBook;
import gui.other.ShowAvailableArticles;
import gui.other.ShowNotAvailableArticles;
import gui.write.AddAudioBookWritePage;
import gui.write.AddBookWritePage;
import gui.write.AddEBookWritePage;
import gui.other.BorrowBook;
import model.service.LibraryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LaunchPage extends CustomePage {
    private JPanel navigationBar = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton deleteButton = new JButton("Delete");
    private JButton showAvailableArticlesButton = new JButton("Available articles");
    private JButton showNotAvailableArticlesButton = new JButton("Not available Articles");
    private JButton borrowBookButton = new JButton("Borrow Book");
    private JButton returnBookButton = new JButton("Return book");
    private JPanel list = new JPanel();
    private JTable table;

    public LaunchPage(LibraryService libraryService) {
        super("Library Manager", libraryService);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                libraryService.serialization();
                System.exit(EXIT_ON_CLOSE);
            }
        });

        configureFrame();
        configureComponents();
        createTable();
    }

    private void configureFrame() {
        setSize(900, 500);
        navigationBar.setLayout(new GridLayout(8, 1));
        navigationBar.setBounds(0, 0, 100, 465);
        //navigationBar.setBorder(new EmptyBorder(10,0,10,0));
        add(navigationBar);

        add(list);
        list.setLayout(new GridLayout(1, 1));
        list.setBounds(100, 0, 750, 465);

    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryService));
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryService));
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryService));
        createButton(deleteButton, e -> new Delete());
        createButton(showAvailableArticlesButton, e -> new ShowAvailableArticles());
        createButton(showNotAvailableArticlesButton, e -> new ShowNotAvailableArticles());
        createButton(borrowBookButton, e -> new BorrowBook(libraryService));
        createButton(returnBookButton, e -> new ReturnBook());
    }

    private void createButton(JButton button, ActionListener actionListener) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        navigationBar.add(button);
    }

    private void createTable() {
        LibraryTableModel libraryTableModel = new LibraryTableModel(libraryService);
        table = new JTable(libraryTableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        list.add(scrollPane);

        //scrollPane.setVisible(false);

    }


}