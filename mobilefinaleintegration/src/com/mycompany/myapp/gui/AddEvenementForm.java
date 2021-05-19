/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Salledesport;
import com.mycompany.myapp.entities.evenement;
import com.mycompany.myapp.services.ServiceEvenement;
import com.mycompany.myapp.services.ServiceSalledesport;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class AddEvenementForm extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");

    public AddEvenementForm(Form previous) {

        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU EVENEMENT");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);

        Label a = new Label("    ");

        TextField tfnomEvennement = new TextField("", "nomEvennement");
        TextField tfnbplaces = new TextField("", "nbplaces");
        TextField tfDescription = new TextField("", "description");
        Picker DATE = new Picker();
        DATE.setUIID("txtn");
        //TextField tfnomSalle = new TextField("", "nomSalle");
        ComboBox cmb_nomSalle = new ComboBox();
                cmb_nomSalle.setUIID("txtn");
                            for (Salledesport s : new ServiceSalledesport().getAllSalles()) {

                               
                                 cmb_nomSalle.addItem(s.getNomSalle());
                                

                            }

        
        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date ddebut = DATE.getDate();
        String dated = dd.format(ddebut);
        Button btnValider = new Button("Ajouter Evenement");
        btnValider.setUIID("vtnvalid");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnomEvennement.getText().length() == 0) || (tfnbplaces.getText().length() == 0) || (tfDescription.getText().length() == 0) ) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        evenement t = new evenement(tfnomEvennement.getText(), Integer.parseInt(tfnbplaces.getText()), tfDescription.getText(), dated, cmb_nomSalle.getSelectedItem().toString());
                        if (ServiceEvenement.getInstance().addEvenement(t)) {
                            Dialog.show("Success", "Evenement Ajoutée", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }

                }

            }
        });

        addAll(tfnomEvennement, tfnbplaces, tfDescription, DATE, cmb_nomSalle,btnValider);
        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });
    }

    AddEvenementForm() {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        super(BoxLayout.y());
        this.getToolbar().setUIID("tb");
        Label logi = new Label("AJOUTER NOUVEAU EVENEMENT");
        theme = UIManager.initFirstTheme("/theme");
        logi.setUIID("login");
        this.add(logi);

        Label a = new Label("    ");

        TextField tfnomEvennement = new TextField("", "nomEvennement");
        TextField tfnbplaces = new TextField("", "nbplaces");
        TextField tfDescription = new TextField("", "description");
        Picker DATE = new Picker();
        DATE.setUIID("txtn");
        //TextField tfnomSalle = new TextField("", "nomSalle");
        ComboBox cmb_nomSalle = new ComboBox();
                cmb_nomSalle.setUIID("txtn");
                            for (Salledesport s : new ServiceSalledesport().getAllSalles()) {

                               
                                 cmb_nomSalle.addItem(s.getNomSalle());
                                

                            }

        
        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date ddebut = DATE.getDate();
        String dated = dd.format(ddebut);
        Button btnValider = new Button("Ajouter Evenement");
        btnValider.setUIID("vtnvalid");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnomEvennement.getText().length() == 0) || (tfnbplaces.getText().length() == 0) || (tfDescription.getText().length() == 0) ) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        evenement t = new evenement(tfnomEvennement.getText(), Integer.parseInt(tfnbplaces.getText()), tfDescription.getText(), dated, cmb_nomSalle.getSelectedItem().toString());
                        if (ServiceEvenement.getInstance().addEvenement(t)) {
                            Dialog.show("Success", "Evenement Ajoutée", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Please Recheck Your Data Types", new Command("OK"));
                    }

                }

            }
        });

        addAll(tfnomEvennement, tfnbplaces, tfDescription, DATE, cmb_nomSalle,btnValider);
        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back.png"), (evt) -> {
            new HomeForm().show();
        });

}
}