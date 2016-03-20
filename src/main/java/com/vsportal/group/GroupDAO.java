package com.vsportal.group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class GroupDAO extends JdbcDaoSupport{
	//Create Group
	public Group insert(final Group group, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Group (created_by, updated_by, "
				+ "user_group_nme)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, group.getName());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Group
	public Group update(Group group, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		group.setUpdated(now);
		
		String sql = "UPDATE Group SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "user_group_nme = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			group.getUpdated(),
			sessionUser.getId(),
			group.getName(),
			group.getId()
		});
		
		return group;
	}
}
