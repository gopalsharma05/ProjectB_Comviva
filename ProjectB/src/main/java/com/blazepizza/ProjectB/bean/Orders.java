package com.blazepizza.ProjectB.bean;

import org.hibernate.annotations.Entity;

@Entity
public class Orders {
	
	public Orders() {
		
	}
	
	@Override
	public String toString() {
		return "Orders [username=" + username + ", task=" + task + ", description=" + description + ", completed="
				+ completed + "]";
	}

	private String username;
	
	private String task,description,completed;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
	
	 
}
