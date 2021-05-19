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
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Salledesport;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceEvenement;
import com.mycompany.myapp.services.ServiceSalledesport;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class ListEvenementForm extends Form {

    Resources theme;

    public ListEvenementForm(Form previous) {
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("LES Evenements");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);
        Label a = new Label("    ");

        Button Ajout = new Button(theme.getImage("add.png"));
        Ajout.addActionListener(e -> new AddEvenementForm(this).show());

        Ajout.setUIID("btnins");
        addAll(a, Ajout);

        for (evenement c : new ServiceEvenement().getAllEvenements()) {

            this.add(addItem(c));
        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });
    }

    public Container addItem(evenement c) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());

        Label lab = new Label(c.getNomEvennement());
        Button btn = new Button(c.getDescription());
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

            Label EVnomEvennement = new Label("Nom De L' Evennement");
            Label lnomEvennement = new Label(String.valueOf(c.getNomEvennement()));
            Label EVnbplaces = new Label("Nbplaces");
            Label nbplaces = new Label(String.valueOf(c.getNbplaces()));
            Label EvenementDSC = new Label("Description");
            Label ldescription = new Label(c.getDescription());
            Label EvenementDate = new Label("Date");
            Label date = new Label(String.valueOf(c.getDate()));
            Label EvenementNAME = new Label("Nom de la Salle");
            Label lname = new Label(c.getNomSalle());
            Label Evenementmodif = new Label("Modifier");
            Label Evenementsupp = new Label("Supprimer");

            

            lnomEvennement.setUIID("type2");
            nbplaces.setUIID("type2");
            ldescription.setUIID("type2");
            date.setUIID("type2");
            lname.setUIID("type2");

            EVnomEvennement.setUIID("type1");
            EVnbplaces.setUIID("type1");
            EvenementDSC.setUIID("type1");
            EvenementDate.setUIID("type1");
            EvenementNAME.setUIID("type1");
            Evenementmodif.setUIID("type1");
            Evenementsupp.setUIID("type1");

            Modifier.setUIID("btnins");
            Supprimer.setUIID("btnins");

            Modifier.addActionListener(mod
                    -> {
                Form fmodifier = new Form(BoxLayout.y());
                Label modif = new Label("MODIFIER EVENEMENT");
                modif.setUIID("login");

                fmodifier.add(modif);
                Button submit = new Button("Modifier");
                submit.setUIID("vtnvalid");
                TextField tfId = new TextField("", "idEvennement");
                TextField tfnomEvennement1 = new TextField("", "nomEvennement");
                TextField tfnbplaces1 = new TextField("", "nbplaces");
                Picker DATE = new Picker();
                DATE.setUIID("txtn");
                DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
                Date ddebut = DATE.getDate();
                String dated = dd.format(ddebut);
                TextField tfDescription1 = new TextField("", "description");

//              TextField tfsalledesport1 = new TextField("", "nomSalle");
                ComboBox cmb_nomSalle1 = new ComboBox();
                cmb_nomSalle1.setUIID("txtn");
                            for (Salledesport s : new ServiceSalledesport().getAllSalles()) {

                               
                                 cmb_nomSalle1.addItem(s.getNomSalle());
                                

                            }

                Label a = new Label("    ");

                fmodifier.getToolbar().setUIID("tb");
                fmodifier.addAll(tfId,tfnomEvennement1, tfnbplaces1, DATE, tfDescription1, cmb_nomSalle1);
                fmodifier.addAll(a, submit);
                fmodifier.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    this.show();
                });
                submit.addActionListener(sub
                        -> {
                    evenement t = new evenement(Integer.parseInt(tfId.getText()),tfnomEvennement1.getText(), Integer.parseInt(tfnbplaces1.getText()), tfDescription1.getText(), dated, cmb_nomSalle1.getSelectedItem().toString());
                    if (ServiceEvenement.getInstance().updateEvenement(t)) {
                        Dialog.show("Success", "Evenement Changée", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                    new ListEvenementForm(this).show();
                }
                );

                fmodifier.show();
            }
            );

            Supprimer.addActionListener(sup
                    -> {
                Form fsupprimer = new Form( BoxLayout.y());
                Label supp = new Label("SUPPRIMER EVENNEMENT");
        supp.setUIID("login");
        
          
fsupprimer.add(supp);
                Button submit = new Button("supprimer");
                submit.setUIID("vtnvalid");
                TextField tfId = new TextField("","idEvennement");
               
        
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
                        if( ServiceEvenement.getInstance().deleteEvenement(id))
                            Dialog.show("Success","Evennement Supprimée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    new ListEvenementForm(this).show();

                }
                );

                fsupprimer.show();

            }
            );

            f2.getToolbar().setUIID("tb");
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                this.show();
            });

            f2.addAll(EVnomEvennement, lnomEvennement, EVnbplaces, nbplaces, EvenementDSC, ldescription, EvenementDate, date, EvenementNAME, lname, Evenementmodif, Modifier, Evenementsupp, Supprimer);
            f2.show();

        });
        cn1.setLeadComponent(btn);
        return cn1;

    }

}