package com.antoiovi.projectp.view;


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import com.antoiovi.projectp.dao.UserDao;
import com.antoiovi.projectp.model.User;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class UserBean {

	@Inject
	private UserDao userDao;

	private User newuser;

	private List<User> allUser;

	@PostConstruct
	public void init() {
		allUser=new ArrayList<User>();
		allUser=userDao.listAll();
		newuser=new User();
	}
	
	
	public void saveNewUser() {
		userDao.create(newuser);
		return;
	}
 
	public List<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

	public User getNewuser() {
		return newuser;
	}

	public void setNewuser(User newuser) {
		this.newuser =newuser;
	}
}
