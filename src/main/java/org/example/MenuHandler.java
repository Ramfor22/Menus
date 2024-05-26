package org.example;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class MenuHandler extends DefaultHandler {
    private List<String> plats = new ArrayList<>();
    private List<String> accompagnements = new ArrayList<>();
    private List<String> desserts = new ArrayList<>();
    private boolean inPlat = false;
    private boolean inAccompagnement = false;
    private boolean inDessert = false;


    public List<String> getPlats() {
        return plats;
    }

    public List<String> getAccompagnements() {
        return accompagnements;
    }

    public List<String> getDesserts() {
        return desserts;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "Plat":
                inPlat = true;
                break;
            case "Accompagnement":
                inAccompagnement = true;
                break;
            case "Dessert":
                inDessert = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "Plat":
                inPlat = false;
                break;
            case "Accompagnement":
                inAccompagnement = false;
                break;
            case "Dessert":
                inDessert = false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inPlat) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                plats.add(content); // Ajoutez le nom du plat à la liste
            }
        } else if (inAccompagnement) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                accompagnements.add(content); // Ajoutez le nom de l'accompagnement à la liste
            }
        } else if (inDessert) {
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                desserts.add(content); // Ajoutez le nom du dessert à la liste
            }
        }
    }
}
