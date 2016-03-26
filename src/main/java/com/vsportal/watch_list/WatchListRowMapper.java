package com.vsportal.watch_list;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.request.Request;

public class WatchListRowMapper<T> implements RowMapper<WatchList> {
	public WatchList mapRow(ResultSet rs, int rowNum) throws SQLException {
		WatchList watchList = new WatchList();
		watchList.setId(rs.getInt("WatchList.id"));
		watchList.setCreated(rs.getDate("WatchList.created"));
		User cb = new User(rs.getInt("WatchList.created_by"), rs.getString("createdby.full_name"));
		watchList.setCreatedBy(cb);
		watchList.setUpdated(rs.getDate("WatchList.updated"));
		User ub = new User(rs.getInt("WatchList.updated_by"), rs.getString("updatedby.full_name"));
		watchList.setUpdatedBy(ub);
		watchList.setRequest(new Request(rs.getInt("WatchList.request_id"),rs.getString("requestid.req_nbr")));
		watchList.setEmail(rs.getString("WatchList.email_address"));
		return watchList;
	}
}
