/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.models.Calendrier;
import com.esprit.services.ServiceCalendrier;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MainProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        ServiceCalendrier calend = new ServiceCalendrier();

//        calend.AjouterCoursDansCalendrier(new Calendrier("fitness", "2021-03-12", "17"));
//        calend.AjouterCoursDansCalendrier(new Calendrier("aerobique", "2021-03-9", "10"));
//        calend.AjouterCoursDansCalendrier(new Calendrier("karate", "2021-03-14", "13"));
//        calend.AjouterCoursDansCalendrier(new Calendrier("yoga", "2021-03-20", "9"));
//        calend.AjouterCoursDansCalendrier(new Calendrier("gym", "2021-03-23", "11"));
//        calend.AjouterCoursDansCalendrier(new Calendrier("aerobique", "2021-03-11", "19"));

//        calend.AjouterCoursDansCalendrier(new Calendrier("judo", "2021-03-06", "15"));
//         calend.AjouterCoursDansCalendrier(new Calendrier("danse", "2021-03-07", "9"));
//           calend.AjouterCoursDansCalendrier(new Calendrier("taekwondo", "2021-03-15", "8"));

//         calend.supprimerCoursDansCalendrier(new Calendrier(4, "yoga", "2021-03-20", "9"));
//         calend.supprimerCoursDansCalendrier(new Calendrier(1,"fitness", "2021-03-12", "17"));

//          calend.modifierCoursDansCalendrier(new Calendrier(3, "zomba", "2021-03-08", "16"));
//          calend.modifierCoursDansCalendrier(new Calendrier(5, "gymnastique", "2021-03-24", "14"));

//           calend.rechercherCoursDansCalendrier().forEach(System.out::println); 

        calend.afficherCalendrier().forEach(System.out::println);

    }

}
