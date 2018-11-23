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


private Person newperson;


@PostConstruct
public void init(){
	persondao=new PersonDao();
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
