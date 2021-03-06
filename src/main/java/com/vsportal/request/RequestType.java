package com.vsportal.request;

import java.sql.Date;

import com.vsportal.user.User;
import com.vsportal.utils.DropdownOption;
import com.vsportal.workflow.WorkflowStep;

public class RequestType {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private String name;
	private String description;
	private WorkflowStep firstWorkflowStep;
	
	public RequestType(){
	}
	
	public RequestType(int id, String displayValue){
	 this.id = id;
	 this.displayValue = displayValue;
	}
	
	public RequestType(int id, String name, String description, WorkflowStep firstWorkflowStep, User createdBy, 
			User updatedBy){
		this.id = id;
		this.name = name;
		this.description = description;
		this.setFirstWorkflowStep(firstWorkflowStep);
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.displayValue = this.name;
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
	
	public String getDisplayValue(){
		return displayValue;
	}
	
	public void setDisplayValue(String displayValue){
		this.displayValue = displayValue;
	}

	public WorkflowStep getFirstWorkflowStep() {
		return firstWorkflowStep;
	}

	public void setFirstWorkflowStep(WorkflowStep firstWorkflowStep) {
		this.firstWorkflowStep = firstWorkflowStep;
	}
}
