package com.vsportal.watch_list;

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

public class WatchListDAO extends JdbcDaoSupport {
	//Create WatchList
	public WatchList insert(final WatchList watchList, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO WatchList (created_by, updated_by, "
				+ "request_id, email_address)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, watchList.getRequest().getId());
						ps.setString(4, watchList.getEmail());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update WatchList
	public WatchList update(WatchList watchList, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		watchList.setUpdated(now);
		
		String sql = "UPDATE WatchList SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "request_id = ?, "
				+ "email_address = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			watchList.getUpdated(),
			sessionUser.getId(),
			watchList.getRequest().getId(),
			watchList.getEmail(),
			watchList.getId()
		});
		return watchList;
	}
	//get WatchList
	public WatchList recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: WatchList
			sql += " WatchList.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: WatchList
				sql += " WatchList." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: WatchList
			sqlJoin += " LEFT JOIN User As createdby ON WatchList.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: WatchList
			sqlJoin += " LEFT JOIN User As updatedby ON WatchList.updated_by = updatedby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: WatchList
			sqlJoin += " LEFT JOIN Request As requestid ON WatchList.request_id = requestid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: WatchList
		sql += " FROM WatchList" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		WatchList watchList = getJdbcTemplate().queryForObject(sql, new Object[]{}, new WatchListRowMapper<WatchList>());
		
		return watchList;
	}
	
	//Get WatchList List
	public ArrayList<WatchList> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " WatchList.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " WatchList." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: WatchList
			sqlJoin += " LEFT JOIN User As createdby ON WatchList.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: WatchList
			sqlJoin += " LEFT JOIN User As updatedby ON WatchList.updated_by = updatedby.id";
		}
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			//Merge Request and: WatchList
			sqlJoin += " LEFT JOIN Request As requestid ON WatchList.request_id = requestid.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM WatchList" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<WatchList> watchListList = (ArrayList<WatchList>)getJdbcTemplate().query(sql,new Object[]{}, new WatchListRowMapper<WatchList>());
		
		return watchListList;
	}
}
