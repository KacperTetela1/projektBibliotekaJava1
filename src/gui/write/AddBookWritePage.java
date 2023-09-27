package gui.write;

import service.LibraryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();
    public AddBookWritePage(LibraryService libraryService) {
        super("Book Details","Pages amount", libraryService);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

        //DownPanelUp

        JLabel coverLabel = new JLabel("Select type of cover");
        coverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downPanelUp.add(coverLabel);

        //DownPanelLow

        JRadioButton button4 = new JRadioButton("Hardcover");
        JRadioButton button5 = new JRadioButton("Softcover");

        button4.setFocusable(false);
        button5.setFocusable(false);

        ButtonGroup group2 = new ButtonGroup();

        group2.add(button4);
        group2.add(button5);

        downPanelLow.add(button4);
        downPanelLow.add(button5);

    }

}
