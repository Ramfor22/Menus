package org.example;

public class FruitDecorator extends PlatDecorator {
    private double prixDessert = 3.0;
    public FruitDecorator (IPlat platDecorated) {
        super(platDecorated);
    }


    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec un fruit";
    }


    @Override
    public double getPrix() {
        return platDecorated.getPrix() + prixDessert;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setPrix(double prix) {

    }

    @Override
    public void setType(String type) {

    }

    @Override
    public String getNom() {
        return null;
    }
}
