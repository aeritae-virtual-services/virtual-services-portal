package com.vsportal.tier;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.tier.Tier;
import com.vsportal.tier.TierDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class TierController {

	//Display List For: Tier
    @RequestMapping(value = "/tier_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Tier
    	TierDAO tierDAO = new TierDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: Tier
	    	model.addObject("redirectTo", "/tier_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: Tier
	    	ArrayList<Tier> tierList = tierDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: Tier
		    userSessionDAO.updateUsersFilter("Tier", query);
	    	
	    	//Call List View For: Tier
	    	model = new ModelAndView("tier_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: tier
	    	model.addObject("tierList", tierList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Tier
    @RequestMapping(value = "/add_tier", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: Tier
    		model.addObject("redirectTo", "/add_tier");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Tier
    		model = new ModelAndView("tier_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: Tier
    @RequestMapping(value = "/add_tier", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Tier
    	TierDAO tierDAO = new TierDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Tier
    		model.addObject("redirectTo", "/add_tier");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Tier
    		
    		//TODO Insert Base Object For: Tier
    		
    		//Redirect to list for: Tier
    		//Include standard filter for: Tier
    		model = new ModelAndView("redirect:/tier_list?query=" + userSessionDAO.getUsersFilter("Tier"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: Tier
    @RequestMapping(value = "/update_tier", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: Tier
    		model.addObject("redirectTo", "/update_tier?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Tier
    		model = new ModelAndView("tier_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: Tier
    @RequestMapping(value = "/update_tier", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Tier
    	TierDAO tierDAO = new TierDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Tier
    		model.addObject("redirectTo", "/update_tier?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Tier
    		
    		//TODO Update Base Object For: Tier
    		
    		//Redirect to list for: Tier
    		//Include standard filter for: Tier
    		model = new ModelAndView("redirect:/tier_list?query=" + userSessionDAO.getUsersFilter("Tier"));
    	}
    	
    	return model;
    }
}