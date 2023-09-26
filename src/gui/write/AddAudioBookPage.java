package gui.write;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddAudioBookPage extends CustomPage{
   private final JPanel leftPanelContainer = new JPanel();
   private final JPanel rightPanelContainer = new JPanel();
   private final JPanel middlePanelUp = new JPanel();
   private final JPanel middlePanelLow = new JPanel();
   private final JPanel downPanelUp = new JPanel();
   private final JPanel downPanelLow = new JPanel();

    public AddAudioBookPage() {
        super("Audio Book Details");

        leftPanelContainer.setLayout(new GridLayout(4, 1));
        rightPanelContainer.setLayout(new GridLayout(4, 1, 0, 22));
        middlePanelUp.setLayout(new FlowLayout());
        middlePanelLow.setLayout(new FlowLayout());
        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());


        leftPanelContainer.setBounds(0, 0, 200, 200);
        rightPanelContainer.setBounds(200, 0, 200, 200);
        middlePanelUp.setBounds(0, 200, 400, 30);
        middlePanelLow.setBounds(0, 230, 400, 30);
        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);


        leftPanelContainer.setBorder(new EmptyBorder(0, 50, 0, 10));
        rightPanelContainer.setBorder(new EmptyBorder(10, 0, 10, 50));
        middlePanelUp.setBorder(new EmptyBorder(10, 0, 0, 0));
        middlePanelLow.setBorder(new EmptyBorder(0,0,0,0));
        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));


        add(leftPanelContainer);
        add(rightPanelContainer);
        add(middlePanelUp);
        add(middlePanelLow);
        add(downPanelUp);
        add(downPanelLow);


        //LeftPanel

        JLabel label1 = new JLabel("Title");
        leftPanelContainer.add(label1);

        JLabel label2 = new JLabel("Author");
        leftPanelContainer.add(label2);

        JLabel label3 = new JLabel("Publication Year");
        leftPanelContainer.add(label3);

        JLabel label4 = new JLabel("Duration(seconds)");
        leftPanelContainer.add(label4);

        //RightPanel

        JTextField textField1 = new JTextField();
        rightPanelContainer.add(textField1);

        JTextField textField2 = new JTextField();
        rightPanelContainer.add(textField2);

        JTextField textField3 = new JTextField();
        rightPanelContainer.add(textField3);

        JTextField textField4 = new JTextField();
        rightPanelContainer.add(textField4);

        //MidlePanelUp

        JLabel languageLabel = new JLabel("Select book language");
        languageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        middlePanelUp.add(languageLabel);

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

        middlePanelLow.add(button1);
        middlePanelLow.add(button2);
        middlePanelLow.add(button3);

        //Footer

        JButton button7 = new JButton("Create");
        button7.addActionListener(e -> create(textField1,textField2,textField3,textField4));
        button7.setFocusable(false);
        footer.add(button7);

    }

    private  void create(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4) {
        String title = textField1.getText();
        String author = textField2.getText();
        String publicationYear = textField3.getText();
        String duration = textField4.getText();
    }

}
