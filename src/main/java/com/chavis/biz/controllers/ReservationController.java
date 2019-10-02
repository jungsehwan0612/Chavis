package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.chavis.biz.reservation.service.ReservationService;
import com.chavis.biz.reservation.vo.ReservationVO;

@CrossOrigin("*")
@Controller
public class ReservationController {
	@Autowired
	ReservationService service;

	@RequestMapping(value = "/Reservation/add.do", method = RequestMethod.POST)
	public @ResponseBody ReservationVO addReservation(@RequestParam("ReversationVO") ReservationVO reservation) {
		service.addReservation(reservation);
		return service.getReservation(reservation.getReservation_no());
	}

	@RequestMapping(value="/Reservation/list.do")
	public @ResponseBody List<ReservationVO> getReservationList() {
		return service.getReservationToday();
	}

	@RequestMapping(value="/Reservation/view.do", method=RequestMethod.POST)
	public @ResponseBody ReservationVO getReserve(@RequestBody int reserve_no) {
		return service.getReservation(reserve_no);
	}

	@RequestMapping(value="/Reservation/chart.do", method=RequestMethod.GET)
	public @ResponseBody Map<Integer, Integer> getChart() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 24; i++) {
			map.put(i, 0);
		}
		for (ReservationVO reserve : service.getReservationToday()) {
			int hour = Integer.parseInt(reserve.getReservation_time().substring(8, 10));
			map.replace(hour, map.get(hour) + 1);
		}
		return map;
	}

	@RequestMapping(value="/Reservation/listToday.do")
	public @ResponseBody List<ReservationVO> getReservationToday() {
		return service.getReservationToday();
	}

	@RequestMapping(value="/Reservation/remove.do", method = RequestMethod.POST)
	public @ResponseBody int removeReservation(@RequestBody int reserve_no) {
		return service.removeReservation(reserve_no);
	}

	@RequestMapping("/Reservation/update.do")
	public @ResponseBody int UpdateReservation(@RequestBody ReservationVO reservation) {
		return service.updateReservation(reservation);
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// ReserveController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
