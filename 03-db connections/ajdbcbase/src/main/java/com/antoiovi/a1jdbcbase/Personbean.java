package com.antoiovi.a1jdbcbase;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

import javax.annotation.PostConstruct;

import com.antoiovi.a1jdbcbase.model.Person;

import java.util.List;
import java.util.ArrayList;
import com.antoiovi.a1jdbcbase.model.Person;

@RequestScoped
@ManagedBean(name = "personbean")
public class Personbean {
	PersonDao persondao;

	public Personbean() {
	}


@PostConstruct
public void init(){
	persondao=new PersonDao();
	allPersons=persondao.findAllPerson();
}

	private List<Person> allPersons;

	public List<Person> getAllPersons() {
		return allPersons;
	}

	public Personbean setAllPersons(List<Person> allPersons) {
		this.allPersons = allPersons;
		return this;
	}

}
