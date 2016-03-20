package com.vsportal.tier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class TierDAO extends JdbcDaoSupport {
	//Create Tier
	public Tier insert(final Tier tier, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Tier (created_by, updated_by, "
				+ "tier_name, tier_description)"
					+ "VALUES(?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, tier.getName());
						ps.setString(4, tier.getDescription());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update TaskType
	public Tier update(Tier tier, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		//set Updated missing from now
		tier.setUpdated(now);
		
		String sql = "UPDATE Tier SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "tier_name = ?, "
				+ "tier_description = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			tier.getUpdated(),
			sessionUser.getId(),
			//getLabel getValue missing from TaskType
			tier.getName(),
			tier.getDescription(),
			tier.getId()
		});
		return tier;
	}
}
