package com.chavis.biz.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chavis.biz.member.service.MemberService;
import com.chavis.biz.member.validator.MemberValidator;
import com.chavis.biz.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(MemberVO vo, HttpServletRequest request) throws Exception {
		
		MemberVO Member = service.login(vo.getMember_id(), vo.getMember_pw());
		if(Member != null) {
			request.getSession().setAttribute("Member", Member);
			request.getSession().setAttribute("login", Member);
			
			return "초기화면으로";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			
			return "로그인 화면으로";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		if(session!=null)
			session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		System.out.println("로그아웃 되었습니다.");
		
		return "로그인 화면으로";
	}
	
	//회원가입
	@RequestMapping(value = "/Member/add.do", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("Member") MemberVO Member, 
								HttpServletRequest request, BindingResult errors) {	

		new MemberValidator().validate(Member, errors);
		if(errors.hasErrors()) {
			return "정보 재입력 위치로";
		}		
		try {
			service.addMember(Member);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "정보 재입력 위치로";
		}			
		
		return "로그인 결과로";
	}
	
	@RequestMapping(value="/Member/list.do", method=RequestMethod.POST)
	public @ResponseBody List<MemberVO> getMemberList(){
		return service.getMemberList();
	}

	@RequestMapping(value="/Member/view.do", method=RequestMethod.POST)
	public @ResponseBody MemberVO getMember(@RequestParam("member_id") String member_id) {
		System.out.println(member_id);
		return service.getMember(member_id);
	}

	@RequestMapping(value="/Member/remove.do", method=RequestMethod.POST)
	public @ResponseBody int removeMember(@RequestBody MemberVO Member) {
		return service.removeMember(Member);
	}
	
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception, Model model) {
		// MemberController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
	
	// 페이징 보류
	@RequestMapping(value="/Member/Memberlist", method = RequestMethod.POST)
	public @ResponseBody List<MemberVO> selectMemberList(@RequestBody Map<String, Object> param){
		return service.selectMemberList(param);
	}
}
