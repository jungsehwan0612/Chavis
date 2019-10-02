package com.chavis.biz.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chavis.biz.carbodyshop.service.CarBodyshopService;
import com.chavis.biz.carbodyshop.vo.CarBodyshopVO;

@Controller
public class CarBodyshopController {
	@Autowired
	CarBodyshopService service;
	
	@RequestMapping(value = "/CarBodyshop/login.do",method = RequestMethod.POST)
	public String loginProc(CarBodyshopVO vo, HttpServletRequest request) throws Exception {
		
		CarBodyshopVO carBodyshop = service.bodyLogin(vo.getBodyshop_id(), vo.getBodyshop_pw());
		if(carBodyshop != null) {
			request.getSession().setAttribute("carBodyshop", carBodyshop);
			request.getSession().setAttribute("login", carBodyshop);
			
			return "초기화면으로";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			
			return "로그인 화면으로";
		}
	}
	@RequestMapping("/CarBodyshop/logout.do")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		if(session!=null)
			session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		System.out.println("로그아웃 되었습니다.");
		
		return "로그인 화면으로";
	}
}
