package com.vsportal.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class TaskTypeDAO extends JdbcDaoSupport{
	//Create TaskType
	public TaskType insert(final TaskType taskType, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO TaskType (created_by, updated_by, "
				+ "label, value)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						//getLabel getValue missing from TaskType
						ps.setString(3, taskType.getLabel());
						ps.setString(4, taskType.getValue());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update TaskType
	public TaskType update(TaskType taskType, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		taskType.setUpdated(now);
		
		String sql = "UPDATE TaskType SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "label = ?, "
				+ "value = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			taskType.getUpdated(),
			sessionUser.getId(),
			//getLabel getValue missing from TaskType
			taskType.getLabel(),
			taskType.getValue(),
			taskType.getId()
		});
		return taskType;
	}
}
