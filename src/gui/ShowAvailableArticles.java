package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowAvailableArticles {
    JFrame frame = new JFrame("AvailableArticles");
    ImageIcon icon = new ImageIcon("book.png");

    ShowAvailableArticles() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);


    }

}
