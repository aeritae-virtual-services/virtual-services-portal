package com.vsportal.approval;

import java.util.ArrayList;

import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class ApprovalDAO {
	//Create Approval
	public int insert(Approval approval, User sessionUser) {
		String sql = "INSERT INTO Approval (created_by, updated_by, client_id, decision_by,"
				+ "decision_date, request_id, description, decision, approval_type)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
		
		//getJdbcTemplate().update(sql,
		//		new Object[]{sessionUser.getId(), sessionUser.getId(), approval.getClient().getId(),
		//		approval.getD,user.getClient(), user.getRole()});
		
		//return providedId;
		return 0;
	}
	
	//Update Approval
	public void update(Approval approval) {
		
	}
	
	//Get Approval Record
	public Approval recordQuery(String query) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT * FROM Approval WHERE ";
		sql += qh.toSQLQuery(query);
		sql += " LIMIT 0,1";
		
		Approval approval = new Approval();
		
		
		
		return approval;
	}
	
	
	//Get Approval List
	public ArrayList<Approval> listQuery(String query) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT * FROM Approval WHERE ";
		sql += qh.toSQLQuery(query);
		
		ArrayList<Approval> approvalList = new ArrayList<Approval>();
		
		
		return approvalList;
	}
	
}
