/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.models.Calendrier;
import com.esprit.services.ServiceCalendrier;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class CrudCoursDansCalendrierController implements Initializable {

    @FXML
    private TableView<Calendrier> tableCours;
    @FXML
    private TableView<Calendrier> Id_Cours;
    @FXML
    private TableColumn<Calendrier, String> type_cours;
    @FXML
    private TableColumn<Calendrier, String> date;
    @FXML
    private TableColumn<Calendrier, String> heure;
     @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker tfDate;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfTypeCours;
    @FXML
    private TextField tfHeure;
     @FXML
    private TextField tfRecherche;
    @FXML
    private Button btnAfficher;
    @FXML
    private Button btnRechercher;

    public ObservableList<Calendrier> items = FXCollections.observableArrayList();

    List<Calendrier> cours = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCalendrier sc = new ServiceCalendrier();
        cours = new ArrayList();
        try {
            cours = sc.afficherCalendrier();
            type_cours.setCellValueFactory(new PropertyValueFactory<Calendrier, String>("Type_Cours"));
            date.setCellValueFactory(new PropertyValueFactory<Calendrier, String>("Date"));
            heure.setCellValueFactory(new PropertyValueFactory<Calendrier, String>("Heure"));

//            duree_cours.setCellValueFactory(new PropertyValueFactory<Calendrier,String>("Duree"));
//            place_dispo.setCellValueFactory(new PropertyValueFactory<Calendrier,Integer>("Place_Disponible"));
//            coach_cours.setCellValueFactory(new PropertyValueFactory<Calendrier,String>("MailCoach"));
            items.clear();
            for (int i = 0; i < cours.size(); i++) {
                items.add(cours.get(i));
                System.out.println(cours.get(i).toString());
            }
            tableCours.setItems(items);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void AjouterCoursDansCalendrier(ActionEvent event) throws SQLException {

        
        String Type_Cours = tfTypeCours.getText();
        String Date = tfDate.getValue().toString();
        String Heure = tfHeure.getText();

        ServiceCalendrier sc = new ServiceCalendrier();
        if (Type_Cours.isEmpty() || Date.isEmpty() || Heure.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir toutes les données");
            alert.showAndWait();
        } else {
            sc.AjouterCoursDansCalendrier(new Calendrier(tfTypeCours.getText(), tfDate.getValue().toString(), tfHeure.getText()));
            JOptionPane.showMessageDialog(null, "Cours ajouté dans le calendrier !!");

            ObservableList<Calendrier> listeCours = FXCollections.observableArrayList();
            listeCours.clear();
        }
    }

    @FXML
    private void modifierCoursDansCalendrier(ActionEvent event) throws SQLException {

        String Type_Cours = tfTypeCours.getText();
        String Date = tfDate.getValue().toString();
        String Heure = tfHeure.getText();

        ServiceCalendrier sc = new ServiceCalendrier();
        if (Type_Cours.isEmpty() || Date.isEmpty() || Heure.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir toutes les données");
            alert.showAndWait();
        } else {
            sc.modifierCoursDansCalendrier(new Calendrier(tfTypeCours.getText(), tfDate.getValue().toString(), tfHeure.getText()));
            JOptionPane.showMessageDialog(null, "Cours modifié dans le calendrier !!");

            ObservableList<Calendrier> listeCours = FXCollections.observableArrayList();
            listeCours.clear();
//            ObservableList<Calendrier> items = FXCollections.observableArrayList(sc.afficherCalendrier());
//       
//           type_cours.setCellValueFactory(new PropertyValueFactory("IdSalle"));
//           date.setCellValueFactory(new PropertyValueFactory("Date"));
//           heure.setCellValueFactory(new PropertyValueFactory("Heure"));
//          
//
//           tableCours.setItems(items);
        }
    }

    @FXML
    private void supprimerCoursDansCalendrier(ActionEvent event) throws SQLException {

        ServiceCalendrier sc = new ServiceCalendrier();
       int selectedIndex = tableCours.getSelectionModel().getSelectedIndex();
       if (selectedIndex==-1) {
         System.out.println("try again");
       }else{
        Calendrier c= (Calendrier) tableCours.getSelectionModel().getSelectedItem();
        
        System.out.println("test :"+selectedIndex);
        
            sc.supprimerCoursDansCalendrier(c);
            Stage stage = (Stage) tableCours.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void rechercherCoursDansCalendrier(ActionEvent event ) {
          
        ServiceCalendrier sc = new ServiceCalendrier();
//        ObservableList<Calendrier> items = FXCollections.observableArrayList(sc.rechercherCoursDansCalendrier(tfRecherche.getText()));
        
           type_cours.setCellValueFactory(new PropertyValueFactory("Type_Cours"));
           date.setCellValueFactory(new PropertyValueFactory("Date"));
           heure.setCellValueFactory(new PropertyValueFactory("Heure"));
           
           tableCours.setItems(items);
       

    }

    @FXML
    private void afficherCalendrier(ActionEvent event
    ) {
        
    }

}
