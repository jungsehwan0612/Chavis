package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chavis.biz.method.AddressMethod;
import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;
import com.chavis.biz.vo.ReservationVO;

@RestController
public class BodyshopController {
	@Autowired
	BodyshopService service;
	int bodyshop_no;
	AddressMethod am = new AddressMethod();

	@RequestMapping(value = "/Bodyshop/login.do", method = RequestMethod.POST)
	public BodyshopVO loginProc(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		System.out.println(map);
		String bodyshop_id = map.get("id");
		String bodyshop_pw = map.get("pw");
		BodyshopVO bodyshop = service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		if (bodyshop != null) {
			request.getSession().setAttribute("Bodyshop", bodyshop);
			request.getSession().setAttribute("Login", bodyshop);
			return service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		} else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			System.out.println(bodyshop);
			return service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		}
	}

	@RequestMapping("/Bodyshop/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null)
			session.invalidate();

		request.setAttribute("msg", "로그아웃 되었습니다.");
		System.out.println("로그아웃 되었습니다.");

		return "로그인 화면으로";
	}

	@RequestMapping(value = "/Bodyshop/regist.do", method = RequestMethod.POST)
	public String addBodyshop(@RequestBody Map<String, String> map, HttpServletRequest request, BindingResult errors) {
		System.out.println(map);
		bodyshop_no = service.getNo();
		String bodyshop_name = map.get("name");
		String bodyshop_pw = map.get("pw");
		String bodyshop_address = map.get("address");
		String[] jiyeok = bodyshop_address.split("/");
		String bodyshop_id = Integer.toString(bodyshop_no) + am.addressTrans(jiyeok[0].substring(0, 2))
				+ am.addressTrans(jiyeok[1]) + bodyshop_name;
		System.out.println(jiyeok[0].substring(0, 2));
		System.out.println(bodyshop_id);
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

	@RequestMapping(value = "/Bodyshop/update.do", method = RequestMethod.POST)
	public String updateBodyshopPassword(String pw, HttpServletRequest request) {
		if (pw == null | pw.equals("")) {
			return "비밀번호 수정 창으로";
		}
		service.updateBodyshopPassword(pw);
		request.setAttribute("msg", "비밀번호가 수정되었습니다.");
		return "로그인 화면으로";
	}

	@RequestMapping(value = "/Bodyshop/remove.do", method = RequestMethod.POST)
	public String removeBodyshop(@ModelAttribute("bodyshop") BodyshopVO carBodyshopVO, HttpServletRequest request) {
		if (carBodyshopVO != null) {
			service.removeBodyshop(carBodyshopVO.getBodyshop_id(), carBodyshopVO.getBodyshop_pw());
			request.setAttribute("msg", "정비소정보가 삭제되었습니다.");
		} else {
			request.setAttribute("msg", "다시 시도해주세요.");
		}
		return "로그인 화면으로";
	}

	@RequestMapping(value = "/Bodyshop/list.do", method = RequestMethod.POST)
	public List<BodyshopVO> getCarBodyshopList() {
		return service.getBodyshoplist();
	}

	@RequestMapping(value = "/Bodyshop/search.do", method = RequestMethod.POST)
	public List<BodyshopVO> searchBodyshop(@RequestParam("bodyshopaddress") String bodyshop_address,
			@RequestParam("bodyshopname") String bodyshop_name) {
		return service.searchBodyshop(bodyshop_address, bodyshop_name);
	}

	@RequestMapping(value = "/Bodyshop/blist.do", method = RequestMethod.POST)
	public List<ReservationListVO> getReservationList(@RequestBody Map<String, String> map) {
		System.out.println("blist" + map);
		int member_no = Integer.parseInt(map.get("bodyshop_no"));
		return service.getReservationList(member_no);
	}
}
