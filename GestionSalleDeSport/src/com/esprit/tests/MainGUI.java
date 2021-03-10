/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

/**
 *
 * @author asus
 */
public class MainGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GestionSalleDeSport.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Gestion Salle De Sport");
        primaryStage.setScene(scene);
        primaryStage.show();
    
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
