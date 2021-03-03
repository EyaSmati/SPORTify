/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Utilisateur {
    private int id;
    private String surnom;
    private String prenom;
    private String nom;
    private String numeroDeTelephone;
    private String email;
    private String password;
    private String dateDeNaissance;
    private String sexe;
    private String role;
    
    
     public Utilisateur(String surnom) {
        this.surnom = surnom;
    }


    public Utilisateur(int id, String surnom, String prenom, String nom, String numeroDeTelephone, String email, String password, String dateDeNaissance, String sexe, String role, int evaluation, int nbrEvaluation) {
        this.id = id;
        this.surnom = surnom;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.email = email;
        this.password = password;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.role = role;
    }

   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Utilisateur() {
    }

    public Utilisateur(int id) {
        this.id = id;
    }

    public Utilisateur(int id, String surnom, String email, String role) {
        this.id = id;
        this.surnom = surnom;
        this.email = email;
        this.role = role;
    }

    

    
 
    public Utilisateur(int id, String surnom, String prenom, String nom, String email) {
        this.id = id;
        this.surnom = surnom;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }
    
   
   
    public Utilisateur(int id, String surnom, String prenom, String nom, String numeroDeTelephone, String email, String password, String dateDeNaissance, String sexe, String role) {
        this.id = id;
        this.surnom = surnom;
        this.prenom = prenom;
        this.nom = nom;
        this.numeroDeTelephone = numeroDeTelephone;
        this.email = email;
        this.password = password;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.role = role;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", surnom=" + surnom + ", prenom=" + prenom + ", nom=" + nom + ", numeroDeTelephone=" + numeroDeTelephone + ", email=" + email + ", password=" + password + ", dateDeNaissance=" + dateDeNaissance + ", sexe=" + sexe + ", role=" + role + '}';
    }

  
      
}

   