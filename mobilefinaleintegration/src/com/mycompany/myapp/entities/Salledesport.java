/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author asus
 */
public class Salledesport {
    private String idSalle;
    private String nomSalle;
    private String adresse;
    private String region;
    private int hdebut;
    private int hfin;
    private int min;
    private int numtel;

    public Salledesport(String idSalle, String nomSalle, String adresse, String region, int hdebut, int hfin, int min, int numtel) {
        this.idSalle = idSalle;
        this.nomSalle = nomSalle;
        this.adresse = adresse;
        this.region = region;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.min = min;
        this.numtel = numtel;
    }

    public Salledesport() {
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getHdebut() {
        return hdebut;
    }

    public void setHdebut(int hdebut) {
        this.hdebut = hdebut;
    }

    public int getHfin() {
        return hfin;
    }

    public void setHfin(int hfin) {
        this.hfin = hfin;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }
    
      @Override
    public String toString() {
        return "Salledesport{" + "IdSalle=" + idSalle + ", NomSalle=" + nomSalle + ", Adresse=" + adresse + ", Région=" + region + ", Heure Début=" + hdebut + ", Heure Fin=" + hfin + ", Min=" + min + ", N°Tel=" + numtel + '}';
    }
}
