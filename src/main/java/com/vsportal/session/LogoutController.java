package com.vsportal.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession sess = request.getSession(false);
		
		//If session exists, log out user
		if(sess != null && sess.getAttribute("valid_session") == "true") {
			sess.setAttribute("valid_session", "false");
			sess.invalidate();
		}
		
		//Redirect to login page
		model = new ModelAndView("login");
		model.addObject("login", new Login());
		return model;
	}
}
