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
import com.vsportal.user.User;

public class EmailLogDAO extends JdbcDaoSupport{
	//Create EmalLog
	public EmailLog insert(final EmailLog emailLog, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO EmailLog (created_by, updated_by, "
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
						ps.setInt(10, emailLog.getTableId());
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
		
		String sql = "UPDATE EmailLog SET"
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
	
	public ArrayList<Contract> getListByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
