package com.vsportal.session;

import javax.servlet.http.HttpSession;

import com.vsportal.user.User;

public class SessionHelper {
	
	public void validateSession(HttpSession sess, User user) {
		if(!isValidSession(sess)) {
			sess.setAttribute("valid_session", "true");
			sess.setAttribute("user", user);
			//Session timeout of 15 minutes
			sess.setMaxInactiveInterval(15 * 60);
		}
	}
	
	
	public boolean isValidSession(HttpSession sess) {
		boolean isValid;
		
		if(sess != null && sess.getAttribute("valid_session") == "true") {
			isValid = true;
		} else {
			isValid = false;
		}
		
		return isValid;
	}
}
