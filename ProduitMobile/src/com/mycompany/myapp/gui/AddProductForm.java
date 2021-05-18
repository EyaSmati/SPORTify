/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.CategorieProduit;
import com.mycompany.myapp.entities.Produits;

import com.mycompany.myapp.services.ServiceCategorieProduit;
import com.mycompany.myapp.services.ServiceProduits;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.util.Date;
/**
 *
 * @author asus
 */
public class AddProductForm extends Form {
    
   Resources theme = UIManager.initFirstTheme("/theme");
    public AddProductForm(Form previous) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU PRODUIT");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

       TextField tfId = new TextField("","ID");
     
        TextField tfLibelle= new TextField("", "libelle");
        
        TextField tfQuantite= new TextField("", "quantite");
       
        TextField tfPrix= new TextField("", "prix");
       
          ComboBox cmb_type = new ComboBox();
           
           
 cmb_type.setUIID("txtn");
                            cmb_type.setUIID("txtn");
                            for (CategorieProduit cat : new ServiceCategorieProduit().getAllCategorieProduit()) {

                               
                                 cmb_type.addItem(cat.getTypecategorie());
                                

                            }
       
        Button btnValider = new Button("Ajouter Produit");
        
          btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               if ((tfId.getText().length()==0)||(tfLibelle.getText().length()==0)||(tfQuantite.getText().length()==0)||(tfPrix.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Produits p = new Produits(tfId.getText(),tfLibelle.getText(),cmb_type.getSelectedItem().toString(),Integer.parseInt(tfQuantite.getText()),Integer.parseInt(tfPrix.getText()));                       
                    if( ServiceProduits.getInstance().addProduits(p))
                            Dialog.show("Success","Produit Ajouté",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
       addAll(tfId,tfLibelle,cmb_type,tfQuantite,tfPrix);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
   
    }
    AddProductForm() {
       super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU PRODUIT");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

        TextField tfId = new TextField("","ID");
     
        TextField tfLibelle= new TextField("", "libelle");
        
        TextField tfQuantite= new TextField("", "quantite");
       
        TextField tfPrix= new TextField("", "prix");
       
          ComboBox cmb_type = new ComboBox();
           
           
 cmb_type.setUIID("txtn");
                            cmb_type.setUIID("txtn");
                            for (CategorieProduit cat : new ServiceCategorieProduit().getAllCategorieProduit()) {

                               
                                 cmb_type.addItem(cat.getTypecategorie());
                                

                            }
       
        Button btnValider = new Button("Ajouter Produit");
        
          btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 if ((tfId.getText().length()==0)||(tfLibelle.getText().length()==0)||(tfQuantite.getText().length()==0)||(tfPrix.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
Produits p = new Produits(tfId.getText(),tfLibelle.getText(),cmb_type.getSelectedItem().toString(),Integer.parseInt(tfQuantite.getText()),Integer.parseInt(tfPrix.getText()));                       
if( ServiceProduits.getInstance().addProduits(p))
                            Dialog.show("Success","Produit Ajouté",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
        addAll(tfId,tfLibelle,cmb_type,tfQuantite,tfPrix);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    
    }
}
