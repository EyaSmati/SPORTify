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
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.services.ServiceCategorie;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceCours;
import com.mycompany.myapp.services.ServiceCours;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ListCourseForm extends Form{
    String file ;

       Resources theme;

    public ListCourseForm(Form previous) {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES COURS");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddCoursForm(this).show());
          
           Ajout.setUIID("btnins");
           add(Ajout);

           add(a);
          
           
           
      

   

        for (Cours c : new ServiceCours().getAllTasks()) {

           
                this.add(addItem(c));
            

        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });
    }
     public Container addItem(Cours c) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(c.getTypeCours());
              
        Button btn = new Button(c.getDate());
      

        lab.setUIID("libC");
        btn.setUIID("btn");
            String url = "http://127.0.0.1:8000/MobilePhoto/"+c.getTypeCours()+".jpg";

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
          
     
      
            Label CoursID = new Label("Identifiant ");
            Label id = new Label(String.valueOf(c.getIdCours()));
            Label CoursNAME = new Label("Type");
            Label lname = new Label(c.getTypeCours());
            Label CoursDSC = new Label("Date");
            Label date = new Label(String.valueOf(c.getDate()));
            Label Coursheure = new Label("Heure");
            Label heure = new Label(String.valueOf(c.getHeure()));
             Label CoursDuree = new Label("Duree");
            Label duree = new Label(String.valueOf(c.getDuree()));
            Label CoursPlaceDispo = new Label("Place Disponible");
            Label dispo = new Label(String.valueOf(c.getPlace_Disponible()));
             Label CoursCoach = new Label("Coach");
            Label coach = new Label(c.getMailCoach());
             Label Categorieimage = new Label("QRCODE");
            Label Categoriemodif = new Label("Modifier");
            Label Categoriesupp = new Label("Supprimer");
            
             
            
              String url2 = "http://127.0.0.1:8000/qrcode/"+c.getQrcode();
            ImageViewer imgv2;
            Image imge2=Image.createImage(400,400);
            EncodedImage enc2;
            enc2 = EncodedImage.createFromImage(imge2,false);
            imge2 = URLImage.createToStorage(enc2, url2, url2);
            imgv2 = new ImageViewer(imge2);

            
         

           

            lname.setUIID("type2");
            date.setUIID("type2");
            id.setUIID("type2");
            heure.setUIID("type2");
            duree.setUIID("type2");
            dispo.setUIID("type2");
             coach.setUIID("type2");
         
       
            CoursNAME.setUIID("type1");
            CoursDSC.setUIID("type1");
            Coursheure.setUIID("type1");
            CoursDuree.setUIID("type1");
            CoursPlaceDispo.setUIID("type1");
            CoursID.setUIID("type1");
            CoursCoach.setUIID("type1");
              Categorieimage.setUIID("type1");
            Categoriemodif.setUIID("type1");
            Categoriesupp.setUIID("type1");
           
Modifier.setUIID("btnins");
Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER Cours");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("MODIFIER");
                submit.setUIID("vtnvalid");
                
             TextField tfId1 = new TextField("","ID");
     
        TextField tfheure1= new TextField("", "heure");
        TextField tfduree1= new TextField("", "duree");
       Picker  DATE = new Picker ();
        DATE.setUIID("txtn");
        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
         Date ddebut = DATE.getDate();
         String dated = dd.format(ddebut);
        TextField tfmailcoach1= new TextField("", "mailcoach");
        TextField tfsalledesport1= new TextField("", "Nomdesalle");
        TextField tfPlaceDisponible1= new TextField("", "PlaceDisponible");
              ComboBox cmb_type1 = new ComboBox();
           
                            cmb_type1.setUIID("txtn");
                            for (Categorie cat : new ServiceCategorie().getAllCategories()) {

                               
                                 cmb_type1.addItem(cat.getType());
                                

                            }
                        
         Label a=new Label("    ");
               
               
                 fmodifier. addAll(tfId1,tfheure1,cmb_type1,tfduree1,DATE,tfmailcoach1,tfsalledesport1,tfPlaceDisponible1);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                      String url1 = "http://127.0.0.1:8000/qrcode.php";

              
                        
                     
                         ConnectionRequest cnreq = new ConnectionRequest();
                cnreq.setPost(false);
                String data = "ID Cours : " + tfId1.getText() + " Type : " +cmb_type1.getSelectedItem().toString()  + "Date :" + dated + " Heure : " + tfheure1.getText() + "Duree : " + tfduree1.getText() +"MailCoach : " + tfmailcoach1.getText() +"PlaceDisponible : " + tfPlaceDisponible1.getText() + "Merci pour votre confiance &#128525;";
 
                cnreq.addArgument("data", data);
                cnreq.setUrl(url1);
                cnreq.addResponseListener(evx
                        -> {
                     String Image = new String(cnreq.getResponseData());
                      Cours c1 = new Cours(tfId1.getText(),cmb_type1.getSelectedItem().toString(),dated,Integer.parseInt(tfheure1.getText()),Integer.parseInt(tfduree1.getText()),tfmailcoach1.getText(),tfsalledesport1.getText(),Integer.parseInt(tfPlaceDisponible1.getText()),Image);
                   
                  if( ServiceCours.getInstance().UpdateCours(c1))
                            Dialog.show("Success","Cours Modifié",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    
                }
                );
               NetworkManager.getInstance().addToQueueAndWait(cnreq);
                    new ListCourseForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                new ServiceCours().DeleteCours(c.getIdCours());
               new ListCourseForm(this).show();

            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
          
           f2.addAll(CoursID,id,CoursNAME,lname,CoursDSC,date,Coursheure,heure,CoursDuree,duree,CoursPlaceDispo,dispo,CoursCoach,coach,Categorieimage,imgv2,Categoriemodif,Modifier,Categoriesupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
    
    
}
