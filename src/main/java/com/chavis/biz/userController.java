package com.chavis.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.chavis.biz.user.userService;

@Controller
public class userController {

	@Autowired
	userService service;
	
	
}
