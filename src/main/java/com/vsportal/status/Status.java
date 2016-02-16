package com.vsportal.status;

import java.sql.Date;

import com.vsportal.user.User;

public class Status {
	private int id;
	private String label;
	private int value;
	private String type;
	private Date created;
	private User created_by;
	private Date updated;
	private User updated_by;
	
	public Status(){
	}
	
	public Status(String label,int value, String type){
		this.label = label;
		this.value = value;
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
