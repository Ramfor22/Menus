package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            DatabaseConfig.loadFromXML(); // Appel sans paramètres
            String url = "jdbc:mysql://localhost:" + DatabaseConfig.getPort() + "/" + DatabaseConfig.getName();
            String user = DatabaseConfig.getUser();
            String password = DatabaseConfig.getPassword();

            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCommande(String table, String plat, String accompagnement, String dessert, double prixTotal) {
        String query = "INSERT INTO commandes (table_num, plat, accompagnement, dessert, prix_total) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, table);
            stmt.setString(2, plat);
            stmt.setString(3, accompagnement);
            stmt.setString(4, dessert);
            stmt.setDouble(5, prixTotal);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
