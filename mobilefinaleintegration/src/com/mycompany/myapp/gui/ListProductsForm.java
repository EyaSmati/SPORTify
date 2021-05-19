/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.Format;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.CategorieProduit;
import com.mycompany.myapp.entities.Produits;

import com.mycompany.myapp.services.ServiceCategorieProduit;
import com.mycompany.myapp.services.ServiceProduits;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ListProductsForm extends Form {
    Resources theme;

    public ListProductsForm(Form previous) {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES PRODUITS");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
         
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddProductForm(this).show());
          
           Ajout.setUIID("btnins");
           addAll(a,Ajout);
        
     
        for (Produits p : new ServiceProduits().getAllProduits()) {

                this.add(addItem(p));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();//HomeForm(this) erreur!!!
        });
    }
    
    public Container addItem(Produits p) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(p.getType());
        Button btn = new Button(p.getLibelle());
        lab.setUIID("libC");
        btn.setUIID("btn");
         String url = "http://127.0.0.1:8000/MobilePhoto/"+p.getType()+".jpg";
           Image imge;
                    EncodedImage enc;

                    enc = EncodedImage.createFromImage(theme.getImage("round.png"),false);
                    imge = URLImage.createToStorage(enc, url, url);
        ImageViewer imgv;
        imgv = new ImageViewer(imge);
    
    
        cn2.add(lab).add(btn);
      
        cn1.add(BorderLayout.EAST, imgv);


        cn1.add(BorderLayout.WEST, cn2);
 

        btn.addActionListener((ActionEvent e) -> {

            Form f2 = new Form(BoxLayout.y());
             Button Modifier = new Button(theme.getImage("edit.png"));
            Button Supprimer = new Button(theme.getImage("remove.png"));
            Label AJOUT = new Label("DETAILS");
            AJOUT.setUIID("login");
            f2.add(AJOUT);
      
            Label ProduitId = new Label("Id du produit");
            Label Id = new Label(String.valueOf(p.getId()));
            
            Label ProduitLibelle = new Label("Nom du produit");
            Label Libelle = new Label(String.valueOf(p.getLibelle()));
            
            Label ProduitQuantite = new Label("Quantite du produit");
            Label Quantite = new Label(String.valueOf(p.getQuantites()));
            
            Label ProduitPrix = new Label("Prix du produit");
            Label Prix = new Label (String.valueOf(p.getPrix()));
            
            Label ProduitType = new Label("Type du produit");
            Label Type = new Label(String.valueOf(p.getType()));
            
           
            Label Produitmodif = new Label("Modifier");
            Label Produitsupp = new Label("Supprimer");
   
     

           
            Id.setUIID("type2");
            Libelle.setUIID("type2");
            Quantite.setUIID("type2");
            Prix.setUIID("type2");
           Type.setUIID("type2");
            
         
       
            ProduitId.setUIID("type1");
            ProduitLibelle.setUIID("type1");
            ProduitQuantite.setUIID("type1");
            ProduitPrix.setUIID("type1");
            ProduitType.setUIID("type1");
            
            Produitmodif.setUIID("type1");
            Produitsupp.setUIID("type1");
           
Modifier.setUIID("btnins");
Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER PRODUIT");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                
               TextField tfIdProduit = new TextField("","Id");
        TextField tfLibelleProduit= new TextField("", "Libelle");
        TextField tfQuantiteProduit= new TextField("", "Quantite");
        TextField tfPrix= new TextField("", "Prix");
                                
ComboBox cmb_type1 = new ComboBox();
           
                            cmb_type1.setUIID("txtn");
                            for (CategorieProduit cp : new ServiceCategorieProduit().getAllCategorieProduit()) {

                               
                                 cmb_type1.addItem(cp.getTypecategorie());
                            
                            }
        
        
         Label a=new Label("    ");
               
                fmodifier.getToolbar().setUIID("tb");
                 fmodifier.addAll(tfIdProduit,tfLibelleProduit,tfQuantiteProduit,tfPrix,cmb_type1);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    Produits p1 = new Produits(Integer.parseInt(tfIdProduit.getText()),tfLibelleProduit.getText(),Integer.parseInt(tfQuantiteProduit.getText()),Integer.parseInt(tfPrix.getText()),cmb_type1.getSelectedItem().toString());
                        if( ServiceProduits.getInstance().UpdateProduits(p1))
                            Dialog.show("Success","Produit modifié",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListProductsForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                Form fsupprimer = new Form( BoxLayout.y());
                Label supp = new Label("SUPPRIMER PRODUITS");
        supp.setUIID("login");
        
          
fsupprimer.add(supp);
                Button submit = new Button("supprimer");
                submit.setUIID("vtnvalid");
                TextField tfId = new TextField("","id");
               
        
        ;
         Label a=new Label("    ");
               
                fsupprimer.getToolbar().setUIID("tb");
                 fsupprimer.addAll(tfId);
                 fsupprimer.addAll(a,submit);
                fsupprimer.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                
                submit.addActionListener(sub
                        -> {
                    int id=Integer.parseInt(tfId.getText());
                        if( ServiceProduits.getInstance().DeleteProduits(id))
                            Dialog.show("Success","Produit Supprimé",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListProductsForm(this).show();

                }
                );

                fsupprimer.show();


            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
   
           f2.addAll(ProduitId,Id,ProduitLibelle,Libelle,ProduitQuantite,Quantite,ProduitPrix,Prix,ProduitType,Type,Produitmodif,Modifier,Produitsupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
}
