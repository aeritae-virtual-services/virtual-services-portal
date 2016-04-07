package com.vsportal.task;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class TaskTypeRowMapper<T> implements RowMapper<TaskType> {
	public TaskType mapRow(ResultSet rs, int rowNum) throws SQLException {
		TaskType taskType = new TaskType();
		taskType.setId(rs.getInt("Task_Type.id"));
		taskType.setCreated(rs.getDate("Task_Type.created"));
		User cb = new User(rs.getInt("Task_Type.created_by"), rs.getString("createdby.full_name"));
		taskType.setCreatedBy(cb);
		taskType.setUpdated(rs.getDate("Task_Type.updated"));
		User ub = new User(rs.getInt("Task_Type.updated_by"), rs.getString("updatedby.full_name"));
		taskType.setUpdatedBy(ub);
		taskType.setLabel(rs.getString("Task_Type.label"));
		taskType.setValue(rs.getString("Task_TYpe.value"));
		return taskType;
	}
}
