package com.vsportal.task;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class TaskTypeRowMapper<T> implements RowMapper<TaskType> {
	public TaskType mapRow(ResultSet rs, int rowNum) throws SQLException {
		TaskType taskType = new TaskType();
		taskType.setId(rs.getInt("TaskType.id"));
		taskType.setCreated(rs.getDate("TaskType.created"));
		User cb = new User(rs.getInt("TaskType.created_by"), rs.getString("createdby.full_name"));
		taskType.setCreatedBy(cb);
		taskType.setUpdated(rs.getDate("TaskType.updated"));
		User ub = new User(rs.getInt("TaskType.updated_by"), rs.getString("updatedby.full_name"));
		taskType.setUpdatedBy(ub);
		taskType.setLabel(rs.getString("TaskType.label"));
		taskType.setValue(rs.getString("TaskType.value"));
		return taskType;
	}
}
