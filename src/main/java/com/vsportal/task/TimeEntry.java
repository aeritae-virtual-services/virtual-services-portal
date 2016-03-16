package com.vsportal.task;

import java.sql.Date;

import com.vsportal.client.Client;
import com.vsportal.contract.Contract;
import com.vsportal.user.User;

public class TimeEntry {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Task task;
	private float hoursConsumed;
	private User user;
	private Contract contract;
	private Client client;
	
	public TimeEntry(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}
	public TimeEntry(int id, Date created, User createdBy, Date updated, User updatedBy, Task task, float hoursConsumed,
			User user, Contract contract, Client client) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.task = task;
		this.hoursConsumed = hoursConsumed;
		this.user = user;
		this.contract = contract;
		this.client = client;
		this.displayValue = Float.toString(this.hoursConsumed);
		
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
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public float getHoursConsumed() {
		return hoursConsumed;
	}
	public void setHoursConsumed(float hoursConsumed) {
		this.hoursConsumed = hoursConsumed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Client getClient() {
		return this.client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
}
