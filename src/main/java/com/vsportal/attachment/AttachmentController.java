package com.vsportal.attachment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.vsportal.request.RequestDAO;
import com.vsportal.user.UserDAO;
import com.vsportal.utils.SessionHelper;

@Controller
public class AttachmentController {

	@RequestMapping(method = RequestMethod.POST, value = "/upload_attachment")
	public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request) {
		HttpSession sess = request.getSession();

    	//Get User Data Access Object to Manage Session User
    	UserDAO userSessionDAO = new UserDAO();
    	
    	//Get Data Access Object For: Attachment
    	AttachmentDAO attachDAO = new AttachmentDAO();
    	
    	//Get Data Access Object For Request
    	RequestDAO requestDAO = new RequestDAO();
		
		//TODO Create Attachment Object
		Attachment attach = new Attachment(userSessionDAO.getSessionUser(sess), userSessionDAO.getSessionUser(sess),
				requestDAO.getRequestById(Integer.parseInt(request.getParameter("request_id"))), "test", null);
		
		//Write Attachment To File
		boolean success = attachDAO.writeFileToServer(request);
		
		if(success) {
			return HttpStatus.BAD_REQUEST.toString();
		} else {
			//Save Attachment Record to Database
			attachDAO.insertAttachment(attach);
			//Get All Attachments for this Request
			ArrayList<Attachment> attachmentsList = attachDAO.getAttachmentListForRequestId(Integer.parseInt(request.getParameter("request_id")));
			
			return HttpStatus.OK.toString();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/delete_attachment")
	public @ResponseBody String handleFileDeletion(@RequestParam("fileId") String id) {
		//Get Data Access Object For: Attachment
    	AttachmentDAO attachDAO = new AttachmentDAO();
    	
    	attachDAO.deleteRecord(id);
		
		return HttpStatus.OK.toString();
	}
}
