package com.vsportal.role;

import java.sql.Date;

import com.vsportal.user.User;
import com.vsportal.utils.DropdownOption;

public class Role {
	
	private int id;
	private String displayValue;
	private String name;
	private int value;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public Role(){
	}
	
	public Role(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
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

	public User getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}

	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created){
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	
	public DropdownOption getDropdownOption() {
		return new DropdownOption(String.valueOf(this.getId()), this.getName());
	}

	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
}
