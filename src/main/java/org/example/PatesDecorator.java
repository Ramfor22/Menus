package org.example;

public class PatesDecorator extends PlatDecorator {
    public PatesDecorator (IPlat platDecorated) {
        super(platDecorated);
    }

    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec des pâtes";
    }

    @Override
    public double getPrix() {
        return platDecorated.getPrix() + 2.5;
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
