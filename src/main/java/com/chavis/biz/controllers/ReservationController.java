package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.service.ReservationService;
import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class ReservationController {
	@Autowired
	ReservationService service;
	
	@Autowired
	BodyshopService bservice;

	@RequestMapping(value = "/Reservation/add.do", method = RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public List<ReservationVO> addClothHistory(@RequestBody Map<String, String> map) {
		//{"member_id":"111","reservation_time":"2019101010","key":"0"}
		System.out.println(map);
		System.out.println(map.get("member_id"));
		System.out.println(map.get("reservation_time"));
		System.out.println(map.get("key"));
		return service.getReservationByID(map.get("member_id"));
	}
	

	@RequestMapping(value="/Reservation/list.do")
	public @ResponseBody List<ReservationVO> getReservationList() {
		return service.getReservationToday();
	}
	

	@RequestMapping(value="/Reservation/view.do", method=RequestMethod.POST)
	public @ResponseBody ReservationVO getReserve(@RequestBody Map<String, String> map) {
		int reserve_no = Integer.parseInt(map.get("reservation_time"));
		System.out.println("view.do");
		System.out.println(map);
		System.out.println(reserve_no);
		return service.getReservation(reserve_no);
	}

	@RequestMapping(value="/Reservation/chart.do", method=RequestMethod.GET)
	public @ResponseBody Map<Integer, Integer> getChart() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 24; i++) {
			map.put(i, 0);
		}
		for (ReservationVO reserve : service.getReservationToday()) {
			String time = reserve.getReservation_time().split(" ")[1];
			int hour = Integer.parseInt(time.split(":")[0]);
			map.replace(hour, map.get(hour) + 1);
		}
		return map;
	}

	
	@RequestMapping(value="/Reservation/listToday.do")
	public @ResponseBody List<ReservationVO> getReservationToday() {
		return service.getReservationToday();
	}

	@RequestMapping(value="/Reservation/remove.do", method = RequestMethod.POST)
	public @ResponseBody int removeReservation(@RequestBody Map<String, String> map) {
		int reserve_no = Integer.parseInt(map.get("reservation_no"));
		return service.removeReservation(reserve_no);
	}

	@RequestMapping("/Reservation/update.do")
	public @ResponseBody int UpdateReservation(@RequestBody ReservationVO reservation) {
		return service.updateReservation(reservation);
	}
	
	@RequestMapping(value="/Reservation/finishrepair.do", method=RequestMethod.POST)
	public @ResponseBody List<ReservationListVO> finishRepair(@RequestBody Map<String, String> map) {
		System.out.println("reservation controller");
		System.out.println(map);
//		ReservationVO vo = new ReservationVO();
//		vo.setReservation_no(Integer.parseInt(map.get("reservation_no")));
//		vo.setRepaired_time(map.get("repaired_time"));
//		vo.setRepaired_person(map.get("repaired_person"));
//		System.out.println(vo);
//		service.finishRepair(vo);
//		return bservice.getReservationList(vo.getBodyshop_no());
		int reservation_no = Integer.parseInt(map.get("reservation_no"));
		String repaired_time = map.get("repaired_time");
		String repaired_person = map.get("repaired_person");
		
		service.finishRepair(reservation_no, repaired_time, repaired_person);
		return bservice.getReservationList(Integer.parseInt(map.get("bodyshop_no")));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// ReserveController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
