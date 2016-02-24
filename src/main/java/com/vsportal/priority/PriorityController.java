package com.vsportal.priority;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.priority.Priority;
import com.vsportal.priority.PriorityDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class PriorityController {

	//Display List For: priority
    @RequestMapping(value = "/priority_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Priority
    	PriorityDAO priorityDAO = new PriorityDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: priority
	    	model.addObject("redirectTo", "/priority_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: priority
	    	ArrayList<Priority> priorityList = priorityDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: Priority
		    userSessionDAO.updateUsersFilter("Priority", query);
	    	
	    	//Call List View For: Priority
	    	model = new ModelAndView("priority_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: Priority
	    	model.addObject("priorityList", priorityList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Priority
    @RequestMapping(value = "/add_priority", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: Priority
    		model.addObject("redirectTo", "/add_priority");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: priority
    		model = new ModelAndView("priority_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: priority
    @RequestMapping(value = "/add_priority", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Priority
    	PriorityDAO priorityDAO = new PriorityDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Priority
    		model.addObject("redirectTo", "/add_priority");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: priority
    		
    		//TODO Insert Base Object For: priority
    		
    		//Redirect to list for: priority
    		//Include standard filter for: priority
    		model = new ModelAndView("redirect:/priority_list?query=" + userSessionDAO.getUsersFilter("Priority"));
    	}
    	return model;
    }
    
    //Display Update Form For: priority
    @RequestMapping(value = "/update_priority", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: priority
    		model.addObject("redirectTo", "/update_priority?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: priority
    		model = new ModelAndView("priority_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: priority
    @RequestMapping(value = "/update_priority", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: priority
    	PriorityDAO priorityDAO = new PriorityDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Priority
    		model.addObject("redirectTo", "/update_priority?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: priority
    		
    		//TODO Update Base Object For: priority
    		
    		//Redirect to list for: priority
    		//Include standard filter for: priority
    		model = new ModelAndView("redirect:/priority_list?query=" + userSessionDAO.getUsersFilter("Priority"));
    	}
    	
    	return model;
    }
}