package gui.write;

import gui.launch.LaunchPage;
import model.model.Book;
import model.model.Item;
import model.service.LibraryModelService;
import gui.launch.LaunchPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddBookWritePage extends CustomWritePage {
    JPanel downPanelUp = new JPanel();
    JPanel downPanelLow = new JPanel();
    private JRadioButton button4;
    private JRadioButton button5;
    Book.CoverType coverType;

    LaunchPage launchPage;

    public AddBookWritePage(LibraryModelService libraryModelService, LaunchPage launchPage) {
        super("Book Details", "Pages amount", libraryModelService);
        launchPage = this.launchPage;
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

        button4 = new JRadioButton("Hardcover");
        button5 = new JRadioButton("Softcover");

        button4.setFocusable(false);
        button5.setFocusable(false);

        ButtonGroup group2 = new ButtonGroup();

        group2.add(button4);
        group2.add(button5);

        button4.addActionListener(this);
        button5.addActionListener(this);

        downPanelLow.add(button4);
        downPanelLow.add(button5);

        button7.addActionListener(e -> create());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button4) {
            coverType = Book.CoverType.HARD;
        } else if (e.getSource() == button5) {
            coverType = Book.CoverType.SOFT;
        }

        if (e.getSource() == button1) {
            language = Item.Language.POLISH;
        } else if (e.getSource() == button2) {
            language = Item.Language.ENGLISH;
        } else if (e.getSource() == button3) {
            language = Item.Language.GERMAN;
        }
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

        libraryModelService.addItem(title,author,publicationYear, objectCharacter, language, coverType);

        setVisible(false);

        try {
            launchPage.addRowToTable("Book",title,author,publicationYear.toString(),language.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

}
