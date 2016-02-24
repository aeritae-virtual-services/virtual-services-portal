package com.vsportal.email;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.email.EmailTemplate;
import com.vsportal.email.EmailTemplateDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class EmailTemplateController {

	//Display List For: EmailTemplate
    @RequestMapping(value = "/emailTemplate_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailTemplate
    	EmailTemplateDAO emailTemplateDAO = new EmailTemplateDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: EmailTemplate
	    	model.addObject("redirectTo", "/emailTemplate_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: EmailTemplate
	    	ArrayList<EmailTemplate> emailTemplateList = emailTemplateDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: EmailTemplate
		    userSessionDAO.updateUsersFilter("EmailTemplate", query);
	    	
	    	//Call List View For: EmailTempate
	    	model = new ModelAndView("emailTemplate_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: EmailTemplate
	    	model.addObject("emailTemplateList", emailTemplateList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: EmailTemplate
    @RequestMapping(value = "/add_emailTemplate", method = RequestMethod.GET)
    public ModelAndView displayNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: EmailTemplate
    		model.addObject("redirectTo", "/add_emailTemplate");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: EmailTemplate
    		model = new ModelAndView("emailTemplate_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: EmailTemplate
    @RequestMapping(value = "/add_emailTemplate", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailTemplate
    	EmailTemplateDAO emailTemplateDAO = new EmailTemplateDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: EmailTemplate
    		model.addObject("redirectTo", "/add_emailTemplate");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: EmailTemplate
    		
    		//TODO Insert Base Object For: EmailTemplate
    		
    		//Redirect to list for: EmailTemplate
    		//Include standard filter for: EmailTemplate
    		model = new ModelAndView("redirect:/emailTemplate_list?query=" + userSessionDAO.getUsersFilter("EmailTemplate"));
    	}
    	return model;
    }
    
    //Display Update Form For: EmailTemplate
    @RequestMapping(value = "/update_emailTemplate", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView displayExistingUser(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: EmailTemplate
    		model.addObject("redirectTo", "/update_emailTemplate?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: emailTemplate
    		model = new ModelAndView("emailTemplate_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: EmailTemplate
    @RequestMapping(value = "/update_emailTemplate", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailTemplate
    	EmailTemplateDAO emailTemplateDAO = new EmailTemplateDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: EmailTemplate
    		model.addObject("redirectTo", "/update_emailTemplate?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: EmailTemplate
    		
    		//TODO Update Base Object For: EmailTemplate
    		
    		//Redirect to list for: EmailTemplate
    		//Include standard filter for: EmailTemplate
    		model = new ModelAndView("redirect:/emailTemplate_list?query=" + userSessionDAO.getUsersFilter("EmailTemplate"));
    	}
    	
    	return model;
    }
}