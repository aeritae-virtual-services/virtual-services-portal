package com.vsportal.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class RequestDAO extends JdbcDaoSupport {

	//Create Request
	public Request insert(final Request request, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Request (created_by, updated_by, "
				+ "requester, req_nbr, description, short_description, client_req_nbr,"
				+ "req_status, request_completion_date, priority, update_set, request_loe,"
				+ "estimated_loe, hours_consumed, request_type, contract_id, tier, resume_to, client_id"
				+ ")"
				+ "VALUES(?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,?,?"
				+ ")";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setInt(3, request.getRequester().getId());
						ps.setString(4, request.getNumber());
						ps.setString(5, request.getDescription());
						ps.setString(6, request.getShortDescription());
						ps.setString(7, request.getClientRequestNumber());
						ps.setInt(8, request.getStatus().getId());
						ps.setDate(9, request.getRequestedCompletionDate());
						ps.setInt(10, request.getPriority().getId());
						ps.setString(11, request.getUpdateSet());
						ps.setBoolean(12, request.isRequestLOE());
						ps.setFloat(13, request.getEstimatedLOE());
						ps.setFloat(14, request.getHoursConsumed());
						ps.setInt(15, request.getRequestType().getId());
						ps.setInt(16, request.getContract().getId());
						ps.setInt(17, request.getTier().getId());
						ps.setInt(18, request.getResumeTo().getId());
						//get client missing
						ps.setInt(19, request.getClient().getId());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Request
	public Request update(Request request, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		request.setUpdated(now);
		
		String sql = "UPDATE Request SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "requester = ?, "
				+ "req_nbr = ?,"
				+ "description = ?,"
				+ "short_description = ?,"
				+ "client_req_nbr = ?,"
				+ "req_status = ?,"
				+ "requested_completion_date = ?,"
				+ "priority = ?,"
				+ "update_set = ?,"
				+ "request_loe = ?,"
				+ "estimated_loe = ?,"
				+ "hours_consumed = ?,"
				+ "request_type = ?, "
				+ "contract_id = ?, "
				+ "tier = ?,"
				+ "resume_to = ?,"
				+ "client_id = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			request.getUpdated(),
			sessionUser.getId(),
			request.getRequester().getId(),
			request.getNumber(),
			request.getDescription(),
			request.getShortDescription(),
			request.getClientRequestNumber(),
			request.getStatus().getId(),
			request.getRequestedCompletionDate(),
			request.getPriority().getId(),
			request.getUpdateSet(),
			request.isRequestLOE(),
			request.getEstimatedLOE(),
			request.getHoursConsumed(),
			request.getRequestType().getId(),
			request.getContract().getId(),
			request.getTier().getId(),
			request.getResumeTo().getId(),
			//get client missing from request
			request.getClient().getId(),
			request.getId()
		});
		
		return request;
	}
	
	public Request getRequestById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Request recordQuery(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
