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

	 
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;
	
	
	//bi-directional many-to-one association to Group
		@ManyToOne
		@JoinColumn(name="group_name")
		private Groups groups;
	
	/*@Size(min=5, max = 10)
	@Column(name="group_name")
	private String group;*/

	public Roles() {
	}

	public Roles(User user, Groups groups) {
		super();
		this.user = user;
		this.groups = groups;
	}

	public int getIdrole() {
		return this.idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	
	 

}