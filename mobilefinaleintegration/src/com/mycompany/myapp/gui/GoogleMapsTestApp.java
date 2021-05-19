/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ToastBar;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.mycompany.myapp.entities.Zone;
import com.mycompany.myapp.services.ServiceZone;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class GoogleMapsTestApp  {
   
    
    private static final String HTML_API_KEY = "AIzaSyBGlpB1VutyRfiwNjYbMzvgbZfHcIke4Nc";
    private Form current;
    
    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            Display.getInstance().setCommandBehavior(Display.COMMAND_BEHAVIOR_SIDE_NAVIGATION);
            UIManager.getInstance().getLookAndFeel().setMenuBarClass(SideMenuBar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
        Zone zon =new Zone();
        Form hi = new Form("Native Maps Test");
        hi.setLayout(new BorderLayout());
        final MapContainer cnt = new MapContainer(HTML_API_KEY);

        Button btnMoveCamera = new Button("Move Camera");
        btnMoveCamera.addActionListener(e->{
            cnt.setCameraPosition(new Coord(36.779457, 10.17117));
        });
        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels((float)0.1));

        
        Button btnAddMarker = new Button("Add Marker");
        btnAddMarker.addActionListener(e->{

             ArrayList<Zone> Zone ;
            for (Zone z : new ServiceZone().getAllZones()) {

             cnt.setCameraPosition(new Coord(z.getLat(),z.getLng()));
            cnt.addMarker(
                    EncodedImage.createFromImage(markerImg, false),
                    cnt.getCameraPosition(),
                    "Hi marker",
                    "Optional long description",
                     evt -> {
                             ToastBar.showMessage("You clicked the marker related to "+z.getRegion(), FontImage.MATERIAL_PLACE);
                     }
            );  
        }
            

        });

        Button btnClearAll = new Button("Clear All");
        btnClearAll.addActionListener(e->{
            cnt.clearMapLayers();
        });
        
        
        Button btnRetour = new Button("Back to list");
        btnRetour.addActionListener(e->{
            new ListZoneForm().show();
        });
        /*cnt.addTapListener(e->{
              ArrayList<Zone> Zone ;
            for (Zone z : new ServiceZone().getAllZones()) {
            TextField enterName = new TextField();
            Container wrapper = BoxLayout.encloseY(new Label("Name:"), enterName);
            InteractionDialog dlg = new InteractionDialog("Add Marker");
            dlg.getContentPane().add(wrapper);
            enterName.setDoneListener(e2->{
                String txt = enterName.getText();
                cnt.addMarker(
                        EncodedImage.createFromImage(markerImg, false),
                        cnt.getCoordAtPosition(e.getX(), e.getY()),
                        enterName.getText(),
                        "",
                        e3->{
                                ToastBar.showMessage("You clicked "+txt, FontImage.MATERIAL_PLACE);
                        }
                );
                dlg.dispose();
            });
            dlg.showPopupDialog(new Rectangle(e.getX(), e.getY(), 10, 10));
            enterName.startEditingAsync();
            }});*/

        Container root = LayeredLayout.encloseIn(
                BorderLayout.center(cnt),
                BorderLayout.south(
                        FlowLayout.encloseBottom(btnMoveCamera, btnAddMarker,btnClearAll,btnRetour)
                )
        );

        hi.add(BorderLayout.CENTER, root);
        hi.show();
       
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }


    
}
