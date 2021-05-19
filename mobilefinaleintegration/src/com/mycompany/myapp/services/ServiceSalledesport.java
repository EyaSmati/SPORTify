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
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Salledesport;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ServiceSalledesport {
  public ArrayList<Salledesport> tasks;
    
    public static ServiceSalledesport instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Form current,hi;
    private Resources theme;
    
     public ServiceSalledesport() {
         req = new ConnectionRequest();
    }
    public static ServiceSalledesport getInstance() {
        if (instance == null) {
            instance = new ServiceSalledesport();
        }
        return instance ;
    } 
    public boolean addSalledesport(Salledesport s) {
        String url = Statics.BASE_URL + "/salledesport/addSalleJSON?idSalle="+ s.getIdSalle()+ "&nomSalle=" + s.getNomSalle()+"&adresse="+s.getAdresse()+"&region="+s.getRegion()+"&hdebut="+s.getHdebut()+"&hfin="+s.getHfin()+"&min="+s.getMin()+"&numtel="+s.getNumtel(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
    }
    public boolean updateSalledesport(Salledesport s) {
        String url = Statics.BASE_URL + "/salledesport/"+s.getIdSalle()+"/updateSalleJSON?idSalle="+ s.getIdSalle()+ "&nomSalle=" + s.getNomSalle()+"&adresse="+s.getAdresse()+"&region="+s.getRegion()+"&hdebut="+s.getHdebut()+"&hfin="+s.getHfin()+"&min="+s.getMin()+"&numtel="+s.getNumtel(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean deleteSalledesport(Salledesport s) {
        String url = Statics.BASE_URL + "/salledesport/"+s.getIdSalle()+"/deleteSalleJSON?idSalle="+s.getIdSalle(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public ArrayList<Salledesport> parseTasks(String jsonText){
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
                Salledesport s = new Salledesport();
                
                Map map = ((Map) obj.get("region"));
                 String a = (String)map.get("region");
                
                
                s.setIdSalle(obj.get("idSalle").toString());
                s.setNomSalle(obj.get("nomSalle").toString());
                s.setAdresse(obj.get("adresse").toString());
                s.setRegion(a);
               // s.setHdebut(Integer.parseInt(obj.get("hdebut").toString()));
                float hdebut = Float.parseFloat(obj.get("hdebut").toString());
                s.setHdebut((int)hdebut);
               // s.setHfin(Integer.parseInt(obj.get("hfin").toString()));
               float hfin = Float.parseFloat(obj.get("hfin").toString());
                s.setHfin((int)hfin);
               // s.setMin(Integer.parseInt(obj.get("min").toString()));
               float min = Float.parseFloat(obj.get("min").toString());
                s.setMin((int)min);
               // s.setNumtel(Integer.parseInt(obj.get("numtel").toString()));
               float numtel = Float.parseFloat(obj.get("numtel").toString());
                s.setNumtel((int)numtel);
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(s);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
    public ArrayList<Salledesport> getAllSalles(){
        String url = Statics.BASE_URL+"/salledesport/AllSalles";
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
    /*public static void main(String[] args) {
         List<String> lang = new ArrayList<>();
         lang.add("Java");
         lang.add("PHP");
        lang.add("Python");
        lang.add("C++");
        List<String> res = new ArrayList<>();
        for (String i : lang) {
            if (i.matches("(?i)c.*")) {
                res.add(i);
            }
        }
        System.out.println(res);
    }*/
}
