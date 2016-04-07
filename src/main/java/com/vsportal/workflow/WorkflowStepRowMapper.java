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
		workflowStep.setId(rs.getInt("Workflow_Step.id"));
		workflowStep.setCreated(rs.getDate("Workflow_Step.created"));
		User cb = new User(rs.getInt("Workflow_Step.created_by"), rs.getString("createdby.full_name"));
		workflowStep.setCreatedBy(cb);
		workflowStep.setUpdated(rs.getDate("Workflow_Step.updated"));
		User ub = new User(rs.getInt("Workflow_Step.updated_by"), rs.getString("updatedby.full_name"));
		workflowStep.setUpdatedBy(ub);
		workflowStep.setOperation(new WorkflowOperation(rs.getInt("Workflow_Step.operation_id"),rs.getString("operationid.operation_nme")));
		workflowStep.setSuccessNextStep(new WorkflowStep(rs.getInt("Workflow_Step.success_next_step"),rs.getString("successnextsteptasktype.label")));
		workflowStep.setFailNextStep(new WorkflowStep(rs.getInt("Workflow_Step.fail_next_step"),rs.getString("failnextsteptasktype.label")));
		workflowStep.setDescription(rs.getString("Workflow_Step.description"));
		workflowStep.setEmailTemplate(new EmailTemplate(rs.getInt("Worflow_Step.email_template_id"),rs.getString("emailtemplateid.subject")));
		workflowStep.setAssignmentGroup(new Group(rs.getInt("Workflow_Step.assignment_group_id"),rs.getString("assignmentgroupid.user_group_nme")));
		workflowStep.setInstructions(rs.getString("Workflow_Step.instructions"));
		workflowStep.setNewStatus(new Status(rs.getInt("Workflow_Step.new_status"),rs.getString("newstatus.label")));
		workflowStep.setTaskType(new TaskType(rs.getInt("Workflow_Step.task_type"),rs.getString("tasktypeid.label")));
				
		return workflowStep;
	}
}
