package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerView {
    private PanelGauche panelGauche;
    private PanelDroit panelDroit;
    private List<IPlat> plats;
    private List<IPlat> accompagnements;
    private List<IPlat> desserts;

    public ControllerView(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.plats = plats;
        this.accompagnements = accompagnements;
        this.desserts = desserts;

        JFrame frame = new JFrame("Menu Commande");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        panelGauche = new PanelGauche(plats, accompagnements, desserts);
        panelDroit = new PanelDroit();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        frame.add(splitPane);

        addListeners();

        frame.setVisible(true);
    }

    private void addListeners() {
        JButton addButton = panelGauche.getAddButton();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterMenu();
            }
        });

        JButton validateButton = panelGauche.getValidateButton();
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validerCommande();
            }
        });
    }

    private void ajouterMenu() {
        String table = (String) panelGauche.getTableComboBox().getSelectedItem();
        String plat = panelGauche.getSelectedPlat();
        String accompagnement = panelGauche.getSelectedAccompagnement();
        String dessert = panelGauche.getSelectedDessert();

        IPlat selectedPlat = plats.stream().filter(p -> p.getNom().equals(plat)).findFirst().orElse(null);
        IPlat selectedAccompagnement = accompagnements.stream().filter(a -> a.getNom().equals(accompagnement)).findFirst().orElse(null);
        IPlat selectedDessert = desserts.stream().filter(d -> d.getNom().equals(dessert)).findFirst().orElse(null);

        double prixPlat = selectedPlat != null ? selectedPlat.getPrix() : 0;
        double prixAccompagnement = selectedAccompagnement != null ? selectedAccompagnement.getPrix() : 0;
        double prixDessert = selectedDessert != null ? selectedDessert.getPrix() : 0;
        double prixTotal = prixPlat + prixAccompagnement + prixDessert;

        panelDroit.appendText("Table : " + table);
        panelDroit.appendText("Plat : " + plat + " - " + prixPlat + "€");
        panelDroit.appendText("Accompagnement : " + accompagnement + " - " + prixAccompagnement + "€");
        panelDroit.appendText("Dessert : " + dessert + " - " + prixDessert + "€");
        panelDroit.appendText("Prix total : " + prixTotal + "€");

        panelDroit.setPrixPlat(prixPlat);
        panelDroit.setPrixAccompagnement(prixAccompagnement);
        panelDroit.setPrixDessert(prixDessert);
        panelDroit.setPrixTotal(prixTotal);
    }

    private void validerCommande() {
        // Logique pour valider la commande
        panelDroit.appendText("Commande validée!");
    }

    public static void main(String[] args) {
        List<IPlat> plats = MenuLoader.loadPlats("src/main/resources/menu.xml");
        List<IPlat> accompagnements = MenuLoader.loadAccompagnements("src/main/resources/menu.xml");
        List<IPlat> desserts = MenuLoader.loadDesserts("src/main/resources/menu.xml");

        new ControllerView(plats, accompagnements, desserts);
    }
}
