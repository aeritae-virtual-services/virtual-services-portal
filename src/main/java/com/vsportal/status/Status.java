package com.vsportal.status;

import java.sql.Date;

import com.vsportal.user.User;

public class Status {
	private int id;
	private String displayValue;
	private String label;
	private int value;
	private String table;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public Status(){
	}
	
	public Status(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}
	
	public Status(String label,int value, String table){
		this.label = label;
		this.value = value;
		this.table = table;
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

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setId(int id){
		this.id=id;
	}
	
	public void setCreated(Date created){
		this.created = created;
	}
	
	public void setUpdated(Date updated){
		this.updated = updated;
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

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
	

	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}

}
