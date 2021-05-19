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
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.services.ServiceBlog;
import java.io.IOException;

/**
 *
 * @author Yassine Karoui
 */


public class AddBlogForm extends Form {
    String file ;
    Resources theme = UIManager.initFirstTheme("/theme");
    public AddBlogForm(Form previous) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU BLOG");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
        Label a=new Label("    ");

        TextField tfTitre= new TextField("", "Titre");
        TextField tfText= new TextField("", "Text");
        TextField tfAuteur= new TextField("", "Auteur");
        
        
         Button upload = new Button("Telecharger Une Image");
        
     
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
                    String out = tfTitre.getText();
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += tfTitre.getText() + ".jpg";
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
        
        
        
        Button btnValider = new Button("Ajouter Blog");
        
        btnValider.setUIID("vtnvalid");
       
     
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (tfTitre.getText().equals("") || tfText.getText().equals("") || tfAuteur.getText().equals(""))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Blog b = new Blog(tfTitre.getText(),file,tfText.getText(),tfAuteur.getText());
                        if(ServiceBlog.getInstance().ajouterBlog(b))
                            Dialog.show("Success","Salle Ajoutée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
        addAll(tfTitre,tfText,tfAuteur);
          addAll(a,upload,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
   
    }
    AddBlogForm() {
       super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU BLOG");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        
 Label a=new Label("    ");

       TextField tfTitre= new TextField("", "Titre");
        TextField tfText= new TextField("", "Text");
        TextField tfAuteur= new TextField("", "Auteur");
        
       Button upload = new Button("Telecharger Une Image");
        
 
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
                    String out = tfTitre.getText();
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += tfTitre.getText() + ".jpg";
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
          
          
          
          Button btnValider = new Button("Ajouter Blog");
        
          btnValider.setUIID("vtnvalid");
     
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tfTitre.getText().equals("") || tfText.getText().equals("") || tfAuteur.getText().equals(""))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Blog b = new Blog(tfTitre.getText(),file,tfText.getText(),tfAuteur.getText());
                       if( ServiceBlog.getInstance().ajouterBlog(b))
                            Dialog.show("Success","Salle Ajoutée",new Command("OK"));
                       else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
         
        addAll(tfTitre,tfText,tfAuteur);
          addAll(a,upload,btnValider);
         this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
               new HomeForm().show();
            });
    
    }
}
