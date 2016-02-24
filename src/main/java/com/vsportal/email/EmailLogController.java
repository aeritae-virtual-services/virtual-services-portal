package com.vsportal.email;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.email.EmailLog;
import com.vsportal.email.EmailLogDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class EmailLogController {

	//Display List For: EmailLog
    @RequestMapping(value = "/emailLog_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailLog
    	EmailLogDAO emailLogDAO = new EmailLogDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: EmailLog
	    	model.addObject("redirectTo", "/emailLog_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: EmailLog
	    	ArrayList<EmailLog> emailLogList = emailLogDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: EmailLog
		    userSessionDAO.updateUsersFilter("EmailLog", query);
	    	
	    	//Call List View For: EmailLog
	    	model = new ModelAndView("emailLog_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: EmailLog
	    	model.addObject("emailLogList", emailLogList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: EmailLog
    @RequestMapping(value = "/add_emailLog", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: EmailLog
    		model.addObject("redirectTo", "/add_emailLog");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: EmailLog
    		model = new ModelAndView("emailLog_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: EmailLog
    @RequestMapping(value = "/add_emailLog", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailLog
    	EmailLogDAO emailLogDAO = new EmailLogDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: EmailLog
    		model.addObject("redirectTo", "/add_emailLog");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: EmailLog
    		
    		//TODO Insert Base Object For: EmailLog
    		
    		//Redirect to list for: EmailLog
    		//Include standard filter for: EmailLog
    		model = new ModelAndView("redirect:/emailLog_list?query=" + userSessionDAO.getUsersFilter("EmailLog"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: EmailLog
    @RequestMapping(value = "/update_emailLog", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: EmailLog
    		model.addObject("redirectTo", "/update_emailLog?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: emailLog
    		model = new ModelAndView("emailLog_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: EmailLog
    @RequestMapping(value = "/update_emailLog", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: EmailLog
    	EmailLogDAO emailLogDAO = new EmailLogDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: EmailLog
    		model.addObject("redirectTo", "/update_emailLog?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: EmailLog
    		
    		//TODO Update Base Object For: EmailLog
    		
    		//Redirect to list for: EmailLog
    		//Include standard filter for: EmailLog
    		model = new ModelAndView("redirect:/emailLog_list?query=" + userSessionDAO.getUsersFilter("EmailLog"));
    	}
    	
    	return model;
    }
}