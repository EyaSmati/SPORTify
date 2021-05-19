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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.Format;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Cours;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCours {

    public ArrayList<Cours> tasks;
    
    public static ServiceCours instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCours() {
         req = new ConnectionRequest();
    }

    public static ServiceCours getInstance() {
        if (instance == null) {
            instance = new ServiceCours();
        }
        return instance;
    }

    public boolean addCours(Cours t) {
 String url = Statics.BASE_URL + "/cours/new?idCours="+t.getIdCours()+"&date=" + t.getDate()+"&heure="+t.getHeure()+ "&duree=" +t.getDuree()+"&placeDisponible=" +t.getPlace_Disponible()+"&mailcoach=" +t.getMailCoach()+"&nomsalledesport=" +t.getNomSalledeSport()+"&typeCours=" +t.getTypeCours()+"&qrcode="+t.getQrcode();
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
     public boolean UpdateCours(Cours t) {
 String url = Statics.BASE_URL + "/cours/"+t.getIdCours()+"/edit?idCours="+t.getIdCours()+"&date=" + t.getDate()+"&heure="+t.getHeure()+ "&duree=" +t.getDuree()+"&placeDisponible=" +t.getPlace_Disponible()+"&mailcoach=" +t.getMailCoach()+"&nomsalledesport=" +t.getNomSalledeSport()+"&typeCours=" +t.getTypeCours()+"&qrcode="+t.getQrcode();
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
public boolean DeleteCours(String t) {
 String url = Statics.BASE_URL + "/cours/"+t;
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
    public ArrayList<Cours> parseTasks(String jsonText){
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
                Cours t = new Cours();
                float heure = Float.parseFloat(obj.get("heure").toString());
                t.setHeure((int)heure);
                
              
               
                String date = (obj.get("date").toString());
              
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(date);
                 Map map = ((Map) obj.get("typeCours"));
                 String a = (String)map.get("type");
               
               
                float duree = Float.parseFloat(obj.get("duree").toString());
                 t.setDuree((int)duree);
                t.setHeure((int)heure);
                t.setDate(s);
                t.setNomSalledeSport(obj.get("nomsalledesport").toString());
                t.setTypeCours(a);
                t.setMailCoach(obj.get("mailcoach").toString());
                float placedispo = Float.parseFloat(obj.get("placeDisponible").toString());
                t.setPlace_Disponible((int)placedispo);
                t.setIdCours(obj.get("idCours").toString());
                t.setQrcode(obj.get("qrcode").toString());
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
    
    public ArrayList<Cours> getAllTasks() {
        String url = Statics.BASE_URL+"/cours/cours";
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
