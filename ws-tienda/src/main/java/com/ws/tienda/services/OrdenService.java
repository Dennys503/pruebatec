/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.services;

import com.ws.tienda.entities.Orden;
import com.ws.tienda.utils.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Valenzuela
 */
@Stateless
public class OrdenService extends AbstractFacade<Orden> {

    public OrdenService() {
        super(Orden.class);
    }

    public Orden consultarPorIdOrden(Integer idOrden) {
      return this.consultarPorId(idOrden);
    }

    public List<Orden> consultarTodosOrdens() {
       return this.consultarTodos("from Orden c");
    }
    
    public void crearOrden(Orden cli) throws Exception {
        this.crear(cli);
    }

    public void editarOrden(Orden cli) throws Exception {
        this.editar(cli);
    }

    public void eliminarOrden(Orden cli) throws Exception {
         this.eliminar(cli);
    }
}
