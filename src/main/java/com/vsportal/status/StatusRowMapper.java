package com.vsportal.status;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class StatusRowMapper<T> implements RowMapper<Status> {
	public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
		Status status = new Status();
		status.setId(rs.getInt("Status.id"));
		status.setCreated(rs.getDate("Status.created"));
		User cb = new User(rs.getInt("Status.created_by"), rs.getString("createdby.full_name"));
		status.setCreatedBy(cb);
		status.setUpdated(rs.getDate("Status.updated"));
		User ub = new User(rs.getInt("Status.updated_by"), rs.getString("updatedby.full_name"));
		status.setUpdatedBy(ub);
		status.setLabel(rs.getString("Status.label"));
		status.setValue(rs.getInt("Status.status_value"));
		status.setTable(rs.getString("Status.table"));
		return status;
	}
}
