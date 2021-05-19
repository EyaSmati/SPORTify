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
import com.mycompany.myapp.entities.Salledesport;
import com.mycompany.myapp.entities.Zone;
import com.mycompany.myapp.services.ServiceSalledesport;
import com.mycompany.myapp.services.ServiceZone;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ListSalledesportForm extends Form {
    Resources theme;

    public ListSalledesportForm(Form previous) {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES SALLES DE SPORT");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
         
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddSalledesportForm(this).show());
          
           Ajout.setUIID("btnins");
           addAll(a,Ajout);
        
     
        for (Salledesport s : new ServiceSalledesport().getAllSalles()) {

                this.add(addItem(s));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();//HomeForm(this) erreur!!!
        });
    }
    
    public Container addItem(Salledesport s) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(s.getNomSalle());
        Button btn = new Button(s.getRegion());
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
      
            Label SalleId = new Label("Id de la Salle");
            Label idSalle = new Label(String.valueOf(s.getIdSalle()));
            Label SalleNom = new Label("Nom de la Salle");
            Label nomSalle = new Label(String.valueOf(s.getNomSalle()));
            Label SalleAdresse = new Label("Adresse de la salle");
            Label adresse = new Label(String.valueOf(s.getAdresse()));
            Label SalleRegion = new Label("Région où se trouve la Salle");
            Label region = new Label(s.getRegion());
            Label SalleHdebut = new Label("Heure d'ouverture");
            Label hdebut = new Label(String.valueOf(s.getHdebut()));
            Label SalleHfin= new Label("heure de fermeture");
            Label hfin = new Label(String.valueOf(s.getHfin()));
            Label SalleMin= new Label("Minute");
            Label min = new Label(String.valueOf(s.getMin()));
            Label SalleNumtel= new Label("N°Tel");
            Label numtel = new Label(String.valueOf(s.getNumtel()));
            Label Sallemodif = new Label("Modifier");
            Label Sallesupp = new Label("Supprimer");
   
     

           
            idSalle.setUIID("type2");
            nomSalle.setUIID("type2");
            adresse.setUIID("type2");
            region.setUIID("type2");
            hdebut.setUIID("type2");
            hfin.setUIID("type2");
            min.setUIID("type2");
            numtel.setUIID("type2");
         
       
            SalleId.setUIID("type1");
            SalleNom.setUIID("type1");
            SalleAdresse.setUIID("type1");
            SalleRegion.setUIID("type1");
            SalleHdebut.setUIID("type1");
            SalleHfin.setUIID("type1");
            SalleMin.setUIID("type1");
            SalleNumtel.setUIID("type1");
            
            Sallemodif.setUIID("type1");
            Sallesupp.setUIID("type1");
           
Modifier.setUIID("btnins");
Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER SALLE");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                
              // TextField tfIdSalle = new TextField("","idSalle");
               ComboBox cmb_idSalle = new ComboBox();
               cmb_idSalle.setUIID("txtn");
               cmb_idSalle.addItem(s.getIdSalle());
        TextField tfNomSalle= new TextField("", "nomSalle");
        TextField tfAdresse= new TextField("", "adresse");
        ComboBox cmb_Region1 = new ComboBox();
           
                            cmb_Region1.setUIID("txtn");
                            for (Zone zon : new ServiceZone().getAllZones()) {

                               
                                 cmb_Region1.addItem(zon.getRegion());
                                

                            }
        TextField tfHdebut= new TextField("", "hdebut");
        TextField tfHfin= new TextField("", "hfin");
        TextField tfMin= new TextField("", "min");
        TextField tfNumtel= new TextField("", "numtel");
        ;
         Label a=new Label("    ");
               
                fmodifier.getToolbar().setUIID("tb");
                 fmodifier.addAll(cmb_idSalle,tfNomSalle,tfAdresse,cmb_Region1,tfHdebut,tfHfin,tfMin,tfNumtel);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    Salledesport salle = new Salledesport(cmb_idSalle.getSelectedItem().toString(),tfNomSalle.getText(),tfAdresse.getText(),cmb_Region1.getSelectedItem().toString(),Integer.parseInt(tfHdebut.getText()),Integer.parseInt(tfHfin.getText()),Integer.parseInt(tfMin.getText()),Integer.parseInt(tfNumtel.getText()));
                        if( ServiceSalledesport.getInstance().updateSalledesport(salle))
                            Dialog.show("Success","Salle de sport Changée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListSalledesportForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                new ServiceSalledesport().deleteSalledesport(s);
               
                            Dialog.show("Success","Salle de sport supprimée",new Command("OK"));
                        
               new ListSalledesportForm(this).show();

            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
   
           f2.addAll(SalleId,idSalle,SalleNom,nomSalle,SalleAdresse,adresse,SalleRegion,region,SalleHdebut,hdebut,SalleHfin,hfin,SalleMin,min,SalleNumtel,numtel,Sallemodif,Modifier,Sallesupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
}
