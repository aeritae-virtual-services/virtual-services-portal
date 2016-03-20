package com.vsportal.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class CommentDAO extends JdbcDaoSupport{
	//Create Comment
	public Comment insert(final Comment comment, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Tier (created_by, updated_by, "
				+ "request, comment, public)"
					+ "VALUES(?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, comment.getRequest().getId());
						ps.setString(4, comment.getComment());
						ps.setBoolean(5, comment.isPublic());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Comment
	public Comment update(Comment comment, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		comment.setUpdated(now);
		
		String sql = "UPDATE EmailTemplate SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "request = ?, "
				+ "comment = ?, "
				+ "public = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			comment.getUpdated(),
			sessionUser.getId(),
			comment.getRequest().getId(),
			comment.getComment(),
			comment.isPublic(),
			comment.getId()
		});
		return comment;
	}
}
