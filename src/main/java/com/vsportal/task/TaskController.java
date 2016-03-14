package com.vsportal.task;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.task.Task;
import com.vsportal.task.TaskDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class TaskController {
	
	//Display List For: Task
    @RequestMapping(value = "/task_list", params = {"query"}, method = RequestMethod.GET)
    public ModelAndView displayList(HttpServletRequest request, @RequestParam(value = "query") String query) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Task
    	TaskDAO taskDAO = new TaskDAO();
    	
    	//Validate Session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to list for: Task
	    	model.addObject("redirectTo", "/task_list?query=" + query);
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Get ArrayList From Query For: Task
	    	ArrayList<Task> taskList = taskDAO.listQuery(query);
		    //Update session user's personalized filter from the provided query for: Task
		    userSessionDAO.updateUsersFilter("Task", query);
	    	
	    	//Call List View For: Task
	    	model = new ModelAndView("task_list");
	    	//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass ArrayList to View For: Task
	    	model.addObject("taskList", taskList);
    	}
    	
    	return model;
    }
    
    //Display Add Form For: Task
    @RequestMapping(value = "/add_task", method = RequestMethod.GET)
    public ModelAndView displayNewTask(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Task
    		model.addObject("redirectTo", "/add_task");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Task
    		model = new ModelAndView("task_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
    		//Pass Operation of New
    		model.addObject("operation", "new");
    	}
    	
    	return model;
    }
    
    //Submit Add Form For: Task
    @RequestMapping(value = "/add_task", method = RequestMethod.POST)
    public ModelAndView insertNewTask(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Task
    	TaskDAO taskDAO = new TaskDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to new form for: Task
    		model.addObject("redirectTo", "/add_task");
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not created.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Task
    		
    		//TODO Insert Base Object For: Task
    		
    		//Redirect to list for: Task
    		//Include standard filter for: Task
    		model = new ModelAndView("redirect:/task_list?query=" + userSessionDAO.getUsersFilter("Task"));
    	}
    	
    	return model;
    }
    
    //Display Update Form For: Task
    @RequestMapping(value = "/update_task", params = {"id"}, method = RequestMethod.GET)
    public ModelAndView displayExistingTask(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Validate session
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Task
    		model.addObject("redirectTo", "/update_task?id=" +  id.toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: Please log in.");
    	} else {
    		//Call Form View For: Task
    		model = new ModelAndView("task_form");
    		//Pass session user to View
	    	model.addObject("sessionUser", userSessionDAO.getSessionUser(sess));
	    	//Pass Operation of Update
    		model.addObject("operation", "update");
    	}
    	
    	return model;
    }
    
    //Submit Update Form For: Task
    @RequestMapping(value = "/update_task", method = RequestMethod.POST)
    public ModelAndView updateExistingTask(HttpServletRequest request) {
    	HttpSession sess = request.getSession();
    	SessionHelper sh = new SessionHelper();
    	ModelAndView model = null;
    	
    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Task
    	TaskDAO taskDAO = new TaskDAO();
    	
    	if(!sh.isValidSession(sess)) {
    		//If invalid session, redirect to login page
    		model = new ModelAndView("login");
    		//Set redirect back to existing form for: Task
    		model.addObject("redirectTo", "/update_task?id=" +  request.getParameter("id").toString());
    		//Error Message: Invalid session
    		model.addObject("errmsg", "Invalid Session: User record not updated.");
    	} else {
    		//TODO Get All Attributes From Form
    		
    		//TODO Populate Object with Attributes For: Task
    		
    		//TODO Update Base Object For: Task
    		
    		//Redirect to list for: Task
    		//Include standard filter for: Task
    		model = new ModelAndView("redirect:/task_list?query=" + userSessionDAO.getUsersFilter("Task"));
    	}
    	
    	return model;
    }
    
    //Accept Poke
    @RequestMapping(method = RequestMethod.POST, value = "/accept_poke")
	public @ResponseBody String acceptPoke(HttpServletRequest request, @RequestParam("task_id") String taskId) {
    	//Task Data Access Object
    	TaskDAO taskDAO = new TaskDAO();
    	
    	Task thisTask = taskDAO.recordQuery("id=" + taskId);
    	thisTask.setAssignedTo(thisTask.getPokedAnalyst());
    	thisTask.setPokedAnalyst(null);
    	thisTask.setPokedBy(null);
    	thisTask.setPokedDate(null);
    	
    	taskDAO.update(thisTask);
    	
		return HttpStatus.OK.toString();
	}
    
  //Decline Poke
    @RequestMapping(method = RequestMethod.POST, value = "/decline_poke")
	public @ResponseBody String declinePoke(@RequestParam("task_id") String taskId) {
    	//Task Data Access Object
    	TaskDAO taskDAO = new TaskDAO();
    	
    	Task thisTask = taskDAO.recordQuery("id=" + taskId);
    	thisTask.setAssignedTo(null);
    	thisTask.setPokedAnalyst(null);
    	thisTask.setPokedBy(null);
    	thisTask.setPokedDate(null);
    	
    	taskDAO.update(thisTask);
    	
		return HttpStatus.OK.toString();
	}
}