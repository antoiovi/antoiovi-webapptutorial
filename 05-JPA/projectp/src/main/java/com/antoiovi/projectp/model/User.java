package com.antoiovi.projectp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name="user_Id")
	private Integer userId;

	@Size(min = 4, max = 10)
	@Column(name="user_name")
	private String username;

	@Size(min = 4, max = 10)
	@Column(name="first_name")
	private String firstname;

	@Size(min = 4, max = 10)
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@Size(max = 256)
	@Column(name="password")
	private String password;

	//bi-directional many-to-one association to Role
		@OneToMany(mappedBy="user")
		private List<Role> roles;


	public User() {
		super();
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
