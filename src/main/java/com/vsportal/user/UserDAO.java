package com.vsportal.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.vsportal.jdbc.ConnectionPool;
import com.vsportal.jdbc.DBUtil;
import com.vsportal.session.SystemUnavailableException;
import com.vsportal.status.Status;
import com.vsportal.status.StatusRowMapper;
import com.vsportal.utils.PasswordHelper;
import com.vsportal.utils.QueryHelper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.RowMapper;  

public class UserDAO extends JdbcDaoSupport {
	
	public void insertUser(User user, String password){
		String sql = "INSERT INTO User (first_name, last_name, phone_number, email, company, role)" +
				"VALUES (?,?,?,?,?,?)";
		
		
		getJdbcTemplate().update(sql, new Object[]{user.getFirstName(), user.getFirstName(), user.getPhone(),
				user.getEmail(),user.getClient(), user.getRole()});
		
		
		this.setPassword(user.getId(), password);
	}
	
	public void updateUser(User user){
		String sql = "INSERT INTO User (first_name, last_name, phone_number, email, company, role)" +
				"VALUES (?,?,?,?,?,?)";
		
		
		getJdbcTemplate().update(sql, new Object[]{user.getFirstName(), user.getFirstName(), user.getPhone(),
				user.getEmail(),user.getClient(), user.getRole()});
		
	}
	
	//get User
	public User recordQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			//If * add all columns for: User
			sql += " User.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				//Add only selected for table: User
				sql += " User." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN User As createdby ON User.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN User As updatedby ON User.updated_by = updatedby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN Client As clientid ON User.client_id = clientid.id";
		}
		//Role
		if(columns.equals("*") || columns.contains("role_id")) {
			sql += " roleid.role_nme,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN Role As roleid ON User.role_id = roleid.id";
		}
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement: User
		sql += " FROM User" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Limit return results to 0 or 1 record
		sql += " LIMIT 0,1";
		
		//Execute query
		User user = getJdbcTemplate().queryForObject(sql, new Object[]{}, new UserRowMapper<User>());
		
		return user;
	}
	
	//Get User List
	public ArrayList<User> listQuery(String query, String columns) {
		QueryHelper qh = new QueryHelper();
		String sql = "SELECT";
		
		//Ensure columns are selected, if none are specified, automatically select all columns
		if(columns.isEmpty() || columns.equals(null)) {
			columns = "*";
		}
		
		if(columns == "*") {
			sql += " User.*,";
		} else {
			String[] columnArr = columns.split(",");
			for(int i = 0; i < columnArr.length; i++) {
				sql += " User." + columnArr[i] + ",";
			}
		}
		
		String sqlJoin = "";
		
		//Created By
		if(columns.equals("*") || columns.contains("created_by")) {
			sql += " createdby.full_name,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN User As createdby ON User.created_by = createdby.id";
		}
		//Updated By
		if(columns.equals("*") || columns.contains("updated_by")) {
			sql += " updatedby.full_name,";
			//Merge User and: User
			sqlJoin += " LEFT JOIN User As updatedby ON User.updated_by = updatedby.id";
		}
		//Client
		if(columns.equals("*") || columns.contains("client_id")) {
			sql += " clientid.client_nme,";
			//Merge Client and: User
			sqlJoin += " LEFT JOIN Client As clientid ON User.client_id = clientid.id";
		}
		//Role
		if(columns.equals("*") || columns.contains("role_id")) {
			sql += " roleid.role_nme,";
			//Merge Role and: User
			sqlJoin += " LEFT JOIN Role As roleid ON User.role_id = roleid.id";
		}
		
		//If last character is a comma, remove it
		if(sql.endsWith(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		
		//Add Generated Join Clauses to SQL Statement
		sql += " FROM User" + sqlJoin;
		
		//Add Where Clause if necessary
		if(query != "") {
			sql += " WHERE " + qh.toSQLQuery(query);
		}
		
		//Execute query
		ArrayList<User> userList = (ArrayList<User>)getJdbcTemplate().query(sql,new Object[]{}, new UserRowMapper<User>());
		
		return userList;
	}
	
	public ArrayList<User> getListByQuery(String query) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT first_name, last_name, phone_number, email, company, role FROM User WHERE ";
		sql += qh.toSQLQuery(query);
		
		ArrayList<User> userList = (ArrayList<User>)getJdbcTemplate().query(sql,new Object[]{}, new UserRowMapper<User>());
		
		return userList;
	}
	
	public User getSessionUser(HttpSession sess) {
		int userId = (Integer)sess.getAttribute("session_user");
		return this.getUserById(userId);
	}
/*    
	public User getUserById(int id) {
		
		String query = "SELECT * from User WHERE id = ?";
		User user = (User)getJdbcTemplate().queryForObject(query,new Object[]{id},new userRowMapper);
		
		return user;
	}
	
	public User getUserByUsername(String username) {
		String query = "SELECT * from User WHERE username = ?";
		User user = (User)getJdbcTemplate().queryForObject(query,new Object[]{username},new userRowMapper);
		
		return user;
	}
*/ 
    public boolean validatePassword(int userId, String pw) {
    	boolean isSuccessful = false;
    	
    	String encodedpw = "";
    	String storedpw = "";
    	
    	try {
    		encodedpw = com.vsportal.utils.PasswordHelper.getInstance().encrypt(pw);
    	} catch(SystemUnavailableException e) {
    		e.printStackTrace();
    	}
    	
	    
		String query = "SELECT password from User WHERE id = ?";
		List<String> result = getJdbcTemplate().query(query, new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum)throws SQLException {
		        return rs.getString(1);
			  }
		});
		
		storedpw = result.get(0);
		
		
		if(encodedpw.matches(storedpw)) {
    		isSuccessful = true;
    	}
		
    	return isSuccessful;
    }
    
    public boolean setPassword(int userId, String pw) {
    	boolean isSuccessful = false;
    	
    	String encodedpw = "";
    	
    	try {
    		encodedpw = com.vsportal.utils.PasswordHelper.getInstance().encrypt(pw);
    	} catch(SystemUnavailableException e) {
    		e.printStackTrace();
    	}
    		    
		String query = "UPDATE User SET password = ? WHERE user_id = ?";
		
		getJdbcTemplate().update(query);
    	
    	return isSuccessful;
    }
}
