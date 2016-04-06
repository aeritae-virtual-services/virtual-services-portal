package com.vsportal.metric;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.metric.Metric;
import com.vsportal.metric.MetricRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class MetricDAO extends JdbcDaoSupport {
	//Create Metric
		public Metric insert(final Metric metric, final User sessionUser) {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			final String sql = "INSERT INTO Metric (created_by, updated_by, "
					+ "type,"
					+ "type_id,"
					+ "start,"
					+ "end,"
					+ "duration,"
					+ "status)"
						+ "VALUES(?,?,"
						+ "?,?,?,?,?,?)";
			
			getJdbcTemplate().update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
							ps.setInt(1, sessionUser.getId());
							ps.setInt(2, sessionUser.getId());
							ps.setString(3, metric.getType());
							ps.setInt(4, metric.getTypeid());
							ps.setDate(5, metric.getStart());
							ps.setDate(6, metric.getEnd());
							ps.setInt(7, metric.getDuration());
							ps.setInt(8, metric.getStatus().getId());
							return ps;
						}
					}, keyHolder);		
			return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
		}
		
		//Update Metric
		public Metric update(Metric metric, User sessionUser) {
			//Set Update Date to Now
			java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
			//set Updated missing from now
			metric.setUpdated(now);
			
			String sql = "UPDATE Metric SET"
					+ "updated = ?, "
					+ "updated_by = ?, "
					+ "type = ?, "
					+ "type_id = ?, "
					+ "start = ?, "
					+ "end = ?, "
					+ "duration = ?, "
					+ "status = ?"
					+ "WHERE id = ?";
			
			getJdbcTemplate().update(sql, new Object[]{
				metric.getUpdated(),
				sessionUser.getId(),
				metric.getType(),
				metric.getTypeid(),
				metric.getStart(),
				metric.getEnd(),
				metric.getDuration(),
				metric.getStatus().getId(),
				metric.getId()
			});
			return metric;
		}
		//get Metric
		public Metric recordQuery(String query, String columns) {
			QueryHelper qh = new QueryHelper();
			String sql = "SELECT";
			
			//Ensure columns are selected, if none are specified, automatically select all columns
			if(columns.isEmpty() || columns.equals(null)) {
				columns = "*";
			}
			
			if(columns == "*") {
				//If * add all columns for: Metric
				sql += " Metric.*,";
			} else {
				String[] columnArr = columns.split(",");
				for(int i = 0; i < columnArr.length; i++) {
					//Add only selected for table: Metric
					sql += " Metric." + columnArr[i] + ",";
				}
			}
			
			String sqlJoin = "";
			
			//Created By
			if(columns.equals("*") || columns.contains("created_by")) {
				sql += " createdby.full_name,";
				//Merge User and: Metric
				sqlJoin += " LEFT JOIN User As createdby ON Metric.created_by = createdby.id";
			}
			//Updated By
			if(columns.equals("*") || columns.contains("updated_by")) {
				sql += " updatedby.full_name,";
				//Merge User and: Metric
				sqlJoin += " LEFT JOIN User As updatedby ON Metric.updated_by = updatedby.id";
			}
			//Status
			if(columns.equals("*") || columns.contains("status")) {
				sql += " statusid.label,";
				//Merge Status and: Metric
				sqlJoin += " LEFT JOIN Status As statusid ON Metric.status = statusid.id";
			}
			
			//If last character is a comma, remove it
			if(sql.endsWith(",")) {
				sql = sql.substring(0, sql.length() - 1);
			}
			
			//Add Generated Join Clauses to SQL Statement: Metric
			sql += " FROM Metric" + sqlJoin;
			
			//Add Where Clause if necessary
			if(query != "") {
				sql += " WHERE " + qh.toSQLQuery(query);
			}
			
			//Limit return results to 0 or 1 record
			sql += " LIMIT 0,1";
			
			//Execute query
			Metric metric = getJdbcTemplate().queryForObject(sql, new Object[]{}, new MetricRowMapper<Metric>());
			
			return metric;
		}
		
		//Get Metric List
		public ArrayList<Metric> listQuery(String query, String columns) {
			QueryHelper qh = new QueryHelper();
			String sql = "SELECT";
			
			//Ensure columns are selected, if none are specified, automatically select all columns
			if(columns.isEmpty() || columns.equals(null)) {
				columns = "*";
			}
			
			if(columns == "*") {
				sql += " Metric.*,";
			} else {
				String[] columnArr = columns.split(",");
				for(int i = 0; i < columnArr.length; i++) {
					sql += " Metric." + columnArr[i] + ",";
				}
			}
			
			String sqlJoin = "";
			
			//Created By
			if(columns.equals("*") || columns.contains("created_by")) {
				sql += " createdby.full_name,";
				//Merge User and: Metric
				sqlJoin += " LEFT JOIN User As createdby ON Metric.created_by = createdby.id";
			}
			//Updated By
			if(columns.equals("*") || columns.contains("updated_by")) {
				sql += " updatedby.full_name,";
				//Merge User and: Metric
				sqlJoin += " LEFT JOIN User As updatedby ON Metric.updated_by = updatedby.id";
			}
			//Status
			if(columns.equals("*") || columns.contains("status")) {
				sql += " statusid.label,";
				//Merge Status and: Metric
				sqlJoin += " LEFT JOIN Status As statusid ON Metric.status = statusid.id";
			}
					
			//If last character is a comma, remove it
			if(sql.endsWith(",")) {
				sql = sql.substring(0, sql.length() - 1);
			}
			
			//Add Generated Join Clauses to SQL Statement
			sql += " FROM Metric" + sqlJoin;
			
			//Add Where Clause if necessary
			if(query != "") {
				sql += " WHERE " + qh.toSQLQuery(query);
			}
			
			//Execute query
			ArrayList<Metric> metricList = (ArrayList<Metric>)getJdbcTemplate().query(sql,new Object[]{}, new MetricRowMapper<Metric>());
			
			return metricList;
		}
	}