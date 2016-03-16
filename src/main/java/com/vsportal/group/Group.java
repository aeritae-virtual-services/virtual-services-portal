package com.vsportal.group;

import java.sql.Date;

import com.vsportal.user.User;

public class Group {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String name;
	
	public Group() {
		super();
	}
	
	public Group(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}

	public Group(int id, Date created, User createdBy, Date updated, User updatedBy, String name) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.name = name;
		this.displayValue = this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
}
