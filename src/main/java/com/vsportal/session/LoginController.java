package com.vsportal.session;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.Map;

import com.vsportal.session.*;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		Login login = new Login();
		model.put("login", login);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login login, BindingResult result, Map Model) {
		String username = "username";
		String password = "password";
		
		if(result.hasErrors()) {
			return "login";
		}
		
		login = (Login) model.get("login");
		
		if(!login.getUsername().equals(username) || )
	}
}
