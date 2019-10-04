package com.chavis.biz.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.validator.CarBodyshopValidator;
import com.chavis.biz.vo.BodyshopVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarBodyshopController {
	@Autowired
	BodyshopService service;
	
	@RequestMapping(value = "/CarBodyshop/login.do",method = RequestMethod.POST)
	public String loginProc(@RequestParam("bodyshopid")String bodyshop_id, @RequestParam("bodyshoppw")String bodyshop_pw, 
			HttpServletRequest request) throws Exception {
		BodyshopVO carBodyshop = service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		if(carBodyshop != null) {
			request.getSession().setAttribute("CarBodyshop", carBodyshop);
			request.getSession().setAttribute("login", carBodyshop);
			return "초기화면으로";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			System.out.println(carBodyshop);
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
	
	@RequestMapping(value = "/CarBodyshop/add.do",method = RequestMethod.POST)
	public String addBodyshop(@ModelAttribute("bodyshop") BodyshopVO carBodyshopVO,
			HttpServletRequest request, BindingResult errors) {
		new CarBodyshopValidator().validate(carBodyshopVO, errors);
		if(errors.hasErrors()) {
			return "정보 재입력 위치로";
		}		
		try {
			service.addBodyshop(carBodyshopVO);
			request.setAttribute("msg", "정비소가 등록되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return "정보 재입력 위치로";
		}			
		
		return "로그인 결과로";
	}
	@RequestMapping(value = "/CarBodyshop/update.do",method = RequestMethod.GET)
	public String updateBodyshopPassword() {
		return "비밀번호 수정 화면으로";
	}
	@RequestMapping(value = "/CarBodyshop/update.do",method = RequestMethod.POST)
	public String updateBodyshopPassword(String pw, HttpServletRequest request) {
		if(pw==null|pw.equals("")) {
			return "비밀번호 수정 창으로";
		}
		service.updateBodyshopPassword(pw);
		request.setAttribute("msg", "비밀번호가 수정되었습니다.");
		return "로그인 화면으로";
	}
	@RequestMapping(value = "CarBodyshop/remove.do",method = RequestMethod.POST)
	public String removeBodyshop(@ModelAttribute("bodyshop") BodyshopVO carBodyshopVO,
			HttpServletRequest request) {
		if(carBodyshopVO != null) {
			service.removeBodyshop(carBodyshopVO.getBodyshop_id(), carBodyshopVO.getBodyshop_pw());
			request.setAttribute("msg", "정비소정보가 삭제되었습니다.");
		}else {
			request.setAttribute("msg", "다시 시도해주세요.");
		}
		return "로그인 화면으로";
	}
	@RequestMapping(value = "CarBodyshop/list.do",method = RequestMethod.POST)
	public @ResponseBody List<BodyshopVO> getCarBodyshopList() {
		return service.getBodyshoplist();
	}
	@RequestMapping(value = "CarBodyshop/search.do",method = RequestMethod.POST)
	public @ResponseBody List<BodyshopVO> searchBodyshop(@RequestParam("bodyshopaddress")String bodyshop_address,
			@RequestParam("bodyshopname")String bodyshop_name) {
		return service.searchBodyshop(bodyshop_address, bodyshop_name);
	}
}
