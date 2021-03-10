/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.*;
import Service.*;
import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
        
        Utilisateur u1 = new Utilisateur ("miso");
        Utilisateur u2 = new Utilisateur ("ziko");
         Utilisateur u3 = new Utilisateur ("bibi");
         Utilisateur u4 = new Utilisateur ("yassino");
         Utilisateur u5 = new Utilisateur ("miral");
         Utilisateur u6 = new Utilisateur ("spenks");
         Utilisateur u7 = new Utilisateur ("lanti");
       Utilisateur u13 = new Utilisateur ("mary");
        
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
            
    
   
     
   S2.afficherCoaches().forEach((e)->System.out.println(e));
    
    //System.out.println(S2.rechercherCoach("miso"));
    //System.out.println(S2.rechercherCoach("zikou")); 
   // System.out.println(S2.rechercherCoach("spenks"));
    
    //S3.afficherClients().forEach((e)->System.out.println(e));
    // System.out.println(S3.rechercherClient("zikou"));
    //System.out.println(S3.rechercherClient("yassouna"));
    //S3.reserverCours(c1);
    //S3.reserverCours(c2);
    //S2.evaluerCoach(u1, 5);
    //S2.evaluerCoach(u1, 6);
    //S2.evaluerCoach(u3, 8);
    //S2.evaluerCoach(u3, 7);
    //S2.evaluerCoach(u4, 9);
    //S2.evaluerCoach(u4, 4);
    
    //S2.evaluerCoach(u7, 10);
    //S2.evaluerCoach(u7, 15);
    
    //S2.evaluerCoach(u13, 10);
   
    
    
        } catch( SQLException e){
            System.out.println(e);
        }
        
        
    }
    
}
