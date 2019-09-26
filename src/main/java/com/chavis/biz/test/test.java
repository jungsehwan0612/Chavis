package com.chavis.biz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.user.service.UserService;
import com.chavis.biz.user.vo.UserVO;


public class test {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		UserService userService = (UserService) context.getBean("userservice");
		UserVO user = new UserVO();
		user.setClientNum("2");
		user.setCarId("11가1111");
		user.setCarType("pororo");
		user.setClientId("test01");
		user.setClientName("테스트");
		user.setPassword("1234");
		user.setTel("010-1234-5678");
		
		userService.addUser(user);	
		
//		for(userVO user:userService.getUserList())
//			System.out.println(user);
		
		System.out.println(userService.getUser("test01"));
		
		UserVO u2 = new UserVO();
		u2.setClientId("test01");
		u2.setTel("010-9876-5432");
		userService.updateUser(u2);
		
//		userService.removeUser("test01");
		
	}
}
