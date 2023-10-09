package gui.launch;

import model.AudioBook;
import model.Book;
import model.EBook;
import model.Item;
import model.service.LibraryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class LibraryTableModel implements TableModel {

    LibraryService libraryService;

    public LibraryTableModel(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public int getRowCount() {
        return libraryService.getLibraryMap().size();
    }

    @Override
    public int getColumnCount() {
        return 10;
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
                return "Book Cover(book only)";

            case 7:
                return "Pages";

            case 8:
                return "File size(MB)";

            case 9:
                return "Duration(sec)";

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
                return Book.CoverType.class;

            case 7:
                return Integer.class;

            case 8:
                return Integer.class;

            case 9:
                return Integer.class;

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
        Item item = libraryService.getLibraryMap().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex;

            case 1:
                if (item instanceof Book) return "Book";
                else if (item instanceof EBook) return "EBook";
                else return "Audio-Book";

            case 2:
                return libraryService.getLibraryMap().get(rowIndex).getTitle();

            case 3:
                return libraryService.getLibraryMap().get(rowIndex).getAuthor();

            case 4:
                return libraryService.getLibraryMap().get(rowIndex).getYearPublished();

            case 5:
                return libraryService.getLibraryMap().get(rowIndex).getLanguage();

            case 6:
                if (item instanceof Book) {
                    return ((Book) item).getCoverType();
                } else {
                    return "-";
                }

            case 7:
                if (item instanceof Book)
                    return ((Book) item).getNumberOfPages();
                else
                    return null;

            case 8:
                if (item instanceof EBook)
                    return ((EBook) item).getFileSize();

            case 9:
                if (item instanceof AudioBook)
                    return ((AudioBook) item).getDuration();

            default:
                return "";
        }

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
