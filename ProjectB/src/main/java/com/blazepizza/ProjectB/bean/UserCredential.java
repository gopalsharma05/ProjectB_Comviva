package com.blazepizza.ProjectB.bean;

import java.util.List;

import javax.persistence.CascadeType;
 	
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;


public class UserCredential {
	
//	private Orders orders;
	
	private String password,username;
	
	 
	List<Orders> orders;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	 
	
	

}
