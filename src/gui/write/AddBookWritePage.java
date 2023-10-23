package gui.write;

import controller.LibraryController;
import model.model.Book;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();

    public AddBookWritePage(LibraryModelService libraryModelService) {
        super("Book Details", "Pages amount", libraryModelService);

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0, 260, 400, 30);
        downPanelLow.setBounds(0, 290, 400, 30);

        downPanelUp.setBorder(new EmptyBorder(0, 0, 0, 0));
        downPanelLow.setBorder(new EmptyBorder(0, 0, 0, 0));

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
            System.out.println("Problem z zamiana String na int\n" + e.getMessage());
        }

        libraryController.createItem(title,author,publicationYear, objectCharacter, language, Book.CoverType.HARD);

        setVisible(false);

    }

}
