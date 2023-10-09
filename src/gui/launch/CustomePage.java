package gui.launch;

import model.service.LibraryService;

import javax.swing.*;

public abstract class CustomePage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    protected LibraryService libraryService;

    public CustomePage(String title, LibraryService libraryService) {
        this.libraryService = libraryService;
        setTitle(title);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocation(600, 200);
    }

}
