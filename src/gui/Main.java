package gui;

import gui.basic.LaunchPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LaunchPage() );
    }

}
