package com.vsportal.workflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class WorkflowOperationDAO extends JdbcDaoSupport {
	//Create WorkflowOperation
	public WorkflowOperation insert(final WorkflowOperation workflowOperation, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO WorkflowOperation (created_by, updated_by, "
				+ "operation_nme, description)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, workflowOperation.getOperationName());
						ps.setString(4, workflowOperation.getDescription());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update WorkflowOperation
	public WorkflowOperation update(WorkflowOperation workflowOperation, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		workflowOperation.setUpdated(now);
		
		String sql = "UPDATE WorkflowOperation SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "operation_nme = ?, "
				+ "description = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			workflowOperation.getUpdated(),
			sessionUser.getId(),
			workflowOperation.getOperationName(),
			workflowOperation.getDescription(),
			workflowOperation.getId()
		});
		return workflowOperation;
	}
}
