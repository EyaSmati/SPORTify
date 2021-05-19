/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.entities.abonnement;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceAbonnement;
import com.mycompany.myapp.services.ServiceEvenement;
import com.mycompany.myapp.services.ServiceUtilisateur;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class AddAbonnementForm extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");

    public AddAbonnementForm(Form previous) {

        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU ABONNEMENT");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);

        Label a = new Label("    ");

        TextField tftypeAbonnement = new TextField("", "typeAbonnement");
        TextField tfprixAbonnement = new TextField("", "prixAbonnement");
        Picker DATE = new Picker();
        DATE.setUIID("txtn");

        TextField tfsurnomUser = new TextField("", "surnomUser");

        ComboBox cmb_surnomUser = new ComboBox();

        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date ddebut = DATE.getDate();
        String dated = dd.format(ddebut);

        cmb_surnomUser.setUIID("txtn");
        

        for (Utilisateur s : new ServiceUtilisateur().getAllUsers()) {
            cmb_surnomUser.addItem(s.getSurnom());
        }
        Button btnValider = new Button("Ajouter Abonnement");
        btnValider.setUIID("vtnvalid");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tftypeAbonnement.getText().length() == 0) || (tfprixAbonnement.getText().length() == 0) ) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        abonnement t = new abonnement(tftypeAbonnement.getText(), Integer.parseInt(tfprixAbonnement.getText()), dated, cmb_surnomUser.getSelectedItem().toString());
                        if (ServiceAbonnement.getInstance().addAbonnement(t)) {
                            Dialog.show("Success", "Abonnement Ajoutée", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }
                }
            }
        });
        addAll(tftypeAbonnement, tfprixAbonnement, DATE, cmb_surnomUser,btnValider);
        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });
    }

    AddAbonnementForm() {
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU ABONNEMENT ");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("libC");
        this.add(logi);

        Label a = new Label("    ");

        TextField tftypeAbonnement = new TextField("", "typeAbonnement");
        TextField tfprixAbonnement = new TextField("", "prixAbonnement");
        Picker DATE = new Picker();
        DATE.setUIID("txtn");
        TextField tfsurnomUser = new TextField("", "surnomUser");

        ComboBox cmb_surnomUser = new ComboBox();

        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date ddebut = DATE.getDate();
        String dated = dd.format(ddebut);
        cmb_surnomUser.setUIID("txtn");
        cmb_surnomUser.setUIID("txtn");

        for (abonnement ab : new ServiceAbonnement().getAllAbonnements()) {
            cmb_surnomUser.addItem(ab.getSurnomUser());
        }
        Button btnValider = new Button("Ajouter Abonnement");
        btnValider.setUIID("vtnvalid");

        btnValider.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent evt) {
                if ((tftypeAbonnement.getText().length() == 0) || (tfprixAbonnement.getText().length() == 0) || (tfsurnomUser.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        abonnement t = new abonnement(tftypeAbonnement.getText(), Integer.parseInt(tfprixAbonnement.getText()), dated, cmb_surnomUser.getSelectedItem().toString());
                        if (ServiceAbonnement.getInstance().addAbonnement(t)) {
                            Dialog.show("Success", "Abonnement Ajoutée", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }

                }

            }
        }
        );

        addAll(tftypeAbonnement, tfprixAbonnement, DATE, cmb_surnomUser);

        this.getToolbar()
                .addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
                    new HomeForm().show();
                }
                );
    }
}