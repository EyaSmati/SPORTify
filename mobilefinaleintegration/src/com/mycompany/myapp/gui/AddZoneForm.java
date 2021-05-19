/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Zone;
import com.mycompany.myapp.services.ServiceZone;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author asus
 */
public class AddZoneForm extends Form{
   
   Resources theme = UIManager.initFirstTheme("/theme");
    public AddZoneForm(Form previous) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE ZONE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

        TextField tfRegion = new TextField("","region");
        TextField tfLng= new TextField("", "lng");
        TextField tfLat= new TextField("", "lat");
       
        Button btnValider = new Button("Ajouter Zone");
        
          btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfRegion.getText().length()==0)||(tfLng.getText().length()==0)||(tfLat.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Zone z = new Zone(tfRegion.getText(),Float.parseFloat(tfLng.getText()),Float.parseFloat(tfLat.getText()));
                        if( ServiceZone.getInstance().addZone(z))
                            Dialog.show("Success","Zone Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfRegion,tfLng,tfLat);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    }

    AddZoneForm() {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE ZONE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("libC");
        this.add(logi);
         
   Label a=new Label("    ");
  

        TextField tfRegion = new TextField("","region");
        TextField tfLng= new TextField("", "lng");
        TextField tfLat= new TextField("", "lat");
       
        Button btnValider = new Button("Ajouter Zone");
        
          btnValider.setUIID("vtnvalid");
         
   
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfRegion.getText().length()==0)||(tfLng.getText().length()==0)||(tfLat.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Zone z = new Zone(tfRegion.getText(),Float.parseFloat(tfLng.getText()),Float.parseFloat(tfLat.getText()));
                        if( ServiceZone.getInstance().addZone(z))
                            Dialog.show("Success","Categorie Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
         addAll(tfRegion,tfLng,tfLat);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    }
    
}
