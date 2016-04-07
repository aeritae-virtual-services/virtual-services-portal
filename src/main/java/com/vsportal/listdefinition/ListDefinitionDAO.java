package com.vsportal.listdefinition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.vsportal.user.User;
import com.vsportal.utils.QueryHelper;

public class ListDefinitionDAO extends JdbcDaoSupport{
	//Create ListDefinition
		public ListDefinition insert(final ListDefinition listDefinition, final User sessionUser) {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			final String sql = "INSERT INTO List_Definition (created_by, updated_by, "
					+ "table_nme,"
					+ "role_id,"
					+ "column_label,"
					+ "column_nme,"
					+ "sequence"
					+ ")"
					+ "VALUES(?,?,?,?,?,?,?)";
			
			getJdbcTemplate().update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
							ps.setInt(1, sessionUser.getId());
							ps.setInt(2, sessionUser.getId());
							ps.setString(3, listDefinition.getTableName());
							ps.setInt(4, listDefinition.getRoleId().getId());
							ps.setString(5, listDefinition.getColumnLabel());
							ps.setString(6, listDefinition.getColumnName());
							ps.setInt(7, listDefinition.getSequence());
							return ps;
						}
					}, keyHolder);		
			return this.recordQuery("id=" + keyHolder.getKey().intValue(), "*");
		}
		//Update ListDefinition
		public ListDefinition update(ListDefinition listDefinition, User sessionUser) {
			//Set Update Date to Now
			java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
			//set Updated missing from now
			listDefinition.setUpdated(now);
			
			String sql = "UPDATE List_Definition SET"
					+ "updated = ?, "
					+ "updated_by = ?, "
					+ "table_nme = ?, "
					+ "role_id = ?, "
					+ "column_label = ?, "
					+ "column_nme = ?, "
					+ "sequence = ?"
					+ "WHERE id = ?";
			
			getJdbcTemplate().update(sql, new Object[]{
				listDefinition.getUpdated(),
				sessionUser.getId(),
				listDefinition.getTableName(),
				listDefinition.getRole().getId(),
				listDefinition.getColumnLabel(),
				listDefinition.getColumnName(),
				listDefinition.getSequence(),
				listDefinition.getId()
			});
			return listDefinition;
		}
		//get ListDefinition
		public ListDefinition recordQuery(String query, String columns) {
			QueryHelper qh = new QueryHelper();
			String sql = "SELECT";
			
			//Ensure columns are selected, if none are specified, automatically select all columns
			if(columns.isEmpty() || columns.equals(null)) {
				columns = "*";
			}
			
			if(columns == "*") {
				//If * add all columns for: ListDefinition
				sql += " List_Definition.*,";
			} else {
				String[] columnArr = columns.split(",");
				for(int i = 0; i < columnArr.length; i++) {
					//Add only selected for table: ListDefinition
					sql += " List_Definition." + columnArr[i] + ",";
				}
			}
			
			String sqlJoin = "";
			
			//Created By
			if(columns.equals("*") || columns.contains("created_by")) {
				sql += " createdby.full_name,";
				//Merge User and: List_Definition
				sqlJoin += " LEFT JOIN User As createdby ON List_Definition.created_by = createdby.id";
			}
			//Updated By
			if(columns.equals("*") || columns.contains("updated_by")) {
				sql += " updatedby.full_name,";
				//Merge User and: List_Definition
				sqlJoin += " LEFT JOIN User As updatedby ON List_Definition.updated_by = updatedby.id";
			}
			//Role
			if(columns.equals("*") || columns.contains("role_id")) {
				sql += " roleid.role_nme,";
				//Merge Role and: List_Definition
				sqlJoin += " LEFT JOIN Role As roleid ON List_Definition.role_id = roleid.id";
			}
			
			//If last character is a comma, remove it
			if(sql.endsWith(",")) {
				sql = sql.substring(0, sql.length() - 1);
			}
			
			//Add Generated Join Clauses to SQL Statement: ListDefinition
			sql += " FROM List_Definition" + sqlJoin;
			
			//Add Where Clause if necessary
			if(query != "") {
				sql += " WHERE " + qh.toSQLQuery(query);
			}
			
			//Limit return results to 0 or 1 record
			sql += " LIMIT 0,1";
			
			//Execute query
			ListDefinition listDefinition = getJdbcTemplate().queryForObject(sql, new Object[]{}, new ListDefinitionRowMapper<ListDefinition>());
			
			return listDefinition;
		}
		//Get ListDefinition List
		public ArrayList<ListDefinition> listQuery(String query, String columns) {
			QueryHelper qh = new QueryHelper();
			String sql = "SELECT";
			
			//Ensure columns are selected, if none are specified, automatically select all columns
			if(columns.isEmpty() || columns.equals(null)) {
				columns = "*";
			}
			
			if(columns == "*") {
				sql += " List_Definition.*,";
			} else {
				String[] columnArr = columns.split(",");
				for(int i = 0; i < columnArr.length; i++) {
					sql += " List_Definition." + columnArr[i] + ",";
				}
			}
			
			String sqlJoin = "";
			
			//Created By
			if(columns.equals("*") || columns.contains("created_by")) {
				sql += " createdby.full_name,";
				//Merge User and: ListDefinition
				sqlJoin += " LEFT JOIN User As createdby ON List_Definition.created_by = createdby.id";
			}
			//Updated By
			if(columns.equals("*") || columns.contains("updated_by")) {
				sql += " updatedby.full_name,";
				//Merge User and: ListDefinition
				sqlJoin += " LEFT JOIN User As updatedby ON List_Definition.updated_by = updatedby.id";
			}
			//Role
			if(columns.equals("*") || columns.contains("role_id")) {
				sql += " roleid.role_nme,";
				//Merge Role and: List_Definition
				sqlJoin += " LEFT JOIN Role As roleid ON List_Definition.role_id = roleid.id";
			}
			
			//If last character is a comma, remove it
			if(sql.endsWith(",")) {
				sql = sql.substring(0, sql.length() - 1);
			}
			
			//Add Generated Join Clauses to SQL Statement
			sql += " FROM List_Definition" + sqlJoin;
			
			//Add Where Clause if necessary
			if(query != "") {
				sql += " WHERE " + qh.toSQLQuery(query);
			}
			
			//Execute query
			ArrayList<ListDefinition> listDefinitionList = (ArrayList<ListDefinition>)getJdbcTemplate().query(sql,new Object[]{}, new ListDefinitionRowMapper<ListDefinition>());
			
			return listDefinitionList;
		}
}
