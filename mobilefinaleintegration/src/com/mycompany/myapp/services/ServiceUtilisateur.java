/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.Format;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.gui.HomeForm;
import com.mycompany.myapp.gui.SignUpForm;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;


/**
 *
 * @author Yassine Karoui
 */
public class ServiceUtilisateur {
     public ArrayList<Utilisateur> tasks;
    public static ServiceUtilisateur instance = null;
    public static boolean resultOk = true;
    
    String json;
    private ConnectionRequest req;

    public static ServiceUtilisateur getInstance(){
        if (instance == null)
            instance = new ServiceUtilisateur();
        return instance;
    }

    public ServiceUtilisateur(){
        req = new ConnectionRequest();

    }

    public void signup(TextField surnom, TextField prenom, TextField nom, TextField numerodetelephone, TextField email, TextField password,  TextField confirmePassword, String datedenaissance, ComboBox sexes, ComboBox roles,String image ,Resources res ){
        
        
        String url = "http://127.0.0.1:8000/user/signup?surnom="+ surnom.getText().toString() +"&prenom="+ prenom.getText().toString() +"&nom="+ nom.getText().toString() +"&numerodetelephone="+ numerodetelephone.getText().toString() +"&email="+ email.getText().toString()+"&password="+ password.getText().toString() +"&datedenaissance="+ datedenaissance +"&sexe="+ sexes.getSelectedItem().toString()+"&role="+ roles.getSelectedItem().toString()+"&image="+image;
        
        req.setUrl(url);
        
        
        if (surnom.getText().equals("") && prenom.getText().equals("") && nom.getText().equals("") && numerodetelephone.getText().equals("") && email.getText().equals("") && password.getText().equals("") && confirmePassword.getText().equals("") && datedenaissance.equals("")){
            Dialog.show("Erreur", "Veuillez remplir tous le champs", "OK", null);
        }
        
        
        req.addResponseListener((e)-> {
            byte[]data = (byte[]) e.getMetaData();
            String responseData = new String(data);
            System.out.println("data === "+responseData);
            
        });
        
        
        NetworkManager.getInstance().addToQueueAndWait(req);
         
    }
    
    public void signin(TextField surnom, TextField password, Resources res){
        String url = "http://127.0.0.1:8000/user/signin?surnom=" + surnom.getText().toString() + "&password=" + password.getText().toString();
        req = new ConnectionRequest(url, false);
        req.setUrl(url);
        req.addResponseListener((e)->{
            JSONParser j  = new JSONParser();
            String json = new String(req.getResponseData()) + "";
             try {
                 
             
            if(json.equals("failed")){
            Dialog.show("Echec d'authentification", "Surnom ou mot de passe éronné", "OK", null);
                
            } else{
                System.out.println("data == "+ json);
                Map<String,Object> user;
               
                    user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
                if (user.size()> 0) {
                    new HomeForm().show();
                }
                    
            }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
           
    public String getPasswordByEmail(String email, Resources rs){
        String url = "http://127.0.0.1:8000/user/mdpOublie?email" +email;
        req = new ConnectionRequest(url, false);
        req.setUrl(url);
        req.addResponseListener((e)-> {
            JSONParser j = new JSONParser();
            
             json = new String(req.getResponseData()) + "";
            
            try{
                System.out.println("data =="+ json);
                
                Map<String,Object> password  = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                //if (user.size() > 0)
                  //  new ListReclamationForm(rs).show();
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return json;
    }
    
    public ArrayList<Utilisateur> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Utilisateur t = new Utilisateur();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                
              
               
                String date = (obj.get("datedenaissance").toString());
              
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(date);
                 
               
                t.setSurnom(obj.get("surnom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setNom(obj.get("nom").toString());
                t.setNumerodetelephone(obj.get("numerodetelephone").toString());
                t.setEmail(obj.get("email").toString());
                t.setPassword(obj.get("password").toString());
                t.setDatedenaissance(s);
                t.setSexe(obj.get("sexe").toString());
                t.setRole(obj.get("role").toString());
             
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
     public ArrayList<Utilisateur> getAllUsers(){
        String url = Statics.BASE_URL+"/AllUsers";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
}
