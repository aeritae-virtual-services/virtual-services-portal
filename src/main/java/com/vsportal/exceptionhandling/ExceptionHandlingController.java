package com.vsportal.exceptionhandling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlingController {
	
	@RequestMapping("error")
	public ModelAndView handleError(HttpServletRequest req, HttpServletResponse resp) {
		String statusCode = req.getAttribute("javax.servlet.error.status_code").toString();
		
		String message = req.getAttribute("javax.servlet.error.message").toString();
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("status_code", statusCode);
		mv.addObject("message", message);
		return mv;
	}
	
}
