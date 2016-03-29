package com.vsportal.workflow;

import com.vsportal.request.Request;

public class WorkflowProcessor {
	private WorkflowStep prev = new WorkflowStep();
	private WorkflowStep next = new WorkflowStep();
	private String result;
	
	public void initiateWorkflow(Request req){
		String result = "yes";
		WorkflowStep prev = new WorkflowStep();
		
		while (result != "stop"){
			if (prev == null){
				next = new WorkflowStep().getFirstStepByReqType(req.getRequestType());
			}else{
				next = new WorkflowStep().getNextStep(prev);				
			}
			
			if (next != null){
				prev = next;
				result = this.callNextStep(req,next.getID(),null);
			}else{
				result = "stop";	
			}
		}
	}
	
	public String callNextStep(Request req, int stepID, WorkflowLog log){
		WorkflowOperationProcessor wop = new WorkflowOperationProcessor();
		String result = wop.executeOpByID(req, stepID,log);
		
		if (result != "stop"){
			//TODO: write log close
		}
		return result;
	}
	
	public void refreshWorkflow(Request req){
		
		WorkflowLog currentLog = new WorkflowLog();
		currentLog = WorkFlowLogDAO.getCurrentLog(req);
		
		if (currentLog != null){
			while (result != "stop"){
				if (prev == null){
					next = new WorkflowStep().getFirstStepByReqType(req.getRequestType());
				}else{
					next = new WorkflowStep().getNextStep(prev);				
				}
				
				if (next != null){
					prev = next;
					result = this.callNextStep(req,next.getID(),null);
				}else{
					result = "stop";
					
				}
			}
		}
		
	}
}
