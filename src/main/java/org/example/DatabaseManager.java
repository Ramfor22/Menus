package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager() {
        try {
            DatabaseConfig config = DatabaseConfig.loadFromXML();
            this.url = "jdbc:mysql://localhost:" + config.getPort() + "/" + config.getName();
            this.user = config.getUser();
            this.password = config.getPassword();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors du chargement de la configuration de la base de données", e);
        }
    }

    public List<Commande> getCommandes(boolean commandesDuJour) {
        List<Commande> commandes = new ArrayList<>();
        String query = "SELECT * FROM commandes";
        if (commandesDuJour) {
            query += " WHERE DATE(date) = CURDATE()";
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Commande commande = new Commande(
                        rs.getInt("id"),
                        rs.getString("table_num"),
                        rs.getString("plat"),
                        rs.getString("accompagnement"),
                        rs.getString("dessert"),
                        rs.getDouble("prix_total"),
                        rs.getTimestamp("date"),
                        rs.getBoolean("payee")
                );
                commandes.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    public void insertCommande(String table, String plat, String accompagnement, String dessert, double prixTotal) {
        String query = "INSERT INTO commandes (table_num, plat, accompagnement, dessert, prix_total, payee) VALUES (?, ?, ?, ?, ?, false)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, table);
            pstmt.setString(2, plat);
            pstmt.setString(3, accompagnement);
            pstmt.setString(4, dessert);
            pstmt.setDouble(5, prixTotal);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




