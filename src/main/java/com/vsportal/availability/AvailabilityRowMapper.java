package com.vsportal.availability;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class AvailabilityRowMapper<T> implements RowMapper<Availability> {
	public Availability mapRow(ResultSet rs, int rowNum) throws SQLException {
		Availability availability = new Availability();
		availability.setId(rs.getInt("Availability.id"));
		availability.setCreated(rs.getDate("Availability.created"));
		User cb = new User(rs.getInt("Availability.created_by"), rs.getString("createdby.full_name"));
		availability.setCreatedBy(cb);
		availability.setUpdated(rs.getDate("Availability.updated"));
		User ub = new User(rs.getInt("Availability.updated_by"), rs.getString("updatedby.full_name"));
		availability.setUpdatedBy(ub);
		User analyst = new User(rs.getInt("Availability.analyst_id"),rs.getString("analystid.full_name"));
		availability.setAnalyst(analyst);
		availability.setStart(rs.getDate("Availability.start"));
		availability.setEnd(rs.getDate("Availability.end"));
		return availability;
	}
}