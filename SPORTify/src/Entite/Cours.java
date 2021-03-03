/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;



/**
 *
 * @author asus
 */
public class Cours {
    private int ID_Cours;
    private String Type_Cours ;
    private String Date;
    private String Heure;
    private String Duree;
    private String MailCoach;
    
    
    public int getID_Cours() {
        return ID_Cours;
    }

    public void setID_Cours(int ID_Cours) {
        this.ID_Cours = ID_Cours;
    }

    public String getType_Cours() {
        return Type_Cours;
    }

    public void setType_Cours(String Type_Cours) {
        this.Type_Cours = Type_Cours;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String Heure) {
        this.Heure = Heure;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public String getMailCoach() {
        return MailCoach;
    }

    public void setMailCoach(String MailCoach) {
        this.MailCoach = MailCoach;
    }


    public Cours() {
    }
    
    

    public Cours(int ID_Cours) {
        this.ID_Cours = ID_Cours;
    }

    public Cours(int ID_Cours, String Type_Cours, String MailCoach) {
        this.ID_Cours = ID_Cours;
        this.Type_Cours = Type_Cours;
        this.MailCoach = MailCoach;
    }

    public Cours(int ID_Cours, String Type_Cours, String Date, String Heure, String Duree, String MailCoach) {
        this.ID_Cours = ID_Cours;
        this.Type_Cours = Type_Cours;
        this.Date = Date;
        this.Heure = Heure;
        this.Duree = Duree;
        this.MailCoach = MailCoach;
    }
    
    

    @Override
    public String toString() {
        return "Cours{" + "ID_Cours=" + ID_Cours + ", Type_Cours=" + Type_Cours + ", Date=" + Date + ", Heure=" + Heure + ", Duree=" + Duree + ", MailCoach=" + MailCoach + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.ID_Cours;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (this.ID_Cours != other.ID_Cours) {
            return false;
        }
        return true;
    }

}