package com.chavis.biz.test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.reservation.service.ReservationService;
import com.chavis.biz.reservation.vo.ReservationVO;

public class Test_Reservation {
	public static void main(String[] args) throws Exception {

		String[] config = { "applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		ReservationService reserveService = (ReservationService) context.getBean("reservationservice");
		for (ReservationVO reserve : reserveService.getReservationToday())
			System.out.println(reserve);

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 24; i++) {
			map.put(i + "", 0);
		}

		System.out.println(map);
		for (ReservationVO reserve : reserveService.getReservationToday()) {
			String hour = reserve.getReservation_time().substring(8, 10);
			map.replace(hour, map.get(hour) + 1);
		}
		System.out.println(map);
	}
}
