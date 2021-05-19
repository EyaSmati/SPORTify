/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author lenovo
 */
public class evenement {

    private int idEvennement;
    private String nomEvennement;
    private int nbplaces;
    private String description;
    private String date;
    private String nomSalle;

    public evenement(int idEvennement, String nomEvennement, int nbplaces, String description, String date, String nomSalle) {
        this.idEvennement = idEvennement;
        this.nomEvennement = nomEvennement;
        this.nbplaces = nbplaces;
        this.description = description;
        this.date = date;
        this.nomSalle = nomSalle;
    }

    public evenement(String nomEvennement, int nbplaces, String description, String date, String nomSalle) {
        this.nomEvennement = nomEvennement;
        this.nbplaces = nbplaces;
        this.description = description;
        this.date = date;
        this.nomSalle = nomSalle;
    }

    public evenement() {
    }

    public int getIdEvennement() {
        return idEvennement;
    }

    public void setIdEvennement(int idEvennement) {
        this.idEvennement = idEvennement;
    }

    public String getNomEvennement() {
        return nomEvennement;
    }

    public void setNomEvennement(String nomEvennement) {
        this.nomEvennement = nomEvennement;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    @Override
    public String toString() {
        return "evenement{" + "idEvennement=" + idEvennement + ", nomEvennement=" + nomEvennement + ", nbplaces=" + nbplaces + ", description=" + description + ", date=" + date + ", nomSalle=" + nomSalle + '}';

    }

}
