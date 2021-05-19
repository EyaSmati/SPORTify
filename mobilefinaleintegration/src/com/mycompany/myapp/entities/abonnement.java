/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class abonnement {

    private int idAbonnement;
    private String typeAbonnement;
    private int prixAbonnement;
    private String datecreation;
    private String surnomUser;

    public abonnement(int idAbonnement, String typeAbonnement, int prixAbonnement, String datecreation, String surnomUser) {
        this.idAbonnement = idAbonnement;
        this.typeAbonnement = typeAbonnement;
        this.prixAbonnement = prixAbonnement;
        this.datecreation = datecreation;
        this.surnomUser = surnomUser;
    }

    public abonnement(String typeAbonnement, int prixAbonnement, String datecreation, String surnomUser) {
        this.typeAbonnement = typeAbonnement;
        this.prixAbonnement = prixAbonnement;
        this.datecreation = datecreation;
        this.surnomUser = surnomUser;
    }

    public abonnement() {
    }

    public int getIdAbonnement() {
        return idAbonnement;
    }

    public void setIdAbonnement(int idAbonnement) {
        this.idAbonnement = idAbonnement;
    }

    public String getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(String typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

    public int getPrixAbonnement() {
        return prixAbonnement;
    }

    public void setPrixAbonnement(int prixAbonnement) {
        this.prixAbonnement = prixAbonnement;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getSurnomUser() {
        return surnomUser;
    }

    public void setSurnomUser(String surnomUser) {
        this.surnomUser = surnomUser;
    }

    @Override
    public String toString() {
        return "abonnement{" + "idAbonnement=" + idAbonnement + ", typeAbonnement=" + typeAbonnement + ", prixAbonnement=" + prixAbonnement + ", datecreation=" + datecreation + ", surnomUser=" + surnomUser + '}';
    }

}
