package com.vsportal.tier;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;

public class TierRowMapper<T> implements RowMapper<Tier> {
	public Tier mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tier tier = new Tier();
		tier.setId(rs.getInt("Tier.id"));
		tier.setCreated(rs.getDate("Tier.created"));
		User cb = new User(rs.getInt("Tier.created_by"), rs.getString("createdby.full_name"));
		tier.setCreatedBy(cb);
		tier.setUpdated(rs.getDate("Tier.updated"));
		User ub = new User(rs.getInt("Tier.updated_by"), rs.getString("updatedby.full_name"));
		tier.setUpdatedBy(ub);
		tier.setName(rs.getString("Tier.tier_name"));
		tier.setDescription(rs.getString("Tier.tier_description"));
		return tier;
	}
}
