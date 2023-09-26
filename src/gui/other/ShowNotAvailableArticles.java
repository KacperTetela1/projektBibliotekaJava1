package gui.other;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowNotAvailableArticles {
    JFrame frame = new JFrame("Not Available Articles");
    ImageIcon icon = new ImageIcon("book.png");

    public ShowNotAvailableArticles() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);


    }

}
