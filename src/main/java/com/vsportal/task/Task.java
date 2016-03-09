package com.vsportal.task;

import java.sql.Date;

import com.vsportal.group.Group;
import com.vsportal.request.Request;
import com.vsportal.status.Status;
import com.vsportal.user.User;

public class Task {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private Request request;
	private Group assignmentGroup;
	private User assignedTo;
	private String instructions;
	private Status status;
	private String number;
	private Status resumeTo;
	private User pokedAnalyst;
	private Date pokedDate;
	private User pokedBy;
	private TaskType type;
	
	private Task() {
		super();
	}
	
	public Task(int id, String displayValue){
		this.id=id;
		this.displayValue = displayValue;
	}

	public Task(int id, Date created, User createdBy, Date updated, User updatedBy, Request request,
			Group assignmentGroup, User assignedTo, String instructions, Status status, String number, TaskType type) {
		super();
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.request = request;
		this.assignmentGroup = assignmentGroup;
		this.assignedTo = assignedTo;
		this.instructions = instructions;
		this.status = status;
		this.number = number;
		this.type = type;
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

	public Group getAssignmentGroup() {
		return assignmentGroup;
	}

	public void setAssignmentGroup(Group assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Status getResumeTo() {
		return resumeTo;
	}

	public void setResumeTo(Status resumeTo) {
		this.resumeTo = resumeTo;
	}

	public User getPokedAnalyst() {
		return pokedAnalyst;
	}

	public void setPokedAnalyst(User pokedAnalyst) {
		this.pokedAnalyst = pokedAnalyst;
	}

	public Date getPokedDate() {
		return pokedDate;
	}

	public void setPokedDate(Date pokedDate) {
		this.pokedDate = pokedDate;
	}

	public User getPokedBy() {
		return pokedBy;
	}

	public void setPokedBy(User pokedBy) {
		this.pokedBy = pokedBy;
	}
	
	public TaskType getTaskType() {
		return type;
	}
	
	public void setTaskType(TaskType type) {
		this.type = type;
	}
}
