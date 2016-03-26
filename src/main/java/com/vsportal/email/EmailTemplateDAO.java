package com.vsportal.email;

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

public class EmailTemplateDAO extends JdbcDaoSupport{
	//Create EmailTemplate
	public EmailTemplate insert(final EmailTemplate emailTemplate, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO EmailTemplate (created_by, updated_by, "
				+ "email_to, email_subject, email_body)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, emailTemplate.getTo());
						ps.setString(4, emailTemplate.getSubject());
						ps.setString(5, emailTemplate.getBody());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update EmailTemplate
	public EmailTemplate update(EmailTemplate emailTemplate, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		emailTemplate.setUpdated(now);
		
		String sql = "UPDATE EmailTemplate SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "email_to = ?, "
				+ "email_subject = ?, "
				+ "email_body = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			emailTemplate.getUpdated(),
			sessionUser.getId(),
			emailTemplate.getTo(),
			emailTemplate.getSubject(),
			emailTemplate.getBody(),
			emailTemplate.getId()
		});
		return emailTemplate;
	}
	public EmailTemplate recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: EmailTemplate
			sql += " EmailTemplate.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: EmailTemplate
				sql += " EmailTemplate." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: EmailTemplate
			sqlJoin += " LEFT JOIN User As createdby ON EmailTemplate.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: EmailTemplate
			sqlJoin += " LEFT JOIN User As updatedby ON EmailTemplate.updated_by = updatedby.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: EmailTemplate
		sql += " FROM EmailTemplate" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		EmailTemplate emailTemplate = getJdbcTemplate().queryForObject(sql, new Object[]{}, new EmailTemplateRowMapper<EmailTemplate>());
		
		return emailTemplate;
	}
	
	//Get EmailTemplate List
	public ArrayList<EmailTemplate> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " EmailTemplate.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " EmailTemplate." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: EmailTemplate
			sqlJoin += " LEFT JOIN User As createdby ON EmailTemplate.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: EmailTemplate
			sqlJoin += " LEFT JOIN User As updatedby ON EmailTemplate.updated_by = updatedby.id";
		}
				
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM EmailTemplate" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<EmailTemplate> emailTemplateList = (ArrayList<EmailTemplate>)getJdbcTemplate().query(sql,new Object[]{}, new EmailTemplateRowMapper<EmailTemplate>());
		
		return emailTemplateList;
	}
}