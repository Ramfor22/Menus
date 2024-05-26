package org.example;

public class PommesDeTerreDecorator extends PlatDecorator {
    public PommesDeTerreDecorator(IPlat platDecorated) {
        super(platDecorated);
    }

    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec des pommes de terre";
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
