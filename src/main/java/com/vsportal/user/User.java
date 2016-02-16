package com.vsportal.user;

import java.sql.Date;
import java.util.ArrayList;

import com.vsportal.company.Company;
import com.vsportal.role.Role;

public class User {
	
	private int id;
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private Company company;
	private int roleID;
	private Date created;
	private User created_by;
	private Date updated;
	private User updated_by;
	private ArrayList group;
	private Role role;
	
	


	public User(){
	}
	
	public User(String first_name, String last_name, String phone, String email, Company company, int roleID){
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.roleID = roleID;
	}
	
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getId() {
		return id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public Company getcompany() {
		return company;
	}

	public void setcompany(Company company) {
		this.company = company;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Date getCreated() {
		return created;
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

	public User getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(User updated_by) {
		this.updated_by = updated_by;
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
