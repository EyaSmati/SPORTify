/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import com.esprit.models.SalleDeSport;
import com.esprit.services.ServiceSalleDeSport;


/**
 *
 * @author aissa
 */
public class MainProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        SalleDeSport s =new SalleDeSport(999, "ArenaGym","11 rue Ali Triki,El ouardia","Tunis",12,13,00,76200130);
        SalleDeSport s1 =new SalleDeSport(123, "CaliforniaGym","Urban Park, 8ieme étage, Centre Urbain Nord","Ariana",9,10,30,36777320);
        SalleDeSport s2 =new SalleDeSport(400, "CaliforniaGym","Urban Park, 8ieme étage, Centre Urbain Nord","Ariana",14,15,10,55022100);
       
         //ss.ajouter(s);
         //ss.ajouter(s1);
         //ss.ajouter(s2);
         
         //ss.afficher().forEach(System.out::println);
         
         //ss.supprimer(s);
         //ss.supprimer(s1);
         //ss.supprimer(s2);
         
         //ss.afficher().forEach(System.out::println);
         
         //ss.modifier(s);
         //ss.modifier(s1);
         //ss.modifier(s2);
         
         //ss.afficher().forEach(System.out::println);
         
         //ss.rechercherParRegion("Ariana").forEach(System.out::println);
         //ss.rechercherParNom("CaliforniaGym").forEach(System.out::println);
         
        //ss.TrierParNom().forEach(System.out::println);
        //ss.TrierParRegion().forEach(System.out::println);
        //ss.nombreSalleDeSport();
        
    }
    
}
