import gui.launch.LaunchPage;
import model.service.LibraryModelService;

import javax.swing.*;


public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            LibraryModelService schoolLibrary = new LibraryModelService();
            new LaunchPage(schoolLibrary);
        });

//        ConsoleController consoleController = new ConsoleController(schoolLibrary);
//        consoleController.runConsoleMenu();

    }
}