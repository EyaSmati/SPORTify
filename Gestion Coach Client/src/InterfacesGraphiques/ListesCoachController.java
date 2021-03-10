/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraphiques;

import Entite.Cours;
import Entite.Utilisateur;
import Service.ServiceClients;
import Service.ServiceCoachDansCours;
import Service.ServiceCoaches;
import Utils.DataSource;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */

public class ListesCoachController implements Initializable {
    public Cours cours; 
     @FXML
    private TableView<Utilisateur> tableCoach;
    @FXML
    private TableColumn<Utilisateur, String> surnom_coach;
    @FXML
    private TableColumn<Utilisateur, String> nom_coach;
    @FXML
    private TableColumn<Utilisateur, String> prenom_coach;
    @FXML
    private TableColumn<Utilisateur, String> tel_coach;
    @FXML
    private TableColumn<Utilisateur, String> mail_coach;
    @FXML
    private TableColumn<Utilisateur, Float> evaluation_coach;
 
    @FXML
    private TextField txtName;
    
 public ObservableList<Utilisateur> data=FXCollections.observableArrayList() ;
 



    @FXML
    private ImageView myimageview2;
    @FXML
    private Button Rechercher;

   
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceCoaches S2 = new ServiceCoaches();
        List<Utilisateur> coaches = new ArrayList();
        try {
            coaches=S2.afficherCoaches();
            surnom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("surnom"));
            nom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
            prenom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
            tel_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("numeroDeTelephone"));
            mail_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
            evaluation_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,Float>("evaluationCoach"));
            data.clear();
            for (int i = 0; i < coaches.size(); i++) {
                data.add(coaches.get(i));
            }
            tableCoach.setItems(data);
      
            
        } catch (SQLException ex) {
            System.out.println("error");
        }
    
    }    
    
    public void setCours(Cours c)
    {
        this.cours=c;
        System.out.println("after setting cours in second controller :"+this.cours);
    }

    @FXML
    private void affecterAction(ActionEvent event) throws SQLException {
ServiceCoachDansCours S1 = new ServiceCoachDansCours();
int selectedIndex = tableCoach.getSelectionModel().getSelectedIndex();
        Utilisateur u = (Utilisateur) tableCoach.getSelectionModel().getSelectedItem();
        
        System.out.println("test :"+selectedIndex);
        if (selectedIndex!=-1) {
            S1.ajouterCoachDansCours(cours, u);
            Stage stage = (Stage) tableCoach.getScene().getWindow();
            stage.close();
        }
    }

  
    @FXML
    private void modifierAction(ActionEvent event) throws SQLException {
        ServiceCoachDansCours S1 = new ServiceCoachDansCours();
int selectedIndex = tableCoach.getSelectionModel().getSelectedIndex();
        Utilisateur u = (Utilisateur) tableCoach.getSelectionModel().getSelectedItem();
        
        System.out.println("test :"+selectedIndex);
        if (selectedIndex!=-1) {
            S1.modifierCoachDansCours(cours, u);
            Stage stage = (Stage) tableCoach.getScene().getWindow();
            stage.close();
        }
        
    }
      @FXML
    private void RechercherCoachAction(ActionEvent event) throws SQLException{

           
        ServiceCoaches S2 = new ServiceCoaches();
       try {
          
        ObservableList<Utilisateur> coaches = FXCollections.observableArrayList(S2.rechercherCoach(txtName.getText()));
           surnom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("surnom"));
            nom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
            prenom_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
            tel_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("numeroDeTelephone"));
            mail_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
            evaluation_coach.setCellValueFactory(new PropertyValueFactory<Utilisateur,Float>("evaluationCoach"));
            data.clear();
     
           tableCoach.setItems(coaches);
    
    } catch (SQLException ex) {
            System.out.println("error");
        }
    
 }
    

}