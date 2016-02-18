package com.vsportal.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.user.User;
import com.vsportal.user.UserDAO;

@Controller
@RequestMapping("/login")
public class LoginController {
	private String errmsg = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession sess = request.getSession(false);
		
		if(sess != null && sess.getAttribute("valid_session") == "true") {
			model = new ModelAndView("home");
		} else {
			model = new ModelAndView("login");
			model.addObject("login",  new Login());
		}
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, @ModelAttribute Login login) {
		errmsg = null;
		ModelAndView model = null;
		HttpSession sess = request.getSession(false);
		
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(login.getUserName());
		
		if (userDAO.validatePassword(user.getId(), login.getPassword())) {
			sess.setAttribute("valid_session", "true");
			model = new ModelAndView("welcome");
		} else {
			errmsg = "Invalid login credentials.";
			sess.setAttribute("valid_session", "false");
			model = new ModelAndView("login");
			model.addObject("login", new Login());
			model.addObject("errmsg", errmsg);
		}
		return model;
	}
}
