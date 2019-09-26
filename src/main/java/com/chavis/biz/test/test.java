package com.chavis.biz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.user.service.ClientService;
import com.chavis.biz.user.vo.ClientVO;


public class test {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		ClientService userService = (ClientService) context.getBean("userservice");
		ClientVO user = new ClientVO();
		user.setClientNum("2");
		user.setCarId("11가1111");
		user.setCarType("pororo");
		user.setClientId("test01");
		user.setClientName("테스트");
		user.setPassword("1234");
		user.setTel("010-1234-5678");
		
		userService.addClient(user);	
		
//		for(userVO user:userService.getUserList())
//			System.out.println(user);
		
		System.out.println(userService.getClient("test01"));
		
		ClientVO u2 = new ClientVO();
		u2.setClientId("test01");
		u2.setTel("010-9876-5432");
		userService.updateClient(u2);
		
		userService.removeClient("test01");
		
	}
}
