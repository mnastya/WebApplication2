/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chudin_e_v
 */
public class Country {

    private String country;
    private final int countryId;
    private List cities;

    public Country(String country, int countryId) {
        this.country = country;
        this.countryId = countryId;
        cities = new ArrayList<City>();
    }

    public Country(String country, int countryId, List cities) {
        this(country, countryId);
        this.cities = cities;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public int getCountryId() {
        return countryId;
    }

    public List getCities() {
        return cities;
    }

    public void setCities(List cities) {
        this.cities = cities;
    }

    public void addCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }
}
