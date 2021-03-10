/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Service.ServiceUtilisateur;
import Utils.DataSource;
import Utils.EmailExistant;
import Utils.EmailValide;
import Utils.NumeroTelValide;
import Utils.SurnomExistant;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassine Karoui
 */
public class InterfaceInscriptionController implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list1 = FXCollections.observableArrayList();

    private Connection cnx = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet result;
    private ServiceUtilisateur SU = new ServiceUtilisateur();
    private SurnomExistant se = new SurnomExistant();
    private EmailExistant me = new EmailExistant();
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPseudo;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private DatePicker tfDdn;
    @FXML
    private TextField tfNum;
    @FXML
    private Button btnInscriptionUser;
    @FXML
    private Label labelX;
    @FXML
    private Label labelInscriptionReussie;
    @FXML
    private Label labelPdu;
    @FXML
    private Label labelEdu;
    @FXML
    private Label labelNumInvalide;
    @FXML
    private ChoiceBox<String> CBsexe;
    @FXML
    private ChoiceBox<String> CBrole;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void InscriptionUser(ActionEvent event) throws SQLException, InterruptedException {
        int test = SU.inscription(tfPseudo.getText(), tfPrenom.getText(), tfNom.getText(), tfNum.getText(), tfEmail.getText(), tfPassword.getText(), tfDdn.getValue().toString(), CBsexe.getValue().toString(), CBrole.getValue().toString());
            labelInscriptionReussie.setText("");
            labelPdu.setText("");
            labelEdu.setText("");
            labelNumInvalide.setText("");
        if (test == 1){
                labelInscriptionReussie.setText("Inscription réussie!");
                TimeUnit.SECONDS.sleep(2);
                Stage stage = (Stage) labelX.getScene().getWindow();
                stage.close();
            
           
            
        } else{
            if (se.verifier(tfPseudo.getText()))
                labelPdu.setText("Surnom deja utilisé");
            if (me.verifier(tfEmail.getText()))
                labelEdu.setText("Email deja utilisé");
            if (!(NumeroTelValide.verifierNumeroTel(tfNum.getText())))
                labelNumInvalide.setText("Numero invalide");
            if (!(EmailValide.verifierEmail(tfEmail.getText())))
                labelEdu.setText("Email invalide");
        }
        }
    
    @FXML
    private void FermerFenetre(MouseEvent event) {
        Stage stage = (Stage) labelX.getScene().getWindow();
        stage.close();
    }
    
    private void loadData(){
        list.removeAll(list);
        String a = "Homme";
        String b = "Femme";
        list.addAll(a,b);
        CBsexe.getItems().addAll(list);
        
        list1.removeAll(list1);
        String aa = "Client";
        String bb = "Coach";
        String cc = "Proprietaire salle de sport";
        list1.addAll(aa,bb,cc);
        CBrole.getItems().addAll(list1);
        
    }
}
