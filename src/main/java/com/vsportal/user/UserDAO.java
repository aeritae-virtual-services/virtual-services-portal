package com.vsportal.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vsportal.jdbc.ConnectionPool;
import com.vsportal.jdbc.DBUtil;
import com.vsportal.session.PasswordHelper;
import com.vsportal.session.SystemUnavailableException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO {
	
	public void insertUser(User user){
		String sql = "INSERT INTO User (first_name, last_name, phone_number, email, company, role)" +
				"VALUES (?,?,?,?,?,?)";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(pool.getDataSource());
		
		jdbcTemplate.update(sql, new Object[]{user.getfirstName(), user.getlastName(), user.getPhone(),
				user.getEmail(),user.getcompany(), user.getRole()});
		
		
	}
	
	public void updateUser(User user){
		
	}
    
	public User getUserByUsername(String username) {
		ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    User user = null;
	  
		String query = "SELECT * from User WHERE username = ?";
		
		try {        
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	user = new User();
            } 
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
        	DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
		
		return user;
	}
    
    public boolean validatePassword(int userId, String pw) {
    	boolean isSuccessful = false;
    	
    	String encodedpw = "";
    	String storedpw = "";
    	
    	try {
    		encodedpw = com.vsportal.session.PasswordHelper.getInstance().encrypt(pw);
    	} catch(SystemUnavailableException e) {
    		e.printStackTrace();
    	}
    	
    	
    	ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
		String query = "SELECT password from User WHERE id = ?";
		
		try {        
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	storedpw = rs.getString("password");
            } 
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
        	DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
		
		if(encodedpw.matches(storedpw)) {
    		isSuccessful = true;
    	}
		
    	return isSuccessful;
    }
    
    public boolean setPassword(int userId, String pw) {
    	boolean isSuccessful = false;
    	
    	String encodedpw = "";
    	
    	try {
    		encodedpw = com.vsportal.session.PasswordHelper.getInstance().encrypt(pw);
    	} catch(SystemUnavailableException e) {
    		e.printStackTrace();
    	}
    	
    	
    	ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
		String query = "UPDATE User SET password = ? WHERE user_id = ?";
		
		try {        
            ps = connection.prepareStatement(query);
            ps.setString(1, encodedpw);
            ps.setInt(2, userId);
            int success = ps.executeUpdate();
            
            if(success == 1) {
            	isSuccessful = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
        	DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    	
    	return isSuccessful;
    }
}
