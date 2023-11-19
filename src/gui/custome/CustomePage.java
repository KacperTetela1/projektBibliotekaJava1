package gui.custome;

import model.service.LibraryModelService;

import javax.swing.*;

public abstract class CustomePage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    protected LibraryModelService libraryModelService;

    public CustomePage(String title, LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
        setTitle(title);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocation(600, 200);
    }

}
