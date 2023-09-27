import console.ConsoleController;
import gui.basic.LaunchPage;
import service.LibraryService;

import javax.swing.*;


public class App {

    public static void main(String[] args) {

        LibraryService schoolLibrary = new LibraryService();
        SwingUtilities.invokeLater(() -> new LaunchPage(schoolLibrary) );

        ConsoleController consoleController = new ConsoleController(schoolLibrary);
        consoleController.runConsoleMenu();
    }
}