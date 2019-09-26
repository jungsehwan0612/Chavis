package com.chavis.biz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.client.service.ClientService;
import com.chavis.biz.client.vo.ClientVO;


public class test {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		ClientService clientService = (ClientService) context.getBean("userservice");
		ClientVO client = new ClientVO();
		client.setClientNum("2");
		client.setCarId("11가1111");
		client.setCarType("pororo");
		client.setClientId("test01");
		client.setClientName("테스트");
		client.setPassword("1234");
		client.setTel("010-1234-5678");
		
		clientService.addClient(client);	
		
//		for(userVO user:userService.getUserList())
//			System.out.println(user);
		
		System.out.println(clientService.getClient("test01"));
		
		ClientVO u2 = new ClientVO();
		u2.setClientId("test01");
		u2.setTel("010-9876-5432");
		clientService.updateClient(u2);
		
//		userService.removeUser("test01");
		
	}
}
