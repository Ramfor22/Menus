package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    public DatabaseManager() {
        DatabaseConfig config = DatabaseConfig.loadFromXML();
        this.url = "jdbc:mysql://localhost:" + config.getPort() + "/" + config.getName();
        this.user = config.getUser();
        this.password = config.getPassword();
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
}

