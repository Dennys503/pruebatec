package com.ws.tienda.utils;

import com.ws.tienda.entities.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Dennys
 */
public class PruebasMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
 
        PruebasMain load=new PruebasMain();

        List<Cliente> entitiesFound = load.consultarTodos10();
       
        for (Cliente cliente : entitiesFound) {
            System.out.println("Nome: " + cliente.getNombres());
            System.out.println("Profissao: " + cliente.getApellidos());
            System.out.println("---------------------------");
        }

    }
    
     public <T> List<T> consultarTodos10() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("promericaPU");
        EntityManager em = emf.createEntityManager();

        List<T> entitiesFound = (List<T>) (T) em.createQuery("from Cliente c").getResultList();
        return entitiesFound;
    }

}
