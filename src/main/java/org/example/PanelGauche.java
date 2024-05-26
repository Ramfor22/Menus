package org.example;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;

public class PanelGauche extends JPanel {
    private JComboBox<String> tableComboBox;
    private JComboBox<String> platComboBox;
    private JComboBox<String> accompagnementComboBox;
    private JComboBox<String> dessertComboBox;
    private ButtonGroup platGroup;
    private ButtonGroup accompagnementGroup;
    private ButtonGroup dessertGroup;

    public PanelGauche(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.setLayout(new BorderLayout());
        this.add(this.createMainPanel(plats, accompagnements, desserts), BorderLayout.CENTER);
        this.add(this.createControlPanel(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        JPanel mainPanel = new JPanel(new GridLayout(4, 1)); // Changer GridLayout pour 4 rangées
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Choisissez votre menu", TitledBorder.CENTER, TitledBorder.TOP));
        mainPanel.add(this.createTablePanel());
        mainPanel.add(this.createPlatPanel(plats));
        mainPanel.add(this.createAccompagnementPanel(accompagnements));
        mainPanel.add(this.createDessertPanel(desserts));
        return mainPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Numéro de Table"));
        tableComboBox = new JComboBox<>();
        for (int i = 1; i <= 20; i++) { // Ajouter 20 tables pour exemple
            tableComboBox.addItem("Table " + i);
        }
        tablePanel.add(tableComboBox, BorderLayout.CENTER);
        return tablePanel;
    }

    private JPanel createPlatPanel(List<IPlat> plats) {
        JPanel platPanel = new JPanel(new BorderLayout());
        platPanel.setBorder(BorderFactory.createTitledBorder("Plats"));

        JPanel platButtonPanel = new JPanel(new FlowLayout());
        JRadioButton viandeButton = new JRadioButton("Viandes");
        JRadioButton volailleButton = new JRadioButton("Volaille");
        JRadioButton poissonButton = new JRadioButton("Poisson");

        platGroup = new ButtonGroup();
        platGroup.add(viandeButton);
        platGroup.add(volailleButton);
        platGroup.add(poissonButton);

        platButtonPanel.add(viandeButton);
        platButtonPanel.add(volailleButton);
        platButtonPanel.add(poissonButton);

        platComboBox = new JComboBox<>();
        for (IPlat plat : plats) {
            platComboBox.addItem(plat.getNom());
        }

        platPanel.add(platButtonPanel, BorderLayout.NORTH);
        platPanel.add(platComboBox, BorderLayout.SOUTH);

        return platPanel;
    }

    private JPanel createAccompagnementPanel(List<IPlat> accompagnements) {
        JPanel accompagnementPanel = new JPanel(new BorderLayout());
        accompagnementPanel.setBorder(BorderFactory.createTitledBorder("Accompagnements"));

        JPanel accompagnementButtonPanel = new JPanel(new FlowLayout());
        JRadioButton fritesButton = new JRadioButton("Frites");
        JRadioButton patesButton = new JRadioButton("Pâtes");
        JRadioButton pommesDeTerreButton = new JRadioButton("Pomme de terre");
        JRadioButton rizButton = new JRadioButton("Riz");

        accompagnementGroup = new ButtonGroup();
        accompagnementGroup.add(fritesButton);
        accompagnementGroup.add(patesButton);
        accompagnementGroup.add(pommesDeTerreButton);
        accompagnementGroup.add(rizButton);

        accompagnementButtonPanel.add(fritesButton);
        accompagnementButtonPanel.add(patesButton);
        accompagnementButtonPanel.add(pommesDeTerreButton);
        accompagnementButtonPanel.add(rizButton);

        accompagnementComboBox = new JComboBox<>();
        for (IPlat accompagnement : accompagnements) {
            accompagnementComboBox.addItem(accompagnement.getNom());
        }

        accompagnementPanel.add(accompagnementButtonPanel, BorderLayout.NORTH);
        accompagnementPanel.add(accompagnementComboBox, BorderLayout.SOUTH);

        return accompagnementPanel;
    }

    private JPanel createDessertPanel(List<IPlat> desserts) {
        JPanel dessertPanel = new JPanel(new BorderLayout());
        dessertPanel.setBorder(BorderFactory.createTitledBorder("Desserts"));

        JPanel dessertButtonPanel = new JPanel(new FlowLayout());
        JRadioButton fruitsButton = new JRadioButton("Fruits");
        JRadioButton glacesButton = new JRadioButton("Glaces");
        JRadioButton patisserieButton = new JRadioButton("Patisserie");
        JRadioButton cafeGourmandButton = new JRadioButton("Café Gourmand");

        dessertGroup = new ButtonGroup();
        dessertGroup.add(fruitsButton);
        dessertGroup.add(glacesButton);
        dessertGroup.add(patisserieButton);
        dessertGroup.add(cafeGourmandButton);

        dessertButtonPanel.add(fruitsButton);
        dessertButtonPanel.add(glacesButton);
        dessertButtonPanel.add(patisserieButton);
        dessertButtonPanel.add(cafeGourmandButton);

        dessertComboBox = new JComboBox<>();
        for (IPlat dessert : desserts) {
            dessertComboBox.addItem(dessert.getNom());
        }

        dessertPanel.add(dessertButtonPanel, BorderLayout.NORTH);
        dessertPanel.add(dessertComboBox, BorderLayout.SOUTH);

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
}
