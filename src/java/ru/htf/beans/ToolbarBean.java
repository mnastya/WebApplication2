package ru.htf.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import org.hibernate.Session;
import ru.htf.hibernate.*;
import ru.htf.hibernate.managers.ConnectionManager;
import ru.htf.hibernate.managers.StorageManager;


/**
 *
 * @author chudin_e_v
 */
@ManagedBean
@ViewScoped
public class ToolbarBean {

    private List<Cities> cities = new ArrayList<Cities>();
    private Integer cityFrom;
    private Integer cityTo;
    private Date dateFrom;
    private Date dateBack;
    private char search  ='F';
    ConnectionManager cm = new ConnectionManager();
    
    @PostConstruct
    void init() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
  //      aService.init();
    }

    public char getSearch() {
        return search;
    }
    
    public void preRenderedViewListener() {
    }

    public final void fetchAirportList() {
        cities = cm.getCities();
    }

    public ToolbarBean() {
        //ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        fetchAirportList();
    }

    public void find() {
        this.search = 'T';
    }

    public void changePorts() {
        Integer from = this.cityFrom; 
        this.cityFrom = this.cityTo;
        this.cityTo = from;
       
    }

    public List<Cities> getCities() {
        return cities;
    }

  public void setDateBack(Date dateBack) {
        this.dateBack = dateBack;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateBack() {
        return dateBack;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Integer getCityFrom() {
        return cityFrom;
    }

    public void syncOut() throws SQLException{
        try{
        StorageManager sm = new StorageManager();
        sm.syncOutOrders();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Integer getCityTo() {
        return cityTo;
    }   

    public void setCityFrom(Integer cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(Integer cityTo) {
        this.cityTo = cityTo;
    }
    
    public Date getMinBackDate() {
        return dateFrom == null ? new Date() : dateFrom;
    }
}
