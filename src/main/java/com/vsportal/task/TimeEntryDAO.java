package com.vsportal.task;

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

public class TimeEntryDAO extends JdbcDaoSupport {
	//Create TimeEntry
	public TimeEntry insert(final TimeEntry timeEntry, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO TimeEntry (created_by, updated_by, "
				+ "task, request_id, hours_consumed, user_id, contract_id, client_id)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, timeEntry.getTask().getId());
						//getRequest missing from Time Entry
						ps.setInt(4, timeEntry.getRequest().getId());
						ps.setFloat(5, timeEntry.getHoursConsumed());
						ps.setInt(6, timeEntry.getUser().getId());
						ps.setInt(7, timeEntry.getContract().getId());
						ps.setInt(8, timeEntry.getClient().getId());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update TimeEntry
	public TimeEntry update(TimeEntry timeEntry, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		timeEntry.setUpdated(now);
		
		String sql = "UPDATE TimeEntry SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "task = ?, "
				+ "request_id = ?, "
				+ "hours_consumed = ?, "
				+ "user_id = ?, "
				+ "contract_id = ?, "
				+ "client_id = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			timeEntry.getUpdated(),
			sessionUser.getId(),
			timeEntry.getTask().getId(),
			//get Request missing
			timeEntry.getRequest().getId(),
			timeEntry.getHoursConsumed(),
			timeEntry.getUser().getId(),
			timeEntry.getContract().getId(),
			timeEntry.getClient().getId(),
			timeEntry.getId()
		});
		return timeEntry;
	}

	public ArrayList<TimeEntry> getListByQuery(String query) {
		ArrayList<TimeEntry> teArr = new ArrayList<TimeEntry>();
		return null;
	}
	//get TimeEntry
	public TimeEntry recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: TimeEntry
			sql += " TimeEntry.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: TimeEntry
				sql += " TimeEntry." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: TimeEntry
			sqlJoin += " LEFT JOIN User As createdby ON TimeEntry.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: TimeEntry
			sqlJoin += " LEFT JOIN User As updatedby ON TimeEntry.updated_by = updatedby.id";
		}
		//Task
		if(columns.equals("*") || columns.contains("task")) {
			sql += " taskid.task_nbr,";
			//Merge Task and: TimeEntry
			sqlJoin += " LEFT JOIN Task As taskid ON TimeEntry.task = taskby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN Request As requestid ON TimeEntry.request_id = requestid.id";
		}
		//User
		if(columns.equals("*") || columns.contains("user_id")) {
			sql += " userid.full_name,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN User As userid ON TimeEntry.user_id = userid.id";
		}
		//Contract
		if(columns.equals("*") || columns.contains("contract_id")) {
			sql += " contractclient.client_nme,";
			//Merge Contract and: Request
			sqlJoin += " LEFT JOIN Contract As contractid ON TimeEntry.contract_id = contractid.id";
			//Merge Client on contractid
			sqlJoin += " LEFT JOIN Client As contractclient ON contratid.client_id = contractclient.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN Client As clientid ON TimeEntry.client_id = clientid.id";
		}
		
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: TimeEntry
		sql += " FROM TimeEntry" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		TimeEntry timeEntry = getJdbcTemplate().queryForObject(sql, new Object[]{}, new TimeEntryRowMapper<TimeEntry>());
		
		return timeEntry;
	}
	
	//Get TimeEntry List
	public ArrayList<TimeEntry> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " TimeEntry.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " TimeEntry." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: TimeEntry
			sqlJoin += " LEFT JOIN User As createdby ON TimeEntry.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: TimeEntry
			sqlJoin += " LEFT JOIN User As updatedby ON TimeEntry.updated_by = updatedby.id";
		}
		//Task
		if(columns.equals("*") || columns.contains("task")) {
			sql += " taskid.task_nbr,";
			//Merge Task and: TimeEntry
			sqlJoin += " LEFT JOIN Task As taskid ON TimeEntry.task = taskby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN Request As requestid ON TimeEntry.request_id = requestid.id";
		}
		//User
		if(columns.equals("*") || columns.contains("user_id")) {
			sql += " userid.full_name,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN User As userid ON TimeEntry.user_id = userid.id";
		}
		//Contract
		if(columns.equals("*") || columns.contains("contract_id")) {
			sql += " contractclient.client_nme,";
			//Merge Contract and: Request
			sqlJoin += " LEFT JOIN Contract As contractid ON TimeEntry.contract_id = contractid.id";
			//Merge Client on contractid
			sqlJoin += " LEFT JOIN Client As contractclient ON contratid.client_id = contractclient.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge Request and: TimeEntry
			sqlJoin += " LEFT JOIN Client As clientid ON TimeEntry.client_id = clientid.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM TimeEntry" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<TimeEntry> timeEntryList = (ArrayList<TimeEntry>)getJdbcTemplate().query(sql,new Object[]{}, new TimeEntryRowMapper<TimeEntry>());
		
		return timeEntryList;
	}
}
