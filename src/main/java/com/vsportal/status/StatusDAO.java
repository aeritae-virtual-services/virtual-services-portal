package com.vsportal.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class StatusDAO extends JdbcDaoSupport{
	//Create Status
	public Status insert(final Status status, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Status (created_by, updated_by, "
				+ "label, status_value, table)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, status.getLabel());
						ps.setInt(4, status.getValue());
						//Table missing from status object, used type
						ps.setString(5, status.getType());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Status
	public Status update(Status status, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		status.setUpdated(now);
		
		String sql = "UPDATE Status SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "label = ?, "
				+ "status_value = ?, "
				+ "table = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			status.getUpdated(),
			sessionUser.getId(),
			status.getLabel(),
			status.getValue(),
			//Table missing from status, used type instead
			status.getType(),
			status.getId()
		});
		return status;
	}
}