/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.ws;

import com.ws.tienda.entities.Orden;
import com.ws.tienda.services.OrdenService;
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
public class OrdenWebService {
    
    @EJB
    private OrdenService ordenService;

    /**
     * Web service getOrden
     * @param idOrden
     * @return 
     */
    @WebMethod(operationName = "getOrden")
    @WebResult(name = "returnOrden")
    public Orden getOrden(@WebParam(name = "idOrden") int idOrden) {
        return this.ordenService.consultarPorIdOrden(idOrden);
    }
    
    @WebMethod(operationName="getOrdenes")
    @WebResult(name = "returnOrdenes")
    public List<Orden> getOrdenes(){
    	return this.ordenService.consultarTodosOrdens();
    }

    @WebMethod(operationName="eliminarOrden")
    @WebResult(name = "returnMsgOrden")
    public String eliminarOrden(@WebParam(name = "idOrden") int idOrden) throws Exception{
        Orden selected=new Orden();
        selected = this.ordenService.consultarPorIdOrden(idOrden);
    	this.ordenService.eliminarOrden(selected);
        return "Registro eliminado con exito";
    }
    
    @WebMethod(operationName="crearOrden")
    public void crearOrden(@WebParam(name = "idOrden") Orden orden) throws Exception{
    	this.ordenService.crearOrden(orden);
    }
    
       @WebMethod(operationName="editarOrden")
    public void editarOrden(@WebParam(name = "orden") Orden orden) throws Exception{
    	this.ordenService.editarOrden(orden);
    }
}
