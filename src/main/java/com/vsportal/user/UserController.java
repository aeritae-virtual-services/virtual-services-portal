package com.vsportal.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.client.Client;
import com.vsportal.client.ClientDAO;
import com.vsportal.role.Role;
import com.vsportal.role.RoleDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class UserController {
	
	//Display List For: User
    @RequestMapping(value = "/user_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: User
    	UserDAO userDAO = new UserDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: User
	    	model.addObject("redirectTo", "/user_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: User
	    	ArrayList<User> userList = userDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: User
		    userSessionDAO.updateUsersFilter("User", query);
	    	
	    	//Call List View For: User
	    	model = new ModelAndView("user_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: User
	    	model.addObject("userList", userList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: User
    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView displayNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	//UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	/*if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: User
    		model.addObject("redirectTo", "/add_user");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {*/
    		//Call Form View For: User
    		model = new ModelAndView("user_form");
    		//Pass session user to View
	    	//model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	//}
    	
    	return model;
    }
    
    //Submit Add Form For: User
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: User
    	UserDAO userDAO = new UserDAO();
    	
    	//Get Data Access Object For Client
    	ClientDAO clientDAO = new ClientDAO();
    	
    	//Get Data Access Object For Role
    	RoleDAO roleDAO = new RoleDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: User
    		model.addObject("redirectTo", "/add_user");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//Get All Attributes From Form
    		String username = request.getParameter("username");
    		String firstName = request.getParameter("first_name");
    		String lastName = request.getParameter("last_name");
    		String phone = request.getParameter("phone");
    		String email = request.getParameter("email");
    		String password = request.getParameter("password");
    		User createdBy = userSessionDAO.getSessionUser(sess);
    		User updatedBy = userSessionDAO.getSessionUser(sess);
    		Client client = clientDAO.getClientById(Integer.parseInt(request.getParameter("client")));
    		Role role = roleDAO.getRoleById(Integer.parseInt(request.getParameter("role")));
    		
    		//Populate Object with Attributes For: User
    		User newUser = new User(username, firstName, lastName, phone, email, client, role, createdBy, updatedBy);
    		
    		//Insert Base Object For: User
    		userDAO.insertUser(newUser, password);
    		
    		//Redirect to list for: User
    		//Include standard filter for: User
    		model = new ModelAndView("redirect:/user_list?query=" + userSessionDAO.getUsersFilter("User"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: User
    @RequestMapping(value = "/update_user", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView displayExistingUser(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get User Data Access Object for: User
    	UserDAO userDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: User
    		model.addObject("redirectTo", "/update_user?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: User
    		model = new ModelAndView("user_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    		//Pass Requested: User
    		model.addObject("user", userDAO.getUserById(id));
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: User
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: User
    	UserDAO userDAO = new UserDAO();
    	
    	//Get Data Access Object For Client
    	ClientDAO clientDAO = new ClientDAO();
    	
    	//Get Data Access Object For Role
    	RoleDAO roleDAO = new RoleDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: User
    		model.addObject("redirectTo", "/update_user?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//Get All Attributes From Form
    		String username = request.getParameter("username");
    		String firstName = request.getParameter("first_name");
    		String lastName = request.getParameter("last_name");
    		String phone = request.getParameter("phone");
    		String email = request.getParameter("email");
    		User createdBy = userSessionDAO.getSessionUser(sess);
    		User updatedBy = userSessionDAO.getSessionUser(sess);
    		Client client = clientDAO.getClientById(Integer.parseInt(request.getParameter("client")));
    		Role role = roleDAO.getRoleById(Integer.parseInt(request.getParameter("role")));
    		
    		//Populate Object with Attributes For: User
    		User updateUser = new User(username, firstName, lastName, phone, email, client, role, createdBy, updatedBy);
    		updateUser.setId(Integer.parseInt(request.getParameter("id")));
    		
    		//Update Base Object For: User
    		userDAO.updateUser(updateUser);
    		
    		//Redirect to list for: User
    		//Include standard filter for: User
    		model = new ModelAndView("redirect:/user_list?query=" + userSessionDAO.getUsersFilter("User"));
    	}
    	
    	return model;
    }
}
