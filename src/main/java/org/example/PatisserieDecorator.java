package org.example;

public class PatisserieDecorator extends PlatDecorator {
    private double prixDessert = 5.0;
    public PatisserieDecorator(IPlat platDecorated){
        super(platDecorated);
    }

    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec une pâtisserie";
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
