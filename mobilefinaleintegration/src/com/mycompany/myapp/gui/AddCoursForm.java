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
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Cours;

import com.mycompany.myapp.services.ServiceCategorie;
import com.mycompany.myapp.services.ServiceCours;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Salledesport;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceSalledesport;
import com.mycompany.myapp.services.ServiceUtilisateur;
import java.util.Date;
/**
 *
 * @author bhk
 */
public class AddCoursForm extends Form{
 Resources theme = UIManager.initFirstTheme("/theme");
    public AddCoursForm(Form previous) {
          
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
     super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU COURS");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("libC");
        this.add(logi);
        ComboBox cmb_nomS = new ComboBox();
        ComboBox cmb_type = new ComboBox();
        ComboBox cmb_mailCoach = new ComboBox();
        TextField tfId = new TextField("","ID");
     
        TextField tfheure= new TextField("", "heure");
        TextField tfduree= new TextField("", "duree");
       Picker  DATE = new Picker ();
        DATE.setUIID("txtn");
       
         cmb_mailCoach.setUIID("txtn");
                            
                            for (Utilisateur s : new ServiceUtilisateur().getAllUsers()) {

                               
                                 cmb_mailCoach.addItem(s.getEmail());
                                

                            }
       
        
                            cmb_nomS.setUIID("txtn");
                            for (Salledesport s : new ServiceSalledesport().getAllSalles()) {

                               
                                 cmb_nomS.addItem(s.getNomSalle());
                                

                            }
        TextField tfPlaceDisponible= new TextField("", "PlaceDisponible");
          
            DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
                                    Date ddebut = DATE.getDate();
                                    String dated = dd.format(ddebut);
           
 cmb_type.setUIID("txtn");
                            cmb_type.setUIID("txtn");
                            for (Categorie cat : new ServiceCategorie().getAllCategories()) {

                               
                                 cmb_type.addItem(cat.getType());
                                

                            }
                        
        Button btnValider = new Button("Ajouter Cours");
                  btnValider.setUIID("vtnvalid");

        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 
            
                if ((tfId.getText().length()==0)||(tfduree.getText().length()==0)||(tfheure.getText().length()==0)||(tfPlaceDisponible.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                   
                         String url = "http://127.0.0.1:8000/qrcode.php";

              
                        
                     
                         ConnectionRequest cnreq = new ConnectionRequest();
                cnreq.setPost(false);
                String data = "ID Cours : " + tfId.getText() + " Type : " +cmb_type.getSelectedItem().toString()  + "Date :" + dated + " Heure : " + tfheure.getText() + "Duree : " + tfduree.getText() +"MailCoach : " + cmb_mailCoach.getSelectedItem().toString() +"NomSalle: "+cmb_nomS.getSelectedItem().toString()+"PlaceDisponible : " + tfPlaceDisponible.getText() + "Merci pour votre confiance &#128525;";
 
                cnreq.addArgument("data", data);
                cnreq.setUrl(url);
                cnreq.addResponseListener(evx
                        -> {
                     String Image = new String(cnreq.getResponseData());
                      Cours c = new Cours(tfId.getText(),cmb_type.getSelectedItem().toString(),dated,Integer.parseInt(tfheure.getText()),Integer.parseInt(tfduree.getText()),cmb_mailCoach.getSelectedItem().toString(),cmb_nomS.getSelectedItem().toString(),Integer.parseInt(tfPlaceDisponible.getText()),Image);
                   
                  if( ServiceCours.getInstance().addCours(c))
                            Dialog.show("Success","Cours Ajouté",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    
                }
                );
               NetworkManager.getInstance().addToQueueAndWait(cnreq);

                       
                     
                    
                }
                
                
            }
        });
        Label a=new Label("    ");
        
        addAll(tfId,tfheure,cmb_type,tfduree,DATE,cmb_mailCoach,cmb_nomS,tfPlaceDisponible);
        addAll(a,btnValider);
       this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    }
      AddCoursForm() {
            
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
     super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU COURS");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("libC");
        this.add(logi);
        
        TextField tfId = new TextField("","ID");
     
        TextField tfheure= new TextField("", "heure");
        TextField tfduree= new TextField("", "duree");
       Picker  DATE = new Picker ();
        DATE.setUIID("txtn");
        TextField tfmailcoach= new TextField("", "mailcoach");
        TextField tfsalledesport= new TextField("", "Nomdesalle");
        TextField tfPlaceDisponible= new TextField("", "PlaceDisponible");
          ComboBox cmb_type = new ComboBox();
           
            DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
                                    Date ddebut = DATE.getDate();
                                    String dated = dd.format(ddebut);
           
 cmb_type.setUIID("txtn");
                            cmb_type.setUIID("txtn");
                            for (Categorie cat : new ServiceCategorie().getAllCategories()) {

                               
                                 cmb_type.addItem(cat.getType());
                                

                            }
                        
        Button btnValider = new Button("Ajouter Cours");
                  btnValider.setUIID("vtnvalid");

        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 
            
                if ((tfId.getText().length()==0)||(tfmailcoach.getText().length()==0)||(tfsalledesport.getText().length()==0)||(tfduree.getText().length()==0)||(tfheure.getText().length()==0)||(tfPlaceDisponible.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                   
                         String url = "http://127.0.0.1:8000/qrcode.php";

              
                        
                     
                         ConnectionRequest cnreq = new ConnectionRequest();
                cnreq.setPost(false);
                String data = "ID Cours : " + tfId.getText() + " Type : " +cmb_type.getSelectedItem().toString()  + "Date :" + dated + " Heure : " + tfheure.getText() + "Duree : " + tfduree.getText() +"MailCoach : " + tfmailcoach.getText() +"PlaceDisponible : " + tfPlaceDisponible.getText() + "Merci pour votre confiance &#128525;";
 
                cnreq.addArgument("data", data);
                cnreq.setUrl(url);
                cnreq.addResponseListener(evx
                        -> {
                     String Image = new String(cnreq.getResponseData());
                      Cours c = new Cours(tfId.getText(),cmb_type.getSelectedItem().toString(),dated,Integer.parseInt(tfheure.getText()),Integer.parseInt(tfduree.getText()),tfmailcoach.getText(),tfsalledesport.getText(),Integer.parseInt(tfPlaceDisponible.getText()),Image);
                   
                  if( ServiceCours.getInstance().addCours(c))
                            Dialog.show("Success","Cours Ajouté",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    
                }
                );
               NetworkManager.getInstance().addToQueueAndWait(cnreq);

                       
                     
                    
                }
                
                
            }
        });
        Label a=new Label("    ");
        
        addAll(tfId,tfheure,cmb_type,tfduree,DATE,tfmailcoach,tfsalledesport,tfPlaceDisponible);
        addAll(a,btnValider);
       this.getToolbar().setUIID("tb");
            this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });

    }
   
    
    
}
 