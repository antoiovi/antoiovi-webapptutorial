package com.antoiovi.projectp.echo.control;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.antoiovi.projectp.echo.entity.Echo;

public class EchoManager {
    @PersistenceContext(unitName="prod")
    EntityManager em;

    public Echo find(String message) {
        return em.find(Echo.class, message);
    }

    public void insert(Echo echo) {
        em.persist(echo);
    }
}
