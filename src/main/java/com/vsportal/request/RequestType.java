package com.vsportal.request;

import java.sql.Date;

import com.vsportal.user.User;
import com.vsportal.utils.DropdownOption;
import com.vsportal.workflow.WorkflowStep;

public class RequestType {
	private int id;
	private String name;
	private String description;
	private WorkflowStep firstStep;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	
	public RequestType(){
	}
	
	public RequestType(int id, String name, String description, WorkflowStep firstStep, User createdBy, 
			User updatedBy){
		this.id = id;
		this.name = name;
		this.description = description;
		this.firstStep = firstStep;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkflowStep getFirstStep() {
		return firstStep;
	}

	public void setFirstStep(WorkflowStep firstStep) {
		this.firstStep = firstStep;
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
	
	public DropdownOption getDropdownOption() {
		return new DropdownOption(String.valueOf(this.getId()), this.getName());
	}

}
