package gui.launch;

import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class LibraryTableModel extends AbstractTableModel {

    private final LibraryModelService libraryModelService = null;
    private List<Item> items = null;

    public LibraryTableModel(LibraryModelService libraryModelService) {
        super();
        //this.libraryModelService = libraryModelService;
        items = libraryModelService.getLibraryMap();
    }

    @Override
    public int getRowCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "Key: ";

            case 1:
                return "Type: ";

            case 2:
                return "Title";

            case 3:
                return "Author";

            case 4:
                return "Publication Year";

            case 5:
                return "Language";

            case 6:
                return "Availablity";

            default:
                return "";

        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Integer.class;

            case 1:
                return String.class;

            case 2:
                return String.class;

            case 3:
                return String.class;

            case 4:
                return Integer.class;

            case 5:
                return Item.Language.class;

            case 6:
                return Boolean.class;

            default:
                return null;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getId();

            case 1:
                if (item instanceof Book) return "Book";
                else if (item instanceof EBook) return "EBook";
                else return "Audio-Book";

            case 2:
                return items.get(rowIndex).getTitle();

            case 3:
                return items.get(rowIndex).getAuthor();

            case 4:
                return items.get(rowIndex).getYearPublished();

            case 5:
                return items.get(rowIndex).getLanguage();

            case 6:
                return items.get(rowIndex).isAvailability();

            default:
                return "";

        }

    }

    public void setItems(boolean available) {
        items = libraryModelService.getLibraryMap(available);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void addRow(Object[] objects) {
    }

    // New method to update the data
/*    public void updateData(Object[] newData) {
        // Assuming your data is a List of Object arrays

        // Update the data
        addRow(newData);

        // Notify the table that the data has changed
        fireTableDataChanged();
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }*/


}
