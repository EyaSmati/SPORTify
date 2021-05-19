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
import com.codename1.ui.ComboBox;
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
import com.mycompany.myapp.entities.Salledesport;
import com.mycompany.myapp.entities.Zone;
import com.mycompany.myapp.services.ServiceSalledesport;
import com.mycompany.myapp.services.ServiceZone;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author asus
 */
public class AddSalledesportForm extends Form {
    
   Resources theme = UIManager.initFirstTheme("/theme");
    public AddSalledesportForm(Form previous) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE SALLE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

        TextField tfIdSalle = new TextField("","idSalle");
        TextField tfNomSalle= new TextField("", "nomSalle");
        TextField tfAdresse= new TextField("", "adresse");
        ComboBox cmb_Region = new ComboBox();
        cmb_Region.setUIID("txtn");
                            cmb_Region.setUIID("txtn");
                            for (Zone zon : new ServiceZone().getAllZones()) {

                               
                                 cmb_Region.addItem(zon.getRegion());}
         
        TextField tfHdebut= new TextField("", "hdebut");
        TextField tfHfin= new TextField("", "hfin");
        TextField tfMin= new TextField("", "min");
        TextField tfNumtel= new TextField("", "numtel");
       
        Button btnValider = new Button("Ajouter Salle");
        
          btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfIdSalle.getText().length()==0)||(tfNomSalle.getText().length()==0)||(tfAdresse.getText().length()==0)||(tfHdebut.getText().length()==0)||(tfHfin.getText().length()==0)||(tfMin.getText().length()==0)||(tfNumtel.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Salledesport s = new Salledesport(tfIdSalle.getText(),tfNomSalle.getText(),tfAdresse.getText(),cmb_Region.getSelectedItem().toString(),Integer.parseInt(tfHdebut.getText()),Integer.parseInt(tfHfin.getText()),Integer.parseInt(tfMin.getText()),Integer.parseInt(tfNumtel.getText()));
                        if( ServiceSalledesport.getInstance().addSalledesport(s))
                            Dialog.show("Success","Salle Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
        addAll(tfIdSalle,tfNomSalle,tfAdresse,cmb_Region,tfHdebut,tfHfin,tfMin,tfNumtel);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
   
    }
    AddSalledesportForm() {
       super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE SALLE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

        TextField tfIdSalle = new TextField("","idSalle");
        TextField tfNomSalle= new TextField("", "nomSalle");
        TextField tfAdresse= new TextField("", "adresse");
        ComboBox cmb_Region = new ComboBox();
        cmb_Region.setUIID("txtn");
                            cmb_Region.setUIID("txtn");
                            for (Zone zon : new ServiceZone().getAllZones()) {

                               
                                 cmb_Region.addItem(zon.getRegion());}
         
        TextField tfHdebut= new TextField("", "hdebut");
        TextField tfHfin= new TextField("", "hfin");
        TextField tfMin= new TextField("", "min");
        TextField tfNumtel= new TextField("", "numtel");
       
        Button btnValider = new Button("Ajouter Salle");
        
          btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfIdSalle.getText().length()==0)||(tfNomSalle.getText().length()==0)||(tfAdresse.getText().length()==0)||(tfHdebut.getText().length()==0)||(tfHfin.getText().length()==0)||(tfMin.getText().length()==0)||(tfNumtel.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Salledesport s = new Salledesport(tfIdSalle.getText(),tfNomSalle.getText(),tfAdresse.getText(),cmb_Region.getSelectedItem().toString(),Integer.parseInt(tfHdebut.getText()),Integer.parseInt(tfHfin.getText()),Integer.parseInt(tfMin.getText()),Integer.parseInt(tfNumtel.getText()));
                        if( ServiceSalledesport.getInstance().addSalledesport(s))
                            Dialog.show("Success","Salle Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
        addAll(tfIdSalle,tfNomSalle,tfAdresse,cmb_Region,tfHdebut,tfHfin,tfMin,tfNumtel);
          addAll(a,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    
    }
}
    