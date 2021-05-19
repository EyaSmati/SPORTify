/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.gif.GifImage;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.getResourceAsStream;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import java.io.IOException;

/**
 *
 * @author aymen
 */
public class welcomeForm extends Form {
 private Resources theme1=UIManager.initFirstTheme("/theme1");


    public welcomeForm() {
          super("Welcome",  new BorderLayout());
      
          Button sign = new Button("Enter");
          sign.setUIID("Button");
       try {
    this.add(CENTER, new ScaleImageLabel(GifImage.decode(getResourceAsStream("/run.gif"), 1177720)));

  
       } catch(Exception err) {
           System.out.println(err.getMessage());
} 
          this.add(BOTTOM, sign); 
       sign.addActionListener(e -> new SignInForm(theme1).show());
       
       
     
       
       
    }
    
    
    
}
