/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entite.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yassine Karoui
 */
public class MailExistant {
    
    private Connection cnx = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet result;
    
    public  boolean verifier(Utilisateur u) throws SQLException{
        String req0 = "SELECT `email` FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req0);
        while (result.next()){
            if (result.getString(1).equals(u.getEmail())){
                System.out.println("Email deja existant");
               return true; 
            }
        }
        return false;
    }
    
    public  boolean verifier(String email) throws SQLException{
        String req0 = "SELECT `email` FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req0);
        while (result.next()){
            if (result.getString(1).equals(email)){
                System.out.println("Email deja existant");
               return true; 
            }
        }
        return false;
    }
    
}
