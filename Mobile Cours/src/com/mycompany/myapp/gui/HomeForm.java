/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

       Label logi = new Label("BIENVENUE A SPORTIFY");
        logi.setUIID("libC");
         Label a=new Label("    ");
          Label b=new Label("    ");
          Label c=new Label("    ");
        addAll(a,logi,b,c);
         this.getToolbar().setUIID("tb");
       
      
        
        this.getToolbar().addCommandToOverflowMenu("Profile", null, ev -> {

          

        });
     
        this.getToolbar().addCommandToOverflowMenu("Logout", null, ev -> {
            new welcomeForm().show();
        });

        Button btnListCours = new Button("Liste des Cours");
        
        Button btnListCategories = new Button("Liste des Categories");
     
       /////////course/////////
        btnListCours.addActionListener(e -> new ListCourseForm(current).show());

   
 ///////////category//////////
        btnListCategories.addActionListener(e -> new ListCategorieForm(current).show());
      
         btnListCours.setUIID("vtnvalid");
            btnListCategories.setUIID("vtnvalid");
       
      
        addAll(btnListCours,btnListCategories);

    }

    HomeForm(ListCategorieForm aThis) {
      current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

       Label logi = new Label("BIENVENUE A SPORTIFY");
        logi.setUIID("libC");
         Label a=new Label("    ");
          Label b=new Label("    ");
       
        addAll(a,logi,b);
        Button btnListCours = new Button("Liste des Cours");
        
        Button btnListCategories = new Button("Liste des Categories");
     
       /////////course/////////
        btnListCours.addActionListener(e -> new ListCourseForm(current).show());

   
 ///////////category//////////
        btnListCategories.addActionListener(e -> new ListCategorieForm(current).show());
      
         btnListCours.setUIID("vtnvalid");
            btnListCategories.setUIID("vtnvalid");
       
      
        addAll(btnListCours,btnListCategories);

    }

}
