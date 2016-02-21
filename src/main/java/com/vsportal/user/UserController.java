package com.vsportal.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
    @RequestMapping(value = "/user_list", method = RequestMethod.GET)
    public ModelAndView displayList() {
    	//ArrayList<User> userList = UserDAO.getListByQuery(query);
    	
    	ModelAndView mv = new ModelAndView("list");
    	//mv.addObject("userList", userList);
    	
    	return mv;
    }
    
    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public ModelAndView displayNewUser() {
    	//ArrayList<User> userList = UserDAO.getListByQuery(query);
    	
    	ModelAndView mv = new ModelAndView("list");
    	//mv.addObject("userList", userList);
    	
    	return mv;
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView displayExistingUser() {
    	//ArrayList<User> userList = UserDAO.getListByQuery(query);
    	
    	ModelAndView mv = new ModelAndView("list");
    	//mv.addObject("userList", userList);
    	
    	return mv;
    }

}
