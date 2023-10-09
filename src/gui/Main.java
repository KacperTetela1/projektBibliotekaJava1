package gui;

import gui.launch.LaunchPage;
import model.service.LibraryService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LaunchPage(new LibraryService()) );
    }

}
