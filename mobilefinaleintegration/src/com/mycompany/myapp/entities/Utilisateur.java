/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Yassine Karoui
 */
public class Utilisateur {
    private int id;
    private String surnom, prenom, nom, numerodetelephone,email,password,datedenaissance,sexe,role;

    public Utilisateur() {
    }

    public Utilisateur(String surnom, String password) {
        this.surnom = surnom;
        this.password = password;
    }

    public Utilisateur(String surnom, String prenom, String nom, String numerodetelephone, String email, String password, String datedenaissance, String sexe, String role) {
        this.surnom = surnom;
        this.prenom = prenom;
        this.nom = nom;
        this.numerodetelephone = numerodetelephone;
        this.email = email;
        this.password = password;
        this.datedenaissance = datedenaissance;
        this.sexe = sexe;
        this.role = role;
    }

    public Utilisateur(int id, String surnom, String prenom, String nom, String numerodetelephone, String email, String password, String datedenaissance, String sexe, String role) {
        this.id = id;
        this.surnom = surnom;
        this.prenom = prenom;
        this.nom = nom;
        this.numerodetelephone = numerodetelephone;
        this.email = email;
        this.password = password;
        this.datedenaissance = datedenaissance;
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

    public String getNumerodetelephone() {
        return numerodetelephone;
    }

    public void setNumerodetelephone(String numerodetelephone) {
        this.numerodetelephone = numerodetelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance) {
        this.datedenaissance = datedenaissance;
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

    
    
    
}
