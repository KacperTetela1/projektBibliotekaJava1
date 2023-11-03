package gui.launch;

import gui.custome.CustomePage;
import gui.write.AddAudioBookWritePage;
import gui.write.AddBookWritePage;
import gui.write.AddEBookWritePage;
import model.model.Book;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LaunchPage extends CustomePage {
    JTextField searchField;
    private JPanel navigationBar = new JPanel();
    private JPanel availableList = new JPanel();
    private JPanel searchBar = new JPanel();
    private JPanel list = new JPanel();
    private JButton addBookButton = new JButton("Add book");
    private JButton addEBookButton = new JButton("Add e-book");
    private JButton addAudioBookButton = new JButton("Add audiobook");
    private JButton availableButton = new JButton("Available only");
    private JButton search = new JButton("Search");
    private JScrollPane scrollPane;
    private int currentTableIndex;
    private JTable[] tables;
    private LibraryTableModel libraryTableModel;
    private LibraryTableModelAvailable libraryTableModelAvailable;
    private LibraryTableModelNotAvailable libraryTableModelNotAvailable;
    private DetailsPanel detailsPanel;

    public LaunchPage(LibraryModelService libraryModelService) {
        super("Library Manager", libraryModelService);
        detailsPanel = new DetailsPanel(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884, Item.Language.POLISH, Book.CoverType.HARD, 588,false));
        searchField = new JTextField();
        searchBar.add(searchField);

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

        ListSelectionModel selectionModel = tables[currentTableIndex].getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // przeprojektuj to tak aby pasowalo do nowego modelu
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = tables[currentTableIndex].getSelectedRow();
                        if (selectedRow != -1) { // Sprawdzenie, czy został zaznaczony jakiś wiersz.
                            // Pobranie danych z zaznaczonego wiersza.

                            String id = tables[currentTableIndex].getValueAt(selectedRow, 0).toString();
                            String type = tables[currentTableIndex].getValueAt(selectedRow, 1).toString();
                            String title = tables[currentTableIndex].getValueAt(selectedRow, 2).toString();
                            String author = tables[currentTableIndex].getValueAt(selectedRow, 3).toString();
                            String year = tables[currentTableIndex].getValueAt(selectedRow, 4).toString();
                            String language = tables[currentTableIndex].getValueAt(selectedRow, 5).toString();

                            // Wyświetlenie danych z zaznaczonego wiersza.
                            System.out.println("ID: " + id);
                            System.out.println("Type: " + type);
                            System.out.println("Title: " + title);

                            int idInt = Integer.parseInt(id);
                            watchDetails(idInt);

                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

    }

    private void configureFrame() {
        setSize(1200, 600);

        navigationBar.setLayout(new GridLayout(3, 1));
        navigationBar.setBounds(0, 0, 200, 150);
        //navigationBar.setBorder(new EmptyBorder(0,0,0,0));
        add(navigationBar);

        detailsPanel.setBounds(0,150,200,450);
        //details.setBorder(new EmptyBorder(0,0,0,0));
        add(detailsPanel);

        availableList.setLayout(new GridLayout());
        availableList.setBounds(200, 0, 200, 25);
        //availableList.setBorder(new EmptyBorder(0,0,0,0));
        add(availableList);

        searchBar.setLayout(new GridLayout());
        searchBar.setBounds(800, 0, 400, 25);
        //searchBar.setBorder(new EmptyBorder(0,0,0,0));
        add(searchBar);

        list.setLayout(new GridLayout(1, 1));
        list.setBounds(200, 25, 985, 540);
        //list.setBorder(new EmptyBorder(0,0,0,0));
        add(list);

    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryModelService, this), navigationBar);
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryModelService), navigationBar);
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryModelService), navigationBar);
        createButton(availableButton, e -> changeTableToAvailableOrNot(), availableList);
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

        if (currentTableIndex == 1) {
            availableButton.setText("Not Available");
        } else if (currentTableIndex == 2) {
            availableButton.setText("All");
        } else {
            availableButton.setText("Available only");
        }

    }

    private void setSearchBar() {
        currentTableIndex = 0;
        scrollPane.setViewportView(tables[currentTableIndex]);

        String searchText = searchField.getText().toLowerCase();
        RowFilter<LibraryTableModel, Object> rowFilter = RowFilter.regexFilter(searchText);
        TableRowSorter<LibraryTableModel> sorter = new TableRowSorter<>((LibraryTableModel) tables[currentTableIndex].getModel());
        sorter.setRowFilter(rowFilter);
        tables[currentTableIndex].setRowSorter(sorter);

    }

    public void addRowToTable(String type, String title, String author, String year, String language) {
        // Walidacja danych - sprawdź czy dane są poprawne przed dodaniem ich do tabeli
        if (isValidData(type, title, author, year, language)) {
            // Iteruj przez wszystkie tabele w tablicy "tables" i dodaj wiersz do każdej z nich
            for (int i = 0; i < tables.length; i++) {
                LibraryTableModel libraryTableModel = (LibraryTableModel) tables[i].getModel();
                libraryTableModel.addRow(new Object[]{type, title, author, year, language});
            }
        } else {
            // Obsłuż niepoprawne dane, np. wyświetl błąd użytkownikowi
            System.out.println("Błędne dane. Nie można dodać wiersza do tabeli.");
        }
    }

    private boolean isValidData(String type, String title, String author, String year, String language) {
        // Implementuj logikę walidacji danych według swoich wymagań
        // Zwróć true, jeśli dane są poprawne, w przeciwnym razie false
        // Możesz sprawdzać czy pola nie są puste, czy rok jest liczbą, itp.
        // Przykład prostej walidacji:
        return !type.isEmpty() && !title.isEmpty() && !author.isEmpty() && !year.isEmpty() && !language.isEmpty();
    }

    private void watchDetails(int id) {
        //TODO change in table or JPanel the view to direct view of Item
    }

}