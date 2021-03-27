package com.blazepizza.ProjectB.dao;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.blazepizza.ProjectB.bean.Tasks;
import com.blazepizza.ProjectB.bean.ProfileBean;
import com.blazepizza.ProjectB.bean.UserCredential;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



@Repository
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public int userSignup(ProfileBean cust) {
//
//		System.out.println("in DAO");
//		return jdbcTemplate.update("insert into POS_TBL_User_Profile values('" + cust.getUserid() + "','"
//				+ cust.getFirstName() + "','" + cust.getLastName() + "','" + cust.getGender() + "','" + cust.getPhone()
//				+ "','" + cust.getStreet() + "','" + cust.getCity() + "','" + cust.getPincode() + "','"
//				+ cust.getState() + "','" + cust.getEmail() + "','" + cust.getPassword() + "')");
//
//	}
	
	public int userRegister(ProfileBean user) {
		return jdbcTemplate.update("insert into task_manager_user values('" + user.getUserName() + "','" + user.getFirstName() + "','" + user.getLastName() + "','"
				+ user.getEmail() + "','" + user.getPassword() + "','" + user.getGender() + "')");
	}
	
//	public int checkExistence(ProfileBean cust)
//	{
//		String email=cust.getEmail();
//		String sql = "SELECT count(*) FROM POS_TBL_User_Profile WHERE email = ?";
//
//	    int count = jdbcTemplate.queryForObject(sql, new Object[] { email }, Integer.class);
//
//		if(count>0)
//			return 1;
//		else 
//			return 0;
//		
//	}
	
	public int checkUser(ProfileBean user) {
		String email=user.getEmail();
		String sql = "SELECT count(*) FROM task_manager_user WHERE email = ?";
		
		int count = jdbcTemplate.queryForObject(sql,new Object [] {email}, Integer.class);
		
		if(count>0)
			return 1;
		else
			return 0;
	}
	
	public boolean isAuth(UserCredential uc)
	{
		String sql = "SELECT count(*) FROM task_manager_user WHERE email = ? and password=? ";
		String email=uc.getEmail();
		String password=uc.getPassword();
	    int count = jdbcTemplate.queryForObject(sql, new Object[] { email,password }, Integer.class);
//		System.out.println("user's mail: "+email);
//		System.out.println("user's password: "+password);
		 
	    return count>0;
	}

	public int addNewTasks(Tasks task) {
			
		 KeyHolder holder = new GeneratedKeyHolder();
//		 int update = jdbcTemplate.update("insert into Tasks (email,taskName,taskDescription,taskDate) values('" + task.getEmail() + "','"
//				+ task.getTaskName() + "','" + task.getTaskDescription() + "','" + task.getTaskDate() + "')" ,holder);
//		
		 int update = jdbcTemplate.update(connection -> {
		        PreparedStatement ps = connection
		          .prepareStatement("insert into Tasks (email,taskName,taskDescription,taskDate) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		          ps.setString(1, task.getEmail());
		          ps.setString(2, task.getTaskName());
		          ps.setString(3, task.getTaskDescription());
		          ps.setDate(4, task.getTaskDate());
		          return ps;
		        }, holder);
		 
		 task.setTaskId(holder.getKey().intValue());
		 System.out.println(task.getTaskId()+"  is the id of the inserted data");
		 return update;
		
	}
	
	public List<Tasks> findAllTasks(String mail)
	{
		

		 
//        System.out.println("username of the user for which task to be extracted is : "+ mail);
        String sql = "SELECT * FROM Tasks WHERE email = ?";

        List<Tasks> tasks= (ArrayList<Tasks>)jdbcTemplate.query(
            sql, 
            new Object[]{mail}, 
            new BeanPropertyRowMapper(Tasks.class));
        
        return tasks;
		
	}
	
	public int updateTheTask(Tasks ts)
	{
		String SQL = "update Tasks set taskName = ? ,taskDescription =?, taskDate=? where taskId = ?";
	      return jdbcTemplate.update(SQL, ts.getTaskName(),ts.getTaskDescription(),ts.getTaskDate()
	    		  ,ts.getTaskId());
	}
	public int deleteTask(Tasks ts)
	{
		String SQL = "delete from Tasks where taskId = ?";
	      return jdbcTemplate.update(SQL,ts.getTaskId());
	}
	
	

}
