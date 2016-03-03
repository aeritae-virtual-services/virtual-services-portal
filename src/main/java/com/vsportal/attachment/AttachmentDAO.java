package com.vsportal.attachment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class AttachmentDAO {

	public boolean writeFileToServer(MultipartHttpServletRequest request) {
		try {
			Iterator<String> itr = request.getFileNames();
			
			MultipartFile mpf = request.getFile(itr.next());
			
			String filename = mpf.getOriginalFilename();
			String dir = "/system/attachments/";
			String filepath = Paths.get(dir, filename).toString();
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(mpf.getBytes());
			stream.close();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void insertAttachment(Attachment attach) {
		
	}

	public ArrayList<Attachment> getAttachmentListForRequestId(int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

}
