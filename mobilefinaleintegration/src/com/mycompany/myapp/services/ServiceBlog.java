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
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

    /**
     *
     * @author Yassine Karoui
     */
public class ServiceBlog {
    public static ServiceBlog instance = null;
    public ArrayList<Blog> tasks;
    
    public boolean resultOk = true;
    private ConnectionRequest req;

    public static ServiceBlog getInstance(){
        if (instance == null)
            instance = new ServiceBlog();
        return instance;
    }

    public ServiceBlog(){
        req = new ConnectionRequest();

    }

   public boolean ajouterBlog(Blog blog){
        String url = "http://127.0.0.1:8000/ajouterBlog?Titre="+ blog.getTitre() + "&Text=" + blog.getTexte() + "&Auteur="+ blog.getAuteur() +"&image=" + blog.getImage() ;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                resultOk = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOk;

    }

    public ArrayList<Blog> parseTasks(String jsonText){
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
                Blog b = new Blog();
                b.setTitre(obj.get("titre").toString());
                b.setText(obj.get("text").toString());
                b.setAuteur(obj.get("auteur").toString());
                 b.setImage(obj.get("image").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(b);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
    public ArrayList<Blog> AfficherBlogs(){
        String url = Statics.BASE_URL+"/afficherBlogs";
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
    
    public Blog afficherBlog(int id , Blog blog){
        String url = Statics.BASE_URL+"/afficherBlog?id=" + id;
        req.setUrl(url);
        String str = new String (req.getResponseData());
        
        req.addResponseListener(((evt) ->{
            JSONParser jsonp = new JSONParser();
            try{
                Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
                blog.setTitre(obj.get("Titre").toString());
                blog.setText(obj.get("text").toString());
                blog.setAuteur(obj.get("Auteur").toString());

            } catch(IOException ex){
                System.out.println("error relatedto sql " + ex.getMessage());
            }
            
            System.out.println("data === "+str);
        }));
        
    NetworkManager.getInstance().addToQueueAndWait(req);
    
    return blog;
    }

    


    public boolean modifierBlog(Blog b) {
        String url = Statics.BASE_URL + "/modifierBlog?id="+ b.getId() + "&Titre="+b.getTitre()+"&Text="+b.getTexte()+"&Auteur="+b.getAuteur();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
    }
    public boolean supprimerBlog(int id) {
        String url = Statics.BASE_URL + "/supprimerBlog?id="+ id;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
    }
    
}
