package org.example;

public class Dessert implements IPlat {
    private String nom;
    private double prix;
    private String type;

    public Dessert(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }



    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public String getPreparation() {
        return nom;
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
