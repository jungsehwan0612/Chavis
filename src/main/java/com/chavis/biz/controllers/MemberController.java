package com.chavis.biz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chavis.biz.service.MemberService;
import com.chavis.biz.validator.MemberValidator;
import com.chavis.biz.vo.MemberVO;

@RestController
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/Member/login.do", method = RequestMethod.POST)
	public MemberVO loginProc(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		String member_id = map.get("member_id");
		String member_pw = map.get("member_pw");
		MemberVO member = service.login(member_id, member_pw);
		if (member != null) {
			request.getSession().setAttribute("Member", member);
			request.getSession().setAttribute("login", member);

			return service.login(member_id, member_pw);
		} else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");

			return service.login(member_id, member_pw);
		}
	}

	@RequestMapping(value = "/Member/update.do",method = RequestMethod.POST)
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
		
		System.out.println(map1);
		System.out.println(map2);
		
		service.updateMember(map1);
		service.updateCar(map2);
		
		return service.updateMember(map);
	}
	
	@RequestMapping("/Member/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null)
			session.invalidate();

		request.setAttribute("msg", "로그아웃 되었습니다.");
		System.out.println("로그아웃 되었습니다.");

		return "로그인 화면으로";
	}
	
	@RequestMapping(value = "/Member/dupcheck.do", method = RequestMethod.POST)
	public int dupcheck(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
		String member_id = map.get("member_id");
		System.out.println(map);
		System.out.println(member_id);
		return service.dupcheck(member_id);
	}

	// 회원가입
	@RequestMapping(value = "/Member/add.do", method = RequestMethod.POST)
	public boolean addMember(@RequestBody Map<String, Object> Member, HttpServletRequest request,
			BindingResult errors) {
		
		System.out.println(Member);
		new MemberValidator().validate(Member, errors);
		if (errors.hasErrors()) {
			return false;
		}
		try {
			service.addMember(Member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/Member/list.do", method = RequestMethod.POST)
	public List<MemberVO> getMemberList() {
		System.out.println("member list controller");
		return service.getMemberList();
	}

	@RequestMapping(value = "/Member/view.do", method = RequestMethod.POST)
	public MemberVO getMember(@RequestBody Map<String, String> map) {
		System.out.println(map);
		String member_id = map.get("member_id");
		System.out.println(member_id);
		return service.getMember(member_id);
	}

	@RequestMapping(value = "/Member/remove.do", method = RequestMethod.POST)
	public int removeMember(@RequestBody Map<String, String> map) {
		return service.removeMember(map.get("member_id"));
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// MemberController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}

	// 페이징 보류
	@RequestMapping(value = "/Member/Memberlist", method = RequestMethod.POST)
	public List<MemberVO> selectMemberList(@RequestBody Map<String, Object> param) {
		return service.selectMemberList(param);
	}
}
