package com.antoiovi.primef;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.antoiovi.primef.model.PersonDao;
import com.antoiovi.primef.model.Person;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;

@ViewScoped
@ManagedBean(name = "personbean")
public class Personbean {


  @ManagedProperty(value="#{persondao}")
  private	PersonDao persondao;

private List<Person> filteredPersons;

  

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
	this.filteredPersons=new ArrayList<Person>();
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
	if(persondao.insertPerson(newperson)) {
		FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Inserimento riuscito", 
                "Nuovo utente, username :  " + newperson.getUsername()));  
	}else {
		FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR,"Inserimento non riuscito", 
                "Verificare se l'utente è gia presente o la connesione al database.  "));
	}
		
}

public Person getNewperson(){
	return newperson;
}

public void setNewperson(Person person){
	this.newperson=person;
}

public List<Person> getFilteredPersons() {
	return filteredPersons;
}

public void setFilteredPersons(List<Person> filteredPersons) {
	this.filteredPersons = filteredPersons;
}




}
