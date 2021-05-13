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

import com.mycompany.myapp.services.ServiceCategorie;
import com.mycompany.myapp.services.ServiceCours;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author bhk
 */
public class AddCategorieForm extends Form{
 String file ;
   Resources theme = UIManager.initFirstTheme("/theme");
    public AddCategorieForm(Form previous) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE CATEGORIE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

        TextField tfId = new TextField("","ID",20, TextArea.NUMERIC);
        TextField tfDescription= new TextField("", "description");
        TextField tfType= new TextField("", "Type");
        Button upload = new Button("Telecharger Une Image");
        Button btnValider = new Button("Ajouter Categorie");
         upload.setUIID("vtnvalid");
          btnValider.setUIID("vtnvalid");
       
     
         upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                      
                    String fileNameInServer = "";
                    MultipartRequest cr = new MultipartRequest();
                    String filepath = Capture.capturePhoto(-1, -1);
                    cr.setUrl("http://127.0.0.1:8000/uploadimage.php");
                    cr.setPost(true);
                    String mime = "image/jpeg";
                    cr.addData("file", filepath, mime);
                    String out = tfType.getText();
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += tfType.getText() + ".jpg";
                    System.err.println("path2 =" + fileNameInServer);
                    file=fileNameInServer;
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                                        
            }
        });
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfId.getText().length()==0)||(tfDescription.getText().length()==0)||(tfType.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Categorie t = new Categorie(tfType.getText(),tfDescription.getText(),file,Integer.parseInt(tfId.getText()));
                        if( ServiceCategorie.getInstance().addCategorie(t))
                            Dialog.show("Success","Categorie Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfId,tfDescription,tfType);
          addAll(a,upload,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    }

    AddCategorieForm() {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVELLE CATEGORIE");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("libC");
        this.add(logi);
         
   Label a=new Label("    ");
  

        TextField tfId = new TextField("","ID",20, TextArea.NUMERIC);
        TextField tfDescription= new TextField("", "description");
        TextField tfType= new TextField("", "Type");
        Button upload = new Button("Telecharger Une Image");
        Button btnValider = new Button("Ajouter Categorie");
         upload.setUIID("vtnvalid");
          btnValider.setUIID("vtnvalid");
         upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                      
                    String fileNameInServer = "";
                    MultipartRequest cr = new MultipartRequest();
                    String filepath = Capture.capturePhoto(-1, -1);
                    cr.setUrl("http://127.0.0.1:8000/uploadimage.php");
                    cr.setPost(true);
                    String mime = "image/jpeg";
                    cr.addData("file", filepath, mime);
                    String out = tfType.getText();
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += tfType.getText() + ".jpg";
                    System.err.println("path2 =" + fileNameInServer);
                    file=fileNameInServer;
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                                        
            }
        });
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfId.getText().length()==0)||(tfDescription.getText().length()==0)||(tfType.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Categorie t = new Categorie(tfType.getText(),tfDescription.getText(),file,Integer.parseInt(tfId.getText()));
                        if( ServiceCategorie.getInstance().addCategorie(t))
                            Dialog.show("Success","Categorie Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfId,tfDescription,tfType);
        addAll(a,btnValider,upload);
        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    }
   
    
    
}
