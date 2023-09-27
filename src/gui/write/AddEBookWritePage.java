package gui.write;

import service.LibraryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigInteger;

public class AddEBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();

    public AddEBookWritePage(LibraryService libraryService) {
        super("EBook Details","File Size(MB)", libraryService);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

    }

}
