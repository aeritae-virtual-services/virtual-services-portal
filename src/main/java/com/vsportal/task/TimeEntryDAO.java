package com.vsportal.task;

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

public class TimeEntryDAO extends JdbcDaoSupport {
	//Create TimeEntry
	public TimeEntry insert(final TimeEntry timeEntry, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO TimeEntry (created_by, updated_by, "
				+ "task, request_id, hours_consumed, user_id, contract_id, client_id)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, timeEntry.getTask().getId());
						//getRequest missing from Time Entry
						ps.setInt(4, timeEntry.getRequest().getId());
						ps.setFloat(5, timeEntry.getHoursConsumed());
						ps.setInt(6, timeEntry.getUser().getId());
						ps.setInt(7, timeEntry.getContract().getId());
						ps.setInt(8, timeEntry.getClient().getId());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update TimeEntry
	public TimeEntry update(TimeEntry timeEntry, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		timeEntry.setUpdated(now);
		
		String sql = "UPDATE TimeEntry SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "task = ?, "
				+ "request_id = ?, "
				+ "hours_consumed = ?, "
				+ "user_id = ?, "
				+ "contract_id = ?, "
				+ "client_id = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			timeEntry.getUpdated(),
			sessionUser.getId(),
			timeEntry.getTask().getId(),
			//get Request missing
			timeEntry.getRequest().getId(),
			timeEntry.getHoursConsumed(),
			timeEntry.getUser().getId(),
			timeEntry.getContract().getId(),
			timeEntry.getClient().getId(),
			timeEntry.getId()
		});
		return timeEntry;
	}

	public ArrayList<TimeEntry> getListByQuery(String query) {
		ArrayList<TimeEntry> teArr = new ArrayList<TimeEntry>();
		return null;
	}

}
