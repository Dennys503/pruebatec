/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.tienda.services;

import com.ws.tienda.entities.Producto;
import com.ws.tienda.utils.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Valenzuela
 */
@Stateless
public class ProductoService extends AbstractFacade<Producto> {

    public ProductoService() {
        super(Producto.class);
    }

    public Producto consultarPorIdProducto(Integer idProducto) {
      return this.consultarPorId(idProducto);
    }

    public List<Producto> consultarTodosProductos() {
       return this.consultarTodos("from Producto c");
    }
    
    public void crearProducto(Producto cli) throws Exception {
        this.crear(cli);
    }

    public void editarProducto(Producto cli) throws Exception {
        this.editar(cli);
    }

    public void eliminarProducto(Producto cli) throws Exception {
         this.eliminar(cli);
    }

}
