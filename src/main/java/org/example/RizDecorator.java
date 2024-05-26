package org.example;

public class RizDecorator extends PlatDecorator {
    public RizDecorator (IPlat platDecorated) {
        super(platDecorated);
    }

    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec du riz";
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
