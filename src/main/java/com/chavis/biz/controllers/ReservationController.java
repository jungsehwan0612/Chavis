package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

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

import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.service.ReservationService;
import com.chavis.biz.vo.ReservationVO;

@CrossOrigin("*")
@RestController
public class ReservationController {

	public static Logger log = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	ReservationService service;
	@Autowired
	BodyshopService bservice;

	@RequestMapping(value = "/Reservation/add.do", method = RequestMethod.POST, consumes = "application/json")
	public List<ReservationVO> addReservation(@RequestBody Map<String, String> map) {
		map.put("repaired_time", "NO");
		service.addReservation(map);
		return service.getReservationByID(map.get("member_id"));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// ReservationController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
