package com.vsportal.role;

import java.sql.Date;

import com.vsportal.user.User;

public class Role {
	
	private int id;
	private String name;
	private int value;
	private Date created;
	private User created_by;
	private Date updated;
	private User updated_by;
	
	public Role(){
	}
	
	public Role(Sting name, int value){
		
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

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public User getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(User updated_by) {
		this.updated_by = updated_by;
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
