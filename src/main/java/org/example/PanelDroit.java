package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelDroit extends JPanel {
    private JTextArea textArea;

    public PanelDroit() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void afficherDetails(String details) {
        textArea.setText(details);
    }
}
