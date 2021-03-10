/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraphiques;

import Entite.Utilisateur;
import Service.ServiceClients;
import Service.ServiceCoaches;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ListeClientsController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableClient;
    @FXML
    private TableColumn<Utilisateur, String> surnom_client;
    @FXML
    private TableColumn<Utilisateur, String> nom_client;
    @FXML
    private TableColumn<Utilisateur, String> prenom_client;
    @FXML
    private TableColumn<Utilisateur, String> tel_client;
    @FXML
    private TableColumn<Utilisateur, String> mail_client;
    @FXML
    private TableColumn<Utilisateur, String> sexe_client;
    @FXML
    private TextField tfTxt;
    @FXML
    private Button Rechercher;
    
     public ObservableList<Utilisateur> data=FXCollections.observableArrayList() ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceClients S3 = new ServiceClients();
        List<Utilisateur> clients = new ArrayList();
        try {
            clients=S3.afficherClients();
            surnom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("surnom"));
            nom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
            prenom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
            tel_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("numeroDeTelephone"));
            mail_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
            sexe_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("sexe"));
            data.clear();
            for (int i = 0; i < clients.size(); i++) {
                data.add(clients.get(i));
            }
            tableClient.setItems(data);
      
            
        } catch (SQLException ex) {
            System.out.println("error");
        }
    
    }    

    @FXML
    private void RechercherClientAction(ActionEvent event) {
        ServiceClients S3 = new ServiceClients();
       try {
          
        ObservableList<Utilisateur> clients = FXCollections.observableArrayList(S3.rechercherClient(tfTxt.getText()));
           surnom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("surnom"));
            nom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
            prenom_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
            tel_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("numeroDeTelephone"));
            mail_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
            sexe_client.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("sexe"));
            data.clear();
     
           tableClient.setItems(clients);
    
    } catch (SQLException ex) {
            System.out.println("error");
        }
    }
    
}
