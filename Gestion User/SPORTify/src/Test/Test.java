/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Administrateur;
import Entite.Utilisateur;
import Service.ServiceUtilisateur;
import Service.ServiceAdministrateur;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yassine Karoui
 */
public class Test {
    public static void main(String args[]) {
        try {
            ServiceUtilisateur SU = new ServiceUtilisateur();
            ServiceAdministrateur SA = new ServiceAdministrateur();
            /*******************************************************SERVICE UTILISATEUR*************************************************************/
            /*******************************************************SERVICE UTILISATEUR*************************************************************/
            /*******************************************************SERVICE UTILISATEUR*************************************************************/
            /********************************************************TEST INSCRIPTION AVEC UTILISATEUR*****************************************************************/
            //Utilisateur u1 = new Utilisateur("BATOO","Yassine","Karoui","23859955","yassinekaroui1999@gmail.com","azerty123","1999-01-06","Homme","Client");
            //SU.inscription(u1);
            /********************************************************TEST INSCRIPTION AVEC ATTRIBUT *******************************************************************/
            //SU.inscription(new Utilisateur ("Yasmina","Yasmine","Grati","99851955","yasmine.grati@esprit.tn","azerty123","1998-05-07","Femme","Client"));
            /********************************************************TEST AUTHENTIFICATION AVEC UTILISATEUR***********************************************************/
            //Utilisateur u2 = new Utilisateur("BATOO","azerty123");
            //System.out.println(SU.authentification(u2));
            /********************************************************TEST AUTHENTIFICATION AVEC ATTRIBUT***********************************************************/
            //System.out.println(SU.authentification("BATOsO","azerty123"));
            /*******************************************************TEST AFFICHAGE TABLE BDD*************************************************************/
            //SU.getUsers().forEach((e)->System.out.println(e));
            /*******************************************************TEST AFFICHAGE TABLE AVEC ROLE BDD*************************************************************/
            //SU.getUser("Cient").forEach((e)->System.out.println(e));
            /*******************************************************TEST AFFICHAGE USER AVEC SURNOM*************************************************************/
            //System.out.println(SU.getUser("BATOO"));
            //Utilisateur u4 = new Utilisateur("veveve","Yassvezve","Kavezvzvi","2377755","ya@ded.fr","azertdzdz23","1979-01-06","Homme","Client");
            SU.modifierUtilisateur("veveve",new Utilisateur("BATOO","yassine","Karoui","23859955","yassinekaroui1999@gmail.com","azerty123","1999-01-06","Homme","Coach"));
            /*******************************************************SERVICE ADMINISTRATEUR*************************************************************/
            /*******************************************************SERVICE ADMINISTRATEUR*************************************************************/
            /*******************************************************SERVICE ADMINISTRATEUR*************************************************************/
            /*******************************************************SUPPRIMER UN USER*************************************************************/
            //SA.supprimerUser("ysmina");
            //System.out.println(SU.getUser("Bibi"));
            /*******************************************************SUPPRIMER UN USER*************************************************************/
            //SA.ajouterAdmin(new Administrateur("bonjour@", "dzadaz"));
            //Administrateur ad1 = new Administrateur("pipo@", "dzadzad");
            //SA.ajouterAdmin(ad1);
            
            //System.out.println(SA.authentification(new Administrateur("pipo@gmail.fr", "dzadzad")));
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }

}