package com.vsportal.availability;

import java.sql.Date;

import com.vsportal.user.User;

public class Availability {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private User analyst;
	private Date start;
	private Date end;
	
	public Availability() {
		super();
	}
	
	public Availability(int id, String displayValue) {
		this.id = id;
		this.displayValue = displayValue;
	}

	public Availability(int id, Date created, User createdBy, Date updated, User updatedBy, User analyst, Date start,
			Date end) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.analyst = analyst;
		this.start = start;
		this.end = end;
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

	public User getAnalyst() {
		return analyst;
	}

	public void setAnalyst(User analyst) {
		this.analyst = analyst;
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
}
