package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

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
    private JButton clearButton;
    private List<IPlat> plats;
    private List<IPlat> accompagnements;
    private List<IPlat> desserts;

    public PanelGauche(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.plats = plats;
        this.accompagnements = accompagnements;
        this.desserts = desserts;

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
        platPanel.add(platButtonPanel, BorderLayout.NORTH);
        platPanel.add(platComboBox, BorderLayout.SOUTH);
        mainPanel.add(platPanel);

        viandeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlatComboBox("Viande");
            }
        });

        volailleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlatComboBox("Volaille");
            }
        });

        poissonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlatComboBox("Poisson");
            }
        });

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
        accompagnementPanel.add(accompagnementButtonPanel, BorderLayout.NORTH);
        accompagnementPanel.add(accompagnementComboBox, BorderLayout.SOUTH);
        mainPanel.add(accompagnementPanel);

        fritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccompagnementComboBox("Frites");
            }
        });

        patesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccompagnementComboBox("Pâtes");
            }
        });

        pommesDeTerreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccompagnementComboBox("Pomme de terre");
            }
        });

        rizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAccompagnementComboBox("Riz");
            }
        });

        JPanel dessertPanel = new JPanel(new BorderLayout());
        dessertPanel.setBorder(BorderFactory.createTitledBorder("Desserts"));

        JPanel dessertButtonPanel = new JPanel(new FlowLayout());
        JRadioButton fruitsButton = new JRadioButton("Fruits");
        JRadioButton glacesButton = new JRadioButton("Glaces");
        JRadioButton patisserieButton = new JRadioButton("Pâtisserie");
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
        dessertPanel.add(dessertButtonPanel, BorderLayout.NORTH);
        dessertPanel.add(dessertComboBox, BorderLayout.SOUTH);
        mainPanel.add(dessertPanel);

        fruitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDessertComboBox("Fruits");
            }
        });

        glacesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDessertComboBox("Glaces");
            }
        });

        patisserieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDessertComboBox("Pâtisserie");
            }
        });

        cafeGourmandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDessertComboBox("Café Gourmand");
            }
        });

        JPanel controlPanel = new JPanel();
        addButton = new JButton("Ajouter Menu");
        validateButton = new JButton("Valider");
        clearButton = new JButton("Effacer");
        controlPanel.add(addButton);
        controlPanel.add(validateButton);
        controlPanel.add(clearButton);

        add(mainPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void updatePlatComboBox(String type) {
        List<String> filteredPlats = plats.stream()
                .filter(plat -> plat.getType().equals(type))
                .map(IPlat::getNom)
                .collect(Collectors.toList());
        platComboBox.setModel(new DefaultComboBoxModel<>(filteredPlats.toArray(new String[0])));
    }

    private void updateAccompagnementComboBox(String type) {
        List<String> filteredAccompagnements = accompagnements.stream()
                .filter(accompagnement -> accompagnement.getType().equals(type))
                .map(IPlat::getNom)
                .collect(Collectors.toList());
        accompagnementComboBox.setModel(new DefaultComboBoxModel<>(filteredAccompagnements.toArray(new String[0])));
    }

    private void updateDessertComboBox(String type) {
        List<String> filteredDesserts = desserts.stream()
                .filter(dessert -> dessert.getType().equals(type))
                .map(IPlat::getNom)
                .collect(Collectors.toList());
        dessertComboBox.setModel(new DefaultComboBoxModel<>(filteredDesserts.toArray(new String[0])));
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getValidateButton() {
        return validateButton;
    }

    public JButton getClearButton() {
        return clearButton;
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
