package com.antoiovi.a1jdbcbase;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.annotation.PostConstruct;

import com.antoiovi.a1jdbcbase.model.Person;

import java.util.List;
import java.util.ArrayList;
import com.antoiovi.a1jdbcbase.model.Person;

@RequestScoped
@ManagedBean(name = "personbean")
public class Personbean {


  @ManagedProperty(value="#{persondao}")
  private	PersonDao persondao;


public void setPersondao(PersonDao _persondao){
  this.persondao=_persondao;
}

	public Personbean() {
	}


private Person newperson;


@PostConstruct
public void init(){
	allPersons=persondao.findAllPerson();
	this.newperson=new Person();
}

	private List<Person> allPersons;

	public List<Person> getAllPersons() {
		return allPersons;
	}

	public Personbean setAllPersons(List<Person> allPersons) {
		this.allPersons = allPersons;
		return this;
	}

public void saveNewPerson(){
	persondao.insertPerson(newperson);
}

public Person getNewperson(){
	return newperson;
}

public void setNewperson(Person person){
	this.newperson=person;
}


}
