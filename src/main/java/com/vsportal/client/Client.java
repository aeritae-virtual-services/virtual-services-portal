package com.vsportal.client;

import java.sql.Date;

import com.vsportal.user.User;

public class Client {
	
	private int id;
	private String name;
	private User primaryContact;
	private String url;
	private String address;
	private User queueManager;
	private boolean migration;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public Client(){
	}
	
	public Client(String name, User primaryContact, String url, String address, User queueManager, boolean migration){
		this.name = name;
		this.primaryContact = primaryContact;
		this.url = url;
		this.address = address;
		this.queueManager = queueManager;
		this.migration = migration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(User primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getQueueManager() {
		return queueManager;
	}

	public void setQueueManager(User queueManager) {
		this.queueManager = queueManager;
	}

	public boolean isMigration() {
		return migration;
	}

	public void setMigration(boolean migration) {
		this.migration = migration;
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
	

}
