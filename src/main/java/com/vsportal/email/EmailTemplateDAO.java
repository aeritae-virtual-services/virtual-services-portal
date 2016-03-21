package com.vsportal.email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

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
}
