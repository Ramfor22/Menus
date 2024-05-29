package org.example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private String tableNum;
    private String plat;
    private String accompagnement;
    private String dessert;
    private double prixTotal;
    private Timestamp date;
    private boolean payee;

    public Commande(int id, String tableNum, String plat, String accompagnement, String dessert, double prixTotal, Timestamp date, boolean payee) {
        this.id = id;
        this.tableNum = tableNum;
        this.plat = plat;
        this.accompagnement = accompagnement;
        this.dessert = dessert;
        this.prixTotal = prixTotal;
        this.date = date;
        this.payee = payee;
    }

    public int getId() {
        return id;
    }

    public String getTableNum() {
        return tableNum;
    }

    public String getPlat() {
        return plat;
    }

    public String getAccompagnement() {
        return accompagnement;
    }

    public String getDessert() {
        return dessert;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public Timestamp getDate() {
        return date;
    }

    public boolean isPayee() {
        return payee;
    }
}

