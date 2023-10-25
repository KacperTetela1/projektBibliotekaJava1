package gui.launch;

import gui.custome.CustomePage;
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
    private JPanel availableList = new JPanel();
    private JPanel searchBar = new JPanel();
    private JPanel list = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton AvailableButton = new JButton("Available, Not Available, All");
    private JButton search = new JButton("Search");
    private JScrollPane scrollPane;
    private int currentTableIndex;
    private JTable[] tables;
    private LibraryTableModel libraryTableModel;
    private LibraryTableModelAvailable libraryTableModelAvailable;
    private LibraryTableModelNotAvailable libraryTableModelNotAvailable;

    public LaunchPage(LibraryModelService libraryModelService) {
        super("Library Manager", libraryModelService);
        tables = new JTable[3];
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

    private void createTable() {
        libraryTableModel = new LibraryTableModel(libraryModelService);
        libraryTableModelAvailable = new LibraryTableModelAvailable(libraryModelService);
        libraryTableModelNotAvailable = new LibraryTableModelNotAvailable(libraryModelService);
        currentTableIndex = 0;

        scrollPane = new JScrollPane();
        tables[0] = new JTable(libraryTableModel);
        tables[1] = new JTable(libraryTableModelAvailable);
        tables[2] = new JTable(libraryTableModelNotAvailable);

        scrollPane = new JScrollPane(tables[currentTableIndex]);
        list.add(scrollPane);

        /*ListSelectionModel selectionModel = tableAll.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableAll.getSelectedRow();
                    if (selectedRow != -1) { // Sprawdzenie, czy został zaznaczony jakiś wiersz.
                        // Pobranie danych z zaznaczonego wiersza.
                        String id = tableAll.getValueAt(selectedRow, 0).toString();
                        String type = tableAll.getValueAt(selectedRow, 1).toString();
                        String title = tableAll.getValueAt(selectedRow, 2).toString();
                        String author = tableAll.getValueAt(selectedRow, 3).toString();
                        String year = tableAll.getValueAt(selectedRow, 4).toString();
                        String language = tableAll.getValueAt(selectedRow, 5).toString();

                        // Wyświetlenie danych z zaznaczonego wiersza.
                        System.out.println("ID: " + id);
                        System.out.println("Type: " + type);
                        System.out.println("Title: " + title);

                        int idInt = Integer.parseInt(id);

                        switch (type) {
                            case "Book":
                                Book book = libraryController.downloadDetailsBook(idInt, type);
                                String coverType = book.getCoverType().toString();
                                String numberOfPages = String.valueOf(book.getNumberOfPages());
                                //setRightDeatilsPanel(idLabelAnswear, typeLabelAnswear, titleLabelAnswear, authorLabelAnswear, yearPublishedLabelAnswear, languaheLabelAnswear, coverTypeLabelAnswear, numberOfPagesLabelAnswear, id, type, title, author, year, language, coverType, numberOfPages);
                                break;
                            case "EBook":
                                break;
                            case "AudioBook":
                                System.out.println();
                                break;
                            default:
                                System.out.println("Error");

                        }
                    }
                }
            }
        });*/
    }

    private void configureFrame() {
        setSize(1200, 600);

        navigationBar.setLayout(new GridLayout(3, 1));
        navigationBar.setBounds(0, 0, 150, 150);
        //navigationBar.setBorder(new EmptyBorder(0,0,0,0));
        add(navigationBar);

        availableList.setLayout(new GridLayout());
        availableList.setBounds(150, 0, 200, 25);
        //availableList.setBorder(new EmptyBorder(0,0,0,0));
        add(availableList);

        searchBar.setLayout(new GridLayout());
        searchBar.setBounds(650, 0, 350, 25);
        //searchBar.setBorder(new EmptyBorder(0,0,0,0));
        add(searchBar);

        list.setLayout(new GridLayout(1, 1));
        list.setBounds(150, 25, 838, 465);
        //list.setBorder(new EmptyBorder(0,0,0,0));
        add(list);

    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryModelService), navigationBar);
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryModelService), navigationBar);
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryModelService), navigationBar);
        createButton(AvailableButton, e -> changeTableToAvailableOrNot(), availableList);
        JTextField searchField = new JTextField();
        searchBar.add(searchField);
        createButton(search, e -> setSearchBar(), searchBar);

    }

    private void createButton(JButton button, ActionListener actionListener, JPanel jPanel) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        jPanel.add(button);
    }

    private void changeTableToAvailableOrNot() {
        currentTableIndex = (currentTableIndex + 1) % tables.length;
        scrollPane.setViewportView(tables[currentTableIndex]);
    }

    private void setSearchBar() {
    }

    //void refreshTable() {libraryTableModel.fireTableDataChanged();}


}