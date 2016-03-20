package com.vsportal.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class RoleDAO extends JdbcDaoSupport{
	//Create Role
	public Role insert(final Role role, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Role (created_by, updated_by, "
				+ "role_nme, role_value)"
				+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, role.getName());
						ps.setInt(4, role.getValue());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Role
	public Role update(Role role, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from role
		role.setUpdated(now);
		
		String sql = "UPDATE Role SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "role_nme = ?, "
				+ "role_value = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			role.getUpdated(),
			sessionUser.getId(),
			role.getName(),
			role.getValue(),
			role.getId()
		});
		return role;
	}
	
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
