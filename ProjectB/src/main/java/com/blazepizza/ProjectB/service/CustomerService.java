package com.blazepizza.ProjectB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blazepizza.ProjectB.bean.ProfileBean;
import com.blazepizza.ProjectB.bean.UserCredential;
import com.blazepizza.ProjectB.dao.CustomerDao;


 

@Service
public class CustomerService {
	

@Autowired
private CustomerDao cdao;

	
	@Transactional
	public int userSignup(ProfileBean emp)
	{
		System.out.println("in service");
		return cdao.userSignup(emp);
	}
	
	@Transactional
	public int checkExistence(ProfileBean emp)
	{
	
		return cdao.checkExistence(emp);
	
	
	}
	
	@Transactional
	public boolean isAuth(UserCredential uc)
	{
	
		return cdao.isAuth(uc);
	}
	

}
