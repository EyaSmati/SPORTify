/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.services.ServiceBlog;

/**
 *
 * @author Yassine Karoui
 */

public class ListBlogForm extends Form {
    Resources theme;

    public ListBlogForm(Form previous) {
      super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES BLOGS");
             theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
           Label a=new Label("    ");
         
        
          Button Ajout = new Button(theme.getImage("add.png"));
          Ajout.addActionListener(e -> new AddBlogForm(this).show());
          
           Ajout.setUIID("btnins");
           addAll(a,Ajout);
        
     
        for (Blog s : new ServiceBlog().AfficherBlogs()) {

                this.add(addItem(s));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();//HomeForm(this) erreur!!!
        });
    }
    
    public Container addItem(Blog s) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
   
      
        Label lab = new Label(s.getTitre());
        Button btn = new Button(s.getAuteur());
        lab.setUIID("libC");
        btn.setUIID("btn");
        String url = "http://127.0.0.1:8000/MobilePhoto/"+s.getImage();
        System.out.println(s.getImage());
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
      
            Label BlogTitre = new Label("Titre du blog");
            Label titreBlog = new Label(String.valueOf(s.getTitre()));
            
            Label BlogText = new Label("Text");
            Label textBlog = new Label(String.valueOf(s.getTexte()));
            
            Label BlogAuteur = new Label("Auteur");
            Label auteurBlog = new Label(String.valueOf(s.getAuteur()));
            
            Label Categorieimage = new Label("image");
            
            Label Blogmodif = new Label("Modifier");
            Label Blogsupp = new Label("Supprimer");
            String url2 = "http://127.0.0.1:8000/"+s.getImage();
            ImageViewer imgv2;
            Image imge2;
            EncodedImage enc2;
            enc2 = EncodedImage.createFromImage(theme.getImage("round.png"), false);
            imge2 = URLImage.createToStorage(enc, url, url);
            imgv2 = new ImageViewer(imge2);
   
     

           
            titreBlog.setUIID("type2");
            textBlog.setUIID("type2");
            auteurBlog.setUIID("type2");
            
       
            BlogTitre.setUIID("type1");
            BlogText.setUIID("type1");
            BlogAuteur.setUIID("type1");
            
            Categorieimage.setUIID("type1");
            Blogmodif.setUIID("type1");
            Blogsupp.setUIID("type1");
           
            Modifier.setUIID("btnins");
            Supprimer.setUIID("btnins");

         
            Modifier.addActionListener(mod
                    -> {
                      Form fmodifier = new Form( BoxLayout.y());
                Label modif = new Label("MODIFIER BLOG");
        modif.setUIID("login");
        
          
fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                //TextField tfId = new TextField("","id");
                 ComboBox cmb_id = new ComboBox();
               cmb_id.setUIID("txtn");
               cmb_id.addItem(s.getId());
               TextField tfTitre = new TextField("","Titre");
        TextField tfText= new TextField("", "text");
        TextField tfAuteur= new TextField("", "Auteur");
        
        ;
         Label a=new Label("    ");
               
                fmodifier.getToolbar().setUIID("tb");
                 fmodifier.addAll(cmb_id,tfTitre,tfText,tfAuteur);
                 fmodifier.addAll(a,submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                
                submit.addActionListener(sub
                        -> {
                    //int id=Integer.parseInt(tfId.getText());
                    Blog blog = new Blog(Integer.parseInt(cmb_id.getSelectedItem().toString()),tfTitre.getText(),tfText.getText(),tfAuteur.getText());
                        if( ServiceBlog.getInstance().modifierBlog(blog))
                            Dialog.show("Success","Blog Changée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListBlogForm(this).show();

                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                      Form fsupprimer = new Form( BoxLayout.y());
                Label supp = new Label("SUPPRIMER BLOG");
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
                        if( ServiceBlog.getInstance().supprimerBlog(id))
                            Dialog.show("Success","Blog Supprimée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListBlogForm(this).show();

                }
                );

                fsupprimer.show();
            }
            );
            
          
           f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });
   
           f2.addAll(BlogTitre,titreBlog,BlogText,textBlog,BlogAuteur,auteurBlog,Categorieimage,imgv2,Blogmodif,Modifier,Blogsupp,Supprimer);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }
}


