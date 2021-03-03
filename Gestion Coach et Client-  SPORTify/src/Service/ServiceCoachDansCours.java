/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.sql.Statement;
import java.sql.ResultSet;
import Entite.Utilisateur;
import Entite.Cours;
import Utils.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.IService;

/**
 *
 * @author asus
 */
public class ServiceCoachDansCours implements IService {
    
    Connection cnx = DataSource.getInstance().getConnection();;
    Statement stm, stm1;

    @Override
    public void ajouterCoachDansCours(Cours c, Utilisateur u) throws SQLException {
        
        
        if(u.getRole().equals("coach")){
            String req = "Update `cours`  set `MailCoach` ='" + u.getEmail() +"' WHERE `ID_Cours` = '"+c.getID_Cours()+"'"; 
            stm = cnx.createStatement();
            stm.executeUpdate(req);
            }else{
          System.out.println("l'utilisateur n est pas un coach");
        }
        
        }

    @Override
    public void supprimerCoachDeCours(Cours c) throws SQLException {
         
            String req = "Update `cours`  set `MailCoach` = 'NULL' WHERE `ID_Cours` = '"+c.getID_Cours()+"'"; 
            stm = cnx.createStatement();
            stm.executeUpdate(req);
            
        
        }

    @Override
    public void modifierCoachDansCours(Cours c, Utilisateur u) throws SQLException {
        if(u.getRole().equals("coach")){
            String req1 = "Update `cours`  set `MailCoach` ='" + u.getEmail() +"' WHERE `ID_Cours` = '"+c.getID_Cours()+"'"; 
            stm = cnx.createStatement();
            stm.executeUpdate(req1);
        }else{
          System.out.println("l'utilisateur n est pas un coach");
        }
    }

     public  List<Utilisateur> afficherCoachs() throws SQLException{
        ArrayList<Utilisateur> listCoach = new ArrayList<>();
        String req = "SELECT * FROM `utilisateur` WHERE `role` = 'coach'";
        stm = cnx.createStatement();
        ResultSet result = stm.executeQuery(req);
        while (result.next()) {
            listCoach.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10)));
        }
        
        return listCoach;
   }
     public Utilisateur rechercherCoach(String surnom) throws SQLException {
        Utilisateur u = null;
        String req = "SELECT * FROM `utilisateur` WHERE ((`surnom` = '" + surnom + "') && (`role` = 'coach'))";
        stm = cnx.createStatement();
        ResultSet result = stm.executeQuery(req);
        
            while (result.next()) {
            u = new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10));
        }
        if (u == null){
            System.out.println("Coach introuvable");
        } 
        return u;  
    }
     public  List<Utilisateur> afficherClients() throws SQLException{
        ArrayList<Utilisateur> listClients = new ArrayList<>();
        String req = "SELECT * FROM `utilisateur` WHERE `role` = 'client'";
        stm = cnx.createStatement();
        ResultSet result = stm.executeQuery(req);
        while (result.next()) {
            listClients.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10)));
        }
        
        return listClients;
   }

     public Utilisateur rechercherClient(String surnom) throws SQLException {
        Utilisateur u = null;
        String req = "SELECT * FROM `utilisateur` WHERE ((`surnom` = '" + surnom + "') && (`role` = 'client'))";
        stm = cnx.createStatement();
        ResultSet result = stm.executeQuery(req);
            while (result.next()) {
            u = new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10));
        }
        if (u == null){
            System.out.println("Client introuvable");
        } 
        return u;  
    }
     
}
            
         
     
     
     
    

    

   
