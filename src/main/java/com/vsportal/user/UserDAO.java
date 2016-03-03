package com.vsportal.user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.vsportal.jdbc.ConnectionPool;
import com.vsportal.jdbc.DBUtil;
import com.vsportal.session.SystemUnavailableException;
import com.vsportal.utils.PasswordHelper;
import com.vsportal.utils.QueryHelper;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO {
	
	public void insertUser(User user, String password){
		String sql = "INSERT INTO User (first_name, last_name, phone_number, email, company, role)" +
				"VALUES (?,?,?,?,?,?)";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(pool.getDataSource());
		
		jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getFirstName(), user.getPhone(),
				user.getEmail(),user.getClient(), user.getRole()});
		
		
		this.setPassword(user.getId(), password);
	}
	
	public void updateUser(User user){
		
	}
	
	public ArrayList<User> getListByQuery(String query) {
		QueryHelper qh = new QueryHelper();
		
		String sql = "SELECT first_name, last_name, phone_number, email, company, role FROM User WHERE ";
		sql += qh.toSQLQuery(query);
		
JdbcTemplate jdbcTemplate = new JdbcTemplate(pool.getDataSource());
		
		jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getFirstName(), user.getPhone(),
				user.getEmail(),user.getCompany(), user.getRole()});
		ConnectionPool pool = ConnectionPool.getInstance();
		
		ArrayList<User> userList = new ArrayList<User>();
		
		return userList;
	}
	
	public User getSessionUser(HttpSession sess) {
		int userId = (Integer)sess.getAttribute("session_user");
		return this.getUserById(userId);
	}
    
	public User getUserById(int id) {
		ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    User user = null;
	  
		String query = "SELECT * from User WHERE id = ?";
		
		try {        
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
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
    		encodedpw = com.vsportal.utils.PasswordHelper.getInstance().encrypt(pw);
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
    		encodedpw = com.vsportal.utils.PasswordHelper.getInstance().encrypt(pw);
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

	public void updateUsersFilter(String tableName, String query) {
		//TODO Define filter update
	}

	public String getUsersFilter(String tableName) {
		// TODO Query to get Saved String
		return null;
	}
}
