/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Houssem
 */
public class Reclamation {
    private int ref;
    private String Adress_source;
    private String objet;
    private String MSG;

    public Reclamation(int ref, String Adress_source, String objet ,String MSG) {
        this.ref = ref;
        this.Adress_source = Adress_source;
        this.objet = objet;
        this.MSG = MSG;
    }

    public Reclamation(String Adress_source, String objet, String MSG) {
        this.Adress_source = Adress_source;
        this.objet = objet;
        this.MSG = MSG;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getAdress_source() {
        return Adress_source;
    }

    public void setAdress_source(String Adress_source) {
        this.Adress_source = Adress_source;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMSG() {
        return MSG;
    }

    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "ref=" + ref + ", Adress_source=" + Adress_source + ", objet=" + objet + ", MSG=" + MSG + '}';
    }
    
    
    
    
}
