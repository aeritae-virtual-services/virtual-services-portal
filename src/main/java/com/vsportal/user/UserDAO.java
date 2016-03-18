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
	
	public ArrayList<User> getListByQuery(String query) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT first_name, last_name, phone_number, email, company, role FROM User WHERE ";
		sql += qh.toSQLQuery(query);
		
		ArrayList<User> userList = (ArrayList<User>)getJdbcTemplate().queryForList(query,new Object[]{query},new userRowMapper);
		
		return userList;
	}
	
	public User getSessionUser(HttpSession sess) {
		int userId = (Integer)sess.getAttribute("session_user");
		return this.getUserById(userId);
	}
    
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

	public void updateUsersFilter(String tableName, String query) {
		//TODO Define filter update
	}

	public String getUsersFilter(String tableName) {
		// TODO Query to get Saved String
		return null;
	}

	public User recordQuery(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}
