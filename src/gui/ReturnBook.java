package gui;

import javax.swing.*;

public class ReturnBook {
    JFrame frame = new JFrame("Return book");
    ImageIcon icon = new ImageIcon("book.png");
    ReturnBook() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);

    }

}
