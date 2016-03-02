package com.vsportal.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.utils.SessionHelper;

@Controller
@RequestMapping("/home")
public class HomepageController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request) {
		ModelAndView model = null;
		HttpSession sess = request.getSession();
		SessionHelper sh = new SessionHelper();
		
		//if(sh.isValidSession(sess)) {
		//	model = new ModelAndView("home");
		//} else {
		//	model = new ModelAndView("login");
		//	sess.setAttribute("valid_session", "false");
		//}
		
		model = new ModelAndView("home");
		return model;
	}
}
