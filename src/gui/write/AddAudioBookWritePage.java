package gui.write;

import gui.launch.LaunchPage;
import model.model.AudioBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddAudioBookWritePage extends CustomWritePage {
    private final JPanel downPanelUp = new JPanel();
    private final JPanel downPanelLow = new JPanel();
    LaunchPage launchPage;

    public AddAudioBookWritePage(LibraryModelService libraryModelService, LaunchPage launchPage) {
        super("Audio Book Details", "Duration(seconds)", libraryModelService);
        launchPage = this.launchPage;
        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0, 260, 400, 30);
        downPanelLow.setBounds(0, 290, 400, 30);

        downPanelUp.setBorder(new EmptyBorder(0, 0, 0, 0));
        downPanelLow.setBorder(new EmptyBorder(0, 0, 0, 0));

        add(downPanelUp);
        add(downPanelLow);

        button7.addActionListener(e -> create());

    }

    private void create() {

        String title = textField1.getText();
        String author = textField2.getText();
        Integer publicationYear = null;
        Integer objectCharacter = null;

        try {
            String text1 = textField3.getText();
            String text2 = textField4.getText();
            publicationYear = Integer.parseInt(text1);
            objectCharacter = Integer.parseInt(text2);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entered an invalid character");
            System.out.println("Problem z zamiana String na int\n");
        }

        if (title.length() > 30 || author.length() > 30 || title.length() < 1 || author.length() < 1) {
            JOptionPane.showMessageDialog(this, "Title or author is too long, or too short");
        } else if (publicationYear > Date.from(new Date().toInstant()).getYear() + 1900 || publicationYear < 0) {
            JOptionPane.showMessageDialog(this, "Publication year is incorrect");
        } else if (language == null) {
            JOptionPane.showMessageDialog(this, "Language is not selected");
        } else if (objectCharacter < 0 || objectCharacter > 10000) {
            JOptionPane.showMessageDialog(this, "Pages amount is incorrect");
        } else {

            libraryModelService.addItem(title, author, publicationYear, objectCharacter, language);
            setVisible(false);

            try {
                launchPage.addRowToTable("EBook", title, author, publicationYear.toString(),
                        language.toString());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
