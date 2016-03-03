package com.vsportal.user;

import java.sql.Date;
import java.util.ArrayList;

import com.vsportal.client.Client;
import com.vsportal.group.Group;
import com.vsportal.role.Role;

public class User {
	
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String fullName;
	private String phone;
	private String email;
	private Client client;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private ArrayList<Group> groups;
	private Role role;
	private String image;

	public User(){
		
	}
	
	public User(String username, String firstName, String lastName, String phone, String email, Client client, Role role, User createdBy, User updatedBy){
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;
		this.phone = phone;
		this.email = email;
		this.client = client;
		this.role = role;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public Date getCreated() {
		return created;
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

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ArrayList<Group> getGroup() {
		return groups;
	}

	public void setGroup(ArrayList<Group> groups) {
		this.groups = groups;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String img) {
		this.image = img;
	}
}
