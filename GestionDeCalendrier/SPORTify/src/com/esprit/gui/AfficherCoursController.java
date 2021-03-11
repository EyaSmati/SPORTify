/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AfficherCoursController implements Initializable {

    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<?> ListeCours;
    @FXML
    private TableColumn<?, ?> ID_Cours;
    @FXML
    private TableColumn<?, ?> Type_Cours;
    @FXML
    private TableColumn<?, ?> Date;
    @FXML
    private TableColumn<?, ?> Heure;
    @FXML
    private TableColumn<?, ?> Duree;
    @FXML
    private TableColumn<?, ?> MailCoach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rechercherCours(KeyEvent event) {
    }

    @FXML
    private void TrierCours(ActionEvent event) {
    }
    
}
