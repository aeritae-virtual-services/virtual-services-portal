package com.vsportal.status;

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

public class StatusDAO extends JdbcDaoSupport{
	//Create Status
	public Status insert(final Status status, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Status (created_by, updated_by, "
				+ "label, status_value, table)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, status.getLabel());
						ps.setInt(4, status.getValue());
						//Table missing from status object, used type
						ps.setString(5, status.getTable());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Status
	public Status update(Status status, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		status.setUpdated(now);
		
		String sql = "UPDATE Status SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "label = ?, "
				+ "status_value = ?, "
				+ "table = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			status.getUpdated(),
			sessionUser.getId(),
			status.getLabel(),
			status.getValue(),
			//Table missing from status, used type instead
			status.getTable(),
			status.getId()
		});
		return status;
	}

	//get Status
	public Status recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Status
			sql += " Status.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Status
				sql += " Status." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Status
			sqlJoin += " LEFT JOIN User As createdby ON Status.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Status
			sqlJoin += " LEFT JOIN User As updatedby ON Status.updated_by = updatedby.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Status
		sql += " FROM Status" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Status status = getJdbcTemplate().queryForObject(sql, new Object[]{}, new StatusRowMapper<Status>());
		
		return status;
	}
	
	//Get Status List
	public ArrayList<Status> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Status.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Status." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Status
			sqlJoin += " LEFT JOIN User As createdby ON Status.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Status
			sqlJoin += " LEFT JOIN User As updatedby ON Status.updated_by = updatedby.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Status" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Status> statusList = (ArrayList<Status>)getJdbcTemplate().query(sql,new Object[]{}, new StatusRowMapper<Status>());
		
		return statusList;
	}
}