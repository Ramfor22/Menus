package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DatabaseConfig {
    private static String user;
    private static String password;
    private static String port;
    private static String name;

    public static void loadFromXML() throws Exception {
        File file = new File("src/main/resources/db_config.xml"); // Chemin relatif au fichier XML
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        doc.getDocumentElement().normalize();

        Element databaseElement = (Element) doc.getElementsByTagName("database").item(0);

        user = databaseElement.getElementsByTagName("user").item(0).getTextContent();
        password = databaseElement.getElementsByTagName("password").item(0).getTextContent();
        port = databaseElement.getElementsByTagName("port").item(0).getTextContent();
        name = databaseElement.getElementsByTagName("name").item(0).getTextContent();
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPort() {
        return port;
    }

    public static String getName() {
        return name;
    }
}

