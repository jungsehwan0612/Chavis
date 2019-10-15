package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.service.ReservationService;
import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;

@CrossOrigin("*")
@RestController
public class ReservationController {
	@Autowired
	ReservationService service;
	@Autowired
	BodyshopService bservice;

	@RequestMapping(value = "/Reservation/add.do", method = RequestMethod.POST, consumes = "application/json")
	public List<ReservationVO> addReservation(@RequestBody Map<String, String> map) {
		// {"member_id":"111","reservation_time":"2019101010","key":"0"}
		map.put("repaired_time", "NO");
		System.out.println("reser add" + map);
		map.put("key_expire_time", "NO");
		if (map.get("key").equals("0") || map.get("key")== null) {
			map.replace("key","NO");
		}
		map.put("bodyshop_no", Integer.toString((int) (Math.random() * 11) + 1));
		System.out.println("map1"+map);
		String member_id = map.get("member_id");
		System.out.println("member_id" + member_id);
		service.addReservation(map);
		return service.getReservationByID(member_id);
	}

	@RequestMapping(value = "/Reservation/list.do")
	public List<ReservationVO> getReservationList() {
		return service.getReservationToday();
	}

	@RequestMapping(value = "/Reservation/view.do", method = RequestMethod.POST)
	public ReservationVO getReserve(@RequestBody Map<String, String> map) {
		int reserve_no = Integer.parseInt(map.get("reservation_time"));
		System.out.println("view.do");
		System.out.println(map);
		System.out.println(reserve_no);
		return service.getReservation(reserve_no);
	}

	@RequestMapping(value = "/Reservation/chart.do", method = RequestMethod.GET)
	public Map<String, Integer> getChart() {
		Map<String, Integer> map = new HashMap<>();
		int midnightToSix = 0;
		int sixToNoon = 0;
		int noonToSix = 0;
		int sixToMidnight = 0;
		
		for (ReservationVO reserve : service.getReservationToday()) {
			String time = reserve.getReservation_time().split(" ")[1];
			int hour = Integer.parseInt(time.split(":")[0]);
			if(hour >= 0 && hour < 6)
				midnightToSix ++;
			if(hour >= 6 && hour < 12)
				sixToNoon ++;
			if(hour >= 12 && hour < 18)
				noonToSix ++;
			if(hour >= 18 && hour < 24)
				sixToMidnight ++;
		}
		map.put("0~6", midnightToSix);
		map.put("6~12", sixToNoon);
		map.put("12~18", noonToSix);
		map.put("18~24", sixToMidnight);
		return map;
	}

	@RequestMapping(value = "/Reservation/listToday.do")
	public List<ReservationVO> getReservationToday() {
		return service.getReservationToday();
	}

	@RequestMapping(value = "/Reservation/remove.do", method = RequestMethod.POST)
	public int removeReservation(@RequestBody Map<String, String> map) {
		int reserve_no = Integer.parseInt(map.get("reservation_no"));
		return service.removeReservation(reserve_no);
	}

	@RequestMapping("/Reservation/update.do")
	public int UpdateReservation(@RequestBody ReservationVO reservation) {
		return service.updateReservation(reservation);
	}

	@RequestMapping(value = "/Reservation/finishrepair.do", method = RequestMethod.POST)
	public List<ReservationListVO> finishRepair(@RequestBody Map<String, String> map) {
		System.out.println("reservation controller");
		System.out.println(map);
		int reservation_no = Integer.parseInt(map.get("reservation_no"));
		String repaired_time = map.get("repaired_time");
		String repaired_person = map.get("repaired_person");

		service.finishRepair(reservation_no, repaired_time, repaired_person);
		return bservice.getReservationList(Integer.parseInt(map.get("bodyshop_no")));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// ReserveController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
