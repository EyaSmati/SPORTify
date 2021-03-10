/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.IServiceUtilisateur;
import Utils.EmailExistant;
import Utils.SurnomExistant;
import Utils.DataSource;
import Entite.Utilisateur;
import Utils.CryptDecrypt;
import Utils.EmailValide;
import Utils.NumeroTelValide;
import Utils.RoleValide;
import Utils.SexeValide;


import java.sql.*;


/**
 *
 * @author Yassine Karoui
 */
public class ServiceUtilisateur implements IServiceUtilisateur {

    private Connection cnx = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet result;
    private SurnomExistant se = new SurnomExistant();
    private EmailExistant me = new EmailExistant();

    @Override
    public int inscription(String surnom, String prenom, String nom, String numeroDeTelephone, String email, String password, String dateDeNaissance, String sexe, String role) throws SQLException {
        int test = 0;
        if (!(se.verifier(surnom)) && !(me.verifier(email)) && (EmailValide.verifierEmail(email)) && SexeValide.verifierSexe(sexe) && RoleValide.verifierRole(role) && NumeroTelValide.verifierNumeroTel(numeroDeTelephone)){
            try {
                String req = "INSERT INTO `utilisateur` (`id`, `surnom`, `prenom`, `nom`, `numeroDeTelephone`, `email`, `password`, `dateDeNaissance`, `sexe`, `role`) VALUES (NULL, '"
                    + surnom + "', '" + prenom + "', '" + nom + "', '" + numeroDeTelephone + "', '" + email + "', '"
                    + CryptDecrypt.encrypt(password) + "', '" + dateDeNaissance + "', '" + sexe + "', '" + role +"')";
                ste = cnx.createStatement();
                ste.executeUpdate(req);
                System.out.println("Utilisateur inscrit.");
                test = 1;
                return test;
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("Utilisateur non inscrit.");
            }
        }
        System.out.println("Utilisateur non inscrit");
        return test;
    }
    
      @Override
    public int authentification(String surnom, String password) throws SQLException {
        int test = 0;
        String req = "SELECT `id` ,`surnom`, `password`  FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next() && test == 0) {
            if ((result.getString("surnom").equals(surnom))
                    && CryptDecrypt.decrypt(result.getString("password")).equals(password)) {
                System.out.println("Utilisateur connecté.");
                test = result.getInt(1);
                System.out.println("Id user = "+test);
                return test;
            }
        }
        if (test == 0){
            System.out.println("Email ou password incorrect.");
            return 0;
        }
        return 0;
       
    }
    
    @Override
    public void modifierUtilisateur(String surnom, Utilisateur u) throws SQLException {  
        try{
            String req = "UPDATE `utilisateur` SET `surnom`= '"+u.getSurnom()+"' ,`prenom`= '"+u.getPrenom()+"',`nom`='"+u.getNom()+"',`numeroDeTelephone`='"+u.getNumeroDeTelephone()+"',`email`='"+u.getEmail()+"',`password`='"+CryptDecrypt.encrypt(u.getPassword())+"',`dateDeNaissance`='"+u.getDateDeNaissance()+"',`sexe`='"+u.getSexe()+"',`role`='"+u.getRole()+"' WHERE `surnom` ='"+surnom+"'";
        ste = cnx.createStatement();
        ste.executeUpdate(req);
        System.out.println("Utilisateur modifié.");
        } catch (SQLException e) {
            System.out.println(e);
        } 
    }
    
    public String retournerSurnom(int id) throws SQLException{
        String str = null;
       String req = "SELECT `surnom` FROM `utilisateur` WHERE `id` ='"+id+"'";
       ste = cnx.createStatement();
       result = ste.executeQuery(req);
       while (result.next()) {
              str= result.getString("surnom");
        }
       
       return str;

    }

}

   

    


