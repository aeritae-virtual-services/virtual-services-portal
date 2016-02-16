package com.vsportal.session;

import java.sql.ResultSet;

import com.vsportal.*;
import com.vsportal.user.User;
import com.vsportal.user.UserDAO;

public class Login {
	private User user;
	
	public Login() {
		this.user = null;
	}
	
	public Login(String name, String password) {
		this.user = null;
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(name);
		
		if (user.validatePassword(password))) {
			this.user = user;
		}
	}
	
	public boolean isValid() {
		if (this.user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public User getUser() {
		return this.user;
	}
}
