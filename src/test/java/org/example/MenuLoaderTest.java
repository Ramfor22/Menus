package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuLoaderTest {

    @Test
    void testChargementMenu() {
        // Utilisation de chemins relatifs pour une meilleure portabilité
        // Assurez-vous que ce chemin relatif est correct par rapport à l'emplacement d'exécution des tests
        String cheminFichierTest = "src\\main\\resources\\menu.xml"; // Ajustez en fonction de la structure de votre projet

        MenuLoader loader = new MenuLoader();
        Carte carte = loader.chargerMenu(cheminFichierTest);

        assertNotNull(carte, "La carte ne devrait pas être null");
        assertFalse(carte.getPlats().isEmpty(), "La liste des plats ne devrait pas être vide");
        assertFalse(carte.getAccompagnements().isEmpty(), "La liste des accompagnements ne devrait pas être vide");
        assertFalse(carte.getDesserts().isEmpty(), "La liste des desserts ne devrait pas être vide");


        //  vérifier qu'un plat spécifique est bien chargé :
        assertTrue(carte.getPlats().contains("Boeuf"), "La carte devrait contenir le plat 'Boeuf'");
    }
}
