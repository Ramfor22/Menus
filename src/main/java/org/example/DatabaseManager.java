package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        DatabaseConfig.loadConfig("path/to/database_config.xml");
        String url = "jdbc:mysql://localhost:" + DatabaseConfig.port + "/" + DatabaseConfig.dbName;
        try {
            connection = DriverManager.getConnection(url, DatabaseConfig.user, DatabaseConfig.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Méthode pour ajouter une commande dans la base de données
    public void addCommande(Commande commande) {
        String query = "INSERT INTO commandes (table_num, plat, accompagnement, dessert, prix_total) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, commande.getTableNum());
            stmt.setString(2, commande.getPlat());
            stmt.setString(3, commande.getAccompagnement());
            stmt.setString(4, commande.getDessert());
            stmt.setDouble(5, commande.getPrixTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
