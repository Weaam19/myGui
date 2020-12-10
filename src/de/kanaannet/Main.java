package de.kanaannet;
import javax.swing.*;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("MAIN");
        JLabel lblText = new JLabel("Hello Weaam Welcome in the JAVA World!");
        JMenuBar jmenu = new JMenuBar();
        JPasswordField password = new JPasswordField();
        //frame.getContentPane().add(lblText);
        frame.setContentPane(lblText);
        //frame.getContentPane().add(password);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 500);
        frame.setSize(500, 100);
        frame.setVisible(true);
        // der eine Farbe zurück gibt
        Color ausgewaehlteFarbe = JColorChooser.showDialog(null,
                "Farbauswahl", null);
        // Ausgabe der ausgewählten Farbe
        System.out.println(ausgewaehlteFarbe);

    }
}
