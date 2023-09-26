package gui.write;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class CustomPage extends JFrame {
    private final ImageIcon icon = new ImageIcon("book.png");
    final JPanel footer = new JPanel();

    public CustomPage(String title) {
        super(title);
        setSize(400, 500);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocation(700,230);

        //Footer

        footer.setLayout(new FlowLayout());
        footer.setBounds(0,390,400,30);
        footer.setBorder(new EmptyBorder(0,140,0,0));
        add(footer);

        JButton button6 = new JButton("Cancel");
        button6.addActionListener(e -> cancel(this));
        button6.setFocusable(false);
        footer.add(button6);

    }

    private static void cancel(Frame frame) {
        frame.setVisible(false);
    }

}
