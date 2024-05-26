package org.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;

public class PanelGauche extends JPanel {
    private JComboBox<String> platComboBox;
    private JComboBox<String> accompagnementComboBox;
    private JComboBox<String> dessertComboBox;

    public PanelGauche(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.setLayout(new BorderLayout());
        this.add(this.createMainPanel(plats, accompagnements, desserts), BorderLayout.CENTER);
        this.add(this.createControlPanel(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Choisissez votre menu", TitledBorder.CENTER, TitledBorder.TOP));
        mainPanel.add(this.createPlatPanel(plats));
        mainPanel.add(this.createAccompagnementPanel(accompagnements));
        mainPanel.add(this.createDessertPanel(desserts));
        return mainPanel;
    }

    private JPanel createPlatPanel(List<IPlat> plats) {
        JPanel platPanel = new JPanel(new BorderLayout());
        platPanel.setBorder(BorderFactory.createTitledBorder("Plats"));
        platComboBox = new JComboBox<>();
        for (IPlat plat : plats) {
            platComboBox.addItem(plat.getNom());
        }
        platPanel.add(platComboBox, BorderLayout.CENTER);
        return platPanel;
    }

    private JPanel createAccompagnementPanel(List<IPlat> accompagnements) {
        JPanel accompagnementPanel = new JPanel(new BorderLayout());
        accompagnementPanel.setBorder(BorderFactory.createTitledBorder("Accompagnements"));
        accompagnementComboBox = new JComboBox<>();
        for (IPlat accompagnement : accompagnements) {
            accompagnementComboBox.addItem(accompagnement.getNom());
        }
        accompagnementPanel.add(accompagnementComboBox, BorderLayout.CENTER);
        return accompagnementPanel;
    }

    private JPanel createDessertPanel(List<IPlat> desserts) {
        JPanel dessertPanel = new JPanel(new BorderLayout());
        dessertPanel.setBorder(BorderFactory.createTitledBorder("Desserts"));
        dessertComboBox = new JComboBox<>();
        for (IPlat dessert : desserts) {
            dessertComboBox.addItem(dessert.getNom());
        }
        dessertPanel.add(dessertComboBox, BorderLayout.CENTER);
        return dessertPanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Ajouter");
        JButton validateButton = new JButton("Valider");
        JButton backButton = new JButton("Retour");
        JButton clearButton = new JButton("Effacer");
        controlPanel.add(addButton);
        controlPanel.add(validateButton);
        controlPanel.add(backButton);
        controlPanel.add(clearButton);
        return controlPanel;
    }

    public String getSelectedPlat() {
        return (String) platComboBox.getSelectedItem();
    }

    public String getSelectedAccompagnement() {
        return (String) accompagnementComboBox.getSelectedItem();
    }

    public String getSelectedDessert() {
        return (String) dessertComboBox.getSelectedItem();
    }
}
