package com.vsportal.workflow;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.workflow.WorkflowOperation;
import com.vsportal.workflow.WorkflowOperationDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class WorkflowOperationController {

	//Display List For: WorkflowOperation
    @RequestMapping(value = "/workflow_operation_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: WorkflowOperation
    	WorkflowOperationDAO workflowOperationDAO = new WorkflowOperationDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: WorkflowOperaration
	    	model.addObject("redirectTo", "/workflow_operation_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: workflowOperation
	    	ArrayList<WorkflowOperation> workflowOperationList = WorkflowOperationDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: WorkflowOperation
		    userSessionDAO.updateUsersFilter("WorkflowOperation", query);
	    	
	    	//Call List View For: WorkflowOperation
	    	model = new ModelAndView("workflow_operation_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: workflowOperation
	    	model.addObject("workflowOperationList", workflowOperationList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: WorkflowOperation
    @RequestMapping(value = "/add_workflow_operation", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: WorkflowOperation
    		model.addObject("redirectTo", "/add_workflow_operation");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: WorkflowOperation
    		model = new ModelAndView("workflow_operation_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: WorkflowOperation
    @RequestMapping(value = "/add_workflow_operation", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: WorkflowOperation
    	WorkflowOperationDAO workflowOperationDAO = new WorkflowOperationDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: WorkflowOperation
    		model.addObject("redirectTo", "/add_workflow_operation");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: workflowOperation
    		
    		//TODO Insert Base Object For: workflowOperation
    		
    		//Redirect to list for: workflowOperation
    		//Include standard filter for: workflowOperation
    		model = new ModelAndView("redirect:/workflow_operation_list?query=" + userSessionDAO.getUsersFilter("WorkflowOperation"));
    	}
    	return model;
    }
    
    //Display Update Form For: workflowOperation
    @RequestMapping(value = "/update_workflow_operation", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: workflowOperation
    		model.addObject("redirectTo", "/update_workflow_operation?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: WorkflowOperation
    		model = new ModelAndView("workflow_operation_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: workflowOperation
    @RequestMapping(value = "/update_workflow_operation", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: workflowOperation
    	WorkflowOperationDAO workflowOperationDAO = new WorkflowOperationDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: workFlowOperation
    		model.addObject("redirectTo", "/update_workflow_operation?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: workflowOperation
    		
    		//TODO Update Base Object For: workflowOperation
    		
    		//Redirect to list for: workflowOperation
    		//Include standard filter for: workflowOperation
    		model = new ModelAndView("redirect:/workflow_operation_list?query=" + userSessionDAO.getUsersFilter("WorkflowOperation"));
    	}
    	
    	return model;
    }
}