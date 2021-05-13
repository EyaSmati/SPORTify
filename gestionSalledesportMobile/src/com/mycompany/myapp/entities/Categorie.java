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
public class Categorie {
    private String type;
    private String description;
    private String image;
    private  int id;

    public Categorie(String type, String description, String image, int id) {
        this.type = type;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public Categorie() {
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categorie{" + "type=" + type + ", description=" + description + ", image=" + image + ", id=" + id + '}';
    }
    
    
}
