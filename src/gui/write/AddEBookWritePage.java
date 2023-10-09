package gui.write;

import model.EBook;
import model.Item;
import model.service.LibraryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();

    public AddEBookWritePage(LibraryService libraryService) {
        super("EBook Details","File Size(MB)", libraryService, (byte) 2);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

    }

    protected static Item addEBook(String title, String author, Integer publicationYear, Integer pagesAmount) {
        Item item = new EBook(title,author, publicationYear, pagesAmount);
        return item;
    }

}
