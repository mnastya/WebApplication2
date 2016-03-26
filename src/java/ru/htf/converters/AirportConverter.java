/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ru.htf.datatypes.Airport;
import ru.htf.service.AirportService;

/**
 *
 * @author chudin_e_v
 */
@FacesConverter("airportConverter")
public class AirportConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            AirportService service = (AirportService) fc.getExternalContext().getApplicationMap().get("airportService");
            for (Airport port : service.getAirports()) {
                if (port.toString().equals(value)) {
                    return port;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((Airport) object).toString());
        } else {
            return null;
        }
    }
}
