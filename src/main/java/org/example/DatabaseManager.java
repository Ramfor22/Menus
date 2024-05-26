package org.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            // Charger la configuration de la base de données depuis le fichier XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(getClass().getClassLoader().getResourceAsStream("db_config.xml"));

            Element root = doc.getDocumentElement();
            String user = root.getElementsByTagName("user").item(0).getTextContent();
            String password = root.getElementsByTagName("password").item(0).getTextContent();
            String port = root.getElementsByTagName("port").item(0).getTextContent();
            String dbName = root.getElementsByTagName("name").item(0).getTextContent();

            String url = "jdbc:mysql://localhost:" + port + "/" + dbName;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
