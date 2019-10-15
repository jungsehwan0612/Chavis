package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.chavis.biz.service.MemberService;
import com.chavis.biz.validator.MemberValidator;
import com.chavis.biz.vo.MemberVO;
import com.chavis.biz.vo.NotificationVO;
import com.chavis.biz.vo.ReservationVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/Member/login.do", method = RequestMethod.POST)
	public Map<String, String> loginProc(@RequestBody Map<String, String> map, HttpServletRequest request)
			throws Exception {
		String member_id = map.get("member_id");
		String member_pw = map.get("member_pw");

		MemberVO vo = null;
		vo = service.login(member_id, member_pw);
		if (vo == null) {
			map.put("code", "100");
			return map;
		} else {
			map.put("member_id", vo.getMember_id());
			map.put("member_pw", vo.getMember_pw());
			map.put("member_mname", vo.getMember_mname());
			map.put("member_phonenumber", vo.getMember_phonenumber());
			map.put("car_id", vo.getCar_id());
			map.put("member_no", Integer.toString(vo.getMember_no()));
			map.put("car_type", vo.getCar_type());
			map.put("car_color", vo.getCar_color());
			map.put("code", "200");
			return map;
		}
	}

	@RequestMapping(value = "/Member/update.do", method = RequestMethod.POST)
	public int updateMember(@RequestBody MemberVO map) {
		System.out.println(map);

		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();

		map1.put("member_id", map.getMember_id());
		map1.put("member_mname", map.getMember_mname());
		map1.put("member_phonenumber", map.getMember_phonenumber());
		map1.put("member_pw", map.getMember_pw());

		map2.put("member_id", map.getMember_id());
		map2.put("car_color", map.getCar_color());
		map2.put("car_id", map.getCar_id());
		map2.put("car_type", map.getCar_type());

		return service.updateMember(map1) & service.updateCar(map2);
	}

	@RequestMapping(value = "/Member/dupcheck.do", method = RequestMethod.POST)
	public int dupcheck(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		return service.dupcheck(map.get("member_id"));
	}

	// 회원가입
	@RequestMapping(value = "/Member/add.do", method = RequestMethod.POST)
	public boolean addMember(@RequestBody Map<String, String> map, HttpServletRequest request, BindingResult errors) {

		MemberVO vo = new MemberVO();
		vo.setMember_id(map.get("member_id"));
		vo.setMember_pw(map.get("member_pw"));
		vo.setMember_mname(map.get("member_mname"));
		vo.setMember_phonenumber(map.get("member_phonenumber"));
		vo.setCar_type(map.get("car_type"));
		vo.setCar_color(map.get("car_color"));
		vo.setCar_id(map.get("car_id"));

		System.out.println(map);
		new MemberValidator().validate(vo, errors);
		if (errors.hasErrors()) {
			return false;
		}
		try {
			service.addMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Member/nlist.do")
	public List<NotificationVO> getNotificationList(HttpServletRequest httpServletRequest) {
		return service.getNotificationList(httpServletRequest.getParameter("member_id"));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Member/rlist.do")
	public List<ReservationVO> getMemberReserveList(HttpServletRequest httpServletRequest, Model model) {
		return service.getMemberReserveList(httpServletRequest.getParameter("id"));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// MemberController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		System.out.println(exception);
		return "error";
	}

}
