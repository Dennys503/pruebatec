/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.ws;

import com.ws.tienda.entities.Cliente;
import com.ws.tienda.services.ClienteService;
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
public class ClienteWebService {

    @EJB
    private ClienteService clienteService;

    /**
     * Web service getCliente
     *
     * @param idCliente
     * @return
     */
    @WebMethod(operationName = "getCliente")
    @WebResult(name = "returnCliente")
    public Cliente getCliente(@WebParam(name = "idCliente") int idCliente) {
        return this.clienteService.consultarPorIdCliente(idCliente);
    }

    @WebMethod(operationName = "getClientes")
    @WebResult(name = "returnClientes")
    public List<Cliente> getClientes() {
        return this.clienteService.consultarTodosClientes();
    }

    @WebMethod(operationName = "eliminarCliente")
    @WebResult(name = "returnMsgCliente")
    public String eliminarCliente(@WebParam(name = "idCliente") int idCliente) throws Exception {
        Cliente selected = new Cliente();
        selected = this.clienteService.consultarPorIdCliente(idCliente);
        this.clienteService.eliminarCliente(selected);
        return "Registro eliminado con exito";
    }

    @WebMethod(operationName = "crearCliente")
    public void crearCliente(@WebParam(name = "idCliente") Cliente cliente) throws Exception {
        this.clienteService.crearCliente(cliente);
    }

    @WebMethod(operationName = "editarCliente")
    public void editarCliente(@WebParam(name = "Cliente") Cliente cliente) throws Exception {
        this.clienteService.editarCliente(cliente);
    }

}
