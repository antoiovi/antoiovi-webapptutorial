package com.antoiovi.projectp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Groups.findAll", query="SELECT g FROM Groups g")
public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to Role
	//@OneToMany(mappedBy="group")
	//private List<Role> roles;

	public Groups() {
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	

}