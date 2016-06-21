/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.hibernate.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.htf.hibernate.Airplanetypes;
import ru.htf.hibernate.Orderstrip;
import ru.htf.hibernate.Roles;
import ru.htf.hibernate.Trips;
import ru.htf.hibernate.Users;

/**
 *
 * @author ЕвГений
 */
public class StorageManager {

    private Connection connection = null;
    ConnectionManager cm = new ConnectionManager();
    int lastTicketId;

    public StorageManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avia_storage?"
                    + "user=root&password=rootroot");
        } catch (Exception e) {
        }
    }

    public void syncOutOrders() throws SQLException {
        lastTicketId = getLastOrderId();
        List<Orderstrip> orders = cm.getOrdersById(lastTicketId);
        CallableStatement cs;
        for (Orderstrip order : orders) {
            Trips trip = order.getTrips();
            Airplanetypes airplanetypes = trip.getAirplanetypes();
            Users user = order.getUsers();
            Roles role = user.getRoles();
            cs = connection.prepareCall("{call addAirplaneType(?, ?, ?)}");
            cs.setInt(1, airplanetypes.getTypeId());
            cs.setString(2, airplanetypes.getTypeName());
            cs.setInt(3, airplanetypes.getCountPlaces());
            cs.execute();
            cs.close();
            cs = connection.prepareCall("{call addTrip(?, ?, ?, ?, ?)}");
            cs.setInt(1, trip.getTripId());
            cs.setDate(2, new java.sql.Date(trip.getDateTrip().getTime()));
            cs.setTime(3, new java.sql.Time(trip.getTimeTrip().getTime()));
            cs.setInt(4, trip.getStartingPricce());
            cs.setInt(5, trip.getAirplanetypes().getTypeId());
            cs.execute();
            cs.close();
            cs = connection.prepareCall("{call addRole(?, ?)}");
            cs.setInt(1, role.getRoleId());
            cs.setString(2, role.getRoleName());
            cs.execute();
            cs.close();
            cs = connection.prepareCall("{call addUser(?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, user.getUserId());
            cs.setString(2, user.getNameU());
            cs.setString(3, user.getSurname());
            cs.setString(4, user.getMiddleName());
            cs.setInt(5, user.getPassportNumber());
            cs.setInt(6, user.getRoles().getRoleId());
            cs.execute();
            cs.close();
            cs = connection.prepareCall("{call addOrder(?, ?, ?, ?)}");
            cs.setInt(1, order.getTicketId());
            cs.setInt(2, order.getUsers().getUserId());
            cs.setDate(3, new java.sql.Date(order.getPurchaseDate().getTime()));
            cs.setInt(4, order.getTrips().getTripId());
            cs.execute();
            cs.close();
            
        }

    }

    private int getLastOrderId() {
        CallableStatement cs;
        int id = 0;
        try {
            cs = connection.prepareCall("{call getMaxOrderId(?)}");
            cs.registerOutParameter(1, id);
            cs.execute();
            id = cs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(StorageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
