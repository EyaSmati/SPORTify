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


     
}
            
         
     
     
     
    

    

   
