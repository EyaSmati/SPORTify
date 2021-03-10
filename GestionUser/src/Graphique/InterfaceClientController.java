/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Yassine Karoui
 */
public class InterfaceClientController implements Initializable {
    
    @FXML
    private Label labelCompte;
    public Label getLabelCompte() {
        return labelCompte;
    }

    public void setLabelCompte(Label labelCompte) {
        this.labelCompte = labelCompte;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Interface1Controller.getSurnom());
        labelCompte.setText(Interface1Controller.getSurnom());
       
    }    
    
}
