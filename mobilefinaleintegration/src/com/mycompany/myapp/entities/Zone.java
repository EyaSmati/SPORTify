/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import com.codename1.ui.ComboBox;

/**
 *
 * @author asus
 */
public class Zone {
    private String region;
    private float lng;
    private float lat;

    public Zone(String region, float lng, float lat) {
        this.region = region;
        this.lng = lng;
        this.lat = lat;
    }

    public Zone() {
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
    
      @Override
    public String toString() {
        return "Zones{" + "Région=" + region + ", Longitude=" + lng + ", Latitude=" + lat + '}';
    }
    
    
}