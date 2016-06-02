/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.hibernate;

import org.hibernate.Session;

/**
 *
 * @author ЕвГений
 */
public class FlightHelper {
 
    Session session = null;

    public FlightHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
}
