/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.controllers;

import com.ui.tienda.clientews.Cliente;
import com.ui.tienda.services.ClienteService;
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
@Named("clienteController")
@ViewScoped
public class ClienteController implements Serializable {

    private List<Cliente> items = new ArrayList<>();
    private List<Cliente> itemsFiltered = new ArrayList<>();
    private List<Object[]> itemsObjects = new ArrayList<>();
    private Cliente selected;
    private String selectedId;

    @EJB
    private ClienteService clienteService;

    @PostConstruct
    public void init() {

    }

    public ClienteController() {
        this.prepararCrear();
    }

    public void prepararCrear() {
        this.selected = new Cliente();
    }

    public void consultarTodos() throws MalformedURLException {
        this.items = this.clienteService.consultarTodos();
    }
     public List<Cliente> getItemsAvailableSelectOne() throws MalformedURLException {
        if (this.items.isEmpty()) {
            items = this.clienteService.consultarTodos();
        }
        return this.items;
    }

 

    public List<Cliente> getItems() {
        return items;
    }

    public void setItems(List<Cliente> items) {
        this.items = items;
    }

    public List<Cliente> getItemsFiltered() {
        return itemsFiltered;
    }

    public void setItemsFiltered(List<Cliente> itemsFiltered) {
        this.itemsFiltered = itemsFiltered;
    }

    public List<Object[]> getItemsObjects() {
        return itemsObjects;
    }

    public void setItemsObjects(List<Object[]> itemsObjects) {
        this.itemsObjects = itemsObjects;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

    public String getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService ordenService) {
        this.clienteService = ordenService;
    }

}
