package com.vsportal.approval;

import java.sql.Date;

import com.vsportal.client.Client;
import com.vsportal.request.Request;
import com.vsportal.user.User;

public class Approval {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Client client;
	private User approvedBy;
	private Date decisionDate;
	private Request request;
	private String description;
	private String decision;
	private String approvalType;
	
	public Approval() {
		
	}
	
	public Approval(int id, String displayValue) {
		this.id = id;
		this.displayValue = displayValue;
	}
	
	public Approval(int id, Date created, User createdBy, Date updated, User updatedBy, Client client,
			User approvedBy, Date decisionDate, Request request, String description, String decision,
			String approvalType) {
		super();
		this.id = id;
		this.displayValue = approvalType;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.client = client;
		this.approvedBy = approvedBy;
		this.decisionDate = decisionDate;
		this.request = request;
		this.description = description;
		this.decision = decision;
		this.approvalType = approvalType;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
