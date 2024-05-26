package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.List;

public class PanelDroit extends JPanel {
    private JTextArea orderDetails;

    public PanelDroit() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 0));
        this.orderDetails = new JTextArea();
        this.orderDetails.setEditable(false);
        this.orderDetails.setBackground(Color.BLACK);
        this.orderDetails.setForeground(Color.WHITE);
        this.orderDetails.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(this.orderDetails);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void displayCommande(List<IPlat> commande) {
        orderDetails.setText("");
        for (IPlat plat : commande) {
            orderDetails.append(plat.getNom() + " - " + plat.getPrix() + "€\n");
        }
    }

    public JTextArea getOrderDetails() {
        return this.orderDetails;
    }
}
