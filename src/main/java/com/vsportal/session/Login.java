package com.vsportal.session;

public class Login {
	private String username;
	private String password;
	
	public Login() {
		this.username = null;
		this.password = null;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void setUserName(String un) {
		this.username = un;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String pw) {
		this.password = pw;
	}
}
