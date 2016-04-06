package com.vsportal.metric;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.status.Status;

public class MetricRowMapper<T> implements RowMapper<Metric> {
	public Metric mapRow(ResultSet rs, int rowNum) throws SQLException {
		Metric metric = new Metric();
		metric.setId(rs.getInt("Metric.id"));
		metric.setCreated(rs.getDate("Metric.created"));
		User cb = new User(rs.getInt("Metric.created_by"), rs.getString("createdby.full_name"));
		metric.setCreatedBy(cb);
		metric.setUpdated(rs.getDate("Metric.updated"));
		User ub = new User(rs.getInt("Metric.updated_by"), rs.getString("updatedby.full_name"));
		metric.setUpdatedBy(ub);
		metric.setType(rs.getString("Metric.type"));
		metric.setTypeid(rs.getInt("Metric.type_id")));
		metric.setStart(rs.getDate("Metric.start"));
		metric.setEnd(rs.getDate("Metric.end"));
		metric.setDuration(rs.getInt("Metric.duration"));
		metric.setStatus(new Status(rs.getInt("Metric.status"),rs.getString("statusid.label")));
		return metric;
	}
}