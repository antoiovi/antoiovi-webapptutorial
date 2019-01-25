package com.antoiovi.projectp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@NamedQuery(name="Group.findAll", query="SELECT g FROM Groups g")
public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="groups")
	private List<Roles> roles;

	public Groups() {
	}

	
	public Groups(String groupName) {
		super();
		this.groupName = groupName;
	}


	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Roles> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public Roles addRole(Roles role) {
		getRoles().add(role);
		role.setGroups(this);

		return role;
	}

	public Roles removeRole(Roles role) {
		getRoles().remove(role);
		role.setGroups(null);

		return role;
	}
}

