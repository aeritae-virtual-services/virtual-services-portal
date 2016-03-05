package com.vsportal.approval;

import java.util.ArrayList;

import com.vsportal.utils.QueryHelper;

public class ApprovalDAO {
	//Create Approval
	public int insert(Approval approval) {
		int providedId = -1;
		
		
		
		return providedId;
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
