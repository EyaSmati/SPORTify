/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Service.ServiceUtilisateur;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yassine Karoui
 */
public class Interface1Controller implements Initializable {
    ServiceUtilisateur SU = new ServiceUtilisateur();
    @FXML
    private Button btnCreeUnCompte;
    @FXML
    private Button btnSeConnecter;
    @FXML
    private Button btnMdpOublie;
    @FXML
    private TextField tfPseudo;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private Label tfIncorret;
    @FXML
    private Label labelCorrect;
    @FXML
    private Label labelX;
    @FXML
    private Label labelMail;
    @FXML
    private Label labelMail1;
    private static String surnom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void CreeUnCompte(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInscription.fxml"));
        Parent root = loader.load();
        Stage stageInscription= new Stage();
        stageInscription.initStyle(StageStyle.UNDECORATED);
        stageInscription.setScene(new Scene(root, 504, 701 ));
        stageInscription.show();   
    }

    @FXML
    private void SeConnecter(ActionEvent event) throws SQLException, IOException, InterruptedException {
        tfIncorret.setText("");        
        labelCorrect.setText("");
        labelMail.setText("");
        labelMail1.setText("");
        if (tfPseudo.getText().isEmpty() == false && tfMdp.getText().isEmpty() == false ){
            int test = SU.authentification(tfPseudo.getText(), tfMdp.getText());
            if (test == 0)
                tfIncorret.setText("Pseudo ou mot de passe incorrect");
            else {
                labelCorrect.setText("Bienvenu "+SU.retournerSurnom(test)+"");
                TimeUnit.SECONDS.sleep(2);
                surnom = SU.retournerSurnom(test);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
                Parent root = loader.load();
                Stage stageInscription= new Stage();
                stageInscription.initStyle(StageStyle.UNDECORATED);
                stageInscription.setScene(new Scene(root, 1200, 800));
                stageInscription.show(); 

            }
                
        } else if(tfPseudo.getText().isEmpty() == true && tfMdp.getText().isEmpty() == true)
            tfIncorret.setText("Entrer votre Pseudo et mot de passe s'il vous plait");
          else if(tfPseudo.getText().isEmpty() == true)
            tfIncorret.setText("Entrer votre Pseudo s'il vous plait"); 
          else if(tfMdp.getText().isEmpty() == true)
            tfIncorret.setText("Entrer votre mot de passe s'il vous plait");      
    }

    @FXML
    private void motDePasseOublie(ActionEvent event) throws SQLException {
        tfIncorret.setText("");        
        labelCorrect.setText("");
        labelMail.setText("");
        labelMail1.setText("");
        if (tfPseudo.getText().isEmpty() == false){
            if (SendEmail.Send(tfPseudo.getText()) == 1)
                labelMail.setText("Email envoyé");
            else
                labelMail1.setText("Pseudo incorrect");
        } else
            tfIncorret.setText("Entrer votre Pseudo"); 
              
    }

    @FXML
    private void FermerFenetre(MouseEvent event) {
        System.exit(0);
    }

    public static String getSurnom() {
        return surnom;
    }

    public static void setSurnom(String surnom) {
        Interface1Controller.surnom = surnom;
    }

    public TextField getTfPseudo() {
        return tfPseudo;
    }

    public void setTfPseudo(TextField tfPseudo) {
        this.tfPseudo = tfPseudo;
    }
    
    
}
