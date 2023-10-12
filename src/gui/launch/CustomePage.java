package gui.launch;

import controller.LibraryController;
import model.service.LibraryModelService;

import javax.swing.*;
import java.awt.*;

public abstract class CustomePage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    protected LibraryController libraryController = new LibraryController();
    protected LibraryModelService libraryModelService;

    public CustomePage(String title, LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
        setTitle(title);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //setLayout(new BorderLayout()); //todo
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocation(600, 200);
    }

}
