package com.vsportal.metric;

import java.sql.Date;

import com.vsportal.status.Status;
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
	
	public Metric() {
		super();
	}

	public Metric(int id, Date created, User createdBy, Date updated, User updatedBy, TaskType type, Date start,
			Date end, int duration, Status status) {
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
}
