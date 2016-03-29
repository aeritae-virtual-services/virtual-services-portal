package com.vsportal.workflow;

import java.sql.Date;

import com.vsportal.approval.Approval;
import com.vsportal.client.Client;
import com.vsportal.group.Group;
import com.vsportal.request.Request;
import com.vsportal.status.Status;
import com.vsportal.task.Task;
import com.vsportal.task.TaskType;
import com.vsportal.user.User;

public class WorkflowOperationProcessor {

	public String executeOpByID(Request req, int stepID, WorkflowLog log) {
		
		WorkflowStep step = new WorkflowStepDAO().getStepByID(stepID);
		
		if (step.getOperationID() == 1){
			//Generate Task
			return generateTask(req,step,log);
		}else if (step.getOperationID() == 2){
			//Evaluate Condition
			return evaluateCondition();
		}else if (step.getOperationID() == 3){
			//Sets Status Value
			return setStatusValue(req, step.getNewStatus());
			
		}else if (step.getOperationID() == 4){
			//Send Notification
			return sendNotification();
			
		} else if (step.getOperationID() == 5){
			//Generate Approval
			return generateApproval();
		}else{
			return "";
		}
		
		
	}

	private String generateTask(Request req, WorkflowStep step, WorkflowLog log) {
		// create new task for request
		if (log.getProgress() == 0){
			log.setProgress(log.getProgress()++);
		}
		Task newTask = new Task(null, null, null, null, null, req,
				req.getAssignmentGroup(), null, step.getInstuctions(), req.getStatus(),
				new String("number"), step.getType());
		
		//TODO: generate email notification
		sendNotification();
		return "stop";
	}

	private String evaluateCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	private String setStatusValue(Request req, Status status) {
		req.setStatus(status);
		//TODO: generate email notification
		sendNotification();
		return "stop";
	}

	private String sendNotification() {
		// TODO Auto-generated method stub
		return null;
	}

	private String generateApproval(Request req) {
		Approval newApproval = new Approval(null, String displayValue, null, null, null, 
				null, req.getClient(), null, req.getRequester(), req, 
				String description, null, String approvalType);
		
		return "stop";
	}

	

}
