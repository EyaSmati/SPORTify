/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.myapp.gui;



import com.codename1.capture.Capture;
import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceUtilisateur;
import static com.sun.javafx.fxml.expression.Expression.add;
import java.io.IOException;
import static java.util.Calendar.DATE;
import java.util.Date;
import java.util.Vector;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends BaseForm {
String file ;
    public SignUpForm(Resources res) throws ParseException {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
                
        TextField surnom = new TextField("", "Surnom", 20, TextField.ANY);
        TextField prenom = new TextField("", "Prenom", 20, TextField.ANY);
        TextField nom = new TextField("", "Nom", 20, TextField.ANY);
        TextField numerodetelephone = new TextField("", "Numero de telephone", 8, TextField.ANY);
        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirme Password", 20, TextField.PASSWORD);
        
        
        Picker datedenaissance = new Picker();
         /*datedenaissance.setType(Display.PICKER_TYPE_DATE);
         datedenaissance.setUIID("TextFieldBlack");
         addStringValue("datedenaissance","datedenaissance");*/
        /* Date date=null;
         date=new SimpleDateFormat("dd/mm/yy").parse(datedenaissance.getText());*/
          DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
                                    Date ddebut = datedenaissance.getDate();
                                    String dated = dd.format(ddebut);
                       

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
                    String out = surnom.getText();
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += surnom.getText() + ".jpg";
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
        
        
        
        
        
        
        
        
        
        
        
        
        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("Client");
        vectorRole.add("Coach");
        vectorRole.add("Proprietaire");
        ComboBox<String> roles = new ComboBox<>(vectorRole);
        
        
        Vector<String> vectorSexe;
        vectorSexe = new Vector();
        vectorSexe.add("Homme");
        vectorSexe.add("Femme");
        ComboBox<String> sexes = new ComboBox<>(vectorSexe);
        
        surnom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        nom.setSingleLineTextArea(false);
        numerodetelephone.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        confirmPassword.setSingleLineTextArea(false);
       
        
        Button next = new Button("Inscription");
        Button signIn = new Button("S'authentifier");
        signIn.addActionListener(e -> new SignInForm(res).show());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Vous possedez déja un compte?");
        
        Container content = BoxLayout.encloseY(
                new Label("Inscription", "LogoLabel"),
                new FloatingHint(surnom),
                createLineSeparator(),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(numerodetelephone),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(confirmPassword),
                createLineSeparator(),
                datedenaissance,
                createLineSeparator(), sexes, roles
                ,upload
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        next.addActionListener((e) -> {
            ServiceUtilisateur.getInstance().signup(surnom, prenom, nom, numerodetelephone, email, password, confirmPassword,dated, sexes, roles,file,res);
            Dialog.show("Succes", "Compte creer", "OK", null);
            new SignInForm(res).show();
        });
    }
    
}
