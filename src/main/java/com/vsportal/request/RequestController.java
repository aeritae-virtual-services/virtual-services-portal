package com.vsportal.request;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.vsportal.priority.Priority;
import com.vsportal.request.Request;
import com.vsportal.request.RequestDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.DropdownOption;
import com.vsportal.utils.SessionHelper;

@Controller
public class RequestController {

	//Display List For: request
    @RequestMapping(value = "/request_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: request
    	RequestDAO requestDAO = new RequestDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: request
	    	model.addObject("redirectTo", "/request_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: request
	    	ArrayList<Request> requestList = requestDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: request
		    userSessionDAO.updateUsersFilter("Request", query);
	    	
	    	//Call List View For: request
	    	model = new ModelAndView("request_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: request
	    	model.addObject("requestList", requestList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Request
    @RequestMapping(value = "/add_request", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: Request
    		model.addObject("redirectTo", "/add_request");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: request
    		model = new ModelAndView("request_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: request
    @RequestMapping(value = "/add_request", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: request
    	RequestDAO requestDAO = new RequestDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: request
    		model.addObject("redirectTo", "/add_request");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: request
    		
    		//TODO Insert Base Object For: request
    		
    		//Redirect to list for: request
    		//Include standard filter for: request
    		model = new ModelAndView("redirect:/request_list?query=" + userSessionDAO.getUsersFilter("Request"));
    	}
    	return model;
    }
    
    //Display Update Form For: request
    @RequestMapping(value = "/update_request", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView displayExistingUser(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	//UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	/*if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: request
    		model.addObject("redirectTo", "/update_request?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {*/
    		//Call Form View For: request
    		model = new ModelAndView("request_form");
    		//Pass session user to View
	    	//model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    		
    		//Add Priorities list
    		ArrayList<DropdownOption> prioritiesList = new ArrayList<DropdownOption>();
    		
    		Priority p1 = new Priority("Critical", 1);
    		Priority p2 = new Priority("High", 2);
    		Priority p3 = new Priority("Medium", 3);
    		Priority p4 = new Priority("Low", 4);
    		
    		prioritiesList.add(p1.getDropdownOption());
    		prioritiesList.add(p2.getDropdownOption());
    		prioritiesList.add(p3.getDropdownOption());
    		prioritiesList.add(p4.getDropdownOption());
    		
    		model.addObject("prioritiesList", prioritiesList);
    		
    		//Add Request Type list
    		ArrayList<DropdownOption> requestTypeList = new ArrayList<DropdownOption>();
    		
    		RequestType inc = new RequestType();
    		inc.setId(0);
    		inc.setName("Incident");
    		
    		RequestType dev = new RequestType();
    		dev.setId(1);
    		dev.setName("Development");
    		
    		RequestType adv = new RequestType();
    		adv.setId(2);
    		adv.setName("Advisory");
    		
    		requestTypeList.add(inc.getDropdownOption());
    		requestTypeList.add(dev.getDropdownOption());
    		requestTypeList.add(adv.getDropdownOption());
    		
    		model.addObject("requestTypeList", requestTypeList);
    		
    	//}
    	
    	return model;
    }
    
    //Submit Update Form For: request
    @RequestMapping(value = "/update_request", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: request
    	RequestDAO requestDAO = new RequestDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Request
    		model.addObject("redirectTo", "/update_request?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: request
    		
    		//TODO Update Base Object For: request
    		
    		//Redirect to list for: request
    		//Include standard filter for: request
    		model = new ModelAndView("redirect:/request_list?query=" + userSessionDAO.getUsersFilter("Request"));
    	}
    	
    	return model;
    }
}