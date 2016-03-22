package com.vsportal.approval;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.client.ClientDAO;
import com.vsportal.request.RequestDAO;
import com.vsportal.user.User;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.QueryHelper;

public class ApprovalDAO extends JdbcDaoSupport {
	
	//Create Approval
	public Approval insert(final Approval approval, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Approval (created_by, updated_by, client_id, decision_by,"
				+ "decision_date, request_id, description, decision, approval_type)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, approval.getClient().getId());
						ps.setInt(4, approval.getDecisionBy().getId());
						ps.setDate(5, approval.getDecisionDate());
						ps.setInt(6, approval.getRequest().getId());
						ps.setString(7, approval.getDescription());
						ps.setString(8, approval.getDecision());
						ps.setString(9, approval.getApprovalType());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Approval
	public Approval update(Approval approval, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		approval.setUpdated(now);
		
		String sql = "UPDATE Approval SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "client_id = ?, "
				+ "decision_by = ?, "
				+ "decision_date = ?, "
				+ "request_id = ?, "
				+ "description = ?, "
				+ "decision = ?,"
				+ "approval_type = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			approval.getUpdated(),
			sessionUser.getId(),
			approval.getClient().getId(),
			approval.getDecisionBy().getId(),
			approval.getDecisionDate(),
			approval.getRequest().getId(),
			approval.getDescription(),
			approval.getDecision(),
			approval.getApprovalType(),
			approval.getId()
		});
		
		return approval;
	}
	
	//Get Approval Record
	public Approval recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Approval.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Approval." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			sqlJoin += " LEFT JOIN User As createdby ON Approval.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			sqlJoin += " INNER JOIN User As updatedby ON Approval.updated_by = updatedby.id";
		}
		//Decision By
		if(columns.equals("*") || columns.contains("decision_by")) {
			sql += " decisionby.full_name,";
			sqlJoin += " INNER JOIN User As decisionby ON Approval.decision_by = decisionby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.name,";
			sqlJoin += " INNER JOIN Client As clientid ON Approval.clientid = Client.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			sqlJoin += " INNER JOIN Request As requestid ON Approval.request_id = requestid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		sql += " FROM Approval" + sqlJoin;
		
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		sql += " LIMIT 0,1";
		
		Approval approval = getJdbcTemplate().queryForObject(sql, new Object[]{}, new ApprovalRowMapper<Approval>());
		
		return approval;
	}
	
	
	//Get Approval List
	public ArrayList<Approval> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Approval.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Approval." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			sqlJoin += " LEFT JOIN User As createdby ON Approval.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			sqlJoin += " INNER JOIN User As updatedby ON Approval.updated_by = updatedby.id";
		}
		//Decision By
		if(columns.equals("*") || columns.contains("decision_by")) {
			sql += " decisionby.full_name,";
			sqlJoin += " INNER JOIN User As decisionby ON Approval.decision_by = decisionby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.name,";
			sqlJoin += " INNER JOIN Client As clientid ON Approval.clientid = Client.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			sqlJoin += " INNER JOIN Request As requestid ON Approval.request_id = requestid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		sql += " FROM Approval" + sqlJoin;
		
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		ArrayList<Approval> approvalList = (ArrayList<Approval>)getJdbcTemplate().query(sql,new Object[]{}, new ApprovalRowMapper<Approval>());
		
		return approvalList;
	}
}
