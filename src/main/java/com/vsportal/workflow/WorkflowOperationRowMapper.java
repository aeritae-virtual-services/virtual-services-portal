package com.vsportal.workflow;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class WorkflowOperationRowMapper<T> implements RowMapper<WorkflowOperation> {
	public WorkflowOperation mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkflowOperation workflowOperation = new WorkflowOperation();
		workflowOperation.setId(rs.getInt("WorkflowOperation.id"));
		workflowOperation.setCreated(rs.getDate("WorkflowOperation.created"));
		User cb = new User(rs.getInt("WorkflowOperation.created_by"), rs.getString("createdby.full_name"));
		workflowOperation.setCreatedBy(cb);
		workflowOperation.setUpdated(rs.getDate("WorkflowOperation.updated"));
		User ub = new User(rs.getInt("WorkflowOperation.updated_by"), rs.getString("updatedby.full_name"));
		workflowOperation.setUpdatedBy(ub);
		workflowOperation.setOperationName(rs.getString("WorkflowOperation.operation_nme"));
		workflowOperation.setDescription(rs.getString("WorkflowOperation.Description"));
		return workflowOperation;
	}
}
