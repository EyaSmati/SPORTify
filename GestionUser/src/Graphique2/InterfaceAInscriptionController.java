/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique2;

import Service.ServiceAdministrateur;
import Utils.EmailValide;
import Utils.NumeroTelValide;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine Karoui
 */
public class InterfaceAInscriptionController implements Initializable {
    ServiceAdministrateur SA = new ServiceAdministrateur();
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnInscriptionAdmin;
    @FXML
    private Label labelX;
    @FXML
    private Label tfEmailexistant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InscriptionAdmin(ActionEvent event) throws SQLException, InterruptedException {
        int test = SA.ajouterAdmin(tfEmail.getText(), tfPassword.getText());
            
        if (test == 1){
                TimeUnit.SECONDS.sleep(2);
                Stage stage = (Stage) labelX.getScene().getWindow();
                stage.close();  
        } else if (test == 2)
                tfEmailexistant.setText("Email existant");
            
                
        
    }

    @FXML
    private void FermerFenetre(MouseEvent event) {
        Stage stage = (Stage) labelX.getScene().getWindow();
        stage.close();
    }
    
}
