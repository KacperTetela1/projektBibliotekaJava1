package gui.launch;

import gui.write.AddAudioBookWritePage;
import gui.write.AddBookWritePage;
import gui.write.AddEBookWritePage;
import model.service.LibraryModelService;

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
    private JButton showAvailableArticlesButton = new JButton("Available articles");
    private JButton showNotAvailableArticlesButton = new JButton("Not available Articles");
    private JButton borrowBookButton = new JButton("Borrow Book");
    private JButton returnBookButton = new JButton("Return book");
    private JPanel list = new JPanel();
    private JPanel listOnylAvailable = new JPanel();
    private JTable table;
    private LibraryTableModel libraryTableModel;

    public LaunchPage(LibraryModelService libraryModelService) {
        super("Library Manager", libraryModelService);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                libraryModelService.serialization();
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
        add(navigationBar,BorderLayout.WEST );

        add(list);
        list.setLayout(new GridLayout(1, 1));
        list.setBounds(100, 0, 750, 465);
        add(navigationBar,BorderLayout.EAST );

        /*add(listOnylAvailable);
        listOnylAvailable.setLayout(new GridLayout(1, 1));
        listOnylAvailable.setBounds(100, 0, 750, 465);*/

    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryModelService));
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryModelService));
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryModelService));
        createButton(showAvailableArticlesButton, e -> changeTableToAvailableOnly());
    }

    private void createButton(JButton button, ActionListener actionListener) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        navigationBar.add(button);
    }

    private void createTable() {
        libraryTableModel = new LibraryTableModel(libraryModelService);
        table = new JTable(libraryTableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        list.add(scrollPane);
    }

    private void changeTableToAvailableOnly() {
        libraryTableModel.setItems(true);
        libraryTableModel.fireTableDataChanged();
    }


}