/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Utilisateur;
import Service.ServiceUtilisateur;
import Service.ServiceAdministrateur;
import Utils.CryptDecrypt;
import Utils.NumeroTelValide;
import Utils.SendEmail;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.net.www.http.HttpClient.New;

/**
 *
 * @author Yassine Karoui
 *///md5
public class Test {
    public static void main(String args[]) throws SQLException {
        ServiceUtilisateur SU = new ServiceUtilisateur();
        ServiceAdministrateur SA = new ServiceAdministrateur();
        SendEmail SE = new SendEmail();
/*-----------------------------------------------------------------------------*/
        SA.authentification("mouhamed@gmail.com", "password");
    }
       
       
    

}