package com.vsportal.role;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class RoleRowMapper<T> implements RowMapper<Role> {
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("Role.id"));
		role.setCreated(rs.getDate("Role.created"));
		User cb = new User(rs.getInt("Role.created_by"), rs.getString("createdby.full_name"));
		role.setCreatedBy(cb);
		role.setUpdated(rs.getDate("Role.updated"));
		User ub = new User(rs.getInt("Role.updated_by"), rs.getString("updatedby.full_name"));
		role.setUpdatedBy(ub);
		role.setName(rs.getString("Role.role_nme"));
		role.setValue(rs.getInt("Role.role_value"));
		return role;
	}
}