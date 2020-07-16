package com.ws.tienda.utils;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractFacade<T> {

    @PersistenceContext(name = "promericaPU")
    private EntityManager em;

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public <T> List<T> consultarTodos(String query) {
        List<T> entitiesFound = (List<T>) (T) em.createQuery(query).getResultList();
        return entitiesFound;
    }

    public T consultarPorId(Object id) {
        return em.find(entityClass, id);
    }
    
    public T editar(T entity) {
        return em.merge(entity);
    }
    
     public void crear(T entity) {
        em.persist(entity);
    }
     
    public void eliminar(T entity) {
        em.remove(em.merge(entity));
    }



}
