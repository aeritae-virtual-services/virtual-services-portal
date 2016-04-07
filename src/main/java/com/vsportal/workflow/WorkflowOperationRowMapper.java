package com.vsportal.workflow;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class WorkflowOperationRowMapper<T> implements RowMapper<WorkflowOperation> {
	public WorkflowOperation mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkflowOperation workflowOperation = new WorkflowOperation();
		workflowOperation.setId(rs.getInt("Workflow_Operation.id"));
		workflowOperation.setCreated(rs.getDate("Workflow_Operation.created"));
		User cb = new User(rs.getInt("Workflow_Operation.created_by"), rs.getString("createdby.full_name"));
		workflowOperation.setCreatedBy(cb);
		workflowOperation.setUpdated(rs.getDate("Workflow_Operation.updated"));
		User ub = new User(rs.getInt("Workflow_Operation.updated_by"), rs.getString("updatedby.full_name"));
		workflowOperation.setUpdatedBy(ub);
		workflowOperation.setOperationName(rs.getString("Workflow_Operation.operation_nme"));
		workflowOperation.setDescription(rs.getString("Workflow_Operation.Description"));
		return workflowOperation;
	}
}
