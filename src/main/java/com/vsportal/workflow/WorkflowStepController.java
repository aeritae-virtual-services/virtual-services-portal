package com.vsportal.workflow;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.workflow.WorkflowStep;
import com.vsportal.workflow.WorkflowStepDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class WorkflowStepController {

	//Display List For: WorkflowStep
    @RequestMapping(value = "/workflow_step_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: workflowStep
    	WorkflowStepDAO workflowStepDAO = new WorkflowStepDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: WorkflowStep
	    	model.addObject("redirectTo", "/workflow_step_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: WorkflowStep
	    	ArrayList<WorkflowStep> workflowStepList = workflowStepDAO.getListByQuery(query);
		    //Update session user's personalized filter from the provided query for: WorkflowStep
		    userSessionDAO.updateUsersFilter("WorkflowStep", query);
	    	
	    	//Call List View For: WorkflowStep
	    	model = new ModelAndView("workflow_step_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: WorkflowStep
	    	model.addObject("workflowStepList", workflowStepList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: WorkflowStep
    @RequestMapping(value = "/add_workflow_step", method = RequestMethod.GET)
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
    		//Set redirect back to new form for: WorkflowStep
    		model.addObject("redirectTo", "/add_workflow_step");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: WorkflowStep
    		model = new ModelAndView("workflow_step_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: WorkflowStep
    @RequestMapping(value = "/add_workflow_step", method = RequestMethod.POST)
    public ModelAndView insertNewUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: WorkflowStep
    	WorkflowStepDAO workflowStepDAO = new WorkflowStepDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: WorkflowStep
    		model.addObject("redirectTo", "/add_workflow_step");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: WorkflowStep
    		
    		//TODO Insert Base Object For: WorkflowStep
    		
    		//Redirect to list for: WorkflowStep
    		//Include standard filter for: WorkflowStep
    		model = new ModelAndView("redirect:/workflow_step_list?query=" + userSessionDAO.getUsersFilter("WorkflowStep"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: WorkflowStep
    @RequestMapping(value = "/update_workflow_step", params = {"id"}, method = RequestMethod.GET)
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
    		//Set redirect back to existing form for: WorkflowStep
    		model.addObject("redirectTo", "/update_workflow_step?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: WorkflowStep
    		model = new ModelAndView("workflow_step_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: WorkflowStep
    @RequestMapping(value = "/update_workflow_step", method = RequestMethod.POST)
    public ModelAndView updateExistingUser(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: WorkflowStep
    	WorkflowStepDAO workflowStepDAO = new WorkflowStepDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: WorkflowStep
    		model.addObject("redirectTo", "/update_workflow_step?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: WorkflowStep
    		
    		//TODO Update Base Object For: WorkflowStep
    		
    		//Redirect to list for: WorkflowStep
    		//Include standard filter for: WorkflowStep
    		model = new ModelAndView("redirect:/workflow_step_list?query=" + userSessionDAO.getUsersFilter("WorkflowStep"));
    	}
    	
    	return model;
    }
}