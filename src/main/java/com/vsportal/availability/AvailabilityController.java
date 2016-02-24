package com.vsportal.availability;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.availability.Availability;
import com.vsportal.availability.AvailabilityDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class AvailabilityController {

	//Display List For: Availability
    @RequestMapping(value = "/availability_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Availability
    	AvailabilityDAO availabilityDAO = new AvailabilityDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: availability
	    	model.addObject("redirectTo", "/availability_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: Availability
	    	ArrayList<Availability> availabilityList = availabilityDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: Availability
		    userSessionDAO.updateUsersFilter("Availability", query);
	    	
	    	//Call List View For: Availability
	    	model = new ModelAndView("availability_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: Availability
	    	model.addObject("availabilityList", availabilityList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: availability
    @RequestMapping(value = "/add_availabilityt", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: availability
    		model.addObject("redirectTo", "/add_availability");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: availability
    		model = new ModelAndView("availability_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: availability
    @RequestMapping(value = "/add_availability", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: availability
    	AvailabilityDAO availabilityDAO = new AvailabilityDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: availability
    		model.addObject("redirectTo", "/add_availability");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: availability
    		
    		//TODO Insert Base Object For: availability
    		
    		//Redirect to list for: availability
    		//Include standard filter for: availability
    		model = new ModelAndView("redirect:/availability_list?query=" + userSessionDAO.getUsersFilter("Availability"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: availability
    @RequestMapping(value = "/update_availability", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: availability
    		model.addObject("redirectTo", "/update_availability?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: availability
    		model = new ModelAndView("availability_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: availability
    @RequestMapping(value = "/update_availability", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: availability
    	AvailabilityDAO availabilityDAO = new AvailabilityDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: availability
    		model.addObject("redirectTo", "/update_availability?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: availability
    		
    		//TODO Update Base Object For: availability
    		
    		//Redirect to list for: availability
    		//Include standard filter for: availability
    		model = new ModelAndView("redirect:/availability_list?query=" + userSessionDAO.getUsersFilter("Availability"));
    	}
    	
    	return model;
    }
}
