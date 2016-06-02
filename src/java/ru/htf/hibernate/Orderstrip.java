package ru.htf.hibernate;
// Generated 27.05.2016 5:56:22 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderstrip generated by hbm2java
 */
public class Orderstrip  implements java.io.Serializable {


     private int ticketId;
     private Trips trips;
     private Orderstatus orderstatus;
     private Users users;
     private Date purchaseDate;
     private Set<Optionfororder> optionfororders = new HashSet<Optionfororder>(0);

    public Orderstrip() {
    }

	
    public Orderstrip(int ticketId) {
        this.ticketId = ticketId;
    }
    public Orderstrip(int ticketId, Trips trips, Orderstatus orderstatus, Users users, Date purchaseDate, Set<Optionfororder> optionfororders) {
       this.ticketId = ticketId;
       this.trips = trips;
       this.orderstatus = orderstatus;
       this.users = users;
       this.purchaseDate = purchaseDate;
       this.optionfororders = optionfororders;
    }
   
    public int getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    public Trips getTrips() {
        return this.trips;
    }
    
    public void setTrips(Trips trips) {
        this.trips = trips;
    }
    public Orderstatus getOrderstatus() {
        return this.orderstatus;
    }
    
    public void setOrderstatus(Orderstatus orderstatus) {
        this.orderstatus = orderstatus;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public Set<Optionfororder> getOptionfororders() {
        return this.optionfororders;
    }
    
    public void setOptionfororders(Set<Optionfororder> optionfororders) {
        this.optionfororders = optionfororders;
    }




}


