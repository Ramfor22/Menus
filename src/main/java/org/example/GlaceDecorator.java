package org.example;

public class GlaceDecorator extends PlatDecorator {
    public GlaceDecorator(IPlat platDecorated) {
        super(platDecorated);
    }

    @Override
    public String getPreparation() {
        return super.getPreparation() + " avec de la glace";
    }

    @Override
    public double getPrix() {
        return platDecorated.getPrix() + 2.5;
    }

    @Override
    public String getType() {
        return platDecorated.getType();
    }

    @Override
    public void setPrix(double prix) {
        platDecorated.setPrix(prix);
    }

    @Override
    public void setType(String type) {
        platDecorated.setType(type);
    }

    @Override
    public String getNom() {
        return platDecorated.getNom() + " (avec glace)";
    }
}

