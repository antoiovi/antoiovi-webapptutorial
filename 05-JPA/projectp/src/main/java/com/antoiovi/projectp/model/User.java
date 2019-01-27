package com.antoiovi.projectp.model;

import java.io.Serializable;
import java.util.ArrayList;
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
	@Column(name="user_name",unique=true)
	private String username;

	@Size(min = 4, max = 25)
	@Column(name="first_name")
	private String firstname;

	@Size(min = 4, max = 25)
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@Size(max = 256)
	@Column(name="password")
	private String password;
 
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role",
		joinColumns=@JoinColumn(
				name="user_name",referencedColumnName="user_name"),
		inverseJoinColumns=@JoinColumn(
			name="role",	referencedColumnName="role")
	)
	
	private List<Roles> roles=new ArrayList<Roles>();
	
	public User() {
		super();
	}



	public boolean add(Roles e) {
		return roles.add(e);
	}



	public User(String username, String firstname, String lastname, String email, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
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



	public List<Roles> getRoles() {
		return roles;
	}



	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	
	
	

}
