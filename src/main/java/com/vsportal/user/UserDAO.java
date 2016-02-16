package com.vsportal.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vsportal.jdbc.ConnectionPool;
import com.vsportal.jdbc.DBUtil;

public class UserDAO {
    
	public User getUserByUsername(String username) {
		ConnectionPool pool = ConnectionPool.getInstance();
	    Connection connection = pool.getConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    User user;
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
    
    
    
    
}
