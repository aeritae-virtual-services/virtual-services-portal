package com.vsportal.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.session.SessionHelper;

@Controller
public class UserController {
	
    @RequestMapping(value = "/user_list", method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request) {
    	HttpSession sess = request.getSession(false);
    	SessionHelper sh = new SessionHelper();
    	
    	ModelAndView model = null;
    	
    	if(!sh.isValidSession(sess)) {
    		model = new ModelAndView("login");
    	} else {
	    	//ArrayList<User> userList = UserDAO.getListByQuery(query);
	    	
	    	model = new ModelAndView("user_list");
	    	//mv.addObject("userList", userList);
    	}
    	
    	return model;
    }
    
    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView displayNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession(false);
    	SessionHelper sh = new SessionHelper();
    	
    	ModelAndView model = null;
    	
    	if(!sh.isValidSession(sess)) {
    		model = new ModelAndView("login");
    	} else {
    		model = new ModelAndView("user_form");
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession(false);
    	SessionHelper sh = new SessionHelper();
    	
    	ModelAndView model = null;
    	
    	if(!sh.isValidSession(sess)) {
    		model = new ModelAndView("login");
    	} else {
    		//TODO Trigger Insert
    		
    		//Redirect to user list
    		model = new ModelAndView("user_list");
    	}
    	
    	return model;
    }
    
    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public ModelAndView displayExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession(false);
    	SessionHelper sh = new SessionHelper();
    	
    	ModelAndView model = null;
    	
    	if(!sh.isValidSession(sess)) {
    		model = new ModelAndView("login");
    	} else {
    		model = new ModelAndView("user_form");
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession(false);
    	SessionHelper sh = new SessionHelper();
    	
    	ModelAndView model = null;
    	
    	if(!sh.isValidSession(sess)) {
    		model = new ModelAndView("login");
    	} else {
    		//TODO Trigger Update
    		
    		//Redirect to user list
    		model = new ModelAndView("user_list");
    	}
    	
    	return model;
    }
}
