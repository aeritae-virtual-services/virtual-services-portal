package com.vsportal.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class WorkflowOperationDAO extends JdbcDaoSupport {
	//Create WorkflowOperation
	public WorkflowOperation insert(final WorkflowOperation workflowOperation, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Workflow_Operation (created_by, updated_by, "
				+ "operation_nme, description)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, workflowOperation.getOperationName());
						ps.setString(4, workflowOperation.getDescription());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update WorkflowOperation
	public WorkflowOperation update(WorkflowOperation workflowOperation, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		workflowOperation.setUpdated(now);
		
		String sql = "UPDATE Workflow_Operation SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "operation_nme = ?, "
				+ "description = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			workflowOperation.getUpdated(),
			sessionUser.getId(),
			workflowOperation.getOperationName(),
			workflowOperation.getDescription(),
			workflowOperation.getId()
		});
		return workflowOperation;
	}

	//get WorkflowOperation
	public WorkflowOperation recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: WorkflowOperation
			sql += " Workflow_Operation.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: WorkflowOperation
				sql += " Workflow_Operation." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: WorkflowOperation
			sqlJoin += " LEFT JOIN User As createdby ON Workflow_Operation.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: WorkflowOperation
			sqlJoin += " LEFT JOIN User As updatedby ON Workflow_Operation.updated_by = updatedby.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: WorkflowOperation
		sql += " FROM Workflow_Operation" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		WorkflowOperation workflowOperation = getJdbcTemplate().queryForObject(sql, new Object[]{}, new WorkflowOperationRowMapper<WorkflowOperation>());
		
		return workflowOperation;
	}
	
	//Get WorkflowOperation List
	public ArrayList<WorkflowOperation> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Workflow_Operation.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Workflow_Operation." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: WorkflowOperation
			sqlJoin += " LEFT JOIN User As createdby ON Workflow_Operation.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: WorkflowOperation
			sqlJoin += " LEFT JOIN User As updatedby ON Workflow_Operation.updated_by = updatedby.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Workflow_Operation" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<WorkflowOperation> workflowOperationList = (ArrayList<WorkflowOperation>)getJdbcTemplate().query(sql,new Object[]{}, new WorkflowOperationRowMapper<WorkflowOperation>());
		
		return workflowOperationList;
	}
}