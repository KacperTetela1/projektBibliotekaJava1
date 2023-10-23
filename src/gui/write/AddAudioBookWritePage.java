package gui.write;

import model.model.AudioBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddAudioBookWritePage extends CustomWritePage {
   private final JPanel downPanelUp = new JPanel();
   private final JPanel downPanelLow = new JPanel();

    public AddAudioBookWritePage(LibraryModelService libraryModelService) {
        super("Audio Book Details","Duration(seconds)", libraryModelService);

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

        libraryController.createItem(title,author,publicationYear,objectCharacter, language);

        setVisible(false);

    }

}
