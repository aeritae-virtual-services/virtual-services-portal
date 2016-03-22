package com.vsportal.approval;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.client.Client;
import com.vsportal.request.Request;
import com.vsportal.user.User;

public class ApprovalRowMapper<T> implements RowMapper<Approval> {
	public Approval mapRow(ResultSet rs, int rowNum) throws SQLException {
		Approval approval = new Approval();
		approval.setApprovalType(rs.getString("Approval.approval_type"));
		approval.setCreated(rs.getDate("Approval.created"));
		approval.setDecision(rs.getString("Approval.decision"));
		approval.setDecisionDate(rs.getDate("Approval.decision_date"));
		approval.setDescription(rs.getString("Approval.description"));
		approval.setId(rs.getInt("Approval.id"));
		approval.setUpdated(rs.getDate("Approval.updated"));
		
		Client cl = new Client(rs.getInt("client_id"), rs.getString("clientid.name"));
		approval.setClient(cl);
		
		User cb = new User(rs.getInt("created_by"), rs.getString("createdby.full_name"));
		approval.setCreatedBy(cb);
		
		User db = new User(rs.getInt("decision_by"), rs.getString("decisionby.full_name"));
		approval.setDecisionBy(db);
		
		User ub = new User(rs.getInt("updated_by"), rs.getString("updatedby.full_name"));
		approval.setUpdatedBy(ub);
		
		Request req = new Request(rs.getInt("request_id"), rs.getString("requestid.req_nbr"));
		approval.setRequest(req);
		
		return approval;
	}
}
