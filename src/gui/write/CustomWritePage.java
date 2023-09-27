package gui.write;

import gui.basic.CustomePage;
import model.Book;
import model.LibraryItemPatern;
import service.LibraryService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class CustomWritePage extends CustomePage {
    JPanel leftPanelContainer = new JPanel();
    JPanel rightPanelContainer = new JPanel();
    JLabel label1 = new JLabel("Title");
    JLabel label2 = new JLabel("Author");
    JLabel label3 = new JLabel("Publication Year");
    JLabel label4 = new JLabel();
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JTextField textField3 = new JTextField();
    JTextField textField4 = new JTextField();
    JPanel midlePanelUp = new JPanel();
    JPanel midlePanelLow = new JPanel();
    final JPanel footer = new JPanel();

    public CustomWritePage(String title, String objectCharacter, LibraryService libraryService) {
        super(title, libraryService);
        label4.setText(objectCharacter);
        setSize(400, 500);

        leftPanelContainer.setLayout(new GridLayout(4, 1));
        rightPanelContainer.setLayout(new GridLayout(4, 1, 0, 22));
        midlePanelUp.setLayout(new FlowLayout());
        midlePanelLow.setLayout(new FlowLayout());

        leftPanelContainer.setBounds(0, 0, 200, 200);
        rightPanelContainer.setBounds(200, 0, 200, 200);
        midlePanelUp.setBounds(0, 200, 400, 30);
        midlePanelLow.setBounds(0, 230, 400, 30);

        leftPanelContainer.setBorder(new EmptyBorder(0, 50, 0, 10));
        rightPanelContainer.setBorder(new EmptyBorder(10, 0, 10, 50));
        midlePanelUp.setBorder(new EmptyBorder(10, 0, 0, 0));
        midlePanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(leftPanelContainer);
        add(rightPanelContainer);
        add(midlePanelUp);
        add(midlePanelLow);

        //LeftPanel

        leftPanelContainer.add(label1);

        leftPanelContainer.add(label2);

        leftPanelContainer.add(label3);

        leftPanelContainer.add(label4);

        //RightPanel

        rightPanelContainer.add(textField1);

        rightPanelContainer.add(textField2);

        rightPanelContainer.add(textField3);

        rightPanelContainer.add(textField4);

        //MidlePanelUp

        JLabel languageLabel = new JLabel("Select book language");
        languageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        midlePanelUp.add(languageLabel);

        //MidlePanelLow

        JRadioButton button1 = new JRadioButton("Polish");
        JRadioButton button2 = new JRadioButton("English");
        JRadioButton button3 = new JRadioButton("German");

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);

        midlePanelLow.add(button1);
        midlePanelLow.add(button2);
        midlePanelLow.add(button3);

        //Footer

        footer.setLayout(new FlowLayout());
        footer.setBounds(0,390,400,30);
        footer.setBorder(new EmptyBorder(0,140,0,0));
        add(footer);

        JButton button6 = new JButton("Cancel");
        JButton button7 = new JButton("Create");

        button6.setFocusable(false);
        button7.setFocusable(false);

        footer.add(button6);
        footer.add(button7);

        button6.addActionListener(e -> cancel(this));
        button7.addActionListener(e -> create());

    }

    private static void cancel(Frame frame) {
        frame.setVisible(false);
    }

    private  void create() {
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

        LibraryItemPatern libraryItemPatern = new Book(title,author, publicationYear, objectCharacter);
        libraryService.addItem(libraryItemPatern);

    }

}
