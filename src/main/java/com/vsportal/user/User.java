package com.vsportal.user;

import java.sql.Date;
import java.util.ArrayList;

import com.vsportal.client.Client;
import com.vsportal.group.Group;
import com.vsportal.role.Role;
import com.vsportal.task.Task;

public class User {
	
	private int id;
	private String displayValue;
	private String username;
	private String firstName;
	private String lastName;
	private String fullName;
	private String phoneNumber;
	private String email;
	private Client client;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private ArrayList<Group> groups;
	private Role role;
	private String image;
	private ArrayList<Task> myPokedTasks;
	private String encodedJSON;

	public User(){
		
	}
	
	public User(int id, String displayValue){
		this.id = id;
		this.displayValue = displayValue;
	}
	
	public User(String username, String firstName, String lastName, String phoneNumber, String email, Client client, Role role, User createdBy, User updatedBy){
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;
		this.displayValue = this.fullName;
		this.phoneNumber = phoneNumber;
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
	
	public void setCreated(Date created){
		this.created=created;
	}
	
	public void setUpdated(Date updated){
		this.updated=updated;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	public void setMyPokedTasks(ArrayList<Task> pokedTasks) {
		this.myPokedTasks = pokedTasks;
	}
	
	public ArrayList<Task> getMyPokedTasks() {
		return this.myPokedTasks;
	}
	
	public String getDisplayValue(){
		return displayValue;
	}
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}
	
	public void setJSONString(String json) {
		this.encodedJSON = json;
	}
	
	public String getJSONString() {
		return this.encodedJSON;
	}
}
