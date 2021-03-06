package com.vsportal.approval;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.approval.Approval;
import com.vsportal.approval.ApprovalDAO;
import com.vsportal.client.Client;
import com.vsportal.client.ClientDAO;
import com.vsportal.listdefinition.ListDefinition;
import com.vsportal.listdefinition.ListDefinitionDAO;
import com.vsportal.request.Request;
import com.vsportal.request.RequestDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class ApprovalController {
	
	//Display List For: approval
    @RequestMapping(value = "/approval_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: approval
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
    	//Get Data Access Object for List Information
    	ListDefinitionDAO listDAO = new ListDefinitionDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: Approval
	    	model.addObject("redirectTo", "/approval_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get List information for Session User's Role for: Approval
    		int roleId = userSessionDAO.getSessionUser(sess).getRole().getId();
    		String columnList = "";
    		
    		ArrayList<ListDefinition> ld = listDAO.listQuery("role_id=" + roleId + "^table_nme=Approval", "*");
    		
    		//Sort List by Sequence
	    	Collections.sort(ld);
    		
    		for(ListDefinition li : ld) {
    			columnList += li.getColumnName() + ",";
    		}
    		
    		columnList = columnList.substring(0, columnList.length() - 1);
    		
    		//Get ArrayList From Query For: Approval
	    	ArrayList<Approval> approvalList = approvalDAO.listQuery(query, columnList);
	    	
	    	//Call List View For: Approval
	    	model = new ModelAndView("Approval_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: Approval
	    	model.addObject("recordList", approvalList);
	    	//Pass Column List for View
	    	model.addObject("columnList", ld);
	    	//Pass List Label
	    	model.addObject("label", "Approvals");
	    	//Control List Actions
	    	model.addObject("canCreate", "false");
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Approval
    @RequestMapping(value = "/add_approval", method = RequestMethod.GET)
    public ModelAndView displayNewForm(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Approval
    		model.addObject("redirectTo", "/add_approval");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Approval
    		model = new ModelAndView("approval_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    		
    		/*
    		 * Get All Reference Lists
    		 */
    		
    		//Active Clients
    		ArrayList<Client> clients = new ClientDAO().listQuery("active=true", "id,client_nme");
    		//All Requests
    		ArrayList<Request> requests = new RequestDAO().listQuery("", "id,req_nbr");
    		
    		//Pass Reference Lists
    		model.addObject("client_id_list", clients);
    		model.addObject("request_id_list", requests);
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: approval
    @RequestMapping(value = "/add_approval", method = RequestMethod.POST)
    public ModelAndView submitNewForm(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Approval
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: approval
    		model.addObject("redirectTo", "/add_approval");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Approval
    		
    		//TODO Update Base Object For: Approval
    		
    		//Redirect to home
    		model = new ModelAndView("redirect:/home");
    	}
    	
    	return model;
    }
    
    //Display Update Form For: Approval
    @RequestMapping(value = "/update_approval", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView displayExistingForm(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: approval
    		model.addObject("redirectTo", "/update_approval?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: approval
    		model = new ModelAndView("approval_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    		/*
    		 * Get All Reference Lists
    		 */
    		
    		//Active Clients
    		ArrayList<Client> clients = new ClientDAO().listQuery("active=true", "id,client_nme");
    		//All Requests
    		ArrayList<Request> requests = new RequestDAO().listQuery("", "id,req_nbr");
    		
    		//Pass Reference Lists
    		model.addObject("client_id_list", clients);
    		model.addObject("request_id_list", requests);
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: approval
    @RequestMapping(value = "/update_approval", method = RequestMethod.POST)
    public ModelAndView submitExistingForm(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: approval
    	ApprovalDAO approvalDAO = new ApprovalDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: approval
    		model.addObject("redirectTo", "/update_approval?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Approval
    		
    		//TODO Update Base Object For: Approval
    		
    		//Redirect to list for: Approval
    		//Include standard filter for: Approval
    		model = new ModelAndView("redirect:/approval_list?query=" + userSessionDAO.getUsersFilter("Approval"));
    	}
    	
    	return model;
    }
}
