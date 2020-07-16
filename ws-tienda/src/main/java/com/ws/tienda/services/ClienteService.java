/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.services;

import com.ws.tienda.entities.Cliente;
import com.ws.tienda.utils.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Valenzuela
 */
@Stateless
public class ClienteService extends AbstractFacade<Cliente> {

    public ClienteService() {
        super(Cliente.class);
    }

    public Cliente consultarPorIdCliente(Integer idCliente) {
      return this.consultarPorId(idCliente);
    }

    public List<Cliente> consultarTodosClientes() {
       return this.consultarTodos("from Cliente c");
    }
    
    public void crearCliente(Cliente cli) throws Exception {
        this.crear(cli);
    }

    public void editarCliente(Cliente cli) throws Exception {
        this.editar(cli);
    }

    public void eliminarCliente(Cliente cli) throws Exception {
         this.eliminar(cli);
    }

}
