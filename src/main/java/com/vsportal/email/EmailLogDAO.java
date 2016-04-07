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

import com.vsportal.contract.Contract;
import com.vsportal.contract.ContractRowMapper;
import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class EmailLogDAO extends JdbcDaoSupport{
	//Create EmalLog
	public EmailLog insert(final EmailLog emailLog, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Email_Log (created_by, updated_by, "
				+ "email_recipient, email_from, email_direction, email_subject, email_body, email_template_id"
				+ "email_table, table_record_id, status, client)"
				+ "VALUES(?,?,?,?"
				+ ",?,?,?,?"
				+ ",?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, emailLog.getRecipient());
						ps.setString(4, emailLog.getFrom());
						ps.setString(5, emailLog.getRecipient());
						ps.setString(6, emailLog.getSubject());
						ps.setString(7, emailLog.getSubject());
						ps.setInt(8, emailLog.getTemplate().getId());
						ps.setString(9, emailLog.getTable());
						ps.setInt(10, emailLog.getTableRecordId());
						ps.setInt(11, emailLog.getStatus().getId());
						//getClient missing
						ps.setInt(12, emailLog.getClient().getId());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update EmailLog
	public EmailLog update(EmailLog emailLog, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		emailLog.setUpdated(now);
		
		String sql = "UPDATE Email_Log SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "email_recipient = ?, "
				+ "email_from = ?, "
				+ "email_direction = ?, "
				+ "email_subject = ?, "
				+ "email_body = ?, "
				+ "email_template_id = ?, "
				+ "email_table = ?, "
				+ "table_record_id = ?, "
				+ "status = ?, "
				+ "client = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			emailLog.getUpdated(),
			sessionUser.getId(),
			emailLog.getRecipient(),
			emailLog.getFrom(),
			emailLog.getDirection(),
			emailLog.getSubject(),
			emailLog.getBody(),
			emailLog.getTemplate().getId(),
			emailLog.getTable(),
			emailLog.getTableId(),
			emailLog.getStatus().getId(),
			emailLog.getClient().getId(),
			emailLog.getId()
		});
		return emailLog;
	}
	//Get EmailLog Record
	public EmailLog recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: EmailLog
			sql += " Email_Log.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Email_Log
				sql += " Email_Log." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: EmailLog
			sqlJoin += " LEFT JOIN User As createdby ON Email_Log.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: EmailLog
			sqlJoin += " LEFT JOIN User As updatedby ON Email_Log.updated_by = updatedby.id";
		}
		//EmailTemplate
		if(columns.equals("*") || columns.contains("email_template_id")) {
			sql += " emailtemplateid.email_subject,";
			sqlJoin += " LEFT JOIN Email_Template As emailtemplateid ON Email_Log.email_template_id = emailtemplateid.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("status")) {
			sql += " statusid.label,";
			sqlJoin += " LEFT JOIN Status As statusid ON Email_Log.status = statusid.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client")) {
			sql += " clientid.client_nme,";
			sqlJoin += " LEFT JOIN Client As clientid ON Email_Log.client = clientid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: EmailLog
		sql += " FROM Email_Log" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		EmailLog emailLog = getJdbcTemplate().queryForObject(sql, new Object[]{}, new EmailLogRowMapper<EmailLog>());
		
		return emailLog;
	}
	
	//Get EmailLog List
	public ArrayList<EmailLog> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " EmailLog.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " EmailLog." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
					sql += " createdby.full_name,";
					//Merge User and: EmailLog
					sqlJoin += " LEFT JOIN User As createdby ON Email_Log.created_by = createdby.id";
				}
				//Updated By
				if(columns.equals("*") || columns.contains("updated_by")) {
					sql += " updatedby.full_name,";
					//Merge User and: EmailLog
					sqlJoin += " LEFT JOIN User As updatedby ON Email_Log.updated_by = updatedby.id";
				}
				//EmailTemplate
				if(columns.equals("*") || columns.contains("email_template_id")) {
					sql += " emailtemplateid.email_subject,";
					sqlJoin += " LEFT JOIN Email_Template As emailtemplateid ON Email_Log.email_template_id = emailtemplateid.id";
				}
				//Status
				if(columns.equals("*") || columns.contains("status")) {
					sql += " statusid.label,";
					sqlJoin += " LEFT JOIN Status As statusid ON Email_Log.status = statusid.id";
				}
				//Client
				if(columns.equals("*") || columns.contains("client")) {
					sql += " clientid.client_nme,";
					sqlJoin += " LEFT JOIN Client As clientid ON Email_Log.client = clientid.id";
				}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM EmailLog" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<EmailLog> emailLogList = (ArrayList<EmailLog>)getJdbcTemplate().query(sql,new Object[]{}, new EmailLogRowMapper<EmailLog>());
		
		return emailLogList;
	}
}
