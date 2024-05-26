package org.example;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<IPlat> plats;
    private List<IPlat> accompagnements;
    private List<IPlat> desserts;

    public Commande() {
        plats = new ArrayList<>();
        accompagnements = new ArrayList<>();
        desserts = new ArrayList<>();
    }

    public void ajouterPlat(IPlat plat) {
        plats.add(plat);
    }

    public void ajouterAccompagnement(IPlat accompagnement) {
        accompagnements.add(accompagnement);
    }

    public void ajouterDessert(IPlat dessert) {
        desserts.add(dessert);
    }

    public List<IPlat> getPlats() {
        return plats;
    }

    public List<IPlat> getAccompagnements() {
        return accompagnements;
    }

    public List<IPlat> getDesserts() {
        return desserts;
    }

    public void afficherDetails() {
        System.out.println("Plats:");
        for (IPlat plat : plats) {
            System.out.println(" - " + plat.getNom());
        }

        System.out.println("Accompagnements:");
        for (IPlat accompagnement : accompagnements) {
            System.out.println(" - " + accompagnement.getNom());
        }

        System.out.println("Desserts:");
        for (IPlat dessert : desserts) {
            System.out.println(" - " + dessert.getNom());
        }
    }
}
