package com.vsportal.user;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; 

@Controller
public class UserController implements Controller {
	
    @RequestMapping("/user_list", method = RequestMethod.GET)
    public ModelAndView listUsers(@RequestParam("query") String query) {
    	ArrayList<User> userList = UserDAO.getListByQuery(query);
    	
    	ModelAndView mv = new ModelAndView("list");
    	mv.addObject("userList", userList);
    	
    	return mv;
    }
    

}
