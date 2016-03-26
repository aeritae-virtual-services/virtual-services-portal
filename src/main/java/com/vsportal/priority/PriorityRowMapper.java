package com.vsportal.priority;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class PriorityRowMapper<T> implements RowMapper<Priority> {
	public Priority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Priority priority = new Priority();
		priority.setId(rs.getInt("Priority.id"));
		priority.setCreated(rs.getDate("Priority.created"));
		User cb = new User(rs.getInt("Priority.created_by"), rs.getString("createdby.full_name"));
		priority.setCreatedBy(cb);
		priority.setUpdated(rs.getDate("Priority.updated"));
		User ub = new User(rs.getInt("Priority.updated_by"), rs.getString("updatedby.full_name"));
		priority.setUpdatedBy(ub);
		priority.setLabel(rs.getString("Priority.label"));
		priority.setValue(rs.getInt("Priority.priority_value"));
		priority.setTable(rs.getString("Priority.table_nme"));
		return priority;
	}
}
