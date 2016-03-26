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
import com.vsportal.utils.QueryHelper;

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
	
	//Get Contract Record
	public Contract recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Contract
			sql += " Contract.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Contract
				sql += " Contract." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Contract
			sqlJoin += " LEFT JOIN User As createdby ON Contract.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Contract
			sqlJoin += " LEFT JOIN User As updatedby ON Contract.updated_by = updatedby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			sqlJoin += " LEFT JOIN Client AS clientid ON Contract.client_id = clientid.id";
		}
		//Tier
		if(columns.equals("*") || columns.contains("tier_id")) {
			sql += " tierid.tier_name,";
			sqlJoin += " LEFT JOIN Tier AS tierid ON Contract.tier_id = teirid.id";
		}
		//Status
		if(columns.equals("*") || columns.contains("contract_status")) {
			sql += " contractstatus.label,";
			sqlJoin += " LEFT JOIN Status AS contractstatus ON Contract.contract_status = contractstatus.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Contract
		sql += " FROM Contract" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Contract contract = getJdbcTemplate().queryForObject(sql, new Object[]{}, new ContractRowMapper<Contract>());
		
		return contract;
	}
	
	//Get Contract List
	public ArrayList<Contract> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Contract.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Contract." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
			if(columns.equals("*") || columns.contains("created_by")) {
				sql += " createdby.full_name,";
				//Merge User and: Contract
				sqlJoin += " LEFT JOIN User As createdby ON Contract.created_by = createdby.id";
			}
			//Updated By
			if(columns.equals("*") || columns.contains("updated_by")) {
				sql += " updatedby.full_name,";
				//Merge User and: Contract
				sqlJoin += " LEFT JOIN User As updatedby ON Contract.updated_by = updatedby.id";
			}
			//Client
			if(columns.equals("*") || columns.contains("client_id")) {
				sql += " clientid.client_nme,";
				sqlJoin += " LEFT JOIN Client AS clientid ON Contract.client_id = clientid.id";
			}
			//Tier
			if(columns.equals("*") || columns.contains("tier_id")) {
				sql += " tierid.tier_name,";
				sqlJoin += " LEFT JOIN Tier AS tierid ON Contract.tier_id = teirid.id";
			}
			//Status
			if(columns.equals("*") || columns.contains("contract_status")) {
				sql += " contractstatus.label,";
				sqlJoin += " LEFT JOIN Status AS contractstatus ON Contract.contract_status = contractstatus.id";
			}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Contract" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Contract> contractList = (ArrayList<Contract>)getJdbcTemplate().query(sql,new Object[]{}, new ContractRowMapper<Contract>());
		
		return contractList;
	}
}