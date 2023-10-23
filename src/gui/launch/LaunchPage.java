package gui.launch;

import gui.write.AddAudioBookWritePage;
import gui.write.AddBookWritePage;
import gui.write.AddEBookWritePage;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LaunchPage extends CustomePage {
    private JPanel navigationBar = new JPanel();
    private JPanel availableList = new JPanel();
    private JPanel searchBar = new JPanel();
    private JPanel list = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton showAvailableArticlesButton = new JButton("Available articles");
    private JButton showNotAvailableArticlesButton = new JButton("Not available Articles");
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
        //navigationBar.setBorder(new EmptyBorder(0,0,0,0));
        add(navigationBar);

        availableList.setLayout(new GridLayout());
        availableList.setBounds(100,0,200,50);
        //availableList.setBorder(new EmptyBorder(0,0,0,0));
        add(availableList);

        searchBar.setLayout(null);
        searchBar.setBounds(300,0,300,50);
        //searchBar.setBorder(new EmptyBorder(0,0,0,0));
        add(searchBar);

        add(list);
        list.setLayout(new GridLayout(1, 1));
        list.setBounds(100, 50, 750, 465);
        //list.setBorder(new EmptyBorder(0,0,0,0));
        add(navigationBar);

    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryModelService),navigationBar);
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryModelService),navigationBar);
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryModelService),navigationBar);
        createButton(showAvailableArticlesButton, e -> changeTableToAvailableOrNot(true),availableList);
        createButton(showNotAvailableArticlesButton, e -> changeTableToAvailableOrNot(false),availableList);
    }

    private void createButton(JButton button, ActionListener actionListener, JPanel jPanel) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        jPanel.add(button);
    }

    private void createTable() {
        libraryTableModel = new LibraryTableModel(libraryModelService);
        table = new JTable(libraryTableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        list.add(scrollPane);
    }

    private void changeTableToAvailableOrNot(boolean avialibility) {
        libraryTableModel.setItems(true);
        //libraryTableModel.fireTableDataChanged();

        //todo
        if (avialibility) {

        } else {

        }

    }


}