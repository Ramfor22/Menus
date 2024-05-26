package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuLoader {
    public static List<IPlat> loadPlats(String filePath) {
        List<IPlat> plats = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList platsList = doc.getElementsByTagName("plat");
            for (int temp = 0; temp < platsList.getLength(); temp++) {
                Node node = platsList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    double prix = Double.parseDouble(element.getElementsByTagName("prix").item(0).getTextContent());
                    plats.add(new Plat(nom, prix));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plats;
    }

    public static List<IPlat> loadAccompagnements(String filePath) {
        List<IPlat> accompagnements = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList accompagnementsList = doc.getElementsByTagName("accompagnement");
            for (int temp = 0; temp < accompagnementsList.getLength(); temp++) {
                Node node = accompagnementsList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    double prix = Double.parseDouble(element.getElementsByTagName("prix").item(0).getTextContent());
                    accompagnements.add(new Accompagnement(nom, prix));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accompagnements;
    }

    public static List<IPlat> loadDesserts(String filePath) {
        List<IPlat> desserts = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList dessertsList = doc.getElementsByTagName("dessert");
            for (int temp = 0; temp < dessertsList.getLength(); temp++) {
                Node node = dessertsList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                    double prix = Double.parseDouble(element.getElementsByTagName("prix").item(0).getTextContent());
                    desserts.add(new Dessert(nom, prix));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desserts;
    }
}

