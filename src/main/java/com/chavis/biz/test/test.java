package com.chavis.biz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.user.service.userService;
import com.chavis.biz.user.vo.userVO;


public class test {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		userService userService = (userService) context.getBean("userservice");
		userVO user = new userVO();
		user.setClientNum("1");
		user.setCarId("11가1111");
		user.setCarType("pororo");
		user.setClientId("test01");
		user.setClientName("테스트");
		user.setPassword("1234");
		user.setTel("010-1234-5678");
		
		userService.addUser(user);	
		
		
		System.out.println(userService.getUserList());
	}
}
