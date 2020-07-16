/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui.tienda.controllers;

import com.ui.tienda.ordenws.Exception_Exception;
import com.ui.tienda.ordenws.Orden;
import com.ui.tienda.services.OrdenService;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valenzuela
 */
@Named("ordenController")
@ViewScoped
public class OrdenController implements Serializable {

    private List<Orden> items = new ArrayList<>();
    private List<Orden> itemsFiltered = new ArrayList<>();
    private List<Object[]> itemsObjects = new ArrayList<>();
    private Orden selected;
    private String selectedId;

    @EJB
    private OrdenService ordenService;
    @Inject
    private ClienteController clienteController;

    @PostConstruct
    public void init() {

    }

    public OrdenController() {
        this.prepararCrear();
    }

    public void prepararCrear() {
        this.selected = new Orden();
    }

    public void consultarTodos() throws MalformedURLException {
        this.items = this.ordenService.consultarTodos();
    }

    public void eliminar() throws MalformedURLException, Exception_Exception {
        this.ordenService.eliminar(selected.getIdOrden());
    }

    public void crear() throws MalformedURLException, Exception_Exception {
        System.out.println("::::: " + clienteController.getSelected().getNombres());
        this.selected.getIdCliente().setIdCliente(1);
        this.selected.getIdCliente().setNombres(clienteController.getSelected().getNombres());
        this.selected.getIdCliente().setApellidos(clienteController.getSelected().getApellidos());
        this.ordenService.crear(selected);
    }

    public void editar() throws MalformedURLException, Exception_Exception {
        this.ordenService.editar(selected);
    }

    public void consultarPorId() throws MalformedURLException {
        //this.ordenService.consultarTodos();
    }

    public List<Orden> getItems() {
        return items;
    }

    public void setItems(List<Orden> items) {
        this.items = items;
    }

    public List<Orden> getItemsFiltered() {
        return itemsFiltered;
    }

    public void setItemsFiltered(List<Orden> itemsFiltered) {
        this.itemsFiltered = itemsFiltered;
    }

    public List<Object[]> getItemsObjects() {
        return itemsObjects;
    }

    public void setItemsObjects(List<Object[]> itemsObjects) {
        this.itemsObjects = itemsObjects;
    }

    public Orden getSelected() {
        return selected;
    }

    public void setSelected(Orden selected) {
        this.selected = selected;
    }

    public String getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

    public OrdenService getOrdenService() {
        return ordenService;
    }

    public void setOrdenService(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

}
