/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.services;

import com.ui.tienda.productows.Producto;
import com.ui.tienda.productows.ProductoWebService;
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
public class ProductoService {
    

    public List<Producto> consultarTodos() throws MalformedURLException {
        
        URL wsdlUrl = new URL("http://localhost:8080/ProductoWebServiceService/ProductoWebService?wsdl");
        QName qname = new QName("http://ws.tienda.ws.com/", "ProductoWebServiceService");
        Service service = Service.create(wsdlUrl, qname);
        ProductoWebService productoService = service.getPort(ProductoWebService.class);
        return productoService.getProductos();
    }
    
}
