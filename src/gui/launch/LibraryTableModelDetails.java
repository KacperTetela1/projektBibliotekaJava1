package gui.launch;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class LibraryTableModelDetails implements TableModel {

    LibraryModelService libraryModelService;

    public LibraryTableModelDetails(LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
    }

    @Override
    public int getRowCount() {
        return libraryModelService.getLibraryMap().size();
    }

    @Override
    public int getColumnCount() {
        return 11;
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

            case 10:
                return "is PDF";

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

            case 10:
                return boolean.class;

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
        Item item = libraryModelService.getLibraryMap().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex;

            case 1:
                if (item instanceof Book) return "Book";
                else if (item instanceof EBook) return "EBook";
                else return "Audio-Book";

            case 2:
                return libraryModelService.getLibraryMap().get(rowIndex).getTitle();

            case 3:
                return libraryModelService.getLibraryMap().get(rowIndex).getAuthor();

            case 4:
                return libraryModelService.getLibraryMap().get(rowIndex).getYearPublished();

            case 5:
                return libraryModelService.getLibraryMap().get(rowIndex).getLanguage();

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
                else return null;

            case 9:
                if (item instanceof AudioBook)
                    return ((AudioBook) item).getDuration();
                else return null;

            case 10:
                if (item instanceof EBook)
                    return ((EBook) item).isPDF();
                else return null;

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
