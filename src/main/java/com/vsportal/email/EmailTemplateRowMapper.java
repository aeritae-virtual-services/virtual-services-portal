package com.vsportal.email;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class EmailTemplateRowMapper<T> implements RowMapper<EmailTemplate> {
	public EmailTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setId(rs.getInt("Email_Template.id"));
		emailTemplate.setCreated(rs.getDate("Email_Template.created"));
		User cb = new User(rs.getInt("Email_Template.created_by"), rs.getString("createdby.full_name"));
		emailTemplate.setCreatedBy(cb);
		emailTemplate.setUpdated(rs.getDate("Email_Template.updated"));
		User ub = new User(rs.getInt("Email_Template.updated_by"), rs.getString("updatedby.full_name"));
		emailTemplate.setUpdatedBy(ub);
		emailTemplate.setTo(rs.getString("Email_Template.email_to"));
		emailTemplate.setSubject(rs.getString("Email_Template.email_subject"));
		emailTemplate.setBody(rs.getString("Email_Template.email_body"));
		return emailTemplate;
	}
}
