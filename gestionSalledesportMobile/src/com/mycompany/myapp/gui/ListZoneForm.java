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
import com.mycompany.myapp.entities.Zone;
import com.mycompany.myapp.services.ServiceZone;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ListZoneForm extends Form {
    Resources theme;

    public ListZoneForm(Form previous) {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES ZONES");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
         
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddZoneForm(this).show());
          
           Ajout.setUIID("btnins");
           addAll(a,Ajout);
        
     
        for (Zone z : new ServiceZone().getAllZones()) {

                this.add(addItem(z));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();//HomeForm(this) erreur!!!
        });
    }
    
    public Container addItem(Zone z) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(z.getRegion());
        Button btn = new Button(z.getRegion());
        lab.setUIID("libC");
        btn.setUIID("btn");
        
    
        cn2.add(lab).add(btn);
        cn1.add(BorderLayout.WEST, cn2);
       
 

        btn.addActionListener((ActionEvent e) -> {

            Form f2 = new Form(BoxLayout.y());
             Button Modifier = new Button(theme.getImage("edit.png"));
            Button Supprimer = new Button(theme.getImage("remove.png"));
            Label AJOUT = new Label("DETAILS");
            AJOUT.setUIID("login");
            f2.add(AJOUT);
      
            Label ZoneRegion = new Label("Région");
            Label region = new Label(String.valueOf(z.getRegion()));
            Label ZoneLng = new Label("Longitude");
            Label lng = new Label(String.valueOf(z.getLng()));
            Label ZoneLat = new Label("Latitude");
            Label lat = new Label(String.valueOf(z.getLat()));
            Label Zonemodif = new Label("Modifier");
            Label Zonesupp = new Label("Supprimer");
   
     

           
            region.setUIID("type2");
            lng.setUIID("type2");
            lat.setUIID("type2");
         
       
            ZoneRegion.setUIID("type1");
            ZoneLng.setUIID("type1");
            ZoneLat.setUIID("type1");
            
            Zonemodif.setUIID("type1");
            Zonesupp.setUIID("type1");
           
         Modifier.setUIID("btnins");
         Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER ZONE");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                
               TextField tfRegion = new TextField("","region");
        TextField tfLng= new TextField("", "lng");
        TextField tfLat= new TextField("", "lat");
        ;
         Label a=new Label("    ");
               
                fmodifier.getToolbar().setUIID("tb");
                 fmodifier.addAll(tfRegion,tfLng,tfLat);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    Zone zon = new Zone(tfRegion.getText(),Float.parseFloat(tfLng.getText()),Float.parseFloat(tfLat.getText()));
                        if( ServiceZone.getInstance().updateZone(zon))
                            Dialog.show("Success","Zone Changée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListZoneForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                new ServiceZone().deleteZone(z);
                Dialog.show("Success","Zone supprimée",new Command("OK"));
               new ListZoneForm(this).show();

            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
   
           f2.addAll(ZoneRegion,region,ZoneLng,lng,ZoneLat,lat,Zonemodif,Modifier,Zonesupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
}
