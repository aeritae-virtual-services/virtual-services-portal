package com.vsportal.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class RequestTypeDAO extends JdbcDaoSupport{

	//Create RequestType
	public RequestType insert(final RequestType requestType, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO RequestType (created_by, updated_by, "
				+ "req_type_nme, description, first_workflow_step"
				+ ")"
				+ "VALUES(?,?,"
				+ "?,?,?"
				+ ")";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, requestType.getName());
						ps.setString(4, requestType.getDescription());
						ps.setInt(5, requestType.getFirstStep().getID());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update RequestType
	public RequestType update(RequestType requestType, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		requestType.setUpdated(now);
		
		String sql = "UPDATE RequestType SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "req_type_nme = ?,"
				+ "description = ?,"
				+ "first_workflow_step = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			requestType.getUpdated(),
			sessionUser.getId(),
			requestType.getName(),
			requestType.getDescription(),
			requestType.getFirstStep().getID(),
			requestType.getId()
		});
		
		return requestType;
	}
}
