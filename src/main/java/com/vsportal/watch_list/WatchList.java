package com.vsportal.watch_list;

import java.sql.Date;

import com.vsportal.request.Request;
import com.vsportal.task.Task;
import com.vsportal.user.User;

public class WatchList {
	private int id;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Request request;
	private String email;
	
	public WatchList() {
		super();
	}

	public WatchList(int id, Date created, User createdBy, Date updated, User updatedBy, Request request,
			String email) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.request = request;
		this.email = email;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
