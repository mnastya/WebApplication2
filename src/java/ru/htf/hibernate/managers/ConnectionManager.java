/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.hibernate.managers;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import ru.htf.hibernate.Airports;
import ru.htf.hibernate.Cities;
import ru.htf.hibernate.HibernateUtil;
import ru.htf.hibernate.Orderstrip;
import ru.htf.hibernate.Trips;
import sun.security.krb5.internal.Ticket;

/**
 *
 * @author ЕвГений
 */
public class ConnectionManager {
    private Session session = null;

    public ConnectionManager() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Session getSession() {
        return session;
    }
    
    public List getAirportByCities(String city){
        List<Airports> airportList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Airports as arp where arp.CityId ='" + city + "'");
            airportList = (List<Airports>)q.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return airportList;
    }
    
    public List getCities(){
        List<Cities> citiesList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cities");
            citiesList = (List<Cities>)q.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return citiesList;
    }
    
     public List getTrips(){
        List<Trips> tripsList = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Trips");
            tripsList = (List<Trips>)q.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tripsList;
    }
     
     public List getOrdersById(int id){
         List<Orderstrip> orderList = null;
         try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Orderstrip where TicketID > " + id);
            orderList = (List<Orderstrip>)q.list();
        } catch (Exception e){
            e.printStackTrace();
        }
         return orderList;
     }
}
