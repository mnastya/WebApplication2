/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.htf.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ЕвГений
 */
@WebService(serviceName = "GetAllWS")
public class GetAllWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "Name") String Name, @WebParam(name = "Surname") String Surname) {
        //TODO write your implementation code here:
        return 0;
    }
}
