package gui.basic;

import javax.swing.*;

public abstract class CustomePage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    public CustomePage(String title) {
        setTitle(title);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocation(600,200);
    }

}
