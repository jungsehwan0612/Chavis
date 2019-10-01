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
import org.springframework.web.bind.annotation.ResponseBody;

import com.chavis.biz.client.service.ClientService;
import com.chavis.biz.client.validator.ClientValidator;
import com.chavis.biz.client.vo.ClientVO;

@Controller
public class ClientController {
	@Autowired
	ClientService service;
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(ClientVO vo, HttpServletRequest request) throws Exception {
		
		ClientVO Client = service.login(vo.getClient_id(), vo.getPassword());
		if(Client != null) {
			request.getSession().setAttribute("client", Client);
			request.getSession().setAttribute("login", Client);
			
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
	@RequestMapping(value = "/Client/add.do", method = RequestMethod.POST)
	public String addClient(@ModelAttribute("client") ClientVO client, 
								HttpServletRequest request, BindingResult errors) {	

		new ClientValidator().validate(client, errors);
		if(errors.hasErrors()) {
			return "정보 재입력 위치로";
		}		
		try {
			service.addClient(client);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "정보 재입력 위치로";
		}			
		
		return "로그인 결과로";
	}
	
	@RequestMapping(value="/Client/list.do", method=RequestMethod.POST)
	public @ResponseBody List<ClientVO> getClientList(){
		return service.getClientList();
	}

	@RequestMapping(value="/Client/view.do", method=RequestMethod.POST)
	public @ResponseBody ClientVO getClient(@RequestBody String client_id) {
		return service.getClient(client_id);
	}

	@RequestMapping(value="/Client/remove.do", method=RequestMethod.POST)
	public @ResponseBody int removeClient(@RequestBody ClientVO client_id) {
		return service.removeClient(client_id);
	}
	
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// ClientController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
	
	// 페이징 보류
	@RequestMapping(value="/Client/clientlist", method = RequestMethod.POST)
	public @ResponseBody List<ClientVO> selectClientList(@RequestBody Map<String, Object> param){
		return service.selectClientList(param);
	}
}
