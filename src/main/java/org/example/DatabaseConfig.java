package org.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DatabaseConfig {
    public static String user;
    public static String password;
    public static int port;
    public static String dbName;

    public static void loadConfig(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            Element root = document.getDocumentElement();

            user = root.getElementsByTagName("user").item(0).getTextContent();
            password = root.getElementsByTagName("password").item(0).getTextContent();
            port = Integer.parseInt(root.getElementsByTagName("port").item(0).getTextContent());
            dbName = root.getElementsByTagName("name").item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
