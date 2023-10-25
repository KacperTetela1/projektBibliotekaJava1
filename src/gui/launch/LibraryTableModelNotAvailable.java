package gui.launch;

import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LibraryTableModelNotAvailable extends AbstractTableModel {

    private LibraryModelService libraryModelService = null;
    private List<Item> items = null;

    public LibraryTableModelNotAvailable(LibraryModelService libraryModelService) {
        super();
        this.libraryModelService = libraryModelService;
        items = libraryModelService.getLibraryMap(false);
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
        return 6;
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
}
