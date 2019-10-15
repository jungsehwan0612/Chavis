package com.chavis.biz.controllers;

import java.util.Map;

import com.chavis.biz.service.CarService;
import com.chavis.biz.vo.CarVO;

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
public class CarController {

	@Autowired
	CarService service;

	@RequestMapping(value = "/Car/personalview.do", method = RequestMethod.POST)
	public CarVO getPersonalCar(@RequestBody Map<String, String> map) {
		return service.getPersonalCar(map.get("member_id"));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// ReserveController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
