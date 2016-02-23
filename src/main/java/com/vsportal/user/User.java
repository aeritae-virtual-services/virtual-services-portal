package com.vsportal.user;

import java.sql.Date;
import java.util.ArrayList;

import com.vsportal.client.Company;
import com.vsportal.group.Group;
import com.vsportal.role.Role;

public class User {
	
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Company company;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private ArrayList<Group> group;
	private Role role;
	
	


	public User(){
	}
	
	public User(String firstName, String lastName, String phone, String email, Company company){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.role = role;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public ArrayList getGroup() {
		return group;
	}

	public void setGroup(ArrayList group) {
		this.group = group;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
