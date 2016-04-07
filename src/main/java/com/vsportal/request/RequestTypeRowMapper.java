package com.vsportal.request;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.workflow.WorkflowStep;

public class RequestTypeRowMapper<T> implements RowMapper<RequestType> {
	public RequestType mapRow(ResultSet rs, int rowNum) throws SQLException {
		RequestType requestType = new RequestType();
		requestType.setId(rs.getInt("Request_Type.id"));
		requestType.setCreated(rs.getDate("Request_Type.created"));
		User cb = new User(rs.getInt("Request_Type.created_by"), rs.getString("createdby.full_name"));
		requestType.setCreatedBy(cb);
		requestType.setUpdated(rs.getDate("Request_Type.updated"));
		User ub = new User(rs.getInt("Request_Type.updated_by"), rs.getString("updatedby.full_name"));
		requestType.setUpdatedBy(ub);
		requestType.setName(rs.getString("Request_Type.req_type_nme"));
		requestType.setDescription(rs.getString("Request_Type.description"));
		WorkflowStep workflowStep = new WorkflowStep(rs.getInt("Request_Type.first_workflow_step"),rs.getString("tasktypeid.label"));
		requestType.setFirstWorkflowStep(workflowStep);
		return requestType;
	}
}
