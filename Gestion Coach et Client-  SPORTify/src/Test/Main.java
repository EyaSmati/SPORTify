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
        
        Utilisateur u1 = new Utilisateur (1,"miso", "mayssachaouali@gmail.com", "coach");
        Utilisateur u2 = new Utilisateur (2,"ziko", "youssef.marzouk@gmail.com", "client");
         Utilisateur u3 = new Utilisateur (5,"bibi", "oumayma.brayek5@gmail.com", "coach");
         Utilisateur u4 = new Utilisateur (3,"yassino", "yassinekaroui@hotmail.com", "coach");
         Utilisateur u5 = new Utilisateur (6,"miral", "maram.mekni@gmail.com", "client");
         Utilisateur u6 = new Utilisateur (7,"spenks", "oussema.chaouali@gmail.com", "proprietaire de salle");
        
        Cours c1 = new Cours(17);
        Cours c2 = new Cours(19);
        Cours c3 = new Cours(20);
        Cours c4 = new Cours(21);
        Cours c5 = new Cours(22);
        
      S1.ajouterCoachDansCours(c4,u1 );
      // S1.ajouterCoachDansCours(c3, u4);
      
     //S1.ajouterCoachDansCours(c2, u2);
     //S1.ajouterCoachDansCours(c1, u6);
     
     //S1.modifierCoachDansCours(c3,u3);
     
    //S1.supprimerCoachDeCours(c3);
    //S1.supprimerCoachDeCours(c4);
    
   
     
    //S1.afficherCoachs().forEach((e)->System.out.println(e));
    
    //System.out.println(S1.rechercherCoach("miso"));
    //System.out.println(S1.rechercherCoach("zikou")); 
   // System.out.println(S1.rechercherCoach("spenks"));
    
    //S1.afficherClients().forEach((e)->System.out.println(e));
    
    //System.out.println(S1.rechercherClient("zikou"));
    //System.out.println(S1.rechercherClient("yassouna"));
    
        
    
        } catch( SQLException e){
            System.out.println(e);
        }
        
        
    }
    
}
