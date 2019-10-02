package com.chavis.biz.test;

import java.util.HashMap;

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
		for(ReserveVO reserve:reserveService.getReserveToday())
			System.out.println(reserve);

		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<24; i++)	{
			map.put(i+"", 0);
		}
		
		System.out.println(map);
		for(ReserveVO reserve:reserveService.getReserveToday()) {
			String hour = reserve.getReserve_time().substring(8, 10);
			map.replace(hour, map.get(hour)+1);
		}
		System.out.println(map);
	}
}
