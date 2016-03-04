package com.vsportal.email;

import java.sql.Date;

import com.vsportal.status.Status;
import com.vsportal.user.User;

public class EmailLog {
	private int id;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String recipient;
	private String from;
	private String direction;
	private String subject;
	private String body;
	private EmailTemplate template;
	private String table;
	private int tableId;
	private Status status;
	
	public EmailLog() {
		super();
	}

	public EmailLog(int id, Date created, User createdBy, Date updated, User updatedBy, String recipient, String from,
			String direction, String subject, String body, EmailTemplate template, String table, int tableId,
			Status status) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.recipient = recipient;
		this.from = from;
		this.direction = direction;
		this.subject = subject;
		this.body = body;
		this.template = template;
		this.table = table;
		this.tableId = tableId;
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

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public EmailTemplate getTemplate() {
		return template;
	}

	public void setTemplate(EmailTemplate template) {
		this.template = template;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
