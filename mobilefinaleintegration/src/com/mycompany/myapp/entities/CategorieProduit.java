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
public class CategorieProduit {
    private String typecategorie;
    private String description;
    private String image;
    private  int idcategorie;

    public CategorieProduit(String typecategorie, String description, String image, int idcategorie) {
        this.typecategorie = typecategorie;
        this.description = description;
        this.image = image;
        this.idcategorie = idcategorie;
    }

    public CategorieProduit() {
    }

    public String getTypecategorie() {
        return typecategorie;
    }

    public void setTypecategorie(String typecategorie) {
        this.typecategorie = typecategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Override
    public String toString() {
        return "CategorieProduit{" + "typecategorie=" + typecategorie + ", description=" + description + ", image=" + image + ", idcategorie=" + idcategorie + '}';
    }
    

}
