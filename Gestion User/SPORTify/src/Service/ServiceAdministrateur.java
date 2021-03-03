/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Administrateur;
import Interface.IServiceAdministrateur;
import Utils.DataSource;
import java.sql.*;


/**
 *
 * @author Yassine Karoui
 */
public class ServiceAdministrateur implements IServiceAdministrateur {
        private Connection cnx = DataSource.getInstance().getCnx();
        private Statement ste;
        private ResultSet result;
        private Statement ste0;
    
    

    @Override
    public void ajouterAdmin(Administrateur a) throws SQLException {
        
        if (a.getEmail_admin() == null || a.getMDP_admin() == null){
            System.out.println("\nSaisie incorrecte");
        }else{
            String req0 = "SELECT `Email_admin` FROM `administrateur`";
            ste = cnx.createStatement();
            result = ste.executeQuery(req0);
            while (result.next()){
                if (result.getString(1).equals(a.getEmail_admin())){
                System.out.println("Email deja existant");
                return;
                }
            }
            
            String req = "INSERT INTO `administrateur`(`Email_admin`, `MDP_admin`) VALUES ('"+ a.getEmail_admin()+"','"+a.getMDP_admin()+"')";
            ste0 = cnx.createStatement();
            ste0.executeUpdate(req);
        }
    }

    @Override
    public void ajouterAdmin(String email, String password) throws SQLException {
        if (email == null || password == null){
            System.out.println("\nSaisie incorrecte");
        }else{
            String req0 = "SELECT `Email_admin` FROM `administrateur`";
            ste = cnx.createStatement();
            result = ste.executeQuery(req0);
            while (result.next()){
                if (result.getString(1).equals(email)){
                System.out.println("Email deja existant");
                return;
                }
            }
            
            String req = "INSERT INTO `administrateur`(`Email_admin`, `MDP_admin`) VALUES ('"+ email+"','"+password+"')";
            ste0 = cnx.createStatement();
            ste0.executeUpdate(req);
        }
    }

    @Override
    public int authentification(Administrateur a) throws SQLException {
        int test = 0;
        String req = "SELECT *  FROM `administrateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next() && test == 0) {
            if (result.getString("Email_admin").equals(a.getEmail_admin())
                    && result.getString("MDP_admin").equals(a.getMDP_admin())) {
                test = result.getInt(1);

                return test;
            }
        }
        if (test == 0)
            System.out.println("Utilisateur non existant.");
        return test;
    }

    @Override
    public int authentification(String email, String password) throws SQLException {
       int test = 0;
        String req = "SELECT *  FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next() && test == 0) {
            if ((result.getString("Email_admin").equals(email))
                    && (result.getString("MDP_admin").equals(password))) {
                test = result.getInt(1);

                return test;
            } 

        }
        if (test == 0)
            System.out.println("Utilisateur non existant.");

        return test;
    }

    @Override
    public void supprimerUser(String surnom) throws SQLException {
        
        
        try{
             String req = "DELETE FROM `utilisateur` WHERE `surnom` = '"+ surnom + "'";
        ste = cnx.createStatement();
        ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e);
        } 
    }

   
    
}
    
