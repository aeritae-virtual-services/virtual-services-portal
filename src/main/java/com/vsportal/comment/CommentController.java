package com.vsportal.comment;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/add_comment")
	public @ResponseBody String handleNewComment(@RequestParam("comment") String comment, @RequestParam("pub") String pub) {
		//TODO Save New Comment
		return HttpStatus.OK.toString();
	}

}
