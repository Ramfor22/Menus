package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerView {
    private JFrame frame;
    private PanelGauche panelGauche;
    private PanelDroit panelDroit;
    private Commande commande;

    public ControllerView(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        frame = new JFrame("Gestion des Commandes de Restaurant");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panelGauche = new PanelGauche(plats, accompagnements, desserts);
        panelDroit = new PanelDroit();

        frame.add(panelGauche, BorderLayout.WEST);
        frame.add(panelDroit, BorderLayout.CENTER);

        commande = new Commande();

        addListeners();

        frame.setVisible(true);
    }

    private void addListeners() {
        JButton addButton = panelGauche.getAddButton();
        JButton validateButton = panelGauche.getValidateButton();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterMenu();
            }
        });

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

        IPlat selectedPlat = new Plat(plat, 0, "");
        IPlat selectedAccompagnement = new Plat(accompagnement, 0, "");
        IPlat selectedDessert = new Plat(dessert, 0, "");

        if (selectedPlat != null) {
            commande.ajouterPlat(selectedPlat);
        }
        if (selectedAccompagnement != null) {
            commande.ajouterAccompagnement(selectedAccompagnement);
        }
        if (selectedDessert != null) {
            commande.ajouterDessert(selectedDessert);
        }

        System.out.println("Menu ajouté pour " + table + ": Plat - " + plat + ", Accompagnement - " + accompagnement + ", Dessert - " + dessert);
    }

    private void validerCommande() {
        StringBuilder details = new StringBuilder();
        details.append("Commande validée:\n");
        details.append("Plats:\n");
        for (IPlat plat : commande.getPlats()) {
            details.append(" - ").append(plat.getNom()).append("\n");
        }

        details.append("Accompagnements:\n");
        for (IPlat accompagnement : commande.getAccompagnements()) {
            details.append(" - ").append(accompagnement.getNom()).append("\n");
        }

        details.append("Desserts:\n");
        for (IPlat dessert : commande.getDesserts()) {
            details.append(" - ").append(dessert.getNom()).append("\n");
        }

        panelDroit.afficherDetails(details.toString());
    }

    public static void main(String[] args) {
        List<IPlat> plats = MenuLoader.loadPlats("src/main/resources/menu.xml");
        List<IPlat> accompagnements = MenuLoader.loadAccompagnements("src/main/resources/menu.xml");
        List<IPlat> desserts = MenuLoader.loadDesserts("src/main/resources/menu.xml");

        new ControllerView(plats, accompagnements, desserts);
    }
}
