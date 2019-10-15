package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.chavis.biz.method.AddressMethod;
import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodyshopController {

	@Autowired
	BodyshopService service;
	int bodyshop_no;
	AddressMethod am = new AddressMethod();

	@RequestMapping(value = "/Bodyshop/login.do", method = RequestMethod.POST)
	public BodyshopVO loginProc(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		String bodyshop_id = map.get("id");
		String bodyshop_pw = map.get("pw");
		BodyshopVO Bodyshop = service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		if (Bodyshop != null) {
			request.getSession().setAttribute("Bodyshop", Bodyshop);
			request.getSession().setAttribute("Login", Bodyshop);
			return service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		} else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			return service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		}
	}

	@RequestMapping(value = "/Bodyshop/regist.do", method = RequestMethod.POST)
	public String addBodyshop(@RequestBody Map<String, String> map, HttpServletRequest request, BindingResult errors) {
		bodyshop_no = service.getNo();
		String bodyshop_name = map.get("name");
		String bodyshop_pw = map.get("pw");
		String bodyshop_address = map.get("address");
		String[] jiyeok = bodyshop_address.split("/");
		String bodyshop_id = Integer.toString(bodyshop_no) + am.addressTrans(jiyeok[0].substring(0, 2))
				+ am.addressTrans(jiyeok[1]) + bodyshop_name;
		BodyshopVO vo = new BodyshopVO();
		vo.setBodyshop_no(bodyshop_no);
		vo.setBodyshop_id(bodyshop_id);
		vo.setBodyshop_name(bodyshop_name);
		vo.setBodyshop_pw(bodyshop_pw);
		vo.setBodyshop_address(bodyshop_address);
		service.addBodyshop(vo);
		System.out.println("실행완료");
		System.out.println(vo);
		return bodyshop_id;
	}

	@RequestMapping(value = "/Bodyshop/list.do", method = RequestMethod.POST)
	public List<BodyshopVO> getCarBodyshopList() {
		return service.getBodyshoplist();
	}

	@RequestMapping(value = "/Bodyshop/blist.do", method = RequestMethod.POST)
	public List<ReservationListVO> getReservationList(@RequestBody Map<String, String> map) {
		return service.getReservationList(Integer.parseInt(map.get("bodyshop_no")));
	}
}
