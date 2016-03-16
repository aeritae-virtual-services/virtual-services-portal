package com.vsportal.priority;

import java.sql.Date;

import com.vsportal.user.User;
import com.vsportal.utils.DropdownOption;

public class Priority {
	private int id;
	private String displayValue;
	private String label;
	private int value;
	private Date created;
	private User created_by;
	private Date updated;
	private User updated_by;
	
	public Priority(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}
	public Priority(){
	}
	
	public Priority(String label, int value){
		this.label = label;
		this.value = value;
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
	
	public DropdownOption getDropdownOption() {
		return new DropdownOption(String.valueOf(this.getValue()), this.getLabel());
	}
	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
	
}
