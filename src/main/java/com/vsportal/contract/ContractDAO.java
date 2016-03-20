package com.vsportal.contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.tier.Tier;
import com.vsportal.user.User;

public class ContractDAO extends JdbcDaoSupport {
	//Create Contract
	public Contract insert(final Contract contract, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Contract (created_by, updated_by, "
				+ "client_id, tier_id, start_date, end_date, final_completion_date, contract_status)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						//various functions missing from contract object
						ps.setInt(3, contract.getClient().getId());
						ps.setInt(4, contract.getTier().getId());
						ps.setDate(5, contract.getStartDate());
						ps.setDate(6, contract.getEndDate());
						ps.setDate(7, contract.getFinalCompetionDate());
						ps.setInt(8, contract.getStatus().getId());
						return ps;
					}
				}, keyHolder);		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Contract
	public Contract update(Contract contract, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		contract.setUpdated(now);
		
		String sql = "UPDATE Contract SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "client_id = ?, "
				+ "tier_id = ?, "
				+ "start_date = ?, "
				+ "end_date = ?, "
				+ "final_completion_date = ?,"
				+ "contract_status = ?"
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			contract.getUpdated(),
			sessionUser.getId(),
			//getLabel getValue missing from TaskType
			contract.getClient().getId(),
			contract.getTier().getId(),
			contract.getStartDate(),
			contract.getEndDate(),
			contract.getFinalCompletionDate(),
			contract.getStatus().getId(),
			contract.getId()
		});
		return contract;
	}
	
	public ArrayList<Contract> getListByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
