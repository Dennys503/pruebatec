/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.controllers;

import com.ui.tienda.productows.Producto;
import com.ui.tienda.services.ProductoService;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valenzuela
 */
@Named("productoController")
@ViewScoped
public class ProductoController implements Serializable {

    private List<Producto> items = new ArrayList<>();
    private List<Producto> itemsFiltered = new ArrayList<>();
    private List<Object[]> itemsObjects = new ArrayList<>();
    private Producto selected;
    private String selectedId;

    @EJB
    private ProductoService productoService;

    @PostConstruct
    public void init() {

    }

    public ProductoController() {
        this.prepararCrear();
    }

    public void prepararCrear() {
        this.selected = new Producto();
    }

    public void consultarTodos() throws MalformedURLException {
        this.items = this.productoService.consultarTodos();
    }

     public List<Producto> getItemsAvailableSelectOne() throws MalformedURLException {
        if (this.items.isEmpty()) {
            items = this.productoService.consultarTodos();
        }
        return this.items;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public List<Producto> getItemsFiltered() {
        return itemsFiltered;
    }

    public void setItemsFiltered(List<Producto> itemsFiltered) {
        this.itemsFiltered = itemsFiltered;
    }

    public List<Object[]> getItemsObjects() {
        return itemsObjects;
    }

    public void setItemsObjects(List<Object[]> itemsObjects) {
        this.itemsObjects = itemsObjects;
    }

    public Producto getSelected() {
        return selected;
    }

    public void setSelected(Producto selected) {
        this.selected = selected;
    }

    public String getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService ordenService) {
        this.productoService = ordenService;
    }

}
