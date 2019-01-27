package com.antoiovi.projectp.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@NamedQuery(name="Roles.findAll", query="SELECT r FROM Roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idrole;

	 
	 
    @Column(unique = true, nullable=false)
    private String role;
	
	/*@Size(min=5, max = 10)
	@Column(name="group_name")
	private String group;*/

	public Roles() {
	}

	

	public Roles(String role) {
		super();
		this.role = role;
	}



	public int getIdrole() {
		return this.idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	 
 

	 
	
	 

}