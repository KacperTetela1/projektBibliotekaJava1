package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class CustomPage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    final JPanel footer = new JPanel();

    public CustomPage(String title) {
        super(title);
        setIconImage(icon.getImage());

        footer.setLayout(new FlowLayout());
        footer.setBounds(0,390,400,30);
        footer.setBorder(new EmptyBorder(0,140,0,0));
        add(footer);


    }

}
