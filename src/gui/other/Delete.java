package gui.other;

import javax.swing.*;

public class Delete {
    JFrame frame = new JFrame("Delete");
    ImageIcon icon = new ImageIcon("book.png");
    public Delete() {

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(700,230);

    }

}
