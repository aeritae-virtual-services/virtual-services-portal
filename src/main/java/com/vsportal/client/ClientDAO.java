package com.vsportal.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;

public class ClientDAO extends JdbcDaoSupport{
//Create Client
	public Client insert(final Client client, final User sessionUser) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sql = "INSERT INTO Client (created_by, updated_by, "
				+ "client_nme, primary_contact, url, address, q_manager, test_migration_req, "
				+ "prod_migration_req, client_po_req, primary_analyst_group)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		getJdbcTemplate().update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
						ps.setInt(1, sessionUser.getId());
						ps.setInt(2, sessionUser.getId());
						ps.setString(3, client.getName());
						ps.setInt(4, client.getPrimaryContact().getId());
						ps.setString(5, client.getUrl());
						ps.setString(6, client.getAddress());
						ps.setInt(7, client.getQueueManagers().getId());
						//test migration required missing from client object
						ps.setBoolean(8, client.isTestMigrationRequired());
						ps.setBoolean(9, client.isMigrationRequired());
						ps.setBoolean(10, client.isClientPORequired());
						ps.setInt(11, client.getPrimaryAnalysts().getId());
						return ps;
					}
				}, keyHolder);
		
		return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
	}
	
	//Update Client
	public Client update(Client client, User sessionUser) {
		//Set Update Date to Now
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		client.setUpdated(now);
		
		String sql = "UPDATE Client SET"
				+ "updated = ?, "
				+ "updated_by = ?, "
				+ "client_nme = ?, "
				+ "primary_contact = ?, "
				+ "url = ?, "
				+ "address = ?, "
				+ "q_manager = ?, "
				+ "test_migration_req = ?, "
				+ "prod_migration_req = ?, "
				+ "client_po_req = ?, "
				+ "primary_analyst_group = ? "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[]{
			client.getUpdated(),
			sessionUser.getId(),
			client.getName(),
			client.getPrimaryContact(),
			client.getUrl(),
			client.getAddress(),
			client.getQueueManagers(),
			//testMigrationRequired missing from client object
			client.isTestMigrationRequired(),
			client.isMigrationRequired(),
			client.isClientPORequired(),
			client.getPrimaryAnalysts(),
			client.getId()
		});
		
		return client;
	}
	public Client recordQuery(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}