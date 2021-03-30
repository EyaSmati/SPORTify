/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import com.esprit.models.SalleDeSport;
import com.esprit.services.IService;
import com.esprit.services.ServiceSalleDeSport;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;
import com.esprit.utils.DataSource;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import static javafx.concurrent.Worker.State;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SalleDeSportController implements Initializable {

     private VBox pnItems = null;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private TextField tf_recherche;
    @FXML
    private Button btn_trier;
    @FXML
    private TableView<SalleDeSport> ListeSalles;
    private TableColumn<?, ?> ID_Salle;
    @FXML
    private TableColumn<?, ?> Nom_Salle;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Region;
    @FXML
    private TableColumn<?, ?> HDebut;
    @FXML
    private TableColumn<?, ?> HFin;
    @FXML
    private TableColumn<?, ?> Min;
    @FXML
    private TableColumn<?, ?> NumTel;
    @FXML
    private AnchorPane Ajouter1;
    @FXML
    private TextField tf_hdebut;
    @FXML
    private TextField tf_hfin;
    @FXML
    private TextField tf_adresse;
    @FXML
    private TextField tf_id;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField tf_min;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_region;
    @FXML
    private TextField tf_numtel;
    @FXML
    private AnchorPane Modifier;
    @FXML
    private TextField tf_hdebut1;
    @FXML
    private TextField tf_hfin1;
    @FXML
    private TextField tf_adresse1;
    @FXML
    private TextField tf_id1;
    @FXML
    private Button btn_modifier;
    @FXML
    private TextField tf_min1;
    @FXML
    private TextField rechercheee;
    @FXML
    private TextField tf_nom1;
    @FXML
    private TextField tf_region1;
    @FXML
    private TextField tf_numtel1;
    @FXML
    private AnchorPane Supprimer;
    @FXML
    private Button btn_supprimer;
    @FXML
    private ComboBox<String> CB_Supprimer;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Pane pnlMenus;
    @FXML
    private AnchorPane Supprimer1;
    @FXML
    private Pane pnlMenus1;
    @FXML
    private Pane pnlOrders;
    public static String address;
    private List<SalleDeSport> SalleDeSport = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    
    ServiceSalleDeSport service = new ServiceSalleDeSport();
    SalleDeSport salle = null;

    
    /*private List<SalleDeSport> getData() {
        List<SalleDeSport> ttSalleDeSport = new ArrayList<>();
        SalleDeSport  salle;

        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ttSalleDeSport=ss.afficher();

        
        return ttSalleDeSport;
    }*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
       ObservableList<String> Nom = FXCollections.observableArrayList(ss.afficherALLNom());
       CB_Supprimer.setItems(Nom);
       
    }    

    @FXML
    private void handleClicks(ActionEvent actionEvent) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
       
           ID_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           Nom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           Region.setCellValueFactory(new PropertyValueFactory("Region"));
           HDebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           HFin.setCellValueFactory(new PropertyValueFactory("HFin"));
           Min.setCellValueFactory(new PropertyValueFactory("Min"));
           NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalles.setItems(items); 
              ObservableList<String> Nom = FXCollections.observableArrayList(ss.afficherALLNom());
                CB_Supprimer.setItems(Nom);
                ObservableList<String> listerecherche = FXCollections.observableArrayList(ss.afficherALLNom());
               TextFields.bindAutoCompletion(rechercheee,listerecherche);
                
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #D3D3D3");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #D3D3D3");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #D3D3D3");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #D3D3D3");
            pnlOrders.toFront();
        }
    }
    @FXML
    private void AjouterSalle(ActionEvent event) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        
        if (tf_id.getText().isEmpty()||tf_nom.getText().isEmpty()||tf_adresse.getText().isEmpty()||tf_region.getText().isEmpty()||tf_hdebut.getText().isEmpty()||tf_hfin.getText().isEmpty()||tf_min.getText().isEmpty()||tf_numtel.getText().isEmpty())
        {
             Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
   
        ss.ajouter(new SalleDeSport(tf_id.getText(),tf_nom.getText(),tf_adresse.getText(),tf_region.getText(),Integer.parseInt(tf_hdebut.getText()),Integer.parseInt(tf_hfin.getText()),Integer.parseInt(tf_min.getText()),Integer.parseInt(tf_numtel.getText())));
         JOptionPane.showMessageDialog(null,"Salle de sport ajoutée");
         clean();}
    }

    @FXML
    private void ModifierSalle(ActionEvent event) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
         if (tf_id1.getText().isEmpty()||tf_nom1.getText().isEmpty()||tf_adresse1.getText().isEmpty()||tf_region1.getText().isEmpty()||tf_hdebut1.getText().isEmpty()||tf_hfin1.getText().isEmpty()||tf_min1.getText().isEmpty()||tf_numtel1.getText().isEmpty())
        {
             Alert alert = new Alert(Alert.AlertType.ERROR); 
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        }
        else{
        ss.modifier(new SalleDeSport(tf_id1.getText(),tf_nom1.getText(),tf_adresse1.getText(),tf_region1.getText(),Integer.parseInt(tf_hdebut1.getText()),Integer.parseInt(tf_hfin1.getText()),Integer.parseInt(tf_min1.getText()),Integer.parseInt(tf_numtel1.getText())));
         JOptionPane.showMessageDialog(null,"Salle de sport modifiée");
         clean();}
    }
    @FXML
    private void SupprimerSalle(ActionEvent event) {
         ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ss.supprimer(CB_Supprimer.getValue());
         JOptionPane.showMessageDialog(null,"Salle de sport Supprimée");
         System.out.println(CB_Supprimer.getValue());
          clean();
    }
    @FXML
    private void afficherrrr(Event event) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.afficher());
        
           //ID_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           Nom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           Region.setCellValueFactory(new PropertyValueFactory("Region"));
           HDebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           HFin.setCellValueFactory(new PropertyValueFactory("HFin"));
           Min.setCellValueFactory(new PropertyValueFactory("Min"));
           NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));
           

           ListeSalles.setItems(items); 
           ObservableList<String> nom = FXCollections.observableArrayList(ss.afficherALLNom());
           CB_Supprimer.setItems(nom);
    }
    
    @FXML
    private void rechercherSalle(KeyEvent event) {
        ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.rechercher(tf_recherche.getText()));
       
           ID_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           Nom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           Region.setCellValueFactory(new PropertyValueFactory("Region"));
           HDebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           HFin.setCellValueFactory(new PropertyValueFactory("HFin"));
           Min.setCellValueFactory(new PropertyValueFactory("Min"));
           NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));
            

           ListeSalles.setItems(items); 
           if(ss.rechercher(tf_recherche.getText()).isEmpty()){
              
          ObservableList<SalleDeSport> item = FXCollections.observableArrayList(ss.afficher());
           ID_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           Nom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           Region.setCellValueFactory(new PropertyValueFactory("Region"));
           HDebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           HFin.setCellValueFactory(new PropertyValueFactory("HFin"));
           Min.setCellValueFactory(new PropertyValueFactory("Min"));
           NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalles.setItems(item);}
    }
    @FXML
    private void TrierCours(ActionEvent event) {
         ServiceSalleDeSport ss = new ServiceSalleDeSport();
        ObservableList<SalleDeSport> items = FXCollections.observableArrayList(ss.TrierRegion());
       
           ID_Salle.setCellValueFactory(new PropertyValueFactory("IdSalle"));
           Nom_Salle.setCellValueFactory(new PropertyValueFactory("NomSalle"));
           Adresse.setCellValueFactory(new PropertyValueFactory("Adresse"));
           Region.setCellValueFactory(new PropertyValueFactory("Region"));
           HDebut.setCellValueFactory(new PropertyValueFactory("HDebut"));
           HFin.setCellValueFactory(new PropertyValueFactory("HFin"));
           Min.setCellValueFactory(new PropertyValueFactory("Min"));
           NumTel.setCellValueFactory(new PropertyValueFactory("NumTel"));

           ListeSalles.setItems(items); 
    }
     @FXML
    private void recherche1(MouseEvent event) {
        ServiceSalleDeSport U = new ServiceSalleDeSport();
           ObservableList<String> listerecherche = FXCollections.observableArrayList(U.afficherALLNom());
               TextFields.bindAutoCompletion(rechercheee,listerecherche);

        SalleDeSport UserModif = U.rechercherID(rechercheee.getText());
        tf_id1.setText(UserModif.getIdSalle());
        tf_nom1.setText(UserModif.getNomSalle());
        tf_adresse1.setText(UserModif.getAdresse());
        tf_region1.setText(UserModif.getRegion());
        tf_hdebut1.setText(String.valueOf(UserModif.getHDebut()));
        tf_hfin1.setText(String.valueOf(UserModif.getHFin()));
        tf_min1.setText(String.valueOf(UserModif.getMin()));
        tf_numtel1.setText(String.valueOf(UserModif.getNumTel()));
        rechercheee.setText(null);
    }
    
    private void clean() {
        
        tf_id.setText(null);
        tf_nom.setText(null);
        tf_adresse.setText(null);
        tf_region.setText(null);
        tf_hdebut.setText(null);
        tf_hfin.setText(null);
        tf_min.setText(null);
        tf_numtel.setText(null);
         tf_id1.setText(null);
        tf_nom1.setText(null);
        tf_adresse1.setText(null);
        tf_region1.setText(null);
        tf_hdebut1.setText(null);
        tf_hfin1.setText(null);
        tf_min1.setText(null);
        tf_numtel1.setText(null);
    }

    @FXML
    private void localisation(Event event) throws IOException {
        
        /*//Connection cnx = DataSource.getInstance().getCnx();
        SalleDeSport ss = new SalleDeSport();
        ss = ListeSalles.getSelectionModel().getSelectedItem();
        IService es = new ServiceSalleDeSport();
        //address="Ariana";
        //address =ss.getRegion();
        
        Stage s = new Stage();
        Parent root = FXMLLoader.load(SalleDeSportController.class.getResource("Map.fxml"));
        s.setTitle("Google Maps");
        Image icon = new Image(getClass().getResourceAsStream("icons8-google-maps-old-100.png"));
        s.getIcons().add(icon);
        s.setScene(new Scene(root));
        s.show();
        //es.supprimer(address);
        */
        
   
        
        SalleDeSport ss = new SalleDeSport();
        Stage stage = new Stage();
         // Create the WebView
        WebView webView = new WebView();
         
        // Create the WebEngine
        final WebEngine webEngine = webView.getEngine();
 
        // LOad the Start-Page
        webEngine.load("https://www.google.com/maps/@36.7948606,10.191524,14z");
         
        // Update the stage title when a new web page title is available (when loading completes successfully)
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() 
        {
            @Override
            public void changed(ObservableValue<? extends State> ov, State oldState, State newState) 
            {
                if (newState == State.SUCCEEDED) 
                {
                    //stage.setTitle(webEngine.getLocation());
                    stage.setTitle(webEngine.getTitle());
                }
            }
        });
 
        // Create the VBox
        VBox root = new VBox();
        // Add the WebView to the VBox
        root.getChildren().add(webView);
 
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        
        Image icon = new Image(getClass().getResourceAsStream("icons8-google-maps-old-100.png"));
        stage.getIcons().add(icon);
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Add  the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }
        
    }
   
    

