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

import com.chavis.biz.reserve.service.ReserveService;
import com.chavis.biz.reserve.vo.ReserveVO;

@CrossOrigin("*")
@Controller
public class ReserveController {
	@Autowired
	ReserveService service;

	@RequestMapping(value = "/Reserve/add.do", method = RequestMethod.POST)
	public @ResponseBody ReserveVO addReserve(@RequestParam("ReverseVO") ReserveVO reserve) {
		service.addReserve(reserve);
		return service.getReserve(reserve.getReserve_id());
	}

	@RequestMapping(value="/Reserve/list.do")
	public @ResponseBody List<ReserveVO> getReserveList() {
		return service.getReserveToday();
	}

	@RequestMapping(value="/Reserve/view.do", method=RequestMethod.POST)
	public @ResponseBody ReserveVO getReserve(@RequestBody String reserve_id) {
		return service.getReserve(reserve_id);
	}

	@RequestMapping(value="/Reserve/chart.do", method=RequestMethod.GET)
	public @ResponseBody Map<Integer, Integer> getChart() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 24; i++) {
			map.put(i, 0);
		}
		for (ReserveVO reserve : service.getReserveToday()) {
			int hour = Integer.parseInt(reserve.getReserve_time().substring(8, 10));
			map.replace(hour, map.get(hour) + 1);
		}
		return map;
	}

	@RequestMapping(value="/Reserve/listToday.do")
	public @ResponseBody List<ReserveVO> getReserveToday() {
		return service.getReserveToday();
	}

	@RequestMapping(value="/Reserve/remove.do", method = RequestMethod.POST)
	public @ResponseBody int removeReserve(@RequestBody String reserve_id) {
		return service.removeReserve(reserve_id);
	}

	@RequestMapping("/Reserve/update.do")
	public @ResponseBody int UpdateReserve(@RequestBody ReserveVO reserveVO) {
		return service.updateReserve(reserveVO);
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// ReserveController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
