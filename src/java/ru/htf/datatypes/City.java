/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.datatypes;

import java.util.List;

/**
 *
 * @author chudin_e_v
 */
public class City {

    private String city;
    private int cityId;
    private List airports;

    public String getCity() {
        return city;
    }

    public List getAirports() {
        return airports;
    }

    public int getCityId() {
        return cityId;
    }

    public City() {
    }

    public City(String city, int cityId, List airports) {
        this.city = city;
        this.cityId = cityId;
        this.airports = airports;
    }
    
    

}
