package com.vsportal.availability;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.QueryHelper;

public class AvailabilityDAO extends JdbcDaoSupport {
	//Create Availability
	public Availability insert(final Availability availability, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Availability (created_by, updated_by, "
				+ "analyst_id, start, end)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, availability.getAnalyst().getId());
						ps.setDate(4, availability.getStart());
						ps.setDate(5, availability.getEnd());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Availability
	public Availability update(Availability availability, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		availability.setUpdated(now);
		
		String sql = "UPDATE Availability SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "analyst_id = ?, "
				+ "start = ?, "
				+ "end = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			availability.getUpdated(),
			sessionUser.getId(),
			availability.getAnalyst().getId(),
			availability.getStart(),
			availability.getEnd(),
			availability.getId()
		});
		
		return availability;
	}
}
