package com.vsportal.priority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class PriorityDAO extends JdbcDaoSupport {
	//Create Priority
	public Priority insert(final Priority priority, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Priority (created_by, updated_by, "
				+ "label, priority_value, table_name)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, priority.getLabel());
						ps.setInt(4, priority.getValue());
						//Table missing from priority object
						ps.setString(5, priority.getTable());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Priority
	public Priority update(Priority priority, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		priority.setUpdated(now);
		
		String sql = "UPDATE Priority SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "label = ?, "
				+ "priority_value = ?, "
				+ "table_nme = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			priority.getUpdated(),
			sessionUser.getId(),
			priority.getLabel(),
			priority.getValue(),
			//Table missing from priority object
			priority.getTable(),
			priority.getId()
		});
		return priority;
	}
}
