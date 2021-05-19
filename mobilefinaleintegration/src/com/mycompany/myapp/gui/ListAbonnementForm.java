/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.entities.abonnement;
import com.mycompany.myapp.services.ServiceAbonnement;
import com.mycompany.myapp.services.ServiceUtilisateur;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class ListAbonnementForm extends Form {

    Resources theme;

    public ListAbonnementForm(Form previous) {
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES ABONNEMENTS");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        Label a = new Label("    ");

        Button Ajout = new Button(theme.getImage("add.png"));
        Ajout.addActionListener(e -> new AddAbonnementForm(this).show());

        Ajout.setUIID("btnins");
        addAll(a, Ajout);

        for (abonnement c : new ServiceAbonnement().getAllAbonnements()) {

            this.add(addItem(c));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });
    }
    

    public Container addItem(abonnement c) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());

        Label lab = new Label(c.getTypeAbonnement());
        Button btn = new Button(c.getTypeAbonnement());
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

            Label AbType = new Label("Type De L'Abonnement");
            Label type = new Label(String.valueOf(c.getTypeAbonnement()));
            Label AbPrix = new Label("Nbplaces");
            Label prix = new Label(String.valueOf(c.getPrixAbonnement()));
            Label AbDate = new Label("Date de Creation");
            Label datecreation = new Label(String.valueOf(c.getDatecreation()));
            Label AbSurom = new Label("Surnom");
            Label surnom = new Label(c.getSurnomUser());
            Label Abonnementmodif = new Label("Modifier");
            Label Abonnementsupp = new Label("Supprimer");

           

            type.setUIID("type2");
            prix.setUIID("type2");
            datecreation.setUIID("type2");
            surnom.setUIID("type2");

            AbType.setUIID("type1");
            AbPrix.setUIID("type1");
            AbDate.setUIID("type1");
            AbSurom.setUIID("type1");
            Abonnementmodif.setUIID("type1");
            Abonnementsupp.setUIID("type1");

            Modifier.setUIID("btnins");
            Supprimer.setUIID("btnins");

            Modifier.addActionListener(mod
                    -> {
                Form fmodifier = new Form(BoxLayout.y());
                Label modif = new Label("MODIFIER ABONNEMENT");
                modif.setUIID("login");

                fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                
                TextField tfIdAbonnement1 = new TextField("", "IdAbonnement");
                TextField tftypeAbonnement1 = new TextField("", "typeAbonnement");
                TextField tfprixAbonnement1 = new TextField("", "prixAbonnement");
                Picker DATE = new Picker();
                DATE.setUIID("txtn");
                DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
                Date ddebut = DATE.getDate();
                String dated = dd.format(ddebut);
                //TextField tfsurnomUser1 = new TextField("", "surnomUser");
                ComboBox cmb_fsurnomUser1 = new ComboBox();
                cmb_fsurnomUser1.setUIID("txtn");
                 for (Utilisateur s : new ServiceUtilisateur().getAllUsers()) {
                    cmb_fsurnomUser1.addItem(s.getSurnom());
                }

                Label a = new Label("    ");

                fmodifier.getToolbar().setUIID("tb");
                fmodifier.addAll(tfIdAbonnement1,tftypeAbonnement1, tfprixAbonnement1, DATE, cmb_fsurnomUser1);
                fmodifier.addAll(a, submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    abonnement t = new abonnement(Integer.parseInt(tfIdAbonnement1.getText()),tftypeAbonnement1.getText(), Integer.parseInt(tfprixAbonnement1.getText()), dated, cmb_fsurnomUser1.getSelectedItem().toString());
                    if (ServiceAbonnement.getInstance().updateAbonnement(t)) {
                        Dialog.show("Success", "Abonnement Changée", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                    new ListAbonnementForm(this).show();
                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                Form fsupprimer = new Form( BoxLayout.y());
                Label supp = new Label("SUPPRIMER ABONNEMENT");
        supp.setUIID("login");
        
          
fsupprimer.add(supp);
                Button submit = new Button("supprimer");
                submit.setUIID("vtnvalid");
                TextField tfId = new TextField("","idAbonnement");
               
        
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
                        if( ServiceAbonnement.getInstance().deleteAbonnement(id))
                            Dialog.show("Success","Abonnement Supprimée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListAbonnementForm(this).show();

                }
                );

                fsupprimer.show();

            }
            );

            f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });

            f2.addAll(AbType, type, AbPrix, prix, AbDate, datecreation, AbSurom, surnom, Abonnementmodif, Modifier, Abonnementsupp, Supprimer);
            f2.show();

        });
        cn1.setLeadComponent(btn);
        return cn1;
    }
}