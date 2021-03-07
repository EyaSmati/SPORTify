/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.*;
import Service.*;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class Main {
    public static void main(String[]args) throws SQLException{
        try{
            ServiceCoachDansCours S1 = new ServiceCoachDansCours();
            ServiceCoaches S2 = new ServiceCoaches();
            ServiceClients S3 = new ServiceClients();
        
        Utilisateur u1 = new Utilisateur ("miso", "mayssachaouali@gmail.com", "coach");
        Utilisateur u2 = new Utilisateur ("ziko", "youssef.marzouk@gmail.com", "client");
         Utilisateur u3 = new Utilisateur ("bibi", "oumayma.brayek5@gmail.com", "coach");
         Utilisateur u4 = new Utilisateur ("yassino", "yassinekaroui@hotmail.com", "coach");
         Utilisateur u5 = new Utilisateur ("miral", "maram.mekni@gmail.com", "client");
         Utilisateur u6 = new Utilisateur ("spenks", "oussema.chaouali@gmail.com", "proprietaire de salle");
        
        Cours c1 = new Cours(17);
        Cours c2 = new Cours(19);
        Cours c3 = new Cours(20);
        Cours c4 = new Cours(21);
        Cours c5 = new Cours(22);
        
      //S1.ajouterCoachDansCours(c4,u1 );
      //S1.ajouterCoachDansCours(c3, u4);
      
     //S1.ajouterCoachDansCours(c2, u2);
     //S1.ajouterCoachDansCours(c1, u6);
     
     //S1.modifierCoachDansCours(c3,u3);
     
    //S1.supprimerCoachDeCours(c3);
    //S1.supprimerCoachDeCours(c4);
    
   
     
    //S2.afficherCoaches().forEach((e)->System.out.println(e));
    
    //System.out.println(S2.rechercherCoach("miso"));
    //System.out.println(S2.rechercherCoach("zikou")); 
   // System.out.println(S2.rechercherCoach("spenks"));
    
    //S3.afficherClients().forEach((e)->System.out.println(e));
    
   // System.out.println(S3.rechercherClient("zikou"));
    //System.out.println(S3.rechercherClient("yassouna"));
    //S3.reserverCours(c1);
    //S3.reserverCours(c2);
    //S2.evaluerCoach(u1, 5);
    S2.evaluerCoach(u1, 6);
        } catch( SQLException e){
            System.out.println(e);
        }
        
        
    }
    
}
