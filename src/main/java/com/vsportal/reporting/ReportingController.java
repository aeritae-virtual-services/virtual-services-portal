package com.vsportal.reporting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportingController {
	@RequestMapping("/hours_report")
	public ModelAndView hoursReport() {
		return null;
	}
}
