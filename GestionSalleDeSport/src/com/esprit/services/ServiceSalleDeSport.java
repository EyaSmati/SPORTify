/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.SalleDeSport;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author asus
 */
public class ServiceSalleDeSport implements IService<SalleDeSport> {
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(SalleDeSport t) {
        try {
            String requete = "INSERT INTO SalleDeSport (Id_Salle,Nom_Salle,Adresse,Region,HDebut,HFin,Min,NumTel) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            if((t.getHDebut()>=0)&&(t.getHDebut()<24)&&(t.getHFin()>=0)&&(t.getHFin()<24)&&(t.getMin()>=0)&&(t.getMin()<60)){
            pst.setInt(1, t.getIdSalle());
            pst.setString(2, t.getNomSalle());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getRegion());
            pst.setInt(5, t.getHDebut());
            pst.setInt(6, t.getHFin());
            pst.setInt(7, t.getMin());
            pst.setInt(8, t.getNumTel());
            pst.executeUpdate();
            System.out.println("SalleDeSport ajoutée !");
            }else{
            System.out.println("l'heure ne dépasse pas 24 h et les minutes ne dépasse pas 60 min !");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(SalleDeSport t) {
        try {
            String requete = "DELETE FROM SalleDeSport WHERE Id_Salle=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getIdSalle());
            pst.executeUpdate();
            System.out.println("SalleDeSport supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(SalleDeSport t) {
        try {
            String requete = "UPDATE SalleDeSport SET Nom_Salle=?,Adresse=?,Region=?,HDebut=?,HFin=?,Min=?,NumTel=? WHERE Id_Salle=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            if((t.getHDebut()>=0)&&(t.getHDebut()<24)&&(t.getHFin()>=0)&&(t.getHFin()<24)&&(t.getMin()>=0)&&(t.getMin()<60)){
            pst.setInt(8, t.getIdSalle());
            pst.setString(1, t.getNomSalle());
            pst.setString(2, t.getAdresse());
            pst.setString(3, t.getRegion());
            pst.setInt(4, t.getHDebut());
            pst.setInt(5, t.getHFin());
            pst.setInt(6, t.getMin());
            pst.setInt(7, t.getNumTel());            
            pst.executeUpdate();
            System.out.println("SalleDeSport modifiée !");
            }else{
             System.out.println("l'heure ne dépasse pas 24 h et les minutes ne dépasse pas 60 min !");    
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<SalleDeSport> afficher() {
        List<SalleDeSport> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM SalleDeSport";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new SalleDeSport(rs.getInt("Id_Salle"), rs.getString("Nom_Salle"), rs.getString("Adresse"),rs.getString("Region"),rs.getInt("HDebut"),rs.getInt("HFin"),rs.getInt("Min"),rs.getInt("NumTel")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public  List<SalleDeSport> rechercherParRegion(String Region){
        ResultSet rst;
          List<SalleDeSport> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM SalleDeSport WHERE Region ='"+Region+"'";
            Statement st = cnx.createStatement();
            rst= st.executeQuery(requete); 
            while(rst.next()){
                list.add(new SalleDeSport(rst.getInt("Id_Salle"), rst.getString("Nom_Salle"), rst.getString("Adresse"),rst.getString("Region"),rst.getInt("HDebut"),rst.getInt("HFin"),rst.getInt("Min"),rst.getInt("NumTel")));
            }
            int size = list.size();
             if(size!=0){
                 System.out.println("Salle Retrouvée"); 
            }else 
                       System.out.println("Salle Non Retrouvée");
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         return list;
   }
    
    @Override
    public  List<SalleDeSport> rechercherParNom(String Nom_Salle){
        ResultSet rst;
          List<SalleDeSport> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM SalleDeSport WHERE Nom_Salle ='"+Nom_Salle+"'";
            Statement st = cnx.createStatement();
            rst= st.executeQuery(requete); 
            while(rst.next()){
                list.add(new SalleDeSport(rst.getInt("Id_Salle"), rst.getString("Nom_Salle"), rst.getString("Adresse"),rst.getString("Region"),rst.getInt("HDebut"),rst.getInt("HFin"),rst.getInt("Min"),rst.getInt("NumTel")));
            }
            int size = list.size();
             if(size!=0){
                 System.out.println("Salle Retrouvée"); 
            }else 
                       System.out.println("Salle Non Retrouvée");
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         return list;
   }

    /**
     *
     * @return
     */
    @Override
    public List<SalleDeSport> TrierParNom() {
        List<SalleDeSport> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM SalleDeSport ORDER BY Nom_Salle ASC";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            System.out.println("Liste triée par  Nom:");
            while (rs.next()) {
                list.add(new SalleDeSport(rs.getInt("Id_Salle"), rs.getString("Nom_Salle"), rs.getString("Adresse"),rs.getString("Region"),rs.getInt("HDebut"),rs.getInt("HFin"),rs.getInt("Min"),rs.getInt("NumTel")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<SalleDeSport> TrierParRegion() {
        List<SalleDeSport> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM SalleDeSport ORDER BY Lieu ASC";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            System.out.println("Liste triée par  Lieu:");
            while (rs.next()) {
                list.add(new SalleDeSport(rs.getInt("Id_Salle"), rs.getString("Nom_Salle"), rs.getString("Adresse"),rs.getString("Region"),rs.getInt("HDebut"),rs.getInt("HFin"),rs.getInt("Min"),rs.getInt("NumTel")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    public void nombreSalleDeSport() {

        int i = 0;
        String requete = "SELECT COUNT(*) as nbr FROM SalleDeSport";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                i = rs.getInt("nbr");

            }
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        System.out.println("Le nombre de salle de sport est "+i);
        
    }

}
