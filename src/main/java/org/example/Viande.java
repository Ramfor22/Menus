package org.example;

public class Viande implements IPlat {
    private double prix;
    private String type;

    // Ajusté pour accepter le prix en tant que paramètre
    public Viande(String type, double prix) {
        this.type = type;
        this.prix = prix; // Utilisez le prix passé en tant que paramètre
    }

    @Override
    public String getPreparation() {
        return "Préparation de viande de type " + type;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getNom() {
        return null;
    }
}

