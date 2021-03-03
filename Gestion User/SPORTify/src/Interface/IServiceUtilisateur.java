/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entite.Utilisateur;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Yassine Karoui
 */
public interface IServiceUtilisateur {
    public void inscription(Utilisateur u) throws SQLException;

    public void inscription(String surnom, String prenom, String nom, String numeroDeTelephone, String email,
            String password, String dateDeNaissance, String sexe, String role) throws SQLException;
    
    public void modifierUtilisateur(String surnom, Utilisateur u) throws SQLException;

    public int authentification(Utilisateur u) throws SQLException;
    
    public int authentification(String surnom, String password) throws SQLException;
    
    public ArrayList<Utilisateur> getUsers() throws SQLException;

    public ArrayList<Utilisateur> getUsersParRole(String role) throws SQLException;
    
    public Utilisateur getUser(String surnom) throws SQLException;

    
}
