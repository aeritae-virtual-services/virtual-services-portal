package com.vsportal.contract;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.client.Client;
import com.vsportal.tier.Tier;
import com.vsportal.status.Status;

public class ContractRowMapper<T> implements RowMapper<Contract> {
	public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contract contract = new Contract();
		contract.setId(rs.getInt("Contract.id"));
		contract.setCreated(rs.getDate("Contract.created"));
		User cb = new User(rs.getInt("Contract.created_by"), rs.getString("createdby.full_name"));
		contract.setCreatedBy(cb);
		contract.setUpdated(rs.getDate("Contract.updated"));
		User ub = new User(rs.getInt("Contract.updated_by"), rs.getString("updatedby.full_name"));
		contract.setUpdatedBy(ub);
		Client client = new Client(rs.getInt("Contract.client_id"),rs.getString("clientid.client_nme"));
		contract.setClient(client);
		Tier tier = new Tier(rs.getInt("Contract.tier_id"),rs.getString("tierid.tier_name"));
		contract.setTier(tier);
		contract.setStartDate(rs.getDate("Contract.start_date"));
		contract.setEndDate(rs.getDate("Contract.end_date"));
		contract.setFinalCompletionDate(rs.getDate("Contract.final_completion_date"));
		Status status = new Status(rs.getInt("Contract.contract_status"),rs.getString("contractstatus.label"));
		contract.setStatus(status);
		return contract;
	}
}
