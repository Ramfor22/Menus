package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelDroit extends JPanel {
    private JTextArea commandeTextArea;

    public PanelDroit() {
        setLayout(new BorderLayout());

        commandeTextArea = new JTextArea();
        commandeTextArea.setEditable(false);
        commandeTextArea.setBackground(Color.BLACK);
        commandeTextArea.setForeground(Color.GREEN);
        JScrollPane scrollPane = new JScrollPane(commandeTextArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendText(String text) {
        commandeTextArea.append(text + "\n");
    }
}

