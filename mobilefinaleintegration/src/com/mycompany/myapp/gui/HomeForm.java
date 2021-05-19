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
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    private Resources theme=UIManager.initFirstTheme("/theme");
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
          Label d=new Label("    ");
          
        addAll(a,logi,b,c,d);
        Button btnListCours = new Button("Liste des Cours");
        
        Button btnListCategories = new Button("Liste des Categories");
        
        Button btnListSalles = new Button("Liste des salles de sport");
        
         Button btnListZones = new Button("Liste des Zones");
          Button btnListBlogs = new Button("Liste des Blogs");
          Button btnListEvents = new Button("Liste des Evénements");
          Button btnListAbonne = new Button("Liste des Abonnements");
          Button btnListProducts = new Button("Liste des Produits");
          Button btnListCategorieP = new Button("Liste des Categories des produits");
     
       /////////course/////////
        btnListCours.addActionListener(e -> new ListCourseForm(current).show());

   
 ///////////category//////////
        btnListCategories.addActionListener(e -> new ListCategorieForm(current).show());
        
        ///////////Salledesport//////////
        btnListSalles.addActionListener(e -> new ListSalledesportForm(current).show());
        
        ///////////Zone//////////
        btnListZones.addActionListener(e -> new ListZoneForm(current).show());
        
        ///////////Blog//////////
        btnListBlogs.addActionListener(e -> new ListBlogForm(current).show());
        ///////////Events//////////
        btnListEvents.addActionListener(e -> new ListEvenementForm(current).show());
        ///////////Abonnement//////////
        btnListAbonne.addActionListener(e -> new ListAbonnementForm(current).show());
        ///////////Products//////////
       btnListProducts.addActionListener(e -> new ListProductsForm(current).show());
        ///////////Categories Product//////////
        btnListCategorieP .addActionListener(e -> new ListCategorieProduitForm(current).show());
        
      
         btnListCours.setUIID("vtnvalid");
            btnListCategories.setUIID("vtnvalid");
             btnListSalles.setUIID("vtnvalid");
              btnListZones.setUIID("vtnvalid");
              btnListBlogs.setUIID("vtnvalid");
              btnListEvents.setUIID("vtnvalid"); 
              btnListAbonne.setUIID("vtnvalid");
              btnListProducts.setUIID("vtnvalid");
              btnListCategorieP.setUIID("vtnvalid");
       
      
        addAll(btnListCours,btnListCategories,btnListSalles,btnListZones,btnListBlogs,btnListEvents,btnListAbonne,btnListProducts, btnListCategorieP);

    }

    HomeForm(ListCategorieForm aThis) {
      current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

       Label logi = new Label("BIENVENUE A SPORTIFY");
        logi.setUIID("libC");
         Label a=new Label("    ");
          Label b=new Label("    ");
          Label c=new Label("    ");
          Label d=new Label("    ");
          
        addAll(a,logi,b,c,d);
        Button btnListCours = new Button("Liste des Cours");
        
        Button btnListCategories = new Button("Liste des Categories");
        
        Button btnListSalles = new Button("Liste des salles de sport");
        
         Button btnListZones = new Button("Liste des Zones");
          Button btnListBlogs = new Button("Liste des Blogs");
          Button btnListEvents = new Button("Liste des Evénements");
          Button btnListAbonne = new Button("Liste des Abonnements");
          Button btnListProducts = new Button("Liste des Produits");
          Button btnListCategorieP = new Button("Liste des Categories des produits");
     
       /////////course/////////
        btnListCours.addActionListener(e -> new ListCourseForm(current).show());

   
 ///////////category//////////
        btnListCategories.addActionListener(e -> new ListCategorieForm(current).show());
        
        ///////////Salledesport//////////
        btnListSalles.addActionListener(e -> new ListSalledesportForm(current).show());
        
        ///////////Zone//////////
        btnListZones.addActionListener(e -> new ListZoneForm(current).show());
        
        ///////////Blog//////////
        btnListBlogs.addActionListener(e -> new ListBlogForm(current).show());
        ///////////Events//////////
        btnListEvents.addActionListener(e -> new ListEvenementForm(current).show());
        ///////////Abonnement//////////
        btnListAbonne.addActionListener(e -> new ListAbonnementForm(current).show());
        ///////////Products//////////
       btnListProducts.addActionListener(e -> new ListProductsForm(current).show());
        ///////////Categories Product//////////
        btnListCategorieP .addActionListener(e -> new ListCategorieProduitForm(current).show());
        
      
         btnListCours.setUIID("vtnvalid");
            btnListCategories.setUIID("vtnvalid");
             btnListSalles.setUIID("vtnvalid");
              btnListZones.setUIID("vtnvalid");
              btnListBlogs.setUIID("vtnvalid");
              btnListEvents.setUIID("vtnvalid"); 
              btnListAbonne.setUIID("vtnvalid");
              btnListProducts.setUIID("vtnvalid");
              btnListCategorieP.setUIID("vtnvalid");
       
      
        addAll(btnListCours,btnListCategories,btnListSalles,btnListZones,btnListBlogs,btnListEvents,btnListAbonne,btnListProducts, btnListCategorieP);

    }

}
