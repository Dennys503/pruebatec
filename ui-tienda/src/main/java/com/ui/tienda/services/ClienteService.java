/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.services;

import com.ui.tienda.clientews.Cliente;
import com.ui.tienda.clientews.ClienteWebService;
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
public class ClienteService {
    
    

    public List<Cliente> consultarTodos() throws MalformedURLException {
        URL wsdlUrl = new URL("http://localhost:8080/ClienteWebServiceService/ClienteWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "ClienteWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        ClienteWebService clienteService = service.getPort(ClienteWebService.class);
        return clienteService.getClientes();
    }
    
}
