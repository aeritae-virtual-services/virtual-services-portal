package com.vsportal.availability;

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

public class AvailabilityDAO extends JdbcDaoSupport {
	//Create Availability
	public Availability insert(final Availability availability, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Availability (created_by, updated_by, "
				+ "analyst_id, start, end)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, availability.getAnalyst().getId());
						ps.setDate(4, availability.getStart());
						ps.setDate(5, availability.getEnd());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Availability
	public Availability update(Availability availability, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		availability.setUpdated(now);
		
		String sql = "UPDATE Availability SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "analyst_id = ?, "
				+ "start = ?, "
				+ "end = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			availability.getUpdated(),
			sessionUser.getId(),
			availability.getAnalyst().getId(),
			availability.getStart(),
			availability.getEnd(),
			availability.getId()
		});
		
		return availability;
	}
	
	//get Availability Record
	public Availability recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Availability
			sql += " Availability.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Availability
				sql += " Availability." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Availability
			sqlJoin += " LEFT JOIN User As createdby ON Availability.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Availability
			sqlJoin += " LEFT JOIN User As updatedby ON Availability.updated_by = updatedby.id";
		}
		//Analyst
		if(columns.equals("*") || columns.contains("analyst_id")) {
			sql += " analystid.full_name,";
			sqlJoin += " LEFT JOIN User As analyst ON Availability.analyst_id = analystid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Availability
		sql += " FROM Availability" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Availability availability = getJdbcTemplate().queryForObject(sql, new Object[]{}, new AvailabilityRowMapper<Availability>());
		
		return availability;
	}
	//Get Availability List
	public ArrayList<Availability> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Availability.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Availability." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Availability
			sqlJoin += " LEFT JOIN User As createdby ON Availability.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Availability
			sqlJoin += " LEFT JOIN User As updatedby ON Availability.updated_by = updatedby.id";
		}
		//Analyst
		if(columns.equals("*") || columns.contains("analyst_id")) {
			sql += " analystid.full_name,";
			sqlJoin += " LEFT JOIN User As analyst ON Availability.analyst_id = analystid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Availability" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Availability> availabilityList = (ArrayList<Availability>)getJdbcTemplate().query(sql,new Object[]{}, new AvailabilityRowMapper<Availability>());
		
		return availabilityList;
	}
}
