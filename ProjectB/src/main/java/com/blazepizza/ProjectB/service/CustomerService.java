package com.blazepizza.ProjectB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blazepizza.ProjectB.bean.Tasks;
import com.blazepizza.ProjectB.bean.ProfileBean;
import com.blazepizza.ProjectB.bean.UserCredential;
import com.blazepizza.ProjectB.dao.CustomerDao;


 

@Service
public class CustomerService {
	

@Autowired
private CustomerDao cdao;

	
//	@Transactional
//	public int userSignup(ProfileBean emp)
//	{
//		System.out.println("in service");
//		return cdao.userSignup(emp);
//	}
	
	@Transactional
	public int userRegister(ProfileBean user) {
		return cdao.userRegister(user);
	}
	
	@Transactional
	public int checkExistence(ProfileBean emp)
	{
	
		return cdao.checkUser(emp);
	
	
	}
	
	@Transactional
	public boolean isAuth(UserCredential uc)
	{
	
		return cdao.isAuth(uc);
	}
	
//	@Transactional
//	public String getUserName(UserCredential uc) {
//		return cdao.
//	}
	
//	@Transactional
//	public int addToOrders(Orders ord)
//	{
//	
//		return cdao.addToOrders(ord);
//	}
	
	@Transactional
	public int addNewTask(Tasks task) {
		return cdao.addNewTasks(task);
	}
	
	@Transactional
	public int updateTheTask(Tasks task) {
		return cdao.updateTheTask(task);
	}
	
	@Transactional
	public List<Tasks> findAllTasks(String email)
	{
	
		return cdao.findAllTasks(email);
	}
	
	@Transactional
	public int deleteTask(Tasks t)
	{
	
		return cdao.deleteTask(t);
	}
	

}
