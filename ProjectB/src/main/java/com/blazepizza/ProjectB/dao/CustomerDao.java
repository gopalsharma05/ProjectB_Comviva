package com.blazepizza.ProjectB.dao;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blazepizza.ProjectB.bean.Orders;
import com.blazepizza.ProjectB.bean.ProfileBean;
import com.blazepizza.ProjectB.bean.UserCredential;

import java.util.ArrayList;
import java.util.List;



@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int userSignup(ProfileBean cust) {

		System.out.println("in DAO");
		return jdbcTemplate.update("insert into POS_TBL_User_Profile values('" + cust.getUserid() + "','"
				+ cust.getFirstName() + "','" + cust.getLastName() + "','" + cust.getGender() + "','" + cust.getPhone()
				+ "','" + cust.getStreet() + "','" + cust.getCity() + "','" + cust.getPincode() + "','"
				+ cust.getState() + "','" + cust.getEmail() + "','" + cust.getPassword() + "')");

	}
	
	public int checkExistence(ProfileBean cust)
	{
		String email=cust.getEmail();
		String sql = "SELECT count(*) FROM POS_TBL_User_Profile WHERE email = ?";

	    int count = jdbcTemplate.queryForObject(sql, new Object[] { email }, Integer.class);

		if(count>0)
			return 1;
		else 
			return 0;
		
	}
	
	public boolean isAuth(UserCredential uc)
	{
		String sql = "SELECT count(*) FROM POS_TBL_User_Profile WHERE email = ? and password=? ";
		String email=uc.getUsername();
		String password=uc.getPassword();
	    int count = jdbcTemplate.queryForObject(sql, new Object[] { email,password }, Integer.class);
		System.out.println("user's mail: "+email);
		System.out.println("user's password: "+password);
		 
	    return count>0;
	}

	public int addToOrders(Orders ord) {
			
		
		return jdbcTemplate.update("insert into Tasks values('" + ord.getUsername() + "','"
				+ ord.getTask() + "','" + ord.getDescription() + "','" + ord.getCompleted() + "')");	
		
	}
	
	public List<Orders> findAllTasks(String username)
	{
		

		 
        System.out.println("username of the user for which task to be extracted is : "+username);
        String sql = "SELECT * FROM Tasks WHERE username = ?";

        List<Orders> orders= (ArrayList<Orders>)jdbcTemplate.query(
            sql, 
            new Object[]{username}, 
            new BeanPropertyRowMapper(Orders.class));
        
        
        return orders;
		
	}
	
	

}
