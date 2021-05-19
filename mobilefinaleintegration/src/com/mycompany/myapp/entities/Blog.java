/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Yassine Karoui
 */
public class Blog {
    private int id;
    private String titre;
    private String image;
    private String text;
    private String auteur;

    public Blog() {
    }

    public Blog(String titre, String text, String auteur) {
        this.titre = titre;
        this.text = text;
        this.auteur = auteur;
    }

    public Blog(String titre, String image, String text, String auteur) {
        this.titre = titre;
        this.image = image;
        this.text = text;
        this.auteur = auteur;
    }

    public Blog(int id, String titre, String image, String text, String auteur) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.text = text;
        this.auteur = auteur;
    }
     public Blog(int id, String titre, String text, String auteur) {
        this.id = id;
        this.titre = titre;
        this.text = text;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTexte() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", titre=" + titre + ", image=" + image + ", text=" + text + ", auteur=" + auteur + '}';
    }
    


}
