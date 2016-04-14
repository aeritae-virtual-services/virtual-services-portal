package com.vsportal.email;

import com.vsportal.request.Request;
import com.vsportal.task.Task;
public class EmailTemplateProcessor {
	public void runTemplate(int id, Request request){
		EmailTemplate emailTemplate = new EmailTemplateDAO().recordQuery("id="+id, "*");
	}
	public void runTemplate(int id, Task task){
		EmailTemplate emailTemplate = new EmailTemplateDAO().recordQuery("id="+id, "*");
	}
}
