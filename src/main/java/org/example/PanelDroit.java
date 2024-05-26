package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelDroit extends JPanel {
    private JTextArea commandeTextArea;
    private JLabel prixPlatLabel;
    private JLabel prixAccompagnementLabel;
    private JLabel prixDessertLabel;
    private JLabel prixTotalLabel;

    public PanelDroit() {
        setLayout(new BorderLayout());

        commandeTextArea = new JTextArea();
        commandeTextArea.setEditable(false);
        commandeTextArea.setBackground(Color.BLACK);
        commandeTextArea.setForeground(Color.GREEN);
        JScrollPane scrollPane = new JScrollPane(commandeTextArea);

        JPanel prixPanel = new JPanel();
        prixPanel.setLayout(new GridLayout(4, 1));
        prixPlatLabel = new JLabel("Prix du plat : 0.0€");
        prixAccompagnementLabel = new JLabel("Prix de l'accompagnement : 0.0€");
        prixDessertLabel = new JLabel("Prix du dessert : 0.0€");
        prixTotalLabel = new JLabel("Prix total : 0.0€");
        prixPanel.add(prixPlatLabel);
        prixPanel.add(prixAccompagnementLabel);
        prixPanel.add(prixDessertLabel);
        prixPanel.add(prixTotalLabel);

        add(scrollPane, BorderLayout.CENTER);
        add(prixPanel, BorderLayout.SOUTH);
    }

    public void appendText(String text) {
        commandeTextArea.append(text + "\n");
    }

    public void setPrixPlat(double prix) {
        prixPlatLabel.setText("Prix du plat : " + prix + "€");
    }

    public void setPrixAccompagnement(double prix) {
        prixAccompagnementLabel.setText("Prix de l'accompagnement : " + prix + "€");
    }

    public void setPrixDessert(double prix) {
        prixDessertLabel.setText("Prix du dessert : " + prix + "€");
    }

    public void setPrixTotal(double prix) {
        prixTotalLabel.setText("Prix total : " + prix + "€");
    }
}
