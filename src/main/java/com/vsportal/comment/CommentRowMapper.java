package com.vsportal.comment;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.request.Request;

public class CommentRowMapper<T> implements RowMapper<Comment> {
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("Comment.id"));
		comment.setCreated(rs.getDate("Comment.created"));
		User cb = new User(rs.getInt("Comment.created_by"), rs.getString("createdby.full_name"));
		comment.setCreatedBy(cb);
		comment.setUpdated(rs.getDate("Comment.updated"));
		User ub = new User(rs.getInt("Comment.updated_by"), rs.getString("updatedby.full_name"));
		comment.setUpdatedBy(ub);
		Request request = new Request(rs.getInt("Comment.request_id"),rs.getString("requestid.req_nbr"));
		comment.setRequest(request);
		comment.setComment(rs.getString("Comment.comment"));
		comment.setPublic(rs.getBoolean("Comment.public"));
		return comment;
	}
}