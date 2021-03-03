/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Utilisateur;
import Utils.DataSource;

import java.sql.*;
import java.util.*;
import Interface.IServiceUtilisateur;
import Utils.MailExistant;
import Utils.SurnomExistant;

/**
 *
 * @author Yassine Karoui
 */
public class ServiceUtilisateur implements IServiceUtilisateur {

    private Connection cnx = DataSource.getInstance().getCnx();
    private Statement ste0;
    private Statement ste00;
    private Statement ste;
    private ResultSet result;
    private SurnomExistant se = new SurnomExistant();
    private MailExistant me = new MailExistant();

    @Override
    public void inscription(Utilisateur u) throws SQLException { 
        if (!(se.verifier(u)) && !(me.verifier(u))){
            try {
            String req = "INSERT INTO `utilisateur` (`id`, `surnom`, `prenom`, `nom`, `numeroDeTelephone`, `email`, `password`, `dateDeNaissance`, `sexe`, `role`) VALUES (NULL, '"
                    + u.getSurnom() + "', '" + u.getPrenom() + "', '" + u.getNom() + "', '" + u.getNumeroDeTelephone()
                    + "', '" + u.getEmail() + "', '" + u.getPassword() + "', '" + u.getDateDeNaissance() + "', '"
                    + u.getSexe() + "', '" + u.getRole() + "')";
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            System.out.println("Utilisateur inscrit");
            } catch (SQLException e) {
            System.out.println("Utilisateur non inscrit");
            }
        }  
    }
    


    @Override
    public void inscription(String surnom, String prenom, String nom, String numeroDeTelephone, String email, String password, String dateDeNaissance, String sexe, String role) throws SQLException {
        if (!(se.verifier(surnom)) || !(me.verifier(email))){
            try {
            String req = "INSERT INTO `utilisateur` (`id`, `surnom`, `prenom`, `nom`, `numeroDeTelephone`, `email`, `password`, `dateDeNaissance`, `sexe`, `role`) VALUES (NULL, '"
                    + surnom + "', '" + prenom + "', '" + nom + "', '" + numeroDeTelephone + "', '" + email + "', '"
                    + password + "', '" + dateDeNaissance + "', '" + sexe + "', '" + role +"')";
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            System.out.println("Utilisateur inscrit");
            } catch (SQLException e) {
            System.out.println("Utilisateur non inscrit");
            } 
        }   
    }
    
    @Override
    public void modifierUtilisateur(String surnom, Utilisateur u) throws SQLException {  
        try{
            String req = "UPDATE `utilisateur` SET `surnom`= '"+u.getSurnom()+"' ,`prenom`= '"+u.getPrenom()+"',`nom`='"+u.getNom()+"',`numeroDeTelephone`='"+u.getNumeroDeTelephone()+"',`email`='"+u.getEmail()+"',`password`='"+u.getPassword()+"',`dateDeNaissance`='"+u.getDateDeNaissance()+"',`sexe`='"+u.getSexe()+"',`role`='"+u.getRole()+"' WHERE `surnom` ='"+surnom+"'";
        ste = cnx.createStatement();
        ste.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println(e);
        } 
    }
    
    @Override
    public int authentification(Utilisateur u) throws SQLException {
        int test = 0;
        String req = "SELECT `id` ,`surnom`, `password`  FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next() && test == 0) {
            if (result.getString("surnom").equals(u.getSurnom())
                    && result.getString("password").equals(u.getPassword())) {
                test = result.getInt(1);

                return test;
            }
        }
        if (test == 0)
            System.out.println("Email ou password incorrect");
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
                    && (result.getString("password").equals(password))) {
                test = result.getInt(1);
                return test;
            } 

        }
        if (test == 0)
            System.out.println("Email ou password incorrect");

        return test;
    }
    
    @Override
    public ArrayList<Utilisateur> getUsers() throws SQLException {
         ArrayList<Utilisateur> listUser = new ArrayList<>();
        String req = "SELECT * FROM `utilisateur`";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next()) {
            listUser.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10)));
        }
        return listUser;
    }

    @Override
    public ArrayList<Utilisateur> getUsersParRole(String role) throws SQLException {
        ArrayList<Utilisateur> listUser = new ArrayList<>();
        String req = "SELECT * FROM `utilisateur` WHERE `role` = '" + role + "'";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next()) {
            listUser.add(new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10)));
        }
        return listUser;
    }
    
    @Override
    public Utilisateur getUser(String surnom) throws SQLException {
        Utilisateur u = null;
        String req = "SELECT * FROM `utilisateur` WHERE `surnom` = '" + surnom + "'";
        ste = cnx.createStatement();
        result = ste.executeQuery(req);
        while (result.next()) {
            u = new Utilisateur(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6), result.getString(7),
                    result.getString(8), result.getString(9), result.getString(10));
        }
        return u;  
    }
    
    


    
       
        
    }

   

    


