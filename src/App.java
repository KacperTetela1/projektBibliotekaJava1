import objects.AudioBook;
import objects.Book;
import objects.LiteraryArt;
import tools.Input;
import tools.Label;


public class App {

    public static void main(String[] args) {
        LibraryManager schoolLibrary = new LibraryManager();
        ConsoleController consoleController = new ConsoleController(schoolLibrary);
        consoleController.runConsoleMenu();
    }



}