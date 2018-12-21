package com.antoiovi.primef.model;
import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;

import com.antoiovi.primef.model.Person;

import javax.faces.bean.ManagedBean;

import  javax.annotation.PostConstruct;


@SessionScoped
@ManagedBean(name = "persondao")
public class PersonDao {

	private List<Person> allPersons;

	@PostConstruct
	public void init(){
		allPersons=new ArrayList<Person>();
 		addNewPerson("user1","Rossi","Mario","mario.rossi@foo.com");
		addNewPerson("user2","King","Bill","bill.comp@foo.com");
		addNewPerson("user3","Queen","Alice","alicequeen@foo.com");
		addNewPerson("user4","Kelly","Grace","kellygrace@foo.com");

 	}



void log(String s){
		System.out.println(s);
}


public boolean insertPerson(Person person) {
	     if(!allPersons.contains(person))
			 return	allPersons.add(person);
	     return false;
} //insertPerson


public void deletePerson(Person person) {
	      allPersons.remove(person);
}
public void updatePerson(Person person) {

	}


public List<Person> findAllPerson() {

	return allPersons;
}

public boolean addNewPerson(String _username,String _lastname,String _firstname,String _email){
Person p=new Person(_username,_lastname,_firstname,_email);
return this.insertPerson(p);
}

}
