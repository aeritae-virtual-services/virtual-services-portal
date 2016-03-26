package com.vsportal.email;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class EmailTemplateRowMapper<T> implements RowMapper<EmailTemplate> {
	public EmailTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setId(rs.getInt("EmailTemplate.id"));
		emailTemplate.setCreated(rs.getDate("EmailTemplate.created"));
		User cb = new User(rs.getInt("EmailTemplate.created_by"), rs.getString("createdby.full_name"));
		emailTemplate.setCreatedBy(cb);
		emailTemplate.setUpdated(rs.getDate("EmailTemplate.updated"));
		User ub = new User(rs.getInt("EmailTemplate.updated_by"), rs.getString("updatedby.full_name"));
		emailTemplate.setUpdatedBy(ub);
		emailTemplate.setTo(rs.getString("EmailTemplate.email_to"));
		emailTemplate.setSubject(rs.getString("EmailTemplate.email_subject"));
		emailTemplate.setBody(rs.getString("EmailTemplate.email_body"));
		return emailTemplate;
	}
}
