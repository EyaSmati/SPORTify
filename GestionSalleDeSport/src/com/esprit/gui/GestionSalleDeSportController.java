/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.models.SalleDeSport;
import com.esprit.services.ServiceSalleDeSport;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class GestionSalleDeSportController implements Initializable {

    @FXML
    private TextField tfId_Salle;
    @FXML
    private TextField tfNom_Salle;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfRegion;
    @FXML
    private Button btn_Ajouter;
    @FXML
    private TextField tfHdebut;
    @FXML
    private TextField tfHfin;
    @FXML
    private TextField tfMin;
    @FXML
    private TextField tfNumTel;
    @FXML
    private Button btn_Supprimer;
    @FXML
    private Button btn_Modifier;
    @FXML
    private TableView<SalleDeSport> ListeSalleDeSport;
    @FXML
    private TableColumn<SalleDeSport, String> clId_Salle;
    @FXML
    private TableColumn<SalleDeSport, String> clNom_Salle;
    @FXML
    private TableColumn<SalleDeSport, String> cl_Adresse;
    @FXML
    private TableColumn<SalleDeSport, String> cl_Region;
    @FXML
    private TableColumn<SalleDeSport, ?> cl_Hdebut;
    @FXML
    private TableColumn<SalleDeSport, ?> cl_Hfin;
    @FXML
    private TableColumn<SalleDeSport, ?> cl_Min;
    @FXML
    private TableColumn<SalleDeSport, ?> cl_NumTel;
    @FXML
    private Button btn_Rechercher;
    @FXML
    private TextField tfChercher;
    @FXML
    private Button btn_Trier;
    @FXML
    private Button btn_AfficherInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
       
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalleDeSport.setItems(items);
    }    

    @FXML
    private void AjouterSalleDeSport(ActionEvent event) {
        String ID_Salle = tfId_Salle.getText();
        String Nom_Salle = tfNom_Salle.getText();
        String Adresse = tfAdresse.getText();
        String Region = tfRegion.getText();
        String HDebut=tfHdebut.getText();
        String HFin=tfHfin.getText();
        String Min = tfMin.getText();
        String NumTel = tfNumTel.getText();
 
       ServiceSalleDeSport ss = new ServiceSalleDeSport();
        if (ID_Salle.isEmpty() || Nom_Salle.isEmpty() || Adresse.isEmpty() || Region.isEmpty() || HDebut.isEmpty() || HFin.isEmpty() || Min.isEmpty() || NumTel.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
           

        }else{
       ss.ajouter(new SalleDeSport(tfId_Salle.getText(),tfNom_Salle.getText(),tfAdresse.getText(),tfRegion.getText(),Integer.parseInt(tfHdebut.getText()),Integer.parseInt(tfHfin.getText()),Integer.parseInt(tfMin.getText()),Integer.parseInt(tfNumTel.getText())));
        JOptionPane.showMessageDialog(null,"Salle de sport ajoutée !");
        clean();
        ObservableList<SalleDeSport> listeSalle = FXCollections.observableArrayList();
        listeSalle.clear(); 
     
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
       
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalleDeSport.setItems(items);
        }
    }

    @FXML
    private void SuppSalleDeSport(ActionEvent event) {
        String ID_Salle = tfId_Salle.getText();
        String Nom_Salle = tfNom_Salle.getText();
 
       ServiceSalleDeSport ss = new ServiceSalleDeSport();
        if (ID_Salle.isEmpty() || Nom_Salle.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
           

        }else{
       ss.supprimer(new SalleDeSport(tfId_Salle.getText(),tfNom_Salle.getText()));
       JOptionPane.showMessageDialog(null,"Salle de sport supprimée !");
        clean();
                ObservableList<SalleDeSport> listeSalle = FXCollections.observableArrayList();
        listeSalle.clear(); 
        
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
       
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalleDeSport.setItems(items);
        }
    }

    @FXML
    private void ModifierSalleDeSport(ActionEvent event) {
        String ID_Salle = tfId_Salle.getText();
        String Nom_Salle = tfNom_Salle.getText();
        String Adresse = tfAdresse.getText();
        String Region = tfRegion.getText();
        String HDebut=tfHdebut.getText();
        String HFin=tfHfin.getText();
        String Min = tfMin.getText();
        String NumTel = tfNumTel.getText();
 
       ServiceSalleDeSport ss = new ServiceSalleDeSport();
        if (ID_Salle.isEmpty() || Nom_Salle.isEmpty() || Adresse.isEmpty() || Region.isEmpty() || HDebut.isEmpty() || HFin.isEmpty() || Min.isEmpty() || NumTel.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
           

        }else{
       ss.modifier(new SalleDeSport(tfId_Salle.getText(),tfNom_Salle.getText(),tfAdresse.getText(),tfRegion.getText(),Integer.parseInt(tfHdebut.getText()),Integer.parseInt(tfHfin.getText()),Integer.parseInt(tfMin.getText()),Integer.parseInt(tfNumTel.getText())));
        JOptionPane.showMessageDialog(null,"Salle de sport modifiée !");
        clean();
        }
                ObservableList<SalleDeSport> listeSalle = FXCollections.observableArrayList();
        listeSalle.clear(); 
        
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
       
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalleDeSport.setItems(items);
    }

    @FXML
    private void RechercherSalleDeSport(ActionEvent event) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.rechercher(tfChercher.getText()));
        
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));
            ListeSalleDeSport.setItems(items);
        }

    @FXML
    private void TrierListeSalleDeSport(ActionEvent event) {
          
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.TrierParRegion());
           clId_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           clNom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           cl_Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           cl_Region.setCellValueFactory(new PropertyValueFactory("Region"));
           cl_Hdebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           cl_Hfin.setCellValueFactory(new PropertyValueFactory("HFin"));
           cl_Min.setCellValueFactory(new PropertyValueFactory("Min"));
           cl_NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalleDeSport.setItems(items);
    }

    private void clean() {
        
        tfId_Salle.setText(null);
        tfNom_Salle.setText(null);
        tfAdresse.setText(null);
        tfRegion.setText(null);
        tfHdebut.setText(null);
        tfHfin.setText(null);
        tfMin.setText(null);
        tfNumTel.setText(null);
        
    }
  
    @FXML
    private void AfficherInfo(ActionEvent event) {
         ServiceSalleDeSport ss = new ServiceSalleDeSport();
        SalleDeSport Modif = ss.rechercherID(tfId_Salle.getText());
        tfNom_Salle.setText(Modif.getNomSalle());
        tfAdresse.setText(Modif.getAdresse());
        tfRegion.setText(Modif.getRegion());
        tfHdebut.setText(String.valueOf(Modif.getHDebut()));
        tfHfin.setText(String.valueOf(Modif.getHFin()));
        tfMin.setText(String.valueOf(Modif.getMin()));
        tfNumTel.setText(String.valueOf(Modif.getNumTel()));
        
        
       // TFUserNameModif.insertText(1, "ok");
    }
        
    }
    

