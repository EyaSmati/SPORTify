/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique2;

import Service.ServiceAdministrateur;
import Utils.SendEmail;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yassine Karoui
 */
public class Interface2Controller implements Initializable {
    ServiceAdministrateur SA = new ServiceAdministrateur();
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private Label labelErreurEmail;
    @FXML
    private Label labelErreurMdp;
    @FXML
    private Button btnSeConnecter;
    @FXML
    private  Label labelEmailEnvoye;
    @FXML
    private Button btnCreeCompte;
    @FXML
    private Label labelX;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SeConnecter(ActionEvent event) throws SQLException, InterruptedException, IOException {
        labelErreurEmail.setText("");
        labelErreurMdp.setText("");
        if (tfEmail.getText().isEmpty() == false && tfMdp.getText().isEmpty() == false ){
            int test = SA.authentification(tfEmail.getText(), tfMdp.getText());
            if (test == 0)
                labelErreurMdp.setText("Mot de passe incorrect");
            else {
                TimeUnit.SECONDS.sleep(2);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                Parent root = loader.load();
                Stage stageInscription= new Stage();
                stageInscription.initStyle(StageStyle.UNDECORATED);
                stageInscription.setScene(new Scene(root, 1200, 800));
                stageInscription.show(); 

            }
                
        }   if (tfEmail.getText().isEmpty() == true)
                labelErreurEmail.setText("Taper votre email");
            if (tfMdp.getText().isEmpty() == true)
                labelErreurMdp.setText("Taper votre mot de passe");

    }
    
    @FXML
    private void motDePasseOublie(ActionEvent event) throws SQLException {
        labelErreurEmail.setText("");        
        labelErreurMdp.setText("");
        if (tfEmail.getText().isEmpty() == false){
            if (SendEmail.SendA(tfEmail.getText()) == 1)
                labelEmailEnvoye.setText("Email envoyé");
            else
                labelErreurEmail.setText("Email incorrect");
        } else
            labelErreurEmail.setText("Entrer votre Email"); 
              
    }
     @FXML
    private void CreeCompte(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAInscription.fxml"));
        Parent root = loader.load();
        Stage stageInscription= new Stage();
        stageInscription.initStyle(StageStyle.UNDECORATED);
        stageInscription.setScene(new Scene(root, 600, 400 ));
        stageInscription.show();   
              
    }
    @FXML
    private void FermerFenetre(MouseEvent event) {
        System.exit(0);
    }
    
}
