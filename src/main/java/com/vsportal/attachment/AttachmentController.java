package com.vsportal.attachment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class AttachmentController {

	@RequestMapping(method = RequestMethod.POST, value = "/upload_attachment")
	public @ResponseBody String handleFileUpload(MultipartHttpServletRequest request) {
		try {
			Iterator<String> itr = request.getFileNames();
			
			MultipartFile mpf = request.getFile(itr.next());
			
			String filename = mpf.getOriginalFilename();
			String dir = "/system/attachments/";
			String filepath = Paths.get(dir, filename).toString();
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(mpf.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return HttpStatus.BAD_REQUEST.toString();
		}
		
		return HttpStatus.OK.toString();
	}
}
