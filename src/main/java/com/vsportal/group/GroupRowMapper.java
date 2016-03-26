package com.vsportal.group;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class GroupRowMapper<T> implements RowMapper<Group> {
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.setId(rs.getInt("User_Group.id"));
		group.setCreated(rs.getDate("User_Group.created"));
		User cb = new User(rs.getInt("User_Group.created_by"), rs.getString("createdby.full_name"));
		group.setCreatedBy(cb);
		group.setUpdated(rs.getDate("User_Group.updated"));
		User ub = new User(rs.getInt("User_Group.updated_by"), rs.getString("updatedby.full_name"));
		group.setUpdatedBy(ub);
		group.setName(rs.getString("User_Group.user_group_nme"));
		return group;
	}
}
