package gui.write;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddAudioBookWritePage extends CustomWritePage {
   private final JPanel downPanelUp = new JPanel();
   private final JPanel downPanelLow = new JPanel();

    public AddAudioBookWritePage() {
        super("Audio Book Details","Duration(seconds)");

        downPanelUp.setLayout(new FlowLayout());
        downPanelLow.setLayout(new FlowLayout());

        downPanelUp.setBounds(0,260,400,30);
        downPanelLow.setBounds(0,290,400,30);

        downPanelUp.setBorder(new EmptyBorder(0,0,0,0));
        downPanelLow.setBorder(new EmptyBorder(0,0,0,0));

        add(downPanelUp);
        add(downPanelLow);

    }

}
