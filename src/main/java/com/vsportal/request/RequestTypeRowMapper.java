package com.vsportal.request;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.workflow.WorkflowStep;

public class RequestTypeRowMapper<T> implements RowMapper<RequestType> {
	public RequestType mapRow(ResultSet rs, int rowNum) throws SQLException {
		RequestType requestType = new RequestType();
		requestType.setId(rs.getInt("RequestType.id"));
		requestType.setCreated(rs.getDate("RequestType.created"));
		User cb = new User(rs.getInt("RequestType.created_by"), rs.getString("createdby.full_name"));
		requestType.setCreatedBy(cb);
		requestType.setUpdated(rs.getDate("RequestType.updated"));
		User ub = new User(rs.getInt("RequestType.updated_by"), rs.getString("updatedby.full_name"));
		requestType.setUpdatedBy(ub);
		requestType.setName(rs.getString("RequestType.req_type_nme"));
		requestType.setDescription(rs.getString("RequestType.description"));
		WorkflowStep workflowStep = new WorkflowStep(rs.getInt("RequestType.first_workflow_step"),rs.getString("tasktypeid.label"));
		requestType.setFirstStep(workflowStep);
		return requestType;
	}
}
