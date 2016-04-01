/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import ru.htf.datatypes.Airport;

/**
 *
 * @author chudin_e_v
 */
//@ManagedBean(name = "airportService", eager = true)
//@ApplicationScoped
public class AirportService {

    List airports;

  //  @PostConstruct
    public void init() {
        airports = new ArrayList<Airport>();
        airports.add(new Airport("Pulkovo", "LED1", "RUS", "St.Petersburg", 1));
        airports.add(new Airport("Pulkovo", "LED2", "RUS", "St.Petersburg[2]", 2));
    }

    public List<Airport> getAirports() {
        return airports;
    }
}
