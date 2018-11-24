package com.antoiovi.a1jdbcbase.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class Person {

	@NotNull
	private Long id;

 	@Size(min = 4, max = 10)
	private String username;

 	@Size(min = 2, max = 25)
	private String firstname;

 	@Size(min = 2, max = 25)
	private String lastname;

	//  @Email ????
		String email;

 	@Size(min = 4, max = 10)
	private String password;

	public Person() {
	}

	public Person(String _username,String  _lastname,String  _firstname,String  _email){
		this.username=_username;
		this.lastname=_lastname;
		this.firstname=_firstname;
		this.email=_email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (username != null && !username.trim().isEmpty())
			result += "username: " + username;


		if (email != null && !email.trim().isEmpty())
			result += ", email: " + email;

		return result;
	}

	@Override
	public boolean equals(Object p) {
		if(! p.getClass().isInstance(this))
		return false;
		return ((Person)p).getUsername().equals(this.getUsername());
	}



	/**
	* Returns value of username
	* @return
	*/
	public String getUsername() {
		return username;
	}

	/**
	* Sets new value of username
	* @param
	*/
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	* Returns value of firstname
	* @return
	*/
	public String getFirstname() {
		return firstname;
	}

	/**
	* Sets new value of firstname
	* @param
	*/
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	* Returns value of lastname
	* @return
	*/
	public String getLastname() {
		return lastname;
	}

	/**
	* Sets new value of lastname
	* @param
	*/
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

}
