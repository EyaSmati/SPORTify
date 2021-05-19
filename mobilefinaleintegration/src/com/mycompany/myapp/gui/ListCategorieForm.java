/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.AutoCompleteTextField;
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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceCategorie;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;


/**
 *
 * @author bhk
 */
public class ListCategorieForm extends Form{
     String file ;

       Resources theme;

    public ListCategorieForm(Form previous) {
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES CATEGORIES");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
         
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddCategorieForm(this).show());
          
           Ajout.setUIID("btnins");
           addAll(a,Ajout);
        
          
          

          
           
           
      

   

        for (Categorie c : new ServiceCategorie().getAllCategories()) {

           
                this.add(addItem(c));
            

        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm(this).show();
        });
    }

    public Container addItem(Categorie c) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(c.getType());
        Button btn = new Button(c.getDescription());
        lab.setUIID("libC");
        btn.setUIID("btn");
        String url = "http://127.0.0.1:8000/MobilePhoto/"+c.getImage();
        ImageViewer imgv;
        Image imge;
        EncodedImage enc;

        enc = EncodedImage.createFromImage(theme.getImage("round.png"), false);
        imge = URLImage.createToStorage(enc, url, url);
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
      
            Label CategorieID = new Label("ID De La Categorie");
            Label id = new Label(String.valueOf(c.getId()));
            Label CategorieNAME = new Label("Type");
            Label lname = new Label(c.getType());
            Label CategorieDSC = new Label("Description");
            Label Categorieimage = new Label("Image");
            Label Categoriemodif = new Label("Modifier");
            Label Categoriesupp = new Label("Supprimer");
            Label lemail = new Label(c.getDescription());
            String url2 = "http://127.0.0.1:8000/"+c.getImage();
            ImageViewer imgv2;
            Image imge2;
            EncodedImage enc2;
            enc2 = EncodedImage.createFromImage(theme.getImage("round.png"), false);
            imge2 = URLImage.createToStorage(enc, url, url);
            imgv2 = new ImageViewer(imge2);
     

           

            lname.setUIID("type2");
            lemail.setUIID("type2");
            id.setUIID("type2");
         
       
            CategorieNAME.setUIID("type1");
            CategorieDSC.setUIID("type1");
            CategorieID.setUIID("type1");
            Categorieimage.setUIID("type1");
            Categoriemodif.setUIID("type1");
            Categoriesupp.setUIID("type1");
           
Modifier.setUIID("btnins");
Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER CATEGORIE");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                
             //  TextField tfId = new TextField("","ID");
               ComboBox cmb_id = new ComboBox();
               cmb_id.setUIID("txtn");
               cmb_id.addItem(c.getId());
        TextField tfDescription= new TextField("", "description");
        TextField tfType= new TextField("", "Type");
        TextField tfImage= new TextField("", "Image");
         Label a=new Label("    ");
               
                fmodifier.getToolbar().setUIID("tb");
                 fmodifier.addAll(cmb_id,tfDescription,tfType,tfImage);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    Categorie t = new Categorie(tfType.getText(),tfDescription.getText(),tfImage.getText(),Integer.parseInt(cmb_id.getSelectedItem().toString()));
                        if( ServiceCategorie.getInstance().updateCategorie(t))
                            Dialog.show("Success","Categorie Changée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListCategorieForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                new ServiceCategorie().deleteCategorie(c.getType());
               new ListCategorieForm(this).show();

            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
   
           f2.addAll(CategorieID,id,CategorieNAME,lname,CategorieDSC,lemail,Categorieimage,imgv2,Categoriemodif,Modifier,Categoriesupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
    
}
