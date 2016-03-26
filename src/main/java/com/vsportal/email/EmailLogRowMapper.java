package com.vsportal.email;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.email.EmailTemplate;
import com.vsportal.status.Status;
import com.vsportal.client.Client;

public class EmailLogRowMapper<T> implements RowMapper<EmailLog> {
	public EmailLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmailLog emailLog = new EmailLog();
		emailLog.setId(rs.getInt("EmailLog.id"));
		emailLog.setCreated(rs.getDate("EmailLog.created"));
		User cb = new User(rs.getInt("EmailLog.created_by"), rs.getString("createdby.full_name"));
		emailLog.setCreatedBy(cb);
		emailLog.setUpdated(rs.getDate("EmailLog.updated"));
		User ub = new User(rs.getInt("EmailLog.updated_by"), rs.getString("updatedby.full_name"));
		emailLog.setUpdatedBy(ub);
		emailLog.setRecipient(rs.getString("EmailLog.email_recipient"));
		emailLog.setFrom(rs.getString("EmailLog.email_from"));
		emailLog.setDirection(rs.getString("EmailLog.email_direction"));
		emailLog.setSubject(rs.getString("EmailLog.email_subject"));
		emailLog.setBody(rs.getString("EmailLog.email_body"));
		EmailTemplate emailTemplate = new EmailTemplate(rs.getInt("EmailLog.email_template_id"),rs.getString("emailtemplateid.email_subject"));
		emailLog.setTemplate(emailTemplate);
		emailLog.setTable(rs.getString("EmailLog.email_table"));
		emailLog.setTableId(rs.getInt("EmailLog.table_record_id"));
		Status status = new Status(rs.getInt("EmailLog.status"),rs.getString("statusid.label"));
		emailLog.setStatus(status);
		Client client = new Client(rs.getInt("EmailLog.client"),rs.getString("clientid.client_nme"));
		emailLog.setClient(client);
		return emailLog;
	}
}