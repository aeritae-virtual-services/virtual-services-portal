package com.vsportal.watch_list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class WatchListDAO extends JdbcDaoSupport {
	//Create WatchList
	public WatchList insert(final WatchList watchList, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO WatchList (created_by, updated_by, "
				+ "request_id, email_address)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, watchList.getRequest().getId());
						ps.setString(4, watchList.getEmail());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update WatchList
	public WatchList update(WatchList watchList, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		watchList.setUpdated(now);
		
		String sql = "UPDATE WatchList SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "request_id = ?, "
				+ "email_address = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			watchList.getUpdated(),
			sessionUser.getId(),
			watchList.getRequest().getId(),
			watchList.getEmail(),
			watchList.getId()
		});
		return watchList;
	}
}
