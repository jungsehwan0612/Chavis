package com.chavis.biz.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.chavis.biz.user.service.userService;

@Controller
public class userController {

	@Autowired
	userService service;
	
	
}
