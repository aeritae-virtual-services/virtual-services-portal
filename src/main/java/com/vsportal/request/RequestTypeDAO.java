package com.vsportal.request;

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

public class RequestTypeDAO extends JdbcDaoSupport{

	//Create RequestType
	public RequestType insert(final RequestType requestType, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Request_Type (created_by, updated_by, "
				+ "req_type_nme, description, first_workflow_step"
				+ ")"
				+ "VALUES(?,?,"
				+ "?,?,?"
				+ ")";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, requestType.getName());
						ps.setString(4, requestType.getDescription());
						ps.setInt(5, requestType.getFirstWorkflowStep().getID());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update RequestType
	public RequestType update(RequestType requestType, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		requestType.setUpdated(now);
		
		String sql = "UPDATE Request_Type SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "req_type_nme = ?,"
				+ "description = ?,"
				+ "first_workflow_step = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			requestType.getUpdated(),
			sessionUser.getId(),
			requestType.getName(),
			requestType.getDescription(),
			requestType.getFirstWorkflowStep().getID(),
			requestType.getId()
		});
		
		return requestType;
	}
	//get RequestType
	public RequestType recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: RequestType
			sql += " Request_Type.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: RequestType
				sql += " Request_Type." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN User As createdby ON Request_Type.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN User As updatedby ON Request_Type.updated_by = updatedby.id";
		}
		//First Workflow Step
		if(columns.equals("*") || columns.contains("first_workflow_step")) {
			sql += " tasktypeid.label,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN Workflow_Step As firstworkflowstep ON Request_Type.first_workflow_step = firstworkflowstep.id";
			//Merge Workflow Step and TaskType
			sqlJoin += " LEFT JOIN Task_Type As tasktypeid ON firstworkflowstep.task_type = tasktypeid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: RequestType
		sql += " FROM RequestType" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		RequestType requestType = getJdbcTemplate().queryForObject(sql, new Object[]{}, new RequestTypeRowMapper<RequestType>());
		
		return requestType;
	}
	
	//Get RequestType List
	public ArrayList<RequestType> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Request_Type.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Request_Type." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN User As createdby ON Request_Type.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN User As updatedby ON Request_Type.updated_by = updatedby.id";
		}
		//First Workflow Step
		if(columns.equals("*") || columns.contains("first_workflow_step")) {
			sql += " tasktypeid.label,";
			//Merge User and: RequestType
			sqlJoin += " LEFT JOIN Workflow_Step As firstworkflowstep ON Request_Type.first_workflow_step = firstworkflowstep.id";
			//Merge Workflow Step and TaskType
			sqlJoin += " LEFT JOIN Task_Type As tasktypeid ON firstworkflowstep.task_type = tasktypeid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Request_Type" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<RequestType> requestTypeList = (ArrayList<RequestType>)getJdbcTemplate().query(sql,new Object[]{}, new RequestTypeRowMapper<RequestType>());
		
		return requestTypeList;
	}
}
