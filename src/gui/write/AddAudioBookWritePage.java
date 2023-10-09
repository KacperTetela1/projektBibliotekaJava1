package gui.write;

import model.AudioBook;
import model.Item;
import model.service.LibraryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddAudioBookWritePage extends CustomWritePage {
   private final JPanel downPanelUp = new JPanel();
   private final JPanel downPanelLow = new JPanel();

    public AddAudioBookWritePage(LibraryService libraryService) {
        super("Audio Book Details","Duration(seconds)", libraryService, (byte) 3);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

    }

    protected static Item addAudioBook(String title, String author, Integer publicationYear, Integer pagesAmount) {
        Item item = new AudioBook(title,author, publicationYear, pagesAmount);
        return item;
    }

}
