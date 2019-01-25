package com.antoiovi.projectp.utility;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.antoiovi.projectp.dao.UserDao;
import com.antoiovi.projectp.model.Groups;
import com.antoiovi.projectp.model.Roles;
import com.antoiovi.projectp.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(eager=true)
@ApplicationScoped
public class Config {
	
	@Inject
	private UserDao userDao;

    @PostConstruct
    public void init() {
    	//String username, String firstname, String lastname, String email, String password
        // Do stuff during webapp's startup.
    	User u=new User("antoiovi","antonello","iovino","antoiovi@antoiovi.com","ciaobello");
    	try {
    	Groups g=new Groups("admin");	
    	userDao.createGroup(g);
    	
    	userDao.create(u);
    	
    	Roles r=new Roles(u,g);
    	userDao.createRole(r);
    	}catch(Exception e) {
    		System.out.println("Errore creazione utente");
    	}
    }

    @PreDestroy
    public void destroy() {
        // Do stuff during webapp's shutdown.
    }
}