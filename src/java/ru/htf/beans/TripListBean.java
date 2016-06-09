/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import ru.htf.hibernate.Airplanetypes;
import ru.htf.hibernate.Trips;
import ru.htf.hibernate.managers.ConnectionManager;
import sun.applet.Main;

/**
 *
 * @author ЕвГений
 */
@ManagedBean
@RequestScoped
public class TripListBean {

    /**
     * Creates a new instance of TripListBean
     */
    ConnectionManager cm = new ConnectionManager();
    private Airplanetypes airplanetypes;
     private Date dateTrip;
     private Date timeTrip;
     private Integer startingPricce;
     private List<Trips> tripsList = new ArrayList<Trips>();
     
     
    public TripListBean() {
         Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        String rserviceTag = params.get("tag");
    }
    
    public void preRenderedViewListener() {
    }
    
    public Trips getTrip(){
        cm = new ConnectionManager();
        tripsList = cm.getTrips();
        System.out.println(tripsList);
        System.out.println("hello");
        return null;
        
    }
    public static void main(String[] args){
       TripListBean tb = new TripListBean();
       
       System.out.println(tb.getTrip());
    }
    
   
}
