package com.vsportal.metric;

import java.sql.Date;

import com.vsportal.client.Client;
import com.vsportal.request.Request;
import com.vsportal.status.Status;
import com.vsportal.task.Task;
import com.vsportal.task.TaskType;
import com.vsportal.user.User;

public class Metric {
	private int id;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private TaskType type;
	private Date start;
	private Date end;
	private int duration;
	private Status status;
	private Request request_id;
	private Client client_id;
	private Task task;
	private String displayValue;
	
	public Metric() {
		super();
	}

	public Metric(int id, Date created, User createdBy, Date updated, User updatedBy, TaskType type, Date start,
			Date end, int duration, Status status, Request request_id, Client client_id, Task task) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.type = type;
		this.start = start;
		this.end = end;
		this.duration = duration;
		this.status = status;
		this.request_id = request_id;
		this.client_id = client_id;
		this.displayValue = type.getDisplayValue();
		this.task = task;
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

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Request getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Request request_id) {
		this.request_id = request_id;
	}

	public Client getClient_id() {
		return client_id;
	}

	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
