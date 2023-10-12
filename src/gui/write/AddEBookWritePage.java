package gui.write;

import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();

    public AddEBookWritePage(LibraryModelService libraryModelService) {
        super("EBook Details","File Size(MB)", libraryModelService);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

        button7.addActionListener(e -> create());

    }

    private void create() {

        String title = textField1.getText();
        String author = textField2.getText();
        Integer publicationYear = 0;
        Integer objectCharacter = 0;

        try {
            String text1 = textField3.getText();
            String text2 = textField4.getText();
            publicationYear = Integer.parseInt(text1);
            objectCharacter = Integer.parseInt(text2);
        } catch (NumberFormatException e) {
            System.out.println("Problem z zamiana String na int\n" + e.getMessage());
        }

        libraryController.createItem(title,author,publicationYear,objectCharacter, Item.Language.POLISH,true);

        setVisible(false);

    }

}
