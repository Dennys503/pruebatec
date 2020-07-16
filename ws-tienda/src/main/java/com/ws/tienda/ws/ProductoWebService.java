/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.ws;

import com.ws.tienda.entities.Producto;
import com.ws.tienda.services.ProductoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Valenzuela
 */
@Stateless
@LocalBean
@WebService
public class ProductoWebService {

    @EJB
    private ProductoService productoService;

    /**
     * Web service getProducto
     *
     * @param idProducto
     * @return
     */
    @WebMethod(operationName = "getProducto")
    @WebResult(name = "returnProducto")
    public Producto getProducto(@WebParam(name = "idProducto") int idProducto) {
        return this.productoService.consultarPorIdProducto(idProducto);
    }

    @WebMethod(operationName = "getProductos")
    @WebResult(name = "returnProductos")
    public List<Producto> getProductos() {
        return this.productoService.consultarTodosProductos();
    }

    @WebMethod(operationName = "eliminarProducto")
    @WebResult(name = "returnMsgProducto")
    public String eliminarProducto(@WebParam(name = "idProducto") int idProducto) throws Exception {
        Producto selected = new Producto();
        selected = this.productoService.consultarPorIdProducto(idProducto);
        this.productoService.eliminarProducto(selected);
        return "Registro eliminado con exito";
    }

    @WebMethod(operationName = "crearProducto")
    @WebResult(name = "returnProducto")
    public void crearProducto(@WebParam(name = "idProducto") Producto producto) throws Exception {
        this.productoService.crearProducto(producto);
    }

    @WebMethod(operationName = "editarProducto")
    public void editarroducto(@WebParam(name = "Producto") Producto producto) throws Exception {
        this.productoService.editarProducto(producto);
    }

}
