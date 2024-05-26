package org.example;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.util.List;

public class StartMenu extends JFrame {
    public StartMenu(List<IPlat> plats, List<IPlat> accompagnements, List<IPlat> desserts) {
        this.setTitle("Gestion des Commandes de Restaurant");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        PanelGauche panelGauche = new PanelGauche(plats, accompagnements, desserts);
        PanelDroit panelDroit = new PanelDroit();

        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroit, BorderLayout.EAST);
    }

    public StartMenu() {

    }

    public static void main(String[] args) {
        List<IPlat> plats = MenuLoader.loadPlats("src/main/resources/menu.xml");
        List<IPlat> accompagnements = MenuLoader.loadAccompagnements("src/main/resources/menu.xml");
        List<IPlat> desserts = MenuLoader.loadDesserts("src/main/resources/menu.xml");

        StartMenu menu = new StartMenu(plats, accompagnements, desserts);
        menu.setVisible(true);
    }
}
