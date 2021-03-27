package com.blazepizza.ProjectB.bean;

import java.util.List;



//@Component
public class UserCredential {
	
//	private Orders orders;
	
	private String password,email;
	List<Tasks> orders;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	 
	
	

}
