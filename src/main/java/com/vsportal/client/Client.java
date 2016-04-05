package com.vsportal.client;

import java.sql.Date;

import com.vsportal.group.Group;
import com.vsportal.user.User;

public class Client {
	
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String name;
	private User primaryContact;
	private String url;
	private String address;
	private Group qManager;
	private boolean testMigrationRequired;
	private boolean productionMigrationRequired;
	private boolean clientPORequired;
	private Group primaryAnalystGroup;
	
	public Client() {
		super();
	}
	
	public Client(int id, String displayValue) {
		this.id = id;
		this.displayValue = displayValue;
	}

	public Client(int id, Date created, User createdBy, Date updated, User updatedBy, String name, User primaryContact,
			String url, String address, Group qManager, boolean testMigrationRequired, boolean productionMigrationRequired,
			boolean clientPORequired, Group primaryAnalystGroup)
	{
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
		this.qManager = qManager;
		this.testMigrationRequired = testMigrationRequired;
		this.clientPORequired = clientPORequired;
		this.primaryAnalystGroup = primaryAnalystGroup;
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

	public Group getQManager() {
		return qManager;
	}

	public void setQManager(Group qManager) {
		this.qManager = qManager;
	}

	public boolean isClientPORequired() {
		return clientPORequired;
	}

	public void setClientPORequired(boolean clientPORequired) {
		this.clientPORequired = clientPORequired;
	}
	public String getDisplayValue(){
		return displayValue;
	}
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}

	public boolean isTestMigrationRequired() {
		return testMigrationRequired;
	}

	public void setTestMigrationRequired(boolean testMigrationRequired) {
		this.testMigrationRequired = testMigrationRequired;
	}

	public boolean isProductionMigrationRequired() {
		return productionMigrationRequired;
	}

	public void setProductionMigrationRequired(boolean productionMigrationRequired) {
		this.productionMigrationRequired = productionMigrationRequired;
	}

	public Group getPrimaryAnalystGroup() {
		return primaryAnalystGroup;
	}

	public void setPrimaryAnalystGroup(Group primaryAnalystGroup) {
		this.primaryAnalystGroup = primaryAnalystGroup;
	}
}
