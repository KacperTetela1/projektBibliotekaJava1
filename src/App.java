import console.ConsoleController;
import service.LibraryService;


public class App {

    public static void main(String[] args) {
        LibraryService schoolLibrary = new LibraryService();
        ConsoleController consoleController = new ConsoleController(schoolLibrary);
        consoleController.runConsoleMenu();
    }
}