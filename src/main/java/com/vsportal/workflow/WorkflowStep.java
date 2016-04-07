package com.vsportal.workflow;

import java.sql.Date;

import com.vsportal.request.RequestType;
import com.vsportal.user.User;
import com.vsportal.email.EmailTemplate;
import com.vsportal.group.Group;
import com.vsportal.status.Status;
import com.vsportal.task.TaskType;
public class WorkflowStep {
	private int id;
	private String displayValue;
	private Date created;
	private User createdBy;
	private Date updated;
	private User updatedBy;
	private WorkflowOperation operation;
	private WorkflowStep successNextStep;
	private WorkflowStep failNextStep;
	private String description;
	private EmailTemplate emailTemplate;
	private Group	assignmentGroup;
	private String instructions;
	private Status newStatus;
	private boolean writeMetric;
	private TaskType taskType;
	public WorkflowStep(){
		super();
	}
	public WorkflowStep(int id, String displayValue){
		this.id=id;
		this.displayValue = displayValue;
	}

	public WorkflowStep getFirstStepByReqType(RequestType requestType) {
		// TODO Auto-generated method stub
		return null;
	}

	public WorkflowStep getNextStep(WorkflowStep prev) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getOperationID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public WorkflowStep getSuccessNextStep() {
		return successNextStep;
	}

	public void setSuccessNextStep(WorkflowStep successNextStep) {
		this.successNextStep = successNextStep;
	}

	public WorkflowOperation getOperation() {
		return operation;
	}

	public void setOperation(WorkflowOperation operation) {
		this.operation = operation;
	}

	public WorkflowStep getFailNextStep() {
		return failNextStep;
	}

	public void setFailNextStep(WorkflowStep failNextStep) {
		this.failNextStep = failNextStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EmailTemplate getEmailTemplate() {
		return emailTemplate;
	}

	public void setEmailTemplate(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public Group getAssignmentGroup() {
		return assignmentGroup;
	}

	public void setAssignmentGroup(Group assignmentGroup) {
		this.assignmentGroup = assignmentGroup;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Status getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(Status newStatus) {
		this.newStatus = newStatus;
	}

	public boolean isWriteMetric() {
		return writeMetric;
	}

	public void setWriteMetric(boolean writeMetric) {
		this.writeMetric = writeMetric;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

}
