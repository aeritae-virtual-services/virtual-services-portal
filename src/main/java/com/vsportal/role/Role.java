package com.vsportal.role;

import java.sql.Date;

import com.vsportal.user.User;

public class Role {
	
	private int id;
	private String name;
	private int value;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public Role(){
	}
	
	public Role(String name, int value){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public User getcreatedBy() {
		return createdBy;
	}

	public void setcreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getupdatedBy() {
		return updatedBy;
	}

	public void setupdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
}
