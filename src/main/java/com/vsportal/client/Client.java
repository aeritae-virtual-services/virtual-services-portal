package com.vsportal.client;

import java.sql.Date;

import com.vsportal.group.Group;
import com.vsportal.user.User;

public class Client {
	
	private int id;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String name;
	private User primaryContact;
	private String url;
	private String address;
	private Group queueManagers;
	private boolean migrationRequired;
	private boolean clientPORequired;
	private Group primaryAnalysts;
	
	public Client() {
		super();
	}

	public Client(int id, Date created, User createdBy, Date updated, User updatedBy, String name, User primaryContact,
			String url, String address, Group queueManagers, boolean migrationRequired, boolean clientPORequired,
			Group primaryAnalysts) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.name = name;
		this.primaryContact = primaryContact;
		this.url = url;
		this.address = address;
		this.queueManagers = queueManagers;
		this.migrationRequired = migrationRequired;
		this.clientPORequired = clientPORequired;
		this.primaryAnalysts = primaryAnalysts;
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

	public Group getQueueManagers() {
		return queueManagers;
	}

	public void setQueueManagers(Group queueManagers) {
		this.queueManagers = queueManagers;
	}

	public boolean isMigrationRequired() {
		return migrationRequired;
	}

	public void setMigrationRequired(boolean migrationRequired) {
		this.migrationRequired = migrationRequired;
	}

	public boolean isClientPORequired() {
		return clientPORequired;
	}

	public void setClientPORequired(boolean clientPORequired) {
		this.clientPORequired = clientPORequired;
	}

	public Group getPrimaryAnalysts() {
		return primaryAnalysts;
	}

	public void setPrimaryAnalysts(Group primaryAnalysts) {
		this.primaryAnalysts = primaryAnalysts;
	}
}
