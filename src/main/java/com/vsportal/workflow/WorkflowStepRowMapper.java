package com.vsportal.workflow;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.email.EmailTemplate;
import com.vsportal.group.Group;
import com.vsportal.status.Status;
import com.vsportal.task.TaskType;

public class WorkflowStepRowMapper<T> implements RowMapper<WorkflowStep> {
	public WorkflowStep mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkflowStep workflowStep = new WorkflowStep();
		workflowStep.setId(rs.getInt("WorkflowStep.id"));
		workflowStep.setCreated(rs.getDate("WorkflowStep.created"));
		User cb = new User(rs.getInt("WorkflowStep.created_by"), rs.getString("createdby.full_name"));
		workflowStep.setCreatedBy(cb);
		workflowStep.setUpdated(rs.getDate("WorkflowStep.updated"));
		User ub = new User(rs.getInt("WorkflowStep.updated_by"), rs.getString("updatedby.full_name"));
		workflowStep.setUpdatedBy(ub);
		workflowStep.setOperation(new WorkflowOperation(rs.getInt("WorkflowStep.operation_id"),rs.getString("operationid.operation_nme")));
		workflowStep.setSuccessNextStep(new WorkflowStep(rs.getInt("WorkflowStep.success_next_step"),rs.getString("successnextsteptasktype.label")));
		workflowStep.setDescription(rs.getString("WorkflowStep.description"));
		workflowStep.setEmailTemplate(new EmailTemplate(rs.getInt("WorflowStep.email_template_id"),rs.getString("emailtemplateid.subject")));
		workflowStep.setAssignmentGroup(new Group(rs.getInt("WorkflowStep.assignment_group_id"),rs.getString("assignmentgroupid.user_group_nme")));
		workflowStep.setInstructions(rs.getString("WorkflowStep.instructions"));
		workflowStep.setNewStatus(new Status(rs.getInt("WorkflowStep.new_status"),rs.getString("newstatus.label")));
		workflowStep.setTaskType(new TaskType(rs.getInt("WorkflowStep.task_type"),rs.getString("tasktypeid.label")));
				
		return workflowStep;
	}
}
