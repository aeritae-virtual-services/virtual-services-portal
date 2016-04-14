package com.vsportal.comment;

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

public class CommentDAO extends JdbcDaoSupport{
	//Create Comment
	public Comment insert(final Comment comment, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Tier (created_by, updated_by, "
				+ "request, comment, public)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, comment.getRequest().getId());
						ps.setString(4, comment.getComment());
						ps.setBoolean(5, comment.isPublic());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Comment
	public Comment update(Comment comment, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		comment.setUpdated(now);
		
		String sql = "UPDATE EmailTemplate SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "request = ?, "
				+ "comment = ?, "
				+ "public = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			comment.getUpdated(),
			sessionUser.getId(),
			comment.getRequest().getId(),
			comment.getComment(),
			comment.isPublic(),
			comment.getId()
		});
		return comment;
	}
	//Get Comment Record
	public Comment recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Comment
			sql += " Comment.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Comment
				sql += " Comment." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Comment
			sqlJoin += " LEFT JOIN User As createdby ON Comment.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Comment
			sqlJoin += " LEFT JOIN User As updatedby ON Comment.updated_by = updatedby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			sqlJoin += " LEFT JOIN Request As requestid ON Comment.request_id = requestid.id";
		}
		
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Comment
		sql += " FROM Comment" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Comment comment = getJdbcTemplate().queryForObject(sql, new Object[]{}, new CommentRowMapper<Comment>());
		
		return comment;
	}
	
	//Get Comment List
	public ArrayList<Comment> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Comment.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Comment." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Comment
			sqlJoin += " LEFT JOIN User As createdby ON Comment.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Comment
			sqlJoin += " LEFT JOIN User As updatedby ON Comment.updated_by = updatedby.id";
		}
		//Request
		if(columns.equals("*") || columns.contains("request_id")) {
			sql += " requestid.req_nbr,";
			sqlJoin += " LEFT JOIN Request As requestid ON Comment.request_id = requestid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Comment" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Comment> commentList = (ArrayList<Comment>)getJdbcTemplate().query(sql,new Object[]{}, new CommentRowMapper<Comment>());
		
		return commentList;
	}
}
