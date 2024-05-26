package org.example;

public class PlatFactory {

    // Version existante qui utilise un prix par défaut
    public static IPlat getPlat(String type) {
        // Ajoutez ici un prix par défaut pour chaque type de plat
        return getPlat(type, 10.0); // Utilisez 10.0 comme prix par défaut, par exemple
    }

    // Nouvelle surcharge permettant de spécifier un prix
    public static IPlat getPlat(String type, double prix) {
        if (type == null) {
            return null;
        }
        switch (type.toUpperCase()) {
            case "POISSON":
                return new Poisson(type, prix);
            case "VIANDE":
                return new Viande(type, prix);
            case "VOLAILLE":
                return new Volaille(type, prix);
            default:
                return null;
        }
    }
}
