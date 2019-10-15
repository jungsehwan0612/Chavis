package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.service.ReservationService;
import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ReservationController {
	private static Logger log = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	ReservationService service;
	@Autowired
	BodyshopService bservice;

	@RequestMapping(value = "/Reservation/add.do", method = RequestMethod.POST, consumes = "application/json")
	public List<ReservationVO> addReservation(@RequestBody Map<String, String> map) {
		// {"member_id":"111","reservation_time":"2019101010","key":"0"}
		map.put("repaired_time", "NO");

		log.info("add.do : " + map);

		map.put("key_expire_time", "NO");
		if (map.get("key").equals("0") || map.get("key").equals(null)) {
			map.replace("key", "NO");
		}
		map.put("bodyshop_no", Integer.toString((int) (Math.random() * 11) + 1));

		service.addReservation(map);
		log.info("member_id : " + map.get("member_id"));
		return service.getReservationByID(map.get("member_id"));
	}

	@RequestMapping(value = "/Reservation/list.do")
	// 리스트 부르면 조인을 해서
	public List<ReservationVO> getReservationList() {
		return service.getReservationList();
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
