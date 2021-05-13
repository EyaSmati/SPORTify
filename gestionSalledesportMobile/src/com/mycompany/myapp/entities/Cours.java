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
public class Cours {
    private String ID_Cours;
    private String Type_Cours;
    private String Date;
    private  float Heure;
    private int Duree;
     private String MailCoach;
     private String nomSalledeSport;
     private String qrcode;
 private int Place_Disponible;

    public Cours(String ID_Cours, String Type_Cours, String Date, float Heure, int Duree, String MailCoach, String nomSalledeSport, int Place_Disponible,String qrcode) {
        this.ID_Cours = ID_Cours;
        this.Type_Cours = Type_Cours;
        this.Date = Date;
        this.Heure = Heure;
        this.Duree = Duree;
        this.MailCoach = MailCoach;
        this.nomSalledeSport = nomSalledeSport;
        this.qrcode = qrcode;
        this.Place_Disponible = Place_Disponible;
    }

    public Cours(String ID_Cours, String Type_Cours, String Date, float Heure, int Duree, String MailCoach, String nomSalledeSport, int Place_Disponible) {
        this.ID_Cours = ID_Cours;
        this.Type_Cours = Type_Cours;
        this.Date = Date;
        this.Heure = Heure;
        this.Duree = Duree;
        this.MailCoach = MailCoach;
        this.nomSalledeSport = nomSalledeSport;
        this.Place_Disponible = Place_Disponible;
    }
     public Cours(String ID_Cours) {
        this.ID_Cours = ID_Cours;
    }
       public Cours() {
      
    }

    public String getIdCours() {
        return ID_Cours;
    }

    public void setIdCours(String ID_Cours) {
        this.ID_Cours = ID_Cours;
    }

    public String getTypeCours() {
        return Type_Cours;
    }

    public void setTypeCours(String Type_Cours) {
        this.Type_Cours = Type_Cours;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public float getHeure() {
        return Heure;
    }

    public void setHeure(float Heure) {
        this.Heure = Heure;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }

    public String getMailCoach() {
        return MailCoach;
    }

    public void setMailCoach(String MailCoach) {
        this.MailCoach = MailCoach;
    }

    public String getNomSalledeSport() {
        return nomSalledeSport;
    }

    public void setNomSalledeSport(String nomSalledeSport) {
        this.nomSalledeSport = nomSalledeSport;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public int getPlace_Disponible() {
        return Place_Disponible;
    }

    public void setPlace_Disponible(int Place_Disponible) {
        this.Place_Disponible = Place_Disponible;
    }

    @Override
    public String toString() {
        return "Cours{" + "ID_Cours=" + ID_Cours + ", Type_Cours=" + Type_Cours + ", Date=" + Date + ", Heure=" + Heure + ", Duree=" + Duree + ", MailCoach=" + MailCoach + ", nomSalledeSport=" + nomSalledeSport + ", qrcode=" + qrcode + ", Place_Disponible=" + Place_Disponible + '}';
    }
 
  
    
    
}
