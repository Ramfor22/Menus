package org.example;
import java.util.List;

public class Carte {
    private List<String> plats;
    private List<String> accompagnements;
    private List<String> desserts;

    public Carte(List<String> plats, List<String> accompagnements, List<String> desserts) {
        this.plats = plats;
        this.accompagnements = accompagnements;
        this.desserts = desserts;
    }

    // Getters
    public List<String> getPlats() {
        return plats;
    }

    public List<String> getAccompagnements() {
        return accompagnements;
    }

    public List<String> getDesserts() {
        return desserts;
    }
}
