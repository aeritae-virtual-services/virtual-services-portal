package com.vsportal.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

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
						ps.setBoolean(9, client.isProductionMigrationRequired());
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
			client.isProductionMigrationRequired(),
			client.isClientPORequired(),
			client.getPrimaryAnalysts(),
			client.getId()
		});
		
		return client;
	}
	//Get Client Record
	public Client recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: Client
			sql += " Client.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: Client
				sql += " Client." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Client
			sqlJoin += " LEFT JOIN User As createdby ON Client.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Client
			sqlJoin += " LEFT JOIN User As updatedby ON Client.updated_by = updatedby.id";
		}
		//Primary Contact
		if(columns.equals("*") || columns.contains("primary_contact")) {
			sql += " primarycontact.full_name,";
			sqlJoin += " LEFT JOIN User As primarycontact ON Client.primary_contact = primarycontact.id";
		}
		//Q Manager
		if(columns.equals("*") || columns.contains("q_manager")) {
			sql += " qmanager.user_group_nme,";
			sqlJoin += " LEFT JOIN User_Group As qmanager ON Client.q_manager = qmanager.id";
		}
		//Primary Analyst Group
		if(columns.equals("*") || columns.contains("primary_analyst_group")) {
			sql += " primaryanalystgroup.user_group_nme,";
			sqlJoin += " LEFT JOIN User_Group As primaryanalystgroup ON Client.primary_analyst_group = primaryanalystgroup.id";
		}
		
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: Client
		sql += " FROM Client" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		Client client = getJdbcTemplate().queryForObject(sql, new Object[]{}, new ClientRowMapper<Client>());
		
		return client;
	}
	
	//Get Client List
	public ArrayList<Client> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " Client.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " Client." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: Client
			sqlJoin += " LEFT JOIN User As createdby ON Client.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: Client
			sqlJoin += " LEFT JOIN User As updatedby ON Client.updated_by = updatedby.id";
		}
		//Primary Contact
		if(columns.equals("*") || columns.contains("primary_contact")) {
			sql += " primarycontact.full_name,";
			sqlJoin += " LEFT JOIN User As primarycontact ON Client.primary_contact = primarycontact.id";
		}
		//Q Manager
		if(columns.equals("*") || columns.contains("q_manager")) {
			sql += " qmanager.user_group_nme,";
			sqlJoin += " LEFT JOIN User_Group As qmanager ON Client.q_manager = qmanager.id";
		}
		//Primary Analyst Group
		if(columns.equals("*") || columns.contains("primary_analyst_group")) {
			sql += " primaryanalystgroup.user_group_nme,";
			sqlJoin += " LEFT JOIN User_Group As primaryanalystgroup ON Client.primary_analyst_group = primaryanalystgroup.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM Client" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<Client> clientList = (ArrayList<Client>)getJdbcTemplate().query(sql,new Object[]{}, new ClientRowMapper<Client>());
		
		return clientList;
	}
}