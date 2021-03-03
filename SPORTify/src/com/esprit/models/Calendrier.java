/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author lenovo
 */
public class Calendrier {

    private int ID_Cours;
    private String Type_Cours;
    private String Date;
    private String Heure;

    public Calendrier() {
    }

    public Calendrier(int ID_Cours, String Type_Cours, String Date, String Heure) {
        this.ID_Cours = ID_Cours;
        this.Type_Cours = Type_Cours;
        this.Date = Date;
        this.Heure = Heure;

    }

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

    @Override
    public String toString() {
        return "Calendrier{" + "ID_Cours=" + ID_Cours + ", Type_Cours=" + Type_Cours + ", Date=" + Date + ", Heure=" + Heure + '}';
    }

    public static void main(String[] args) {
        //création de l'objet GregorianCalendar
        GregorianCalendar d = new GregorianCalendar();
        //recupere le jour du mois
        int mois = d.get(Calendar.MONTH);
        //recupere le jour d'aujourd'hui
        int aujourdhui = d.get(Calendar.DAY_OF_MONTH);
        //indique le permier jour du mois
        d.set(Calendar.DAY_OF_MONTH, 1);
        //recupere les jours de de la semaine
        int jourdeweekend = d.get(Calendar.DAY_OF_WEEK);
        //imprime les noms des jours
        System.out.println("Dim Lun Mar Mer Jeu Ven Sam");
        //initialise la seconde ligne du calendrier
        for (int i = Calendar.SUNDAY; i < jourdeweekend; i++) {
            System.out.print("    ");
        }
        do {
            //regle un petit problème et imprime les numéros des jours
            int jour = d.get(Calendar.DAY_OF_MONTH);
            if (jour < 10) {
                System.out.print(" ");
            }
            System.out.print(jour);

            //si le jour est celui d'aujourd'hui une étoile l'indiquera
            if (jour == aujourdhui) {
                System.out.print("* ");
            } else //sinon rien ne sera ajouter
            {
                System.out.print("  ");
            }
            //chaque samedi il y a un retour à la ligne
            if (jourdeweekend == Calendar.SATURDAY) {
                System.out.println();
            }
            //permet de changer de jour tous les jours
            d.add(Calendar.DAY_OF_MONTH, 1);
            //remet à jour les jours de semaine à chaque changement de jour
            jourdeweekend = d.get(Calendar.DAY_OF_WEEK);
        } //tout cela si le mois est égale au mois en cours
        while (d.get(Calendar.MONTH) == mois);

        //imprime la derniere fin de ligne
        if (jourdeweekend != Calendar.SUNDAY) {
            System.out.println();
        }
    }
}
