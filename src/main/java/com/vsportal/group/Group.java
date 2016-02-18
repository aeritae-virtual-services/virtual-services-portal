package com.vsportal.group;

import java.sql.Date;

import com.vsportal.user.User;

public class Group {
	private int id;
	private String name;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public Group(){
	}
	
	public Group(String name){
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public Date getCreated() {
		return created;
	}

	public User getcreatedBy() {
		return createdBy;
	}

	public void setcreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public User getupdatedBy() {
		return updatedBy;
	}

	public void setupdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
}
