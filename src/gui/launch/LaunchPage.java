package gui.launch;

import gui.custome.CustomePage;
import gui.write.AddAudioBookWritePage;
import gui.write.AddBookWritePage;
import gui.write.AddEBookWritePage;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LaunchPage extends CustomePage {
    private final JPanel navigationBar = new JPanel();
    private final JPanel availableList = new JPanel();
    private final JPanel searchBar = new JPanel();
    private final JPanel list = new JPanel();
    private final JButton addBookButton = new JButton("Add book");
    private final JButton addEBookButton = new JButton("Add e-book");
    private final JButton addAudioBookButton = new JButton("Add audiobook");
    private final JButton availableButton = new JButton("Available only");
    private final JButton search = new JButton("Search");
    private final JTable[] tables;
    private final DetailsPanel detailsPanel;
    JTextField searchField;
    private JScrollPane scrollPane;
    private int currentTableIndex;
    private LibraryTableModel libraryTableModel;
    private LibraryTableModelAvailable libraryTableModelAvailable;
    private LibraryTableModelNotAvailable libraryTableModelNotAvailable;

    public LaunchPage(LibraryModelService libraryModelService) {
        super("Library Manager", libraryModelService);
        detailsPanel = new DetailsPanel(libraryModelService);
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
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = tables[currentTableIndex].getSelectedRow();
                        if (selectedRow != -1) { // Check if any line has been selected.
                            // Downloading data from the selected row

                            String id = tables[currentTableIndex].getValueAt(selectedRow, 0).toString();
                            String type = tables[currentTableIndex].getValueAt(selectedRow, 1).toString();
                            String title = tables[currentTableIndex].getValueAt(selectedRow, 2).toString();

                            // Displaying data from the selected row
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

    public void updateTable() {
        libraryTableModel.fireTableDataChanged();
    }

    private void configureFrame() {
        setSize(1200, 600);
        navigationBar.setLayout(new GridLayout(3, 1));
        navigationBar.setBounds(0, 0, 200, 150);
        add(navigationBar);

        detailsPanel.setBounds(0, 150, 200, 450);
        add(detailsPanel);

        availableList.setLayout(new GridLayout());
        availableList.setBounds(200, 0, 200, 25);
        add(availableList);

        searchBar.setLayout(new GridLayout());
        searchBar.setBounds(800, 0, 400, 25);
        add(searchBar);

        list.setLayout(new GridLayout(1, 1));
        list.setBounds(200, 25, 985, 540);
        add(list);
    }

    public void configureComponents() {
        createButton(addBookButton, e -> new AddBookWritePage(libraryModelService, this), navigationBar);
        createButton(addEBookButton, e -> new AddEBookWritePage(libraryModelService, this), navigationBar);
        createButton(addAudioBookButton, e -> new AddAudioBookWritePage(libraryModelService, this), navigationBar);
        createButton(availableButton, e -> changeTableToAvailableOrNot(), availableList);
        createButton(search, e -> setSearchBar(), searchBar);
    }

    private void createButton(JButton button, ActionListener actionListener, JPanel jPanel) {
        button.setFocusable(false);
        button.addActionListener(actionListener);
        jPanel.add(button);
    }

    public void changeTableToAvailableOrNot() {
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
        String searchText = searchField.getText();
        RowFilter<LibraryTableModel, Object> rowFilter = RowFilter.regexFilter(searchText);
        TableRowSorter<LibraryTableModel> sorter = new TableRowSorter<>((LibraryTableModel) tables[currentTableIndex].getModel());
        sorter.setRowFilter(rowFilter);
        tables[currentTableIndex].setRowSorter(sorter);
    }

    public void addRowToTable(String type, String title, String author, String year, String language) {
        if (isValidData(type, title, author, year, language)) {
            for (int i = 0; i < tables.length; i++) {
                LibraryTableModel libraryTableModel = (LibraryTableModel) tables[i].getModel();
                libraryTableModel.addRow(new Object[]{type, title, author, year, language});
            }
        } else {
            System.out.println("Błędne dane. Nie można dodać wiersza do tabeli.");
        }
    }

    private boolean isValidData(String type, String title, String author, String year, String language) {
        return !type.isEmpty() && !title.isEmpty() && !author.isEmpty() && !year.isEmpty() && !language.isEmpty();
    }

    private void watchDetails(int id) {
        detailsPanel.setValues(libraryModelService.findItem(id));
        detailsPanel.setFunctionsButtons(libraryModelService.findItem(id));
    }

}