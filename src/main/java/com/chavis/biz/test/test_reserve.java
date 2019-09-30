package com.chavis.biz.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.reserve.service.ReserveService;
import com.chavis.biz.reserve.vo.ReserveVO;

public class test_reserve {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		ReserveService reserveService = (ReserveService) context.getBean("reserveservice");
		for(ReserveVO reserve:reserveService.getReserveList())
			System.out.println(reserve);
	}
}
