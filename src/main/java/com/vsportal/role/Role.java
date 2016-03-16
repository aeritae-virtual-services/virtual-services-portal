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
