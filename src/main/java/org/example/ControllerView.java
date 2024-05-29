package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerView {
    private PanelGauche panelGauche;
    private PanelDroit panelDroit;
    private List<IPlat> plats;
    private List<IPlat> accompagnements;
    private List<IPlat> desserts;
    private DatabaseManager dbManager;

    public ControllerView(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.plats = plats;
        this.accompagnements = accompagnements;
        this.desserts = desserts;
        this.dbManager = new DatabaseManager();

        JFrame frame = new JFrame("Menu Commande");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        panelGauche = new PanelGauche(plats, accompagnements, desserts);
        panelDroit = new PanelDroit();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        frame.add(splitPane);

        frame.setJMenuBar(createMenuBar());

        addListeners();

        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");
        JMenuItem commandesJour = new JMenuItem("Commandes du jour");
        JMenuItem toutesCommandes = new JMenuItem("Toutes les commandes");

        commandesJour.addActionListener(e -> afficherCommandes(true));
        toutesCommandes.addActionListener(e -> afficherCommandes(false));

        menu.add(commandesJour);
        menu.add(toutesCommandes);
        menuBar.add(menu);

        return menuBar;
    }

    private void afficherCommandes(boolean commandesDuJour) {
        List<Commande> commandes = dbManager.getCommandes(commandesDuJour);

        String[] columnNames = {"ID", "Table", "Plat", "Accompagnement", "Dessert", "Prix Total", "Date", "Payée"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Commande commande : commandes) {
            Object[] row = {
                    commande.getId(),
                    commande.getTableNum(),
                    commande.getPlat(),
                    commande.getAccompagnement(),
                    commande.getDessert(),
                    commande.getPrixTotal(),
                    commande.getDate(),
                    commande.isPayee() ? "Oui" : "Non"
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        table.setDefaultRenderer(Object.class, new CommandeTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Liste des commandes", JOptionPane.INFORMATION_MESSAGE);
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

        JButton clearButton = panelGauche.getClearButton();
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effacerCommande();
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

        // Insérer la commande dans la base de données
        dbManager.insertCommande(table, plat, accompagnement, dessert, prixTotal);
    }

    private void validerCommande() {
        // Logique pour valider la commande
        panelDroit.appendText("Commande validée!");
    }

    private void effacerCommande() {
        // Effacer le contenu du panel droit
        panelDroit.clearText();
    }

    public static void main(String[] args) {
        List<IPlat> plats = MenuLoader.loadPlats("src/main/resources/menu.xml");
        List<IPlat> accompagnements = MenuLoader.loadAccompagnements("src/main/resources/menu.xml");
        List<IPlat> desserts = MenuLoader.loadDesserts("src/main/resources/menu.xml");

        new ControllerView(plats, accompagnements, desserts);
    }
}



