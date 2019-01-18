package com.antoiovi.project1.view;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import com.antoiovi.project1.dao.PersoneDao;
import com.antoiovi.project1.model.Persone;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class Personbean {

	@Inject
	private PersoneDao personDao;

	public List<Persone> allPersons;

	@PostConstruct
	public void init() {
		allPersons=new ArrayList<Persone>();
		
	}
	
 
	public List<Persone> getAllPersons() {
		return allPersons;
	}

	public void setAllPersons(List<Persone> allPersons) {
		this.allPersons = allPersons;
	}

}