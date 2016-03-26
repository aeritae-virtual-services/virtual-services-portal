package com.vsportal.user;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.client.Client;
import com.vsportal.role.Role;

public class UserRowMapper<T> implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("User.id"));
		user.setCreated(rs.getDate("User.created"));
		user.setCreatedBy(new User(rs.getInt("User.created_by"), rs.getString("createdby.full_name")));
		user.setUpdated(rs.getDate("User.updated"));
		user.setUpdatedBy(new User(rs.getInt("User.updated_by"), rs.getString("updatedby.full_name")));
		user.setFirstName(rs.getString("User.first_nme"));
		user.setLastName(rs.getString("User.last_nme"));
		user.setFullName(rs.getString("User.full_nme"));
		user.setPhoneNumber(rs.getString("User.phone_number"));
		user.setEmail(rs.getString("User.email"));
		user.setClient(new Client(rs.getInt("User.client_id"),rs.getString("clientid.client_nme")));
		user.setRole(new Role(rs.getInt("User.role_id"),rs.getString("roleid.role_nme")));
		user.setUserID(rs.getString("user_id"));
		//left password out for security reasons
		//user.setPassword(rs.getString("User.password"));
		user.setProfileImage(rs.getString("User.profile_image"));
		return user;
	}
}