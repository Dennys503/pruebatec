/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.services;

import com.ui.tienda.ordenws.Exception_Exception;
import com.ui.tienda.ordenws.Orden;
import com.ui.tienda.ordenws.OrdenWebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Valenzuela
 */
@Stateless
public class OrdenService {

    public List<Orden> consultarTodos() throws MalformedURLException {
        URL wsdlUrl = new URL("http://localhost:8080/OrdenWebServiceService/OrdenWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "OrdenWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        OrdenWebService orderService = service.getPort(OrdenWebService.class);
        return orderService.getOrdenes();
    }

    public void eliminar(int id) throws MalformedURLException, Exception_Exception {
        URL wsdlUrl = new URL("http://localhost:8080/OrdenWebServiceService/OrdenWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "OrdenWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        OrdenWebService orderService = service.getPort(OrdenWebService.class);
        orderService.eliminarOrden(id);
    }

    public void crear(Orden orden) throws MalformedURLException, Exception_Exception {
        URL wsdlUrl = new URL("http://localhost:8080/OrdenWebServiceService/OrdenWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "OrdenWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        OrdenWebService orderService = service.getPort(OrdenWebService.class);
        orderService.crearOrden(orden);
    }

    public void editar(Orden orden) throws MalformedURLException, Exception_Exception {
        URL wsdlUrl = new URL("http://localhost:8080/OrdenWebServiceService/OrdenWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "OrdenWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        OrdenWebService orderService = service.getPort(OrdenWebService.class);
        orderService.editarOrden(orden);
    }
}
