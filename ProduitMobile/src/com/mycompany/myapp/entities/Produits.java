/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author user
 */
public class Produits {
    private String id;
    private String type;
    private String libelle;
    private  int quantites;
    private int prix;

    public Produits() {
    }

    public Produits(String id, String type, String libelle, int quantites, int prix) {
        this.id = id;
        this.type = type;
        this.libelle = libelle;
        this.quantites = quantites;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantites() {
        return quantites;
    }

    public void setQuantites(int quantites) {
        this.quantites = quantites;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produits{" + "id=" + id + ", type=" + type + ", libelle=" + libelle + ", quantites=" + quantites + ", prix=" + prix + '}';
    }
     

}