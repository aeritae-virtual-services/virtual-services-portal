package com.vsportal.client;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.user.User;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class ClientController {
	
	//Display List For: Client
    @RequestMapping(value = "/client_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Client
    	ClientDAO clientDAO = new ClientDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: Client
	    	model.addObject("redirectTo", "/client_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: Client
	    	ArrayList<Client> clientList = clientDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: Client
		    userSessionDAO.updateUsersFilter("Client", query);
	    	
	    	//Call List View For: Client
	    	model = new ModelAndView("client_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: Client
	    	model.addObject("clientList", clientList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Client
    @RequestMapping(value = "/add_client", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: Client
    		model.addObject("redirectTo", "/add_client");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Client
    		model = new ModelAndView("client_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: Client
    @RequestMapping(value = "/add_client", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Client
    	ClientDAO clientDAO = new ClientDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Client
    		model.addObject("redirectTo", "/add_client");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Client
    		
    		//TODO Insert Base Object For: Client
    		
    		//Redirect to list for: Client
    		//Include standard filter for: Client
    		model = new ModelAndView("redirect:/client_list?query=" + userSessionDAO.getUsersFilter("Client"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: Client
    @RequestMapping(value = "/update_client", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: Client
    		model.addObject("redirectTo", "/update_client?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Client
    		model = new ModelAndView("client_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: Client
    @RequestMapping(value = "/update_client", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Client
    	ClientDAO clientDAO = new ClientDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Client
    		model.addObject("redirectTo", "/update_client?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Client
    		
    		//TODO Update Base Object For: Client
    		
    		//Redirect to list for: Client
    		//Include standard filter for: Client
    		model = new ModelAndView("redirect:/client_list?query=" + userSessionDAO.getUsersFilter("Client"));
    	}
    	
    	return model;
    }
}
