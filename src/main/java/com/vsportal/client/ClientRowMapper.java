package com.vsportal.client;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

import com.vsportal.user.User;
import com.vsportal.group.Group;

public class ClientRowMapper<T> implements RowMapper<Client> {
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("Client.id"));
		client.setCreated(rs.getDate("Client.created"));
		User cb = new User(rs.getInt("Client.created_by"), rs.getString("createdby.full_name"));
		client.setCreatedBy(cb);
		client.setUpdated(rs.getDate("Client.updated"));
		User ub = new User(rs.getInt("Client.updated_by"), rs.getString("updatedby.full_name"));
		client.setUpdatedBy(ub);
		client.setName(rs.getString("Client.client_nme"));
		User primaryContact = new User(rs.getInt("Client.primary_contact"),rs.getString("primarycontact.full_name"));
		client.setPrimaryContact(primaryContact);
		client.setUrl(rs.getString("Client.url"));
		client.setAddress(rs.getString("Client.address"));
		Group queueManagers = new Group(rs.getInt("Client.q_manager"),rs.getString("qmanager.user_group_nme"));
		client.setQManager(queueManagers);
		client.setTestMigrationRequired(rs.getBoolean("Client.test_migration_req"));
		client.setProductionMigrationRequired(rs.getBoolean("Client.prod_migration_req"));
		client.setClientPORequired(rs.getBoolean("Client.client_po_req"));
		Group primaryAnalysts = new Group(rs.getInt("Client.primary_analyst_group"),rs.getString("primaryanalystgroup.user_group_nme"));
		client.setPrimaryAnalystGroup(primaryAnalysts);
		return client;
	}
}