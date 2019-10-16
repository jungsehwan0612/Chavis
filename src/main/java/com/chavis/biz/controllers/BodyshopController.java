package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chavis.biz.method.AddressMethod;
import com.chavis.biz.service.BodyshopService;
import com.chavis.biz.vo.BodyshopVO;
import com.chavis.biz.vo.ReservationListVO;

@RestController
public class BodyshopController {

	public static Logger log = LoggerFactory.getLogger(BodyshopController.class);

	@Autowired
	BodyshopService service;

	int bodyshop_no;
	AddressMethod am = new AddressMethod();

	@RequestMapping(value = "/Bodyshop/login.do", method = RequestMethod.POST)
	public BodyshopVO loginProc(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		String bodyshop_id = map.get("id");
		String bodyshop_pw = map.get("pw");
		System.out.println("bodyshop id : " + bodyshop_id);
		BodyshopVO Bodyshop = service.bodyshopLogin(bodyshop_id, bodyshop_pw);
		if (Bodyshop != null) {
			return Bodyshop;
		} else {
			BodyshopVO tmp = new BodyshopVO();
			tmp.setBodyshop_id("NO");
			return tmp;
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
		log.info("/bodyshop/regist.do 실행완료");
		log.info(vo.toString());
		return bodyshop_id;
	}
	// 이름을 주면 id, id랑 이름 주면 pw
	@RequestMapping(value = "/Bodyshop/list.do", method = RequestMethod.POST)
	public List<BodyshopVO> getCarBodyshopList() {
		return service.getBodyshoplist();
	}
	
	@RequestMapping(value = "/Bodyshop/findinfo.do", method = RequestMethod.POST)
	public String getMyInfo(@RequestBody Map<String, String> map){
		log.info(map.toString());
		if (map.get("bodyshop_id").equals("NO")) {
			return service.findBodyshopID(map);
		} else {
			return service.findBodyshopPW(map);
		}
	}

	@RequestMapping(value = "/Bodyshop/blist.do", method = RequestMethod.POST)
	public List<ReservationListVO> getReservationList(@RequestBody Map<String, String> map) {
		return service.getReservationList(Integer.parseInt(map.get("bodyshop_no")));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// BodyshopController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
