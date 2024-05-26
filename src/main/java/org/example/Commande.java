package org.example;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int numeroTable;
    private List<IPlat> plats = new ArrayList<>();
    private double prixTotal;

    public Commande(int numeroTable) {
        this.numeroTable = numeroTable;
    }

    public void ajouterPlat(IPlat plat) {
        plats.add(plat);
        prixTotal += plat.getPrix();
    }

    public int getNumeroTable() {
        return numeroTable;
    }

    public double getPrixTotal() {
        // Le prix total est déjà calculé lors de l'ajout de chaque plat
        return prixTotal;
    }

    public List<IPlat> getPlats() {
        return new ArrayList<>(plats); // Retourne une copie pour éviter la modification externe
    }
}
