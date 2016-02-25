package com.vsportal.request;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.request.RequestType;
import com.vsportal.request.RequestTypeDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class RequestTypeController {

	//Display List For: RequestType
    @RequestMapping(value = "/request_type_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: RequestType
    	RequestTypeDAO requestTypeDAO = new RequestTypeDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: RequestType
	    	model.addObject("redirectTo", "/request_type_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: RequestType
	    	ArrayList<RequestType> requestTypeList = RequestTypeDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: RequestType
		    userSessionDAO.updateUsersFilter("RequestType", query);
	    	
	    	//Call List View For: RequestType
	    	model = new ModelAndView("request_type_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: RequestType
	    	model.addObject("requestTypeList", requestTypeList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: RequestType
    @RequestMapping(value = "/add_request_type", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: RequestType
    		model.addObject("redirectTo", "/add_request_type");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: RequestType
    		model = new ModelAndView("request_type_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: RequestType
    @RequestMapping(value = "/add_request_type", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: requestType
    	RequestTypeDAO requestTypeDAO = new RequestTypeDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: RequestType
    		model.addObject("redirectTo", "/add_request_type");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: RequestType
    		
    		//TODO Insert Base Object For: RequestType
    		
    		//Redirect to list for: RequestType
    		//Include standard filter for: RequestType
    		model = new ModelAndView("redirect:/request_type_list?query=" + userSessionDAO.getUsersFilter("RequestType"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: RequestType
    @RequestMapping(value = "/update_request_type", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: RequestType
    		model.addObject("redirectTo", "/update_request_type?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: requestType
    		model = new ModelAndView("request_type_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: RequestType
    @RequestMapping(value = "/update_request_type", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: RequestType
    	RequestTypeDAO requestTypeDAO = new RequestTypeDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: RequestType
    		model.addObject("redirectTo", "/update_request_type?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: RequestType
    		
    		//TODO Update Base Object For: RequestType
    		
    		//Redirect to list for: RequestType
    		//Include standard filter for: RequestType
    		model = new ModelAndView("redirect:/request_type_list?query=" + userSessionDAO.getUsersFilter("RequestType"));
    	}
    	
    	return model;
    }
}