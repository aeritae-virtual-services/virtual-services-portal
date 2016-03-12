package com.vsportal.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.user.User;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession sess = request.getSession();
		SessionHelper sh = new SessionHelper();
		
		if(sh.isValidSession(sess)) {
			model = new ModelAndView("home");
		} else {
			model = new ModelAndView("login");
			sess.setAttribute("valid_session", "false");
		}
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession sess = request.getSession();
		SessionHelper sh = new SessionHelper();
		UserDAO userDAO = new UserDAO();
		User user = null;
		String errmsg;
		
		if(request.getParameter("username").isEmpty() && request.getParameter("password").isEmpty()) {
			errmsg = "Username and password are required.";
			model = new ModelAndView("login");
			if(!request.getParameter("redirectTo").isEmpty()) {
				model.addObject("redirectTo", request.getParameter("redirectTo"));
			}
			model.addObject("errmsg", errmsg);
		} else if(request.getParameter("username").isEmpty()) {
			errmsg = "Username is required.";
			model = new ModelAndView("login");
			if(!request.getParameter("redirectTo").isEmpty()) {
				model.addObject("redirectTo", request.getParameter("redirectTo"));
			}
			model.addObject("errmsg", errmsg);
		} else if(request.getParameter("password").isEmpty()) {
			errmsg = "Password is required.";
			model = new ModelAndView("login");
			if(!request.getParameter("redirectTo").isEmpty()) {
				model.addObject("redirectTo", request.getParameter("redirectTo"));
			}
			model.addObject("errmsg", errmsg);
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			user = userDAO.getUserByUsername(username);
			
			if (userDAO.validatePassword(user.getId(), password)) {
				sh.validateSession(sess, user);
				
				if(request.getParameter("redirect_to").isEmpty()) {
					model = new ModelAndView("home");
				} else {
					model = new ModelAndView("redirect:" + request.getParameter("redirect_to"));
				}
				model.addObject("session_user", user);
			} else {
				errmsg = "Invalid login credentials. Please try again.";
				model = new ModelAndView("login");
				if(!request.getParameter("redirectTo").isEmpty()) {
					model.addObject("redirectTo", request.getParameter("redirectTo"));
				}
				model.addObject("errmsg", errmsg);
			}
		}
		
		return model;
	}
}
