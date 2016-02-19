package com.vsportal.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user_list")
public class UserController {
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listUsers() {
    	//ArrayList<User> userList = UserDAO.getListByQuery(query);
    	
    	ModelAndView mv = new ModelAndView("list");
    	//mv.addObject("userList", userList);
    	
    	return mv;
    }
    

}
