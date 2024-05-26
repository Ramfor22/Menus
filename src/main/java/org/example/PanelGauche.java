package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelGauche extends JPanel {
    private JComboBox<String> tableComboBox;
    private JComboBox<String> platComboBox;
    private JComboBox<String> accompagnementComboBox;
    private JComboBox<String> dessertComboBox;
    private ButtonGroup platGroup;
    private ButtonGroup accompagnementGroup;
    private ButtonGroup dessertGroup;
    private JButton addButton;
    private JButton validateButton;

    public PanelGauche(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Numéro de Table"));
        tableComboBox = new JComboBox<>();
        for (int i = 1; i <= 20; i++) {
            tableComboBox.addItem("Table " + i);
        }
        tablePanel.add(tableComboBox);
        mainPanel.add(tablePanel);

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
        mainPanel.add(platPanel);

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
        mainPanel.add(accompagnementPanel);

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
        mainPanel.add(dessertPanel);

        JPanel controlPanel = new JPanel();
        addButton = new JButton("Ajouter");
        validateButton = new JButton("Valider");
        controlPanel.add(addButton);
        controlPanel.add(validateButton);

        add(mainPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getValidateButton() {
        return validateButton;
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

    public JComboBox<String> getTableComboBox() {
        return tableComboBox;
    }
}

