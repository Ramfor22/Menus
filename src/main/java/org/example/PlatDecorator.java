package org.example;

public abstract class PlatDecorator implements IPlat {
    protected IPlat platDecorated;

    public PlatDecorator(IPlat platDecorated) {
        this.platDecorated = platDecorated;
    }

    @Override
    public String getPreparation() {
        return platDecorated.getPreparation();
    }


}
