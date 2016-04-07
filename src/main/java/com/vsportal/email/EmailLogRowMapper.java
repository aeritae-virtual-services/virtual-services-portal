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
		emailLog.setId(rs.getInt("Email_Log.id"));
		emailLog.setCreated(rs.getDate("Email_Log.created"));
		User cb = new User(rs.getInt("Email_Log.created_by"), rs.getString("createdby.full_name"));
		emailLog.setCreatedBy(cb);
		emailLog.setUpdated(rs.getDate("Email_Log.updated"));
		User ub = new User(rs.getInt("Email_Log.updated_by"), rs.getString("updatedby.full_name"));
		emailLog.setUpdatedBy(ub);
		emailLog.setRecipient(rs.getString("Email_Log.email_recipient"));
		emailLog.setFrom(rs.getString("Email_Log.email_from"));
		emailLog.setDirection(rs.getString("Email_Log.email_direction"));
		emailLog.setSubject(rs.getString("Email_Log.email_subject"));
		emailLog.setBody(rs.getString("Email_Log.email_body"));
		EmailTemplate emailTemplate = new EmailTemplate(rs.getInt("Email_Log.email_template_id"),rs.getString("emailtemplateid.email_subject"));
		emailLog.setTemplate(emailTemplate);
		emailLog.setTable(rs.getString("Email_Log.email_table"));
		emailLog.setTableRecordId(rs.getInt("Email_Log.table_record_id"));
		Status status = new Status(rs.getInt("Email_Log.status"),rs.getString("statusid.label"));
		emailLog.setStatus(status);
		Client client = new Client(rs.getInt("Email_Log.client"),rs.getString("clientid.client_nme"));
		emailLog.setClient(client);
		return emailLog;
	}
}