package com.vsportal.priority;

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

public class PriorityDAO extends JdbcDaoSupport {
	//Create Priority
	public Priority insert(final Priority priority, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Priority (created_by, updated_by, "
				+ "label, priority_value, table_name)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, priority.getLabel());
						ps.setInt(4, priority.getValue());
						//Table missing from priority object
						ps.setString(5, priority.getTable());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Priority
	public Priority update(Priority priority, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		priority.setUpdated(now);
		
		String sql = "UPDATE Priority SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "label = ?, "
				+ "priority_value = ?, "
				+ "table_nme = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			priority.getUpdated(),
			sessionUser.getId(),
			priority.getLabel(),
			priority.getValue(),
			//Table missing from priority object
			priority.getTable(),
			priority.getId()
		});
		return priority;
	}
	//get Priority
	public Priority recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Priority
			sql += " Priority.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Priority
				sql += " Priority." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Priority
			sqlJoin += " LEFT JOIN User As createdby ON Priority.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Priority
			sqlJoin += " LEFT JOIN User As updatedby ON Priority.updated_by = updatedby.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Priority
		sql += " FROM Priority" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Priority priority = getJdbcTemplate().queryForObject(sql, new Object[]{}, new PriorityRowMapper<Priority>());
		
		return priority;
	}
	
	//Get Priority List
	public ArrayList<Priority> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Priority.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Priority." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Priority
			sqlJoin += " LEFT JOIN User As createdby ON Priority.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Priority
			sqlJoin += " LEFT JOIN User As updatedby ON Priority.updated_by = updatedby.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Priority" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Priority> priorityList = (ArrayList<Priority>)getJdbcTemplate().query(sql,new Object[]{}, new PriorityRowMapper<Priority>());
		
		return priorityList;
	}
}
