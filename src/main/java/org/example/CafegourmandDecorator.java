package org.example;

public class CafegourmandDecorator extends PlatDecorator {
    private double prixDessert = 4.5;
    public CafegourmandDecorator(IPlat platDecorated) {
        super(platDecorated);
    }


    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec un café gourmand";
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
