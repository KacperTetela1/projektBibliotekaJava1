package gui.write;

import gui.custome.CustomePage;
import gui.launch.LaunchPage;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CustomWritePage extends CustomePage implements ActionListener {
    final JPanel footer = new JPanel();
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
    JRadioButton button1;
    JRadioButton button2;
    JRadioButton button3;
    JButton button6 = new JButton("Cancel");
    JButton button7 = new JButton("Create");
    Item.Language language;

    public CustomWritePage(String title, String objectCharacter, LibraryModelService libraryModelService) {
        super(title, libraryModelService);
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
        midlePanelLow.setBorder(new EmptyBorder(0, 0, 0, 0));

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

        button1 = new JRadioButton("Polish");
        button2 = new JRadioButton("English");
        button3 = new JRadioButton("German");

        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(button1);
        group1.add(button2);
        group1.add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        midlePanelLow.add(button1);
        midlePanelLow.add(button2);
        midlePanelLow.add(button3);

        //Footer

        footer.setLayout(new FlowLayout());
        footer.setBounds(0, 390, 400, 30);
        footer.setBorder(new EmptyBorder(0, 140, 0, 0));
        add(footer);

        button6.setFocusable(false);
        button7.setFocusable(false);

        footer.add(button6);
        footer.add(button7);

        button6.addActionListener(e -> cancel());
    }

    private void cancel() {
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            language = Item.Language.POLISH;
        } else if (e.getSource() == button2) {
            language = Item.Language.ENGLISH;
        } else if (e.getSource() == button3) {
            language = Item.Language.GERMAN;
        }
    }

}
