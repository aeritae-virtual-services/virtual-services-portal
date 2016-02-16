package com.vsportal.company;

import java.sql.Date;

import com.vsportal.user.User;

public class Company {
	
	private int id;
	private String name;
	private User primary_contact;
	private String url;
	private String address;
	private User queue_manager;
	private boolean migration;
	private Date created;
	private User created_by;
	private Date updated;
	private User updated_by;
	
	public Company(){
	}
	
	public Company(String name, User primary_contact, String url, String address, User queue_manager, boolean migration){
		this.name = name;
		this.primary_contact = primary_contact;
		this.url = url;
		this.address = address;
		this.queue_manager = queue_manager;
		this.migration = migration;
	}

	public int getID(){
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getPrimary_contact() {
		return primary_contact;
	}

	public void setPrimary_contact(User primary_contact) {
		this.primary_contact = primary_contact;
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

	public User getQueue_manager() {
		return queue_manager;
	}

	public void setQueue_manager(User queue_manager) {
		this.queue_manager = queue_manager;
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

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public User getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(User updated_by) {
		this.updated_by = updated_by;
	}
	
	

}
