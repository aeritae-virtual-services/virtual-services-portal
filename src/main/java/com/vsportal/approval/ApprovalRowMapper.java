package com.vsportal.approval;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.client.Client;
import com.vsportal.request.Request;
import com.vsportal.user.User;

public class ApprovalRowMapper<T> implements RowMapper<Approval> {
	public Approval mapRow(ResultSet rs, int rowNum) throws SQLException {
		Approval approval = new Approval();
		approval.setApprovalType(rs.getString("approval_type"));
		approval.setCreated(rs.getDate("created"));
		approval.setDecision(rs.getString("decision"));
		approval.setDecisionDate(rs.getDate("decision_date"));
		approval.setDescription(rs.getString("description"));
		approval.setId(rs.getInt("id"));
		approval.setUpdated(rs.getDate("updated"));
		
		Client cl = new Client();
		cl.setId(rs.getInt("client_id"));
		approval.setClient(cl);
		
		User cb = new User();
		cb.setId(rs.getInt("created_by"));
		approval.setCreatedBy(cb);
		
		User db = new User();
		db.setId(rs.getInt("decision_by"));
		approval.setDecisionBy(db);
		
		User ub = new User();
		ub.setId(rs.getInt("updated_by"));
		approval.setUpdatedBy(ub);
		
		Request req = new Request();
		req.setId(rs.getInt("request_id"));
		approval.setRequest(req);
		
		return approval;
	}
}
